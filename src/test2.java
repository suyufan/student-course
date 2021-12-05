import java.sql.*;

public class test2 {
    public static void main(String[] args) throws Exception{
        Connection con;
        //jdbc驱动
        String driver="com.mysql.cj.jdbc.Driver";
        //这里是我的数据库的信息
        String url="jdbc:mysql://localhost:3306/choiceweb?&useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="suyufanzuimei.";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            //判断连接是否成功
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement=con.createStatement();
            String sql;
            //sql语句
            sql="select * from course";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                String cNo=resultSet.getString("cNo");
                String cName=resultSet.getString("cName");
                String cTeacher=resultSet.getString("cTeacher");
                System.out.println("cNo:"+cNo+"cName:"+cName+"cTeacher:"+cTeacher);
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}

