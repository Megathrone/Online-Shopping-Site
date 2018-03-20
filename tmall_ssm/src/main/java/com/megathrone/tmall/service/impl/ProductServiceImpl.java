package com.megathrone.tmall.service.impl;

import com.megathrone.tmall.mapper.ProductMapper;
import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.pojo.Product;
import com.megathrone.tmall.pojo.ProductExample;
import com.megathrone.tmall.pojo.ProductImage;
import com.megathrone.tmall.service.CategoryService;
import com.megathrone.tmall.service.ProductImageService;
import com.megathrone.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;


    @Override
    public void add(Product p) {
        productMapper.insert(p);
    }

    @Override
    public void delete(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Product p) {
        productMapper.updateByPrimaryKeySelective(p);
    }

    @Override
    public Product get(int id) {
        Product p = productMapper.selectByPrimaryKey(id);
        setCategory(p);
        return p;
    }

    @Override
    public List list(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setCategory(result);
        return result;
    }

    @Override
    public void fill(Category c) {
        List<Product> ps = list(c.getId());
        c.setProducts(ps);
    }

    @Override
    public void fill(List<Category> cs) {
        for (Category c : cs) {
            fill(c);
        }
    }

    @Override
    public void fillByRow(List<Category> cs) {
        int productNumberEachRow = 8;
        for(Category c:cs){
            List<Product> products = c.getProducts();
            List<List<Product>> productsByRow = new ArrayList<>();
            for(int i=0;i<products.size();i+=productNumberEachRow){
                int size = i +productNumberEachRow;
                size = size > products.size() ? products.size() : size;
                List<Product> productsOfEachRow = products.subList(i,size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }



    public void setCategory(List<Product> ps){
        for(Product p : ps){
            setCategory(p);
        }
    }

    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }
}
