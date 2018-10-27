package com.yonyou.POJO;

import java.lang.reflect.Method;

public class UserVO extends SuperVO{
    private String pk_user;
    private String username;
    private Person_addressVO person_address;

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
    public String getValues() {
        return null;
    }

    @Override
    public String getColumn() {
        return null;
    }

    @Override
    public String getTable_name() {
        return null;
    }

    @Override
    public String getPk_name() {
        return null;
    }

    public String getPk_user() {
        return pk_user;
    }

    public void setPk_user(String pk_user) {
        this.pk_user = pk_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Person_addressVO getPerson_address() {
        return person_address;
    }

    public void setPerson_address(Person_addressVO person_address) {
        this.person_address = person_address;
    }
}
