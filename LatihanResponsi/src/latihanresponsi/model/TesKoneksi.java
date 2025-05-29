/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanresponsi.model;

import latihanresponsi.model.Koneksi;
import java.sql.Connection;

public class TesKoneksi {
    public static void main(String[] args) {
        Koneksi koneksiDB = new Koneksi();
        Connection conn = koneksiDB.getKoneksi();

        if (conn != null) {
            System.out.println("✔ Koneksi sukses ke database!");
        } else {
            System.out.println("✖ Gagal terkoneksi ke database!");
        }
    }
}