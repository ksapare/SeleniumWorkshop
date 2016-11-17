package com.test;
import java.sql.*;

/**
 * Test class to read data from database
 */
public class DatabaseTest {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:postgresql://localhost:5432/demo";

        //Database Username
        String username = "postgres";

        //Database Password
        String password = "test";

        //Query to fetch order details from orders table
        String query = "select * from orders;";

        //Load mysql jdbc driver
        Class.forName("org.postgresql.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){

            String orderid = rs.getString(1);

            String userName = rs.getString(2);

            String itemid = rs.getString(3);

            String itemqty = rs.getString(4);

            String itemprice = rs.getString(5);

            String total = rs.getString(6);

            System.out.println(orderid+" , "+ itemid +" , " + itemqty + " , " + itemprice + " , " + total);

        }
        // closing DB Connection
        con.close();
    }
}
