package com.yonyou.POJO;

import java.lang.reflect.Method;

public class MenuVO extends SuperVO{
    String pk_menu;
    String code;
    String name;
    String father_menu;
    String level;

    @Override
    public void setAttribution(String key, String value) {
        if(key==null)
            throw new RuntimeException("没输入key");
        key=key.substring(0,1).toUpperCase()+key.substring(1);
        try {
            Method method=this.getClass().getMethod("set"+key,String.class);
            method.invoke(this,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTable_name() {
        return "bd_menu";
    }

    @Override
    public String getPk_name() {
        return "pk_menu";
    }

    @Override
    public String getValues() {

        return "('"+this.pk_menu+"' ,'"+this.code+"' ,'"+this.name+"' ,'"+this.father_menu+"' ,"+this.level+")";
    }

    @Override
    public String getColumn() {
        return " pk_menu, code, name, father_menu, level";
    }

    public String getPk_menu() {
        return pk_menu;
    }

    public void setPk_menu(String pk_menu) {
        this.pk_menu = pk_menu;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_menu() {
        return father_menu;
    }

    public void setFather_menu(String father_menu) {
        this.father_menu = father_menu;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
