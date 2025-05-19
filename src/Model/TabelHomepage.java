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
public class TabelHomepage extends AbstractTableModel
    {
        List<Homepage> lb;
        
        public TabelHomepage(List<Homepage> lb){
            this.lb = lb;
        }
        
        public int getColumnCount(){
            return 8;
        }
        
        public int getRowCount(){
            return lb.size();
        }
        
        public String getColumnName(int column){
            switch(column){
                case 0:
                    return "ID";
                case 1:
                    return "Tgl Masuk";
                case 2:
                    return "Tgl Keluar";
                case 3:
                    return "Berat";
                case 4:
                    return "Harga";
                case 5:
                    return "Status Pesanan";
                case 6:
                    return "Status Antar";
                case 7:
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
                    return lb.get(row).getTgl_masuk();
                case 2:
                    return lb.get(row).getTgl_keluar();
                case 3:
                    return lb.get(row).getBerat();
                case 4:
                    return lb.get(row).getHarga();
                case 5:
                    return lb.get(row).getStatus_pesanan();
                case 6:
                    return lb.get(row).getStatus_antar();
                case 7:
                    return lb.get(row).getNama_driver();
                default:
                    return null;
            }       
        }
    }
