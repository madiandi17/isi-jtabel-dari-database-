package com.wordpress.bmadi.belajar.jtable.tablemodel;

import com.wordpress.bmadi.belajar.jtable.model.Kontak;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class KontakTableModel extends AbstractTableModel {

    private List<Kontak> dataKontak;

    public KontakTableModel(List<Kontak> dataKontak) {
        this.dataKontak = dataKontak;
    }
    
    public List<Kontak> getData(){
        return dataKontak;
    }
    
    public int getRowCount() {
        return dataKontak.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Kontak k = dataKontak.get(rowIndex);
        if (columnIndex == 0) {
            return k.getNama();
        }
        if (columnIndex == 1) {
            return k.getAlamat();
        }
        if (columnIndex == 2) {
            return k.getTanggalLahir();
        }
        if (columnIndex == 3) {
            return k.getAktif();
        }
        return "undefined";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nama";
        }
        if (columnIndex == 1) {
            return "Alamat";
        }
        if (columnIndex == 2) {
            return "Tanggal Lahir";
        }
        if (columnIndex == 3) {
            return "Status";
        }
        return "undefined";
    }

}
