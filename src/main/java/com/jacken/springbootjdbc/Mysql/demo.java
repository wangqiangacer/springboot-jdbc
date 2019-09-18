package com.jacken.springbootjdbc.Mysql;

import java.sql.*;

public class demo {
    public static void main(String[] args) {
        getConnection();

    }
    public static Connection getConnection()
    {
        Connection conn = null; //数据库连接
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //加载数据库驱动，注册到驱动管理器
            /*数据库链接地址*/
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
            String username = "root";
            String password = "root";
            /*创建Connection链接*/
            conn = DriverManager.getConnection(url, username, password);
            CallableStatement cs = conn.prepareCall("{call findUser()}");
            ResultSet resultSet = cs.executeQuery();
            if(resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String userPassword = resultSet.getString(3);
                String email = resultSet.getString(4);
                System.out.println(id+name+userPassword+email);
            }

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn; //返回数据库连接
    }
}
