package com.yongming.dao;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.yongming.entity.UsersEntity;
import com.yongming.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.w3c.dom.Element;

import java.util.List;

/**
 * Created by jiangyongming on 4/24/16.
 */

/**
 * UserDAO提供增删改查方法
 */
public class UserDAO {

    private UsersEntity user;

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    /**
     * 添加用户
     * @param entity
     * @return
     */
    @Test
    public static boolean Add(UsersEntity entity) {
//        user.setID(getNextID());
        Session session=null;
        Transaction tx=null;
        try {
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
            return true;


        } catch (Exception e) {
            tx.rollback();
            System.out.println("注册失败");
            e.printStackTrace();
            return false;
        }finally{
            HibernateUtils.closeSession(session);
        }

    }

    /**
     * 删除用户
     * @param entity
     */
    public static boolean delete(UsersEntity entity) {
        Session session=null;
        Transaction tx=null;
        try {
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
            return true;


        } catch (Exception e) {
            tx.rollback();
            System.out.println("删除失败");
            e.printStackTrace();
            return false;
        }finally{
            HibernateUtils.closeSession(session);
        }
    }

    /**
     * 获取全部用户
     * @return
     */
    public static List<UsersEntity> getAll(){

        String hql = "from UsersEntity";
        return (List<UsersEntity>)HibernateUtils.getSession().createQuery(hql).list();

    }

    /**
     * 获取单个用户
     * @param name
     * @return
     */
    public static UsersEntity loadUserByName(String name){
        Session session = null;
        Transaction tx = null;
        try {

            session = HibernateUtils.getSession();

            tx = session.beginTransaction();

            String hql = "select u from UsersEntity as u where u.userName=?";

            Query query = session.createQuery(hql);
            query.setString(0,name);
            UsersEntity user = (UsersEntity) query.setMaxResults(1).uniqueResult();
            tx.commit();
            if (user == null){
                return null;
            }else {
                return user;
            }

        }catch (Exception e){
            if (tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
            return  null;
        }
        finally {
            HibernateUtils.closeSession(session);
        }
    }

    public static UsersEntity loadUserByNameAndPassword(String username,String password){
        Session session = null;
        Transaction tx = null;
        try {

            session = HibernateUtils.getSession();

            tx = session.beginTransaction();

            String hql = "select u from UsersEntity as u where u.userName=? and u.password=?";

            Query query = session.createQuery(hql);
            query.setString(0,username);
            query.setString(1,password);
            UsersEntity user = (UsersEntity) query.setMaxResults(1).uniqueResult();
            tx.commit();
            if (user == null){
                return null;
            }else {
                return user;
            }
        }catch (Exception e){
            if (tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
            return  null;
        }
        finally {
            HibernateUtils.closeSession(session);
        }
    }
    public static UsersEntity loadUserById(Integer id){
        Session session = null;
        Transaction tx = null;
        try {

            session = HibernateUtils.getSession();

            tx = session.beginTransaction();

            String hql = "select u from UsersEntity as u where u.id=?";

            Query query = session.createQuery(hql);
            query.setInteger(0,id);
            UsersEntity user = (UsersEntity) query.setMaxResults(1).uniqueResult();
            tx.commit();
            if (user == null){
                return null;
            }else {
                return user;
            }

        }catch (Exception e){
            if (tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
            return  null;
        }
        finally {
            HibernateUtils.closeSession(session);
        }
    }

}

