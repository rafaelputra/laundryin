/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laundryin;

import Helper.KoneksiDB;
import View.FormLaundryin;
import javax.swing.SwingUtilities;

/**
 *
 * @author rafaelputra
 */
public class Laundryin
    {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KoneksiDB.getConnection();
        
        SwingUtilities.invokeLater(() -> {
            FormLaundryin form = new FormLaundryin();
            form.setVisible(true);
            form.setLocationRelativeTo(null);
        });
    }
    
    }
