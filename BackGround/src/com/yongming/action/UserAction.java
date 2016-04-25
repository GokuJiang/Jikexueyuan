package com.yongming.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yongming.dao.UserDAO;
import com.yongming.entity.UsersEntity;
import com.yongming.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by jiangyongming on 4/24/16.
 */
public class UserAction extends ActionSupport implements ModelDriven<UsersEntity> {

    private static final long serialVersionUID = -1799577135387097221L;
    private Integer id;
    private UsersEntity user;
    private String userName;
    private String password;
    private String confirmPassword;
    private String realName;
    private int age;
    private String phoneNum;
    private String address;


    UserService service = UserService.getInstance();


    public String findAll(){
        List<UsersEntity> list = service.findAll();
        ServletActionContext.getRequest().getSession().setAttribute("list",list);
        return "adminSuccess";
    }
    public String loadUser(){
        UsersEntity userEntity = UserDAO.loadUserByName(userName);
        ServletActionContext.getRequest().getSession().setAttribute("user",userEntity);
        return "userSuccess";
    }

    @Test
    /**
     * 注册用户Action
     */
    public String register(){

//        if (!password.equals(confirmPassword)){
//            return "error";
//        }

        UsersEntity user = new UsersEntity(userName,password);
        user.setAge(age);
        user.setPhoneNum(phoneNum);
        user.setRealName(realName);
        user.setAddress(address);
        System.out.println(user.toString());
        if(service.save(user)){
            return SUCCESS;

        }
        else {
            return ERROR;
        }
    }


    public String Login(){
        UsersEntity user = new UsersEntity(userName,password);
        boolean isExist = service.login(user);
        if (isExist){
            if (userName.equals("admin")){
                return findAll();
            }
            else {
                return loadUser();
            }
        }
        else
            return ERROR;
    }



    public String Delete(){
        service.delete(user.getId());
        return findAll();
    }

    /**
     * Getter and Setter
     * @return
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Override
    public UsersEntity getModel() {
        return null;
    }
}
