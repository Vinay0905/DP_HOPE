package java_solutions.SQL;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
public class App {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/");
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }   

}
