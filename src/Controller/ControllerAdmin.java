package Controller;

import DAO.DAOAdmin;
import DAOInterface.IAdmin;
import Model.Adminpage;
import Model.TabelAdmin;
import View.FormAdminPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rafaelputra
 */
public class ControllerAdmin
    {
    FormAdminPage frame;
    IAdmin implAdmin;
    List<Adminpage> lb;
    private Map<String, Integer> driverMap;
        
    public ControllerAdmin(FormAdminPage frame){
        this.frame = frame;
        implAdmin = new DAOAdmin();
        lb = implAdmin.getAll();
        driverMap = implAdmin.getDriverNameIdMap();
    }
    
    public void reset(){
        frame.getTextfield_nama().setText("");
        frame.getTextfield_alamat().setText("");
        frame.getTextfield_nohp().setText("");
        frame.getTextfield_berat().setText("");
        frame.getTextfield_harga().setText("");
        frame.getTextoption_parfum().setSelectedItem("");
    }
    
    public void isiTable(){
        lb = implAdmin.getAll();
        TabelAdmin th = new TabelAdmin(lb);
        frame.getTabelData().setModel(th);
        }

    public void insert(){   
        if (!frame.getTextfield_nama().getText().trim().isEmpty()){
            Adminpage b = new Adminpage();
            b.setNama(frame.getTextfield_nama().getText());
            b.setAlamat(frame.getTextfield_alamat().getText());
            b.setNohp(frame.getTextfield_nohp().getText());
            b.setBerat(Float.parseFloat(frame.getTextfield_berat().getText()));
            b.setHarga(Integer.parseInt(frame.getTextfield_harga().getText()));
            b.setParfum(frame.getTextoption_parfum().getSelectedItem().toString());
            b.setStatus_pesanan(frame.getTextoption_status_pesanan().getSelectedItem().toString());
            b.setStatus_antar(frame.getTextoption_status_antar().getSelectedItem().toString());

            String selectedNamaDriver = frame.getTextoption_driver().getSelectedItem().toString();
            if (driverMap != null && driverMap.containsKey(selectedNamaDriver)) {
                int driverId = driverMap.get(selectedNamaDriver);
                b.setDriverId(driverId);

                implAdmin.insert(b);  // hanya di sini!
                JOptionPane.showMessageDialog(null, "Simpan Data sukses");
            } else {
                JOptionPane.showMessageDialog(null, "Driver tidak valid atau belum dimuat.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }


    public Map<String, Integer> getDriverMap() {
        return driverMap;
    }
    
    public void isiTableCariId(){
        lb=implAdmin.getCariId(Integer.parseInt(frame.gettextfield_cari().getText()));
        TabelAdmin th =new TabelAdmin(lb);
        frame.getTabelData().setModel(th);
    }
    
    public void cariId(){
        String input = frame.gettextfield_cari().getText().trim();

        if (!input.isEmpty()) {
            int id = Integer.parseInt(input);
            implAdmin.getCariId(id); 
            isiTableCariId();
        } else{
            JOptionPane.showMessageDialog(frame,"Silahkan Pilih Data");
        }
    }
    
    public void isiField(int row){
            frame.getTextfield_nama().setText(lb.get(row).getNama());
            frame.getTextfield_alamat().setText(lb.get(row).getAlamat());
            frame.getTextfield_nohp().setText(lb.get(row).getNohp());
            frame.getTextfield_tglmasuk().setText(lb.get(row).getTgl_masuk());
            frame.getTextfield_tglkeluar().setText(lb.get(row).getTgl_keluar());
            frame.getTextfield_berat().setText(lb.get(row).getBerat());
            frame.getTextfield_harga().setText(lb.get(row).getHarga());
            frame.getTextoption_parfum().setSelectedItem(lb.get(row).getParfum());
            frame.getTextoption_status_pesanan().setSelectedItem(lb.get(row).getStatus_pesanan());
            frame.getTextoption_status_antar().setSelectedItem(lb.get(row).getStatus_antar());
            frame.getTextoption_driver().setSelectedItem(lb.get(row).getDriverId());
    }
    
    public void update(){
            if (!frame.getTextfield_nama().getText().trim().isEmpty()){
                Adminpage b = new Adminpage();
                b.setId(Integer.parseInt(frame.getTextfield_id().getText()));
                b.setNama(frame.getTextfield_nama().getText());
                b.setAlamat(frame.getTextfield_alamat().getText());
                b.setNohp(frame.getTextfield_nohp().getText());
                b.setTgl_masuk(frame.getTextfield_tglmasuk().getText());
                b.setTgl_keluar(frame.getTextfield_tglkeluar().getText());
                b.setBerat(Float.parseFloat(frame.getTextfield_berat().getText()));
                b.setHarga(Integer.parseInt(frame.getTextfield_harga().getText()));
                b.setParfum(frame.getTextoption_parfum().getSelectedItem().toString());
                b.setStatus_pesanan(frame.getTextoption_status_pesanan().getSelectedItem().toString());
                b.setStatus_antar(frame.getTextoption_status_antar().getSelectedItem().toString());

                String selectedNamaDriver = frame.getTextoption_driver().getSelectedItem().toString();
                if (driverMap != null && driverMap.containsKey(selectedNamaDriver)) {
                    int driverId = driverMap.get(selectedNamaDriver);
                    b.setDriverId(driverId);

                    implAdmin.insert(b);
                    JOptionPane.showMessageDialog(null, "Simpan Data sukses");
                } else {
                    JOptionPane.showMessageDialog(null, "Driver tidak valid atau belum dimuat.");
                }
                
                implAdmin.update(b);
                JOptionPane.showMessageDialog(null, "Update Data sukses");  
                } else {
                    JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
                }
            }
    }