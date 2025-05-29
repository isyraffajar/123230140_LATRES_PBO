/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanresponsi.model;

import java.sql.*;

public class Koneksi {
    String DBurl = "jdbc:mysql://localhost/latrespbo_apotek";
    String DBusername= "root";
    String DBpassword= "";
    
    Connection koneksi;
    Statement statement;
    
    public Koneksi(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception e){
            System.out.println("Koneksi Gagal");
        }
    }
    
    public Connection getKoneksi(){
        return koneksi;
    }
}
