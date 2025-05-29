package latihanresponsi.view;

import javax.swing.*;
import latihanresponsi.controller.ControllerApotek;

public class ViewEdit extends JFrame {
    private JTextField tfNamaPelanggan = new JTextField();
    private JTextField tfNamaObat = new JTextField();
    private JTextField tfHargaSatuan = new JTextField();
    private JTextField tfJumlahBeli = new JTextField();
    private JButton btnSimpan = new JButton("Simpan");

    private ControllerApotek controller;
    private int id;

    public ViewEdit(ControllerApotek controller, int id, String namaPelanggan, String namaObat, int hargaSatuan, int jumlahBeli) {
        this.controller = controller;
        this.id = id;

        setTitle("Edit Transaksi");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        add(new JLabel("Nama Pelanggan:")).setBounds(20, 20, 120, 25);
        tfNamaPelanggan.setBounds(150, 20, 200, 25);
        tfNamaPelanggan.setText(namaPelanggan);
        add(tfNamaPelanggan);

        add(new JLabel("Nama Obat:")).setBounds(20, 60, 120, 25);
        tfNamaObat.setBounds(150, 60, 200, 25);
        tfNamaObat.setText(namaObat);
        add(tfNamaObat);

        add(new JLabel("Harga Satuan:")).setBounds(20, 100, 120, 25);
        tfHargaSatuan.setBounds(150, 100, 200, 25);
        tfHargaSatuan.setText(String.valueOf(hargaSatuan));
        add(tfHargaSatuan);

        add(new JLabel("Jumlah Beli:")).setBounds(20, 140, 120, 25);
        tfJumlahBeli.setBounds(150, 140, 200, 25);
        tfJumlahBeli.setText(String.valueOf(jumlahBeli));
        add(tfJumlahBeli);

        btnSimpan.setBounds(120, 190, 150, 30);
        add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            if (validateInput()) {
                controller.updateData(
                    this.id,
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
