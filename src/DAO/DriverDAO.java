/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.IDriver;
import Helper.KoneksiDB;
import Model.Adminpage;
import Model.Driverpage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asus
 */
public class DriverDAO  implements IDriver{
       Connection connection;
      final String SelectbyDR = "SELECT p.id, p.tgl_masuk, p.tgl_keluar, p.berat, p.harga, p.status_pesanan, p.status_antar, p.alamat, p.no_hp, d.nama AS nama_driver FROM pesanan p LEFT JOIN driver d ON p.driver_id = d.id WHERE d.nama = ?;";
      final String getCariId = "SELECT p.id, p.tgl_masuk, p.tgl_keluar, p.berat, p.harga, p.status_pesanan, p.status_antar, p.alamat, p.no_hp, d.nama AS nama_driver FROM pesanan p LEFT JOIN driver d ON p.driver_id = d.id WHERE p.id = ? AND d.nama = ?";
      final String updateStatus = "UPDATE pesanan SET status_pesanan = ? WHERE id = ?";
      final String select = "SELECT * FROM driver;";
      final String cariIdDriver = "SELECT id, nama, password, no_hp, motor FROM driver WHERE id LIKE ?;";
      final String insert = "INSERT INTO driver (nama, password, no_hp, motor) VALUES (?, ?, ?, ?);";
      final String delete = "DELETE FROM driver WHERE id=? ;";
      final String update = "UPDATE driver SET nama=?, password=?, no_hp=?, motor=? WHERE id=? ;";


    public DriverDAO() {
        connection = KoneksiDB.getConnection();
    }

    public void update(Driverpage b){
    PreparedStatement statement = null;
    try {
        statement = connection.prepareStatement(update);
        statement.setString(1, b.getNama());
        statement.setString(2, b.getPassword());
        statement.setString(3, b.getNoHP_driver());
        statement.setString(4, b.getMotor());
        statement.setInt(5, b.getId());
        int affectedRows = statement.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Berhasil update");
        } else {
            System.out.println("Gagal update: Tidak ada baris yang terpengaruh (id mungkin tidak cocok)");
        }
    } catch (SQLException ex){
        System.out.println("Gagal update karena error: " + ex.getMessage());
    } finally {
        try {
            if (statement != null) statement.close();
        } catch (SQLException ex){
            System.out.println("Gagal menutup statement: " + ex.getMessage());
        }
    }
}
    
    public void insert(Driverpage b){
    PreparedStatement statement = null;
    try {
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, b.getNama());
        statement.setString(2, b.getPassword());
        statement.setString(3, b.getNoHP_driver());
        statement.setString(4, b.getMotor());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()){
            b.setId(rs.getInt(1));
        }

        System.out.println("Berhasil Input");
    } catch (SQLException ex) {
        System.out.println("Gagal Input: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            if (statement != null) statement.close();
        } catch (SQLException ex) {
            System.out.println("Gagal menutup statement: " + ex.getMessage());
        }
    }
}
    
    public void delete(int id){
            PreparedStatement statement = null;
            try{
                statement = connection.prepareStatement(delete);
                
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException ex){
                System.out.println("Berhasil Delete");
            } finally {
                try{
                    statement.close();
                } catch (SQLException ex){
                    System.out.println("Gagal Update");
                }
            }
        }
    
    public List<Driverpage> getAll(){
            List<Driverpage> lb = null;
            try{
                lb = new ArrayList<Driverpage>();
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(select);
                while (rs.next()){
                    Driverpage b = new Driverpage();
                    // nama kolom
                    b.setId(rs.getInt("id"));
                    b.setNama(rs.getString("nama"));
                    b.setPassword(rs.getString("password"));
                    b.setNoHP_driver(rs.getString("no_hp"));
                    b.setMotor(rs.getString("motor"));
                    lb.add(b);
                }
            } catch (SQLException ex){
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lb;
        }

        public List<Driverpage> getCariIdDriver(int id){
            List<Driverpage> lb = null;
            try{
                lb = new ArrayList<Driverpage>();
                PreparedStatement st = connection.prepareStatement(cariIdDriver);
                st.setInt(1,id);
                ResultSet rs = st.executeQuery();
                while (rs.next()){
                    Driverpage b = new Driverpage();
                    b.setId(rs.getInt("id"));
                    b.setNama(rs.getString("nama"));
                    b.setPassword(rs.getString("password"));
                    b.setNoHP_driver(rs.getString("no_hp"));
                    b.setMotor(rs.getString("motor"));
                    lb.add(b);
                }
            } catch (SQLException ex){
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lb;
        }
        
        
    public List<Driverpage> getAllJob(String username) {
        List<Driverpage> list = new ArrayList<>();
           try {
               PreparedStatement stmt = connection.prepareStatement(SelectbyDR);
               stmt.setString(1, username);
               ResultSet rs = stmt.executeQuery();

               while (rs.next()) {
                   Driverpage d = new Driverpage();
                   d.setId(rs.getInt("id"));
                   d.setTgl_masuk(rs.getString("tgl_masuk"));
                   d.setTgl_keluar(rs.getString("tgl_keluar"));
                   d.setBerat(rs.getFloat("berat"));
                   d.setHarga(rs.getInt("harga"));
                   d.setStatus_pesanan(rs.getString("status_pesanan"));
                   d.setStatus_antar(rs.getString("status_antar"));
                   d.setNama_driver(rs.getString("nama_driver"));
                   d.setAlamat(rs.getString("alamat"));
                   d.setNoHP(rs.getString("no_hp"));
                   list.add(d);
               }

               rs.close();
               stmt.close();

           } catch (SQLException e) {
               e.printStackTrace();
           }
           return list;
    }

    public List<Driverpage> getCariId (int id,String username) {
                List<Driverpage> list = new ArrayList<>();
            try {
                PreparedStatement stmt = connection.prepareStatement(getCariId);
                stmt.setInt(1, id);
                stmt.setString(2,username);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    Driverpage d = new Driverpage();
                    d.setId(rs.getInt("id"));
                    d.setTgl_masuk(rs.getString("tgl_masuk"));
                    d.setTgl_keluar(rs.getString("tgl_keluar"));
                    d.setBerat(rs.getFloat("berat"));
                    d.setHarga(rs.getInt("harga"));
                    d.setStatus_pesanan(rs.getString("status_pesanan"));
                    d.setStatus_antar(rs.getString("status_antar"));
                    d.setNama_driver(rs.getString("nama_driver"));
                    d.setAlamat(rs.getString("alamat"));
                    d.setNoHP(rs.getString("no_hp"));
                    list.add(d);
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
    
    public  boolean updateStatus(String id, String status) {
  
        try (
             PreparedStatement stmt = connection.prepareStatement(updateStatus)) {
            stmt.setString(1, status);
            stmt.setString(2, id);
            int updated = stmt.executeUpdate();
            return updated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
