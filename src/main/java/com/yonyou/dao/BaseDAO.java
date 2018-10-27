package com.yonyou.dao;

import com.yonyou.POJO.PasswordVO;
import com.yonyou.POJO.SuperVO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDAO {
    private Connection conn;

    public Connection getConnection() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public BaseDAO(String DatabaesType) {
        try {
            ConnectDatabase connectDatabase=null;
            BeanFactory factory=new ClassPathXmlApplicationContext("applicationContext.xml");

            if(DatabaesType.equals("MySql"))
                connectDatabase =(ConnectDatabase)factory.getBean("ConnectMySql");
            else if(DatabaesType.equals("Oracle"))
                connectDatabase =(ConnectDatabase)factory.getBean("ConnectOracle");

             conn=connectDatabase.getConnection();

             conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void insertVO(SuperVO superVO){

        String table_name=superVO.getTable_name();
        String values=superVO.getValues();
        String pk=superVO.getPk_name();
        String columns=superVO.getColumn();
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("insert into ");
        stringBuffer.append(table_name);
        stringBuffer.append(" (");
        stringBuffer.append(columns);
        stringBuffer.append(" ) values");
        stringBuffer.append(values);
        String sql=stringBuffer.toString();
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            int result=preparedStatement.executeUpdate();
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public boolean checkUser(String username , String password){

        String sql="select pk_pwd from bd_pwd where username='"+username+"' and password='"+password+"'";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.last();
            if(resultSet.getRow()==0){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    public boolean checkVO(Class classname,String pk_value) {
        try {
            Object obj = classname.newInstance();
            if (obj instanceof SuperVO) {
                SuperVO vo = (SuperVO) obj;
                String pk_name = vo.getPk_name();
                String sql = "select * from " + vo.getTable_name() + " where " + vo.getPk_name() + "='" + pk_value+"'";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.last();
                if (resultSet.getRow()==0)
                    return false;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return true;

    }

    public ArrayList<SuperVO> getVOwithCase(Class classname, String wherepart){
        StringBuffer sqlbuffer=new StringBuffer();
        SuperVO vo=null;
        try {
             vo=(SuperVO)classname.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        sqlbuffer.append("select ");
        sqlbuffer.append(vo.getColumn());
        sqlbuffer.append(" from ");
        sqlbuffer.append(vo.getTable_name());
        sqlbuffer.append(" where ");
        sqlbuffer.append(wherepart);
        String sql=sqlbuffer.toString();
        try {
            ArrayList<SuperVO> superVOS=new ArrayList<>();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                SuperVO superVO=vo.getClass().newInstance();
                for(int j=1;j<resultSet.getMetaData().getColumnCount();j++) {

                    String key=resultSet.getMetaData().getColumnName(j);
                  String value= resultSet.getString(j);
                  superVO.setAttribution(key,value);

                }
                superVOS.add(superVO);
            }
            return superVOS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateVO(SuperVO superVO){

    }

    public void deleteVO(SuperVO superVO){

    }

}
