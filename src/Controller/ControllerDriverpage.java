/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DriverDAO;
import DAOInterface.IDriver;
import Model.Driverpage;
import Model.TabelDriverpage;
import View.FormDriverPage;
import View.FormLoginDriver;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus
 */
public class ControllerDriverpage {
      FormDriverPage frame;
    IDriver implDriverpage;
    List<Driverpage> lb;
    String username; // simpan username di controller

    public ControllerDriverpage(FormDriverPage frame, String username) {
        this.frame = frame;
        this.username = username;
        implDriverpage = new DriverDAO();
        lb = implDriverpage.getAllJob(username); 
    }

    public void isiTable() {
        lb = implDriverpage.getAllJob(username); 
        TabelDriverpage th = new TabelDriverpage(lb);
        frame.getTabelData().setModel(th);
    }

    public void cariId() {
                String input = frame.gettextfield_cari().getText().trim();
            if (!input.isEmpty()) {
                try {
                    int id = Integer.parseInt(input);
                    lb = implDriverpage.getCariId(id,username); 
                    if (lb.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Data tidak ditemukan!");
                    }
                    isiTableCariId();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Masukkan ID yang valid!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Silahkan masukkan ID pesanan.");
            }
        }

    private void isiTableCariId() {
         TabelDriverpage th = new TabelDriverpage(lb);
         frame.getTabelData().setModel(th);
    }
}
