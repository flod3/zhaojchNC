package com.yonyou.Util;


import com.yonyou.POJO.MenuVO;
import com.yonyou.dao.BaseDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneratePK {


    public static String generate(Class ClassName){
        StringBuffer stringBuffer=new StringBuffer();
        LocalDate ld=LocalDate.now();
        String str=" ";
        BaseDAO dao=new BaseDAO("MySql");
        int i=10;
        do{
            stringBuffer=new StringBuffer();
            stringBuffer.append(ld.format(DateTimeFormatter.ofPattern("yyyyddMM")));
            stringBuffer.append(String.valueOf(i));
            i++;
            str=stringBuffer.toString();
        } while(dao.checkVO(ClassName,str));

            return str;
    }


}
