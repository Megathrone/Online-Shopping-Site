package com.megathrone.tmall.interceptor;

import com.megathrone.tmall.pojo.Category;
import com.megathrone.tmall.pojo.OrderItem;
import com.megathrone.tmall.pojo.User;
import com.megathrone.tmall.service.CategoryService;
import com.megathrone.tmall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OtherInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;


    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * true : Execute the next interceptor until last one and then call postHandle backward.
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }


    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     *
     * Executing before generating modelView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //Show info below the search bar
        List<Category> cs = categoryService.list();
        request.getSession().setAttribute("cs",cs);


        // return to the main page
        HttpSession session = request.getSession();
        String contexPath = session.getServletContext().getContextPath()+"/forehome";
        request.getSession().setAttribute("contextPath",contexPath);

        //Get total number of products in carts
        User user  = (User) request.getSession().getAttribute("user");
        int cartTotalItemNumber = 0;
        if(null!=user){
            List<OrderItem> ois = orderItemService.listByUser(user.getId());
            for(OrderItem oi : ois){
                cartTotalItemNumber+=oi.getNumber();
            }
        }
        request.getSession().setAttribute("cartTotalItemNumber",cartTotalItemNumber);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
