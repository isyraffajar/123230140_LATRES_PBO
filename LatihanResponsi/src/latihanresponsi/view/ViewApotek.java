package latihanresponsi.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewApotek extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnTambah, btnEdit, btnHapus;

    public ViewApotek() {
        setTitle("Dashboard Transaksi Apotek");
        setSize(850, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        String[] columnNames = {"ID", "Nama Pelanggan", "Nama Obat", "Jumlah Beli", "Harga Satuan", "Diskon", "Total Bayar"};
        model = new DefaultTableModel(columnNames, 0) {
            // agar kolom id tidak bisa diedit langsung di table
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 800, 250);
        add(scrollPane);

        btnTambah = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");

        btnTambah.setBounds(250, 290, 100, 30);
        btnEdit.setBounds(370, 290, 100, 30);
        btnHapus.setBounds(490, 290, 100, 30);

        add(btnTambah);
        add(btnEdit);
        add(btnHapus);
    }

    public JTable getTable() {
        return table;
    }

    public JButton getBtnTambah() {
        return btnTambah;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnHapus() {
        return btnHapus;
    }

    public void setTableData(List<String[]> data) {
        model.setRowCount(0);
        for (String[] row : data) {
            model.addRow(row);
        }
    }
}
