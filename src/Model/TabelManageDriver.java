/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rafaelputra
 */
public class TabelManageDriver extends AbstractTableModel
    {
        List<Driverpage> lb;
        
        public TabelManageDriver(List<Driverpage> lb){
            this.lb = lb;
        }
        
        public int getColumnCount(){
            return 4;
        }
        
        public int getRowCount(){
            return lb.size();
        }
        
        public String getColumnName(int column){
            switch(column){
                case 0:
                    return "ID";
                case 1:
                    return "Nama";
                case 2:
                    return "Password";
                case 3:
                    return "No HP";
                default:
                    return null;
            }
        }
        
        @Override
        public Object getValueAt(int row, int column){
            switch (column){
                case 0:
                    return lb.get(row).getId();
                case 1:
                    return lb.get(row).getNama();
                case 2:
                    return lb.get(row).getPassword();
                case 3:
                    return lb.get(row).getNoHP_driver();
                default:
                    return null;
            }       
        }
    }
