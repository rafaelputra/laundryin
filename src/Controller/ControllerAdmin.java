package Controller;

import DAO.DAOAdmin;
import DAOInterface.IAdmin;
import Model.Adminpage;
import Model.TabelAdmin;
import View.FormAdminPage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
        frame.getTextfield_id().setText("");
        frame.getTextfield_nama().setText("");
        frame.getTextfield_alamat().setText("");
        frame.getTextfield_nohp().setText("");
        frame.getTextfield_tglmasuk().setDate(new Date());
        frame.getTextfield_tglkeluar().setDate(new Date());
        frame.getTextfield_berat().setText("");
        frame.getTextfield_harga().setText("");
        frame.getTextoption_parfum().setSelectedItem("");
        frame.getTextoption_status_pesanan().setSelectedItem("");
        frame.getTextoption_status_antar().setSelectedItem("");
        frame.getTextoption_driver().setSelectedItem("");
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
            Date dateMasuk = frame.getTextfield_tglmasuk().getDate();
            Date dateKeluar = frame.getTextfield_tglkeluar().getDate();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String tglMasukStr = (dateMasuk != null) ? sdf.format(dateMasuk) : "";
            String tglKeluarStr = (dateKeluar != null) ? sdf.format(dateKeluar) : "";

            b.setTgl_masuk(tglMasukStr);
            b.setTgl_keluar(tglKeluarStr);
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
                b.setDriverId(null);
                implAdmin.insert(b);
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
            isiTable();
            //JOptionPane.showMessageDialog(frame,"Silahkan Pilih Data");
        }
    }
    
    public void isiField(int row){
            frame.getTextfield_id().setText(String.valueOf(lb.get(row).getId()));
            frame.getTextfield_nama().setText(lb.get(row).getNama());
            frame.getTextfield_alamat().setText(lb.get(row).getAlamat());
            frame.getTextfield_nohp().setText(lb.get(row).getNohp());
            String tglMasukStr = lb.get(row).getTgl_masuk();
            String tglKeluarStr = lb.get(row).getTgl_keluar();

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            if (tglMasukStr != null && !tglMasukStr.isEmpty()) {
                try {
                    Date dateMasuk = formatter.parse(tglMasukStr);
                    frame.getTextfield_tglmasuk().setDate(dateMasuk);
                } catch (ParseException e) {
                    e.printStackTrace();
                    frame.getTextfield_tglmasuk().setDate(null);
                }
            } else {    
                frame.getTextfield_tglmasuk().setDate(null);
            }

            if (tglKeluarStr != null && !tglKeluarStr.isEmpty()) {
                try {
                    Date dateKeluar = formatter.parse(tglKeluarStr);
                    frame.getTextfield_tglkeluar().setDate(dateKeluar);
                } catch (ParseException e) {
                    e.printStackTrace();
                    frame.getTextfield_tglkeluar().setDate(null);
                }
            } else {
                frame.getTextfield_tglkeluar().setDate(null);
            }


            frame.getTextfield_berat().setText(String.valueOf(lb.get(row).getBeratAsFloat()));
            frame.getTextfield_harga().setText(String.valueOf(lb.get(row).getHargaAsInteger()));
            frame.getTextoption_parfum().setSelectedItem(lb.get(row).getParfum());
            frame.getTextoption_status_pesanan().setSelectedItem(lb.get(row).getStatus_pesanan());
            frame.getTextoption_status_antar().setSelectedItem(lb.get(row).getStatus_antar());
            if (lb.get(row).getNama_driver() != null) {
                frame.getTextoption_driver().setSelectedItem(lb.get(row).getNama_driver());
            } else {
                frame.getTextoption_driver().setSelectedItem("");
            }
    }
    
    public void update(){
            if (!frame.getTextfield_nama().getText().trim().isEmpty()){
                Adminpage b = new Adminpage();
                b.setId(Integer.parseInt(frame.getTextfield_id().getText()));
                b.setNama(frame.getTextfield_nama().getText());
                b.setAlamat(frame.getTextfield_alamat().getText());
                b.setNohp(frame.getTextfield_nohp().getText());
                Date dateMasuk = frame.getTextfield_tglmasuk().getDate();
                Date dateKeluar = frame.getTextfield_tglkeluar().getDate();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String tglMasukStr = (dateMasuk != null) ? sdf.format(dateMasuk) : "";
                String tglKeluarStr = (dateKeluar != null) ? sdf.format(dateKeluar) : "";

                b.setTgl_masuk(tglMasukStr);
                b.setTgl_keluar(tglKeluarStr);
                b.setBerat(Float.parseFloat(frame.getTextfield_berat().getText()));
                b.setHarga(Integer.parseInt(frame.getTextfield_harga().getText()));
                b.setParfum(frame.getTextoption_parfum().getSelectedItem().toString());
                b.setStatus_pesanan(frame.getTextoption_status_pesanan().getSelectedItem().toString());
                b.setStatus_antar(frame.getTextoption_status_antar().getSelectedItem().toString());

                String selectedNamaDriver = frame.getTextoption_driver().getSelectedItem().toString();
                if (driverMap != null && driverMap.containsKey(selectedNamaDriver)) {
                    int driverId = driverMap.get(selectedNamaDriver);
                    b.setDriverId(driverId);

                    implAdmin.update(b);
                    JOptionPane.showMessageDialog(null, "Edit data sukses");
                } else {
                    b.setDriverId(null);
                    implAdmin.update(b);
                }
            }else {
                    JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
                }
            }
    
            public void delete(){
            if (!frame.getTextfield_id().getText().trim().isEmpty()){
                int id = Integer.parseInt(frame.getTextfield_id().getText());
                implAdmin.delete(id);
                JOptionPane.showMessageDialog(null, "Hapus data sukses");
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih data yang akan dihapus");
            }
        }
    }