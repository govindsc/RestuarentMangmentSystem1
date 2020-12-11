import java.sql.*;

public class Data {
    public static Connection connect(){
        Connection con=null;
        try{
         Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restuarantmangmentdata","root","devchouhan123");
    }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}

 