package com.megathrone.tmall.test;

import com.megathrone.tmall.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestTmall {

    public static void main(String args[]) throws IOException{
//        //准备分类测试数据：
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try (
//                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8",
//                        "root", "123456");
//                Statement s = c.createStatement();
//        )
//        {
//            for (int i = 1; i <=10 ; i++) {
//                String sqlFormat = "insert into category values (null, '测试分类%d')";
//                String sql = String.format(sqlFormat, i);
//                s.execute(sql);
//            }
//
//            System.out.println("已经成功创建10条分类测试数据");
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        List<Category> cs = session.selectList("listCategory");
//        for (Category c : cs) {
//            session.delete("deleteCategory", c);
//        }
//        for (int i = 0; i < 100; i++) {
//            Category c = new Category();
//            c.setName("category name " + i);
//            session.insert("addCategory", c);
//        }
//        List<Category> cs2 = session.selectList("listCategory");
//        for (Category c : cs2) {
//            System.out.println(c.getName());
//        }
//
//        session.commit();
//        session.close();
    }

}
