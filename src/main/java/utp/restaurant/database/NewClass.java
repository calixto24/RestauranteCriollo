package utp.restaurant.database;

import io.github.cdimascio.dotenv.Dotenv;

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
        
    }
    
   
}

public class NewClass {
    public static void main(String[] args) {
        DB db = new DB();
    }
}
