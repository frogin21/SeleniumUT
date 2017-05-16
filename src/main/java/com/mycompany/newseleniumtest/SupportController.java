/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.newseleniumtest;

import java.sql.*;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 *
 * @author RZ
 */
public class SupportController {
	@Test(enabled=true)
   public static void waittoLoad(WebElement w, WebDriverWait wait) {

        wait.until((WebDriver driver) -> w);
    }
    public static String getApID(String email,String database){
        Object o=SupportController.getfromDatabase("SELECT a.apli_id FROM application_data as a INNER JOIN applicant_data as b on a.apli_ap_id=b.ap_id WHERE b.ap_email_address='"+email+"';", database);
        return o.toString();
            
    }
    public static Object getfromDatabase(String query, String database) {
        Connection con;
        Statement stmt;
        ResultSet rs;
        Object output;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            switch (database) {
                case "local":
                    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/tuingtuing", "root", "");
                    break;
               case "dev":
//                   con = DriverManager.getConnection("jdbc:mysql://10.0.0.13/utdev2015", "rheno", "(*&^5erfg~!@#$%ygfSDF876r$RTG7tr)(*");
                   con = DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");

                   break;
                   
              case "hotfix":
                   con = DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                   break;
               case "staging":
//                  con = DriverManager.getConnection("jdbc:mysql://10.0.0.13/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                   con = DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                   break;
                default:
                    throw new Exception("No Database with that name");
            }

            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            output = rs.getObject(1);
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            return "Error:" + e.getMessage();
        }
        return output;
    }

    public static String createRandom(int Digits) {
        String result = new String();
        Random rand = new Random();
        for (int i = 0; i < Digits; i++)
        {
            result = result + rand.nextInt(9);
        }
        return result;
    }

    
}