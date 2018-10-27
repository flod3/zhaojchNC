package com.yonyou.POJO;

import java.lang.reflect.Method;

public class Person_addressVO extends SuperVO{
    private String province;
    private String city;
    private String district;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
