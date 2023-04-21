package DAL;
import java.sql.*;

class DatabaseAccess {
    private static String conString = "jdbc:sqlserver://LAPTOP-QNC29JHR;databaseName=QLVPP";
    private static String username = "sa1";
    private static String passwd = "123";
    protected static Connection conn;
    protected static Statement statement;
    protected static PreparedStatement ps;
    protected static ResultSet resultSet;
    protected static ResultSet resultSet1;

    protected static void getConnection(){
        try{
            conn = DriverManager.getConnection(conString, username, passwd);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    protected static void closeConnection(){
        try{
        	if (conn != null)
        		conn.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
