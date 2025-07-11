package jdbc;

import io.github.cdimascio.dotenv.Dotenv;

public class TesteConexao {
    public static void main(String[] args) {
         
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String pass = dotenv.get("DB_PASS");

        System.out.println("DB_URL = " + url);
        System.out.println("DB_USER = " + user);
        System.out.println("DB_PASS = " + pass);
    }
    
}