/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.newseleniumtest;

import java.awt.AWTException;

import org.testng.annotations.Test;


/**
 *
 * @author RZ
 */
public class Main{
	
    public static void main(String[] args) throws InterruptedException, AWTException{
        boolean summary =true;
        TestScript ts = new TestScript("myjne020@gmail.com");
        ts.testLocation= "dev";
//        ts.isCampaign=true;
//        ts.promo_code="QANOMOR1";
//        ts.isPromo = true;       
//       ts.ApplytoDisburse();
           ts.Apply_new();
//          ts.processFraud();
          ts.processsupercs();
         ts.processStaff();
        ts.processManager();
         ts.doingdisburse(true);
//        ts.processSupermanagerDisburse(true);
//        ts.Apply_Partner();
           
//           coba cb= new coba();
//           cb.latihan("testing on firefox");

    }
    
}
