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
    }
