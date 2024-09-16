package utp.restaurant.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DB {
    private String url;
    private String user;
    private String password;
    private Dotenv dotenv;
    
    DB() {
        dotenv = Dotenv.load();
        
        url = dotenv.get("DB_URL"); // jdbc:postgresql://localhost:5432/Restaurant
        user = dotenv.get("DB_USER"); // postgres
        password = dotenv.get("DB_PASSWORD");
        
        System.out.println(url);        
        System.out.println(user);
        
        try {
            
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persona");
            
            while(rs.next()) {
                
                System.out.println(rs.getString("nombre"));
                
            }
            
            
        } catch (SQLException e) {
            
            System.out.println("error");
            
            
        }
        
        
    }
    
   
}

public class NewClass {
    public static void main(String[] args) {
        DB db = new DB();
    }
}
