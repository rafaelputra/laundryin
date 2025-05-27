/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class TabelDriverpage extends AbstractTableModel {
        List<Driverpage> lb;
        
        public TabelDriverpage(List<Driverpage> lb){
            this.lb = lb;
        }
        
        public int getColumnCount(){
            return 10;
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
                case 8:
                    return "Alamat Antar";
                case 9:
                    return "No HP Pelanggan";
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
                case 8:
                    return lb.get(row).getAlamat_antar();
                case 9:
                    return lb.get(row).getNo_Pelanggan();
                default:
                    return null;
            }       
        }
}
