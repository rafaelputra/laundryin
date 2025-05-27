/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAO;
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
        implDriverpage = new DAO();
        lb = implDriverpage.getAllJob(username); 
    }

    public void isiTable() {
        lb = implDriverpage.getAllJob(username); 
        TabelDriverpage th = new TabelDriverpage(lb);
        frame.getTabelData().setModel(th);
    }

    public void cariId() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
