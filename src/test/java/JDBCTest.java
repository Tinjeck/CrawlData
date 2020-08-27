import vo.Info;
import vo.Result;
import vo.Resultinfo;

import java.sql.*;
import java.util.List;

public class JDBCTest {

    public void save(List<Result> result){

        // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/hu";
        PreparedStatement pst =null;

        // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
        //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


        // 数据库的用户名与密码，需要根据自己的设置
        final String USER = "root";
        final String PASS = "123456";

        Connection conn = null;
        Statement stmt = null;
        int a=0,b=0,c = 0;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            for(Result r : result){
                // 执行查询
                String sql;
                sql = "insert into result(resultcode) values(?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1,r.getResultcode());
                pst.executeUpdate();
                System.out.println("保存result成功");
                a++;

                sql = "insert into resultinfo(count,pageno,payqb,per,saveqb) values(?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setInt(1,r.getResultinfo().getCount());
                pst.setInt(2,r.getResultinfo().getPageno());
                pst.setFloat(3,r.getResultinfo().getPayqb());
                pst.setInt(4,r.getResultinfo().getPer());
                pst.setFloat(5,r.getResultinfo().getSaveqb());
                pst.executeUpdate();
                System.out.println("保存resultinfo成功");
                b++;

                for(Info info : r.getResultinfo().getList()){
                    sql = "insert into info(accttype,balance,info,pay,save,tranday) values(?,?,?,?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,info.getAccttype());
                    pst.setFloat(2,info.getBalance());
                    pst.setString(3,info.getInfo());
                    pst.setString(4,info.getPay());
                    pst.setFloat(5,info.getSave());
                    pst.setString(6,info.getTranday());
                    pst.executeUpdate();
                    System.out.println("保存info成功");
                    c++;
                }

            }
            System.out.println("a="+a);
            System.out.println("b="+b);
            System.out.println("c="+c);


            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

}
