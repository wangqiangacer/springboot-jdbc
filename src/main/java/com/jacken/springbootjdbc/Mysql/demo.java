package com.jacken.springbootjdbc.Mysql;

import java.sql.*;

/**
 * drop PROCEDURE p_judge;
 * -- 定义存储过程
 *-- if else
 * delimiter //
 * CREATE PROCEDURE p_judge()
 * BEGIN
 * DECLARE number1 int;
 * declare number2 int;
 * set number1 =1;
 * set number2 =2;
 *
 *
 * if number1>number2 then
 * SELECT 'true'as result ;
 * ELSE
 * SELECT 'false'result ;
 * end if;
 *
 * END
 * //
 *
 * 定义存储过程mysql very important
 *
 */
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

/**
 * delimiter //
 * CREATE PROCEDURE p_judge()
 * BEGIN
 * DECLARE number1 int;
 * set number1 =2;
 * case number1
 * when 1 then
 * SELECT '我是1' as result ;
 * when 2 then
 * SELECT '我是2' as result;
 * end case;
 * END
 * //
 *
 * case 相当于java中的switch  case
 */
