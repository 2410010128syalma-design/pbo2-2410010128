/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p02;

/**
 *
 * @author ASUS
 */
public class Skripsi extends Koleksi {
    private String penulis;
    private String programStudi;

    // Constructor menyesuaikan super(kode, judul, tahunTerbit) di Koleksi.java
    public Skripsi(String kode, String judul, int tahunTerbit, String penulis, String programStudi) {
        super(kode, judul, tahunTerbit);
        this.penulis = penulis;
        this.programStudi = programStudi;
    }

    // Getter (optional, tapi baik untuk dimiliki)
    public String getPenulis() {
        return penulis;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    // Skripsi hanya dibaca di tempat (batas hari = 0)
    @Override
    public int batasHariPinjam() {
        return 0;
    }

    // Denda Skripsi selalu 0
    @Override
    public long hitungDenda(int hariTerlambat) {
        return 0;
    }

    // Menampilkan keterangan spesifik Skripsi (penulis dan program studi)
    @Override
    public String keterangan() {
        return "Skripsi karya " + penulis + " (Prodi: " + programStudi + ")";
    }

    // Override pinjam() agar Skripsi TIDAK BISA dipinjam (selalu mengembalikan false)
    @Override
    public boolean pinjam() {
        return false;
    }
}
