/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanresponsi.view;

import javax.swing.*;

public class ViewTambah extends JFrame {

    // Komponen form dipakai di controller
    public JTextField tfNamaPelanggan = new JTextField();
    public JTextField tfNamaObat = new JTextField();
    public JTextField tfHargaSatuan = new JTextField();
    public JTextField tfJumlahBeli = new JTextField();
    public JButton btnTambah = new JButton("Tambah");
    
    //Komponen form label
    JLabel lblNamaPelanggan = new JLabel("Nama Pelanggan:");
    JLabel lblNamaObat = new JLabel("Nama Obat:");
    JLabel lblHargaSatuan = new JLabel("Harga Satuan:");
    JLabel lblJumlahBeli = new JLabel("Jumlah Beli:");

    public ViewTambah() {
        setTitle("Aplikasi Apotek");
        setSize(400, 300);//atur ukuran Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // atur posisi frame di tengah
        setLayout(null);//layout manual
        
       // setBounds(X, Y, Width, Height), X dari kiri, Y dari atas      
        lblNamaPelanggan.setBounds(20, 20, 120, 25);
        tfNamaPelanggan.setBounds(150, 20, 200, 25);
        lblNamaObat.setBounds(20, 60, 120, 25);
        tfNamaObat.setBounds(150, 60, 200, 25);
        lblHargaSatuan.setBounds(20, 100, 120, 25);
        tfHargaSatuan.setBounds(150, 100, 200, 25);     
        lblJumlahBeli.setBounds(20, 140, 120, 25);
        tfJumlahBeli.setBounds(150, 140, 200, 25);
        btnTambah.setBounds(120, 190, 150, 30);

        // Tambah ke frame
        add(lblNamaPelanggan);
        add(tfNamaPelanggan);
        add(lblNamaObat);
        add(tfNamaObat);
        add(lblHargaSatuan);
        add(tfHargaSatuan);
        add(lblJumlahBeli);
        add(tfJumlahBeli);
        add(btnTambah);

        setVisible(true);
    }
}