/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanresponsi.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ViewApotek extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnTambah, btnEdit, btnHapus;

    public ViewApotek() {
        setTitle("Dashboard Transaksi Apotek");
        setSize(850, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);  // manual layout

        // Nama kolom tabel
        String[] columnNames = {"ID", "Nama Pelanggan", "Nama Obat", "Jumlah Beli", "Harga Satuan", "Diskon", "Total Bayar"};

        // Model tabel dengan 0 baris data awal
        model = new DefaultTableModel(columnNames, 0);

        // Contoh data awal
        addDataRow("1", "Andi", "Paracetamol", 6, 10000);
        addDataRow("2", "Sari", "Amoxicillin", 4, 12000);
        addDataRow("3", "Budi", "Bodrex", 10, 9000);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 800, 250);
        add(scrollPane);

        // Tombol Tambah, Edit, Hapus
        btnTambah = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");

        btnTambah.setBounds(250, 290, 100, 30);
        btnEdit.setBounds(370, 290, 100, 30);
        btnHapus.setBounds(490, 290, 100, 30);

        add(btnTambah);
        add(btnEdit);
        add(btnHapus);

        // Listener tombol
        btnTambah.addActionListener(e -> {new ViewTambah();});

        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data untuk diedit");
            } else {
                String namaPelanggan = "Sari";
                String namaObat = "Paracetamol";
                int hargaSatuan = 10000;
                int jumlahBeli = 6;

    new ViewEdit(namaPelanggan, namaObat, hargaSatuan, jumlahBeli);
            }
        });

        btnHapus.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data untuk dihapus");
            } else {
                int konfirmasi = JOptionPane.showConfirmDialog(this,
                        "Yakin ingin hapus data ID " + model.getValueAt(row, 0) + "?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION);
                if (konfirmasi == JOptionPane.YES_OPTION) {
                    model.removeRow(row);
                }
            }
        });

        setVisible(true);
    }

    // Tambah data ke tabel, otomatis hitung diskon & total bayar
    private void addDataRow(String id, String namaPelanggan, String namaObat, int jumlahBeli, int hargaSatuan) {
        int totalHarga = jumlahBeli * hargaSatuan;
        int diskon = 0;
        if (jumlahBeli > 5) {
            diskon = (int) (totalHarga * 0.1);  // diskon 10%
        }
        int totalBayar = totalHarga - diskon;

        model.addRow(new Object[]{id, namaPelanggan, namaObat, jumlahBeli, hargaSatuan, diskon, totalBayar});
    }

}
