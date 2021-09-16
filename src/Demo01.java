import java.sql.*;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //  1注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2  获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicoding=true&characterEncoding=utf-8", "root", "123456");
        //3   准备状态   传输器对象
        Statement statement =connection.createStatement();
        // 4  执行  获取结果
          String sql01="select *from book";
          String sql02="insert  into book  values (null ,'东北查寝故事','张美玉',9999)";
       // ResultSet resultSet =statement.executeQuery(sql01);
        int  result= statement.executeUpdate(sql02);
        //  5 遍历结果
        /*while (resultSet.next()) {
              System.out.println(resultSet.getInt(1) + "" + resultSet.getString(2)
                    + resultSet.getString(3) + resultSet.getDouble(4)
            );*/
        String message  =result ==-1 ?"没有成功":"操作成功";
        System.out.println(message);
        //6  关闭资源
        statement.close();
         connection.close();
    }
}
