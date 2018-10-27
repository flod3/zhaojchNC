package com.yonyou.POJO;

import java.lang.reflect.Method;

public class PasswordVO extends SuperVO{
    private String pk_pwd;
    private String username;
    private String password;

    @Override
    public String getTable_name() {
        return "bd_pwd";
    }

    @Override
    public void setAttribution(String key, String value) {
        if(key==null)
            throw new RuntimeException("没输入key");
        key=key.substring(0,1).toUpperCase()+key.substring(1);
        try {
            Method method=this.getClass().getMethod("get"+key,String.class);
            method.invoke(this,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPk_name() {
        return "pk_pwd";
    }

    public String getPk_pwd() {
        return pk_pwd;
    }

    public void setPk_pwd(String pk_pwd) {
        this.pk_pwd = pk_pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getValues() {
        return "( '"+this.pk_pwd+"', '"+this.username+"','"+this.password+"' )";
    }


    @Override
    public String getColumn() {
        return " pk_pwd,username,password ";
    }
}
