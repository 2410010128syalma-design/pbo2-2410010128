/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package id.ac.uniska.pbo2.p07;

/**
 *
 * @author ASUS
 */
public class P07TabelDanMenu {

    public static void main(String[] args) {
        com.formdev.flatlaf.FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            DialogKontak dialog = new DialogKontak(null, "Ubah Kontak", null);
            dialog.setVisible(true);
            System.exit(0);
        });
    }
}
