package real_estate_networking_and_solutions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Real_Estate_Networking_And_Solutions {


    public Connection connection;
            
    public void connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=RealEstate;selectMethod=cursor", "sa", "123456");

            System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

            Statement statement = connection.createStatement();
             
            ResultSet resultSet = statement
                    .executeQuery("SELECT Name FROM REAL_ESTATE_COMPANY");
            
         
             while (resultSet.next()) {
                
                System.out.println("Developer NAME:" + 
                        resultSet.getString("Name"));
                
            }
               
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        
        Real_Estate_Networking_And_Solutions cnObj = new Real_Estate_Networking_And_Solutions();  
        cnObj.connectDB();
        
    }
    
}