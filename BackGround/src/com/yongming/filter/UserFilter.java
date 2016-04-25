package com.yongming.filter;

import com.yongming.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by jiangyongming on 4/24/16.
 */
@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();
            chain.doFilter(req,resp);
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
