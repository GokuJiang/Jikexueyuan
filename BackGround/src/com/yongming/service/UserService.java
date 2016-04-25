package com.yongming.service;

import com.sun.prism.MaskTextureGraphics;
import com.yongming.dao.UserDAO;
import com.yongming.entity.UsersEntity;
import com.yongming.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiangyongming on 4/24/16.
 */
public class UserService {


    /**
     * 单例模式
     */
    private UserService(){

    }

    private static class  UserServiceHolder{
        private static final UserService INSTANCE = new UserService();
    }

    public static final UserService getInstance() {
        return UserServiceHolder.INSTANCE;
    }



    public List<UsersEntity> findAll() {
        List<UsersEntity> list = new ArrayList<UsersEntity>();
        try {

            list = UserDAO.getAll();
        } catch (Exception ce) {
            ce.printStackTrace();
        }
        return list;
    }


    @Test
    public boolean save(UsersEntity entity){
        try{
            if(registerValidate(entity)){
                UserDAO.Add(entity);
                return true;
            }
            else{
                return false;
            }
        }catch(Exception ce){
            ce.printStackTrace();
            return false;
        }
    }

    public boolean login(UsersEntity entity){
        if( loginValidate(entity.getUserName(),entity.getPassword())){
            return true;
        }else {
            return false;
        }
    }

    public void delete(Integer id){
        try{
            UsersEntity user = UserDAO.loadUserById(id);
            if(user != null){
                UserDAO.delete(user);
            }
        }catch(Exception ce){
            ce.printStackTrace();
        }
    }
    /**
     * 判断userName是否存在于数据库中
     * @param user
     * @return
     */
    public  boolean registerValidate(UsersEntity user){
        boolean conflict_flag = true;


        //检验用户名
        if (user.getUserName()==null || user.getUserName().equals("")){
            return false;
        }

        //校验年龄
        if (user.getAge()>150||user.getAge()<0){
            return false;
        }


        //正则校验手机号码
        /**
         * 中国移动：China Mobile
         * 134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
         */
        Pattern mobile = Pattern.compile("^1(3[0-9]|5[0-35-9]|8[025-9])\\d{8}$");
        /**
         * 中国移动：China Mobile
         * 134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
         */
        Pattern cm = Pattern.compile("^1(34[0-8]|(3[5-9]|5[017-9]|8[278])\\d)\\d{7}$");
        /**
         * 中国联通：China Unicom
         * 130,131,132,155,156,185,186,145,176,1709
         */
        Pattern cu = Pattern.compile("^1(34[0-8]|(3[5-9]|5[017-9]|8[278])\\\\d)\\\\d{7}$");
        /**
         * 中国电信：China Telecom
         * 133,153,180,181,189,177,1700
         */
        Pattern ct = Pattern.compile("(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)");
        Matcher matcherMobile = mobile.matcher(user.getPhoneNum());
        Matcher matcherCm = cm.matcher(user.getPhoneNum());
        Matcher matcherCu = cu.matcher(user.getPhoneNum());
        Matcher matcherCt = ct.matcher(user.getPhoneNum());

        if (!(matcherMobile.find()||
                matcherCm.find()||
                matcherCt.find()||
                matcherCu.find())){
            return false;
        }

        //校验真姓名
        if (user.getRealName()==null || user.getRealName().equals("")){
            return false;
        }

        //校验地址
        if (user.getAddress() == null || user.getAddress().equals("")){
            return false;
        }


        if (UserDAO.loadUserByName(user.getUserName()) != null ) {

            return false;
        }

        return true;
    }



    /**
     * 判断用户合法
     * @param name
     * @param pswd
     * @return
     */
    public  boolean loginValidate(String name,String pswd){

            if (UserDAO.loadUserByNameAndPassword(name, pswd) != null)
                return true;
            else
                return false;

    }

    public boolean userIsExist(Integer id){
        if (UserDAO.loadUserById(id)!=null){
            return true;
        }
        else{
            return false;
        }
    }



}
