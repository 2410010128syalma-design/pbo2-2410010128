/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class BarangTableModel extends AbstractTableModel {
    private static final String[] KOLOM = {"Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal"};
    private final List<Barang> daftar = new ArrayList<>();

    @Override public int getRowCount() { 
        return daftar.size(); 
    }
    
    @Override public int getColumnCount() {
        return KOLOM.length; 
    }
    
    @Override public String getColumnName(int kolom) {
        return KOLOM[kolom]; 
    }
    
    @Override
    public Object getValueAt(int baris, int kolom) {
        Barang b = daftar.get(baris);
        return switch (kolom) {
            case 0 -> b.getNama();
            case 1 -> b.getKategori();
            case 2 -> rupiah(b.getHarga());
            default -> b.getJumlah();    
        };
    }
    
    public Barang get(int baris) {
        return daftar.get(baris);
    }
    
    public void tambah(Barang barang) {
        daftar.add(barang);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris); // tampilkan baris baru
    }
    
    public void bersihkan(int baris) {
        daftar.remove(baris);
        fireTableRowsDeleted(baris, baris);
    }
    
    public static String rupiah(long nilai) {
        DecimalFormatSymbols s = new DecimalFormatSymbols();
        s.setGroupingSeparator('.');
        return "Rp" + new DecimalFormat("#,##0", s).format(nilai);
    }

   
    public boolean sudahAda(String nama) {
        for (Barang b : daftar) {
            if (b.getNama().equalsIgnoreCase(nama)) return true;
        }
        return false;
    }

   
    public long getTotal() {
        long total = 0;
        for (Barang b : daftar) total += b.getSubtotal();
        return total;
    }

    public long getDiskon() {
        long total = getTotal();
        return total >= 100000 ? total / 10 : 0;   // pembagian long = dibulatkan ke bawah
    }

    public long getBayar() { return getTotal() - getDiskon(); }

    
}
