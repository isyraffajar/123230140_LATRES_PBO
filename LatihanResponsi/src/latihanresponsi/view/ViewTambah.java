package latihanresponsi.view;

import javax.swing.*;
import latihanresponsi.controller.ControllerApotek;

public class ViewTambah extends JFrame {
    private JTextField tfNamaPelanggan = new JTextField();
    private JTextField tfNamaObat = new JTextField();
    private JTextField tfHargaSatuan = new JTextField();
    private JTextField tfJumlahBeli = new JTextField();
    private JButton btnTambah = new JButton("Tambah");

    private ControllerApotek controller;

    public ViewTambah(ControllerApotek controller) {
        this.controller = controller;

        setTitle("Tambah Transaksi");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        add(new JLabel("Nama Pelanggan:")).setBounds(20, 20, 120, 25);
        tfNamaPelanggan.setBounds(150, 20, 200, 25);
        add(tfNamaPelanggan);

        add(new JLabel("Nama Obat:")).setBounds(20, 60, 120, 25);
        tfNamaObat.setBounds(150, 60, 200, 25);
        add(tfNamaObat);

        add(new JLabel("Harga Satuan:")).setBounds(20, 100, 120, 25);
        tfHargaSatuan.setBounds(150, 100, 200, 25);
        add(tfHargaSatuan);

        add(new JLabel("Jumlah Beli:")).setBounds(20, 140, 120, 25);
        tfJumlahBeli.setBounds(150, 140, 200, 25);
        add(tfJumlahBeli);

        btnTambah.setBounds(120, 190, 150, 30);
        add(btnTambah);

        btnTambah.addActionListener(e -> {
            if (validateInput()) {
                // Kirim data ke controller
                controller.tambahData(
                    tfNamaPelanggan.getText(),
                    tfNamaObat.getText(),
                    Integer.parseInt(tfHargaSatuan.getText()),
                    Integer.parseInt(tfJumlahBeli.getText())
                );
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Mohon isi data dengan benar.");
            }
        });
    }

    private boolean validateInput() {
        try {
            if (tfNamaPelanggan.getText().isEmpty() || tfNamaObat.getText().isEmpty())
                return false;
            Integer.parseInt(tfHargaSatuan.getText());
            Integer.parseInt(tfJumlahBeli.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
}
