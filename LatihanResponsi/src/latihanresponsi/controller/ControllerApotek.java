package latihanresponsi.controller;

import latihanresponsi.model.ModelApotek;
import latihanresponsi.view.ViewApotek;
import latihanresponsi.view.ViewTambah;
import latihanresponsi.view.ViewEdit;

import javax.swing.*;
import java.util.List;

public class ControllerApotek {
    private ModelApotek model;
    private ViewApotek view;

    public ControllerApotek(ViewApotek view) {
        this.view = view;
        this.model = new ModelApotek();

        loadTable();

        view.getBtnTambah().addActionListener(e -> {
            ViewTambah vt = new ViewTambah(this);
            vt.setVisible(true);
        });

        view.getBtnEdit().addActionListener(e -> {
            int row = view.getTable().getSelectedRow();
            if (row != -1) {
                int id = Integer.parseInt(view.getTable().getValueAt(row, 0).toString());
                String[] data = model.getDataById(id);
                if (data != null) {
                    ViewEdit ve = new ViewEdit(this, id, data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    ve.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Silakan pilih baris data yang ingin diedit.");
            }
        });

        view.getBtnHapus().addActionListener(e -> {
            int row = view.getTable().getSelectedRow();
            if (row != -1) {
                int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int id = Integer.parseInt(view.getTable().getValueAt(row, 0).toString());
                    model.delete(id);
                    loadTable();
                }
            } else {
                JOptionPane.showMessageDialog(view, "Silakan pilih baris data yang ingin dihapus.");
            }
        });
    }

    public void tambahData(String namaPelanggan, String namaObat, int harga, int jmlBeli) {
        model.insert(namaPelanggan, namaObat, harga, jmlBeli);
        loadTable();
    }

    public void updateData(int id, String namaPelanggan, String namaObat, int harga, int jmlBeli) {
        model.update(id, namaPelanggan, namaObat, harga, jmlBeli);
        loadTable();
    }

    private void loadTable() {
        List<String[]> data = model.getAllData();
        view.setTableData(data);
    }
}
