/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicesclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author User
 */
public class Methods {
    //HTTP GET request
    public static String sendGet(String url)throws Exception{
        
        
        URL obj=new URL(url);
        HttpURLConnection con =(HttpURLConnection) obj.openConnection();
        
        con.setRequestMethod("GET");
        
        con.setRequestProperty("Accept", "application/json");
        
//        int responseCode=con.getResponseCode();
//    
//        System.out.println("\nSending 'GET' request to URL: ");
//        System.out.println("Resoinse Code: "+responseCode);
        
        BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer response =new StringBuffer();
        
        while((inputLine=in.readLine())!=null){
            response.append(inputLine);
        }
        in.close();
        
        //System.out.println(response.toString());
        
        return response.toString();
    }
    
    public static String sendPost(String url, String data)throws Exception{
        
        
        URL obj=new URL(url);
        HttpURLConnection con =(HttpURLConnection) obj.openConnection();
        
        con.setRequestMethod("POST");
        
        con.setRequestProperty("Accept", "application/xml");
        con.setRequestProperty("Content-Type", "application/json");
        
        con.setDoOutput(true);
        DataOutputStream wr=new DataOutputStream(con.getOutputStream());
        wr.writeBytes(data);
        wr.flush();
        wr.close();


        BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer response =new StringBuffer();
        
        while((inputLine=in.readLine())!=null){
            response.append(inputLine);
        }
        in.close();
        
        //System.out.println(response.toString());
        
        return response.toString();
    }
}
