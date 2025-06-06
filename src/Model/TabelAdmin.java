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
public class TabelAdmin extends AbstractTableModel
    {
        List<Adminpage> lb;
        
        public TabelAdmin(List<Adminpage> lb){
            this.lb = lb;
        }
        
        public int getColumnCount(){
            return 12;
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
                    return "Alamat";
                case 3:
                    return "No HP";
                case 4:
                    return "Tgl masuk";    
                case 5:
                    return "Tgl keluar";
                case 6:
                    return "Berat";
                case 7:
                    return "Harga";
                case 8:
                    return "Parfum";
                case 9:
                    return "Status Pesanan";
                case 10:
                    return "Status Antar";
                case 11:
                    return "Nama Driver";
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
                    return lb.get(row).getAlamat();
                case 3:
                    return lb.get(row).getNohp();
                case 6:    
                    return lb.get(row).getBerat();
                case 7:
                    return lb.get(row).getHarga();
                case 8:
                    return lb.get(row).getParfum();
                case 9:
                    return lb.get(row).getStatus_pesanan();
                case 10:
                    return lb.get(row).getStatus_antar();
                case 11:
                    return lb.get(row).getNama_driver();
                default:
                    return null;
            }       
        }
    }
