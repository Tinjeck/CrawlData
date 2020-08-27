package jdbc;

import vo.Info;
import vo.Result;

import java.sql.*;
import java.util.List;

public class JDBCBase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/hu";
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public void saveResultList(List<Result> result){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pst = null;

        try{
            //加载驱动
            Class.forName(JDBC_DRIVER);
            //获取连接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //初始化执行对象
            stmt = conn.createStatement();

            //开始做保存
            for(Result r : result){
                String sql;
                sql = "insert into result(resultcode) values(?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1,r.getResultcode());
                pst.executeUpdate();

                sql = "insert into resultinfo(count,pageno,payqb,per,saveqb) values(?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setInt(1,r.getResultinfo().getCount());
                pst.setInt(2,r.getResultinfo().getPageno());
                pst.setFloat(3,r.getResultinfo().getPayqb());
                pst.setInt(4,r.getResultinfo().getPer());
                pst.setFloat(5,r.getResultinfo().getSaveqb());
                pst.executeUpdate();

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
                }

            }
            //关闭资源
            pst.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pst!=null) pst.close();
            }catch(SQLException se2){
            } try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

}
