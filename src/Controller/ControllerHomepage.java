/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAO;
import DAOInterface.ILaundryin;
import Model.Homepage;
import Model.TabelHomepage;
import View.FormLaundryin;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rafaelputra
 */
public class ControllerHomepage
    {
        FormLaundryin frame;
        ILaundryin implHomepage;
        List<Homepage> lb;
        
        public ControllerHomepage(FormLaundryin frame){
            this.frame = frame;
            implHomepage = new DAO();
            lb = implHomepage.getAll();
        }
        
        public void isiTable(){
            lb = implHomepage.getAll();
            TabelHomepage th = new TabelHomepage(lb);
            frame.getTabelData().setModel(th);
        }
        
        public void isiTableCariId(){
            lb=implHomepage.getCariId(Integer.parseInt(frame.gettextfield_cari().getText()));
            TabelHomepage th =new TabelHomepage(lb);
            frame.getTabelData().setModel(th);
        }
        
        public void cariId(){
            String input = frame.gettextfield_cari().getText().trim();

            if (!input.isEmpty()) {
                            int id = Integer.parseInt(input);
                             implHomepage.getCariId(id); 
                            isiTableCariId();
            } else{
                JOptionPane.showMessageDialog(frame,"Silahkan Pilih Data");
            }
        }
    }
