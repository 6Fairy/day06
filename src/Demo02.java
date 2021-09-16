import java.sql.*;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //  1注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //  2获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "123456");

        //3 准备传输状态
        String sql01 = "select *from  book  ";
        String sql02 = "insert into book values(? ,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql02);
        //   4查询
        //preparedStatement.setString(1,"我");
        preparedStatement.setInt(1,6);
        preparedStatement.setString(2,"东北查寝故事");
        preparedStatement.setString(3,"美玉");
        preparedStatement.setDouble(4,999);
      //  ResultSet  resultSet =preparedStatement.executeQuery(sql01);
        int result =preparedStatement.executeUpdate();

        //5  遍历结果
       /* while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "" + resultSet.getString(2)+""
                    + resultSet.getString(3) + resultSet.getDouble(4)
            );}*/
            //  6  关闭资源
           // resultSet.close();
            preparedStatement.close();
            connection.close();
        }
    }
