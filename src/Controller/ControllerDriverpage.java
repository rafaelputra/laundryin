/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DriverDAO;
import DAOInterface.IDriver;
import Model.Driverpage;
import Model.TabelDriverpage;
import Model.TabelManageDriver;
import View.FormDriverPage;
import View.FormManageDriver;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus
 */
public class ControllerDriverpage {
    FormDriverPage frame;
    FormManageDriver frame2;
    IDriver implDriverpage;
    List<Driverpage> lb;
    String username;

    public ControllerDriverpage(FormManageDriver frame){
        this.frame2 = frame;
        implDriverpage = new DriverDAO();
        lb = implDriverpage.getAll();
    }
    
    public void isiTableManageDriver(){
        lb = implDriverpage.getAll();
        TabelManageDriver th = new TabelManageDriver(lb);
        frame2.getTabelData().setModel(th);
        }
    
    public ControllerDriverpage(FormDriverPage frame, String username) {
        this.frame = frame;
        this.username = username;
        implDriverpage = new DriverDAO();
        lb = implDriverpage.getAllJob(username); 
    }

    public void reset(){
        frame2.gettextfield_nama().setText("");
        frame2.gettextfield_nohp().setText("");
        frame2.gettextfield_password().setText("");
    }
    
    public void isiTable() {
        lb = implDriverpage.getAllJob(username); 
        TabelDriverpage th = new TabelDriverpage(lb);
        frame.getTabelData().setModel(th);
    }
    
    public void delete(){
            if (!frame2.gettextfield_id().getText().trim().isEmpty()){
                int id = Integer.parseInt(frame2.gettextfield_id().getText());
                implDriverpage.delete(id);
                JOptionPane.showMessageDialog(null, "Hapus data sukses");
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih data yang akan dihapus");
            }
        }
     
        public void isiField(int row){
            frame2.gettextfield_id().setText(String.valueOf(lb.get(row).getId()));
            frame2.gettextfield_nama().setText(lb.get(row).getNama());
            frame2.gettextfield_password().setText(lb.get(row).getPassword());
            frame2.gettextfield_nohp().setText(lb.get(row).getNoHP_driver());
            frame2.gettextfield_motor().setText(lb.get(row).getMotor());
        }
        
        public void insert(){   
        if (!frame2.gettextfield_nama().getText().trim().isEmpty()){
            Driverpage b = new Driverpage();
            b.setNama(frame2.gettextfield_nama().getText());
            b.setPassword(frame2.gettextfield_password().getText());
            b.setNoHP_driver(frame2.gettextfield_nohp().getText());
            b.setMotor(frame2.gettextfield_motor().getText());
            implDriverpage.insert(b);
            JOptionPane.showMessageDialog(null, "Simpan Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame2, "Data Tidak Boleh Kosong");
        }
    }
        
        public void update(){
            if (!frame2.gettextfield_nama().getText().trim().isEmpty()){
                Driverpage b = new Driverpage();
                b.setNama(frame2.gettextfield_nama().getText());
                b.setPassword(frame2.gettextfield_password().getText());
                b.setNoHP_driver(frame2.gettextfield_nohp().getText());
                b.setId(Integer.parseInt(frame2.gettextfield_id().getText()));
                b.setMotor(frame2.gettextfield_motor().getText());
                implDriverpage.update(b);
                JOptionPane.showMessageDialog(frame2, "Simpan data sukses");
            }else {
                    JOptionPane.showMessageDialog(frame2, "Pilih data yang akan di ubah");
                }
            }
        
    public void cariIdDriver(){
        String input = frame2.gettextfield_cari().getText().trim();

        if (!input.isEmpty()) {
            int id = Integer.parseInt(input);
            implDriverpage.getCariIdDriver(id); 
            isiTableCariIdDriver();
        } else{
            isiTableManageDriver();
        }
    }
    
    public void isiTableCariIdDriver(){
        lb=implDriverpage.getCariIdDriver(Integer.parseInt(frame2.gettextfield_cari().getText()));
        TabelManageDriver th =new TabelManageDriver(lb);
        frame2.getTabelData().setModel(th);
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
    
    public boolean updateStatus(String id, String status) {
    return implDriverpage.updateStatus(id, status); 
}

    private void isiTableCariId() {
         TabelDriverpage th = new TabelDriverpage(lb);
         frame.getTabelData().setModel(th);
    }
}
