/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IAdmin;
import Helper.KoneksiDB;
import Model.Adminpage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafaelputra
 */
public class DAOAdmin implements IAdmin
    {
    Connection connection;
    final String select = "SELECT p.id, p.nama, p.alamat, p.no_hp, p.berat, p.harga, p.parfum, p.status_pesanan, p.status_antar, p.driver_id, d.nama AS nama_driver FROM  pesanan AS p LEFT JOIN driver AS d ON p.driver_id = d.id;";
    final String insert = "INSERT INTO pesanan (nama, alamat, no_hp, berat, harga, parfum, status_pesanan, status_antar, driver_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String cariId = "SELECT p.*, d.nama AS nama_driver FROM pesanan p LEFT JOIN driver d ON p.driver_id = d.id WHERE p.id LIKE ?";
    final String ALogin ="SELECT * FROM admin WHERE username = ? AND password = ?";
    final String update = "UPDATE pesanan SET nama=?, alamat=?, no_hp=?, berat=?, harga=?, parfum=?, status_pesanan=?, status_antar=?, driver_id=? WHERE id=?;";
    final String getAllDriver = "SELECT id, nama FROM driver";
    final String delete = "DELETE FROM pesanan WHERE id=? ;";
    
    public DAOAdmin(){
        connection = KoneksiDB.getConnection();
    }
    
    public List<Adminpage> getAll(){
            List<Adminpage> lb = null;
            try{
                lb = new ArrayList<Adminpage>();
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(select);
                while (rs.next()){
                    Adminpage b = new Adminpage();
                    // nama kolom
                    b.setId(rs.getInt("id"));
                    b.setNama(rs.getString("nama"));
                    b.setAlamat(rs.getString("alamat"));
                    b.setNohp(rs.getString("no_hp"));
                    String strBerat = rs.getString("berat");
                    if (strBerat != null && !strBerat.trim().isEmpty()) {
                        b.setBerat(Float.parseFloat(strBerat));
                    } else {
                        b.setBerat(0.0f);
                    }
                    String strHarga = rs.getString("harga");
                    if (strHarga != null && !strHarga.trim().isEmpty()){
                        b.setHarga(Integer.parseInt(strHarga));
                    } else {
                        b.setHarga(0);
                    }
                    b.setParfum(rs.getString("parfum"));
                    b.setStatus_pesanan(rs.getString("status_pesanan"));
                    b.setStatus_antar(rs.getString("status_antar"));
                    b.setNama_driver(rs.getString("nama_driver"));
                    lb.add(b);
                }
            } catch (SQLException ex){
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lb;
        }

public void insert(Adminpage b){
    PreparedStatement statement = null;
    try {
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, b.getNama());
        statement.setString(2, b.getAlamat());
        statement.setString(3, b.getNohp());
        statement.setFloat(4, b.getBeratAsFloat());
        statement.setInt(5, b.getHargaAsInteger());
        statement.setString(6, b.getParfum());
        statement.setString(7, b.getStatus_pesanan());
        statement.setString(8, b.getStatus_antar());
        statement.setInt(9, b.getDriverId());

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
    
    public Map<String, Integer> getDriverNameIdMap() {
        Map<String, Integer> driverMap = new HashMap<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getAllDriver);
            while (rs.next()) {
                driverMap.put(rs.getString("nama"), rs.getInt("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return driverMap;
    }   
    public List<Adminpage> getCariId(int id){
            List<Adminpage> lb = null;
            try{
                lb = new ArrayList<Adminpage>();
                PreparedStatement st = connection.prepareStatement(cariId);
                st.setInt(1,id);
                ResultSet rs = st.executeQuery();
                while (rs.next()){
                    Adminpage b = new Adminpage();
                    b.setId(rs.getInt("id"));
                    b.setNama(rs.getString("nama"));
                    b.setAlamat(rs.getString("alamat"));
                    b.setNohp(rs.getString("no_hp"));
                    b.setTgl_masuk(rs.getString("tgl_masuk"));
                    b.setTgl_keluar(rs.getString("tgl_keluar"));
                    b.setBerat(rs.getFloat("berat"));
                    b.setHarga(rs.getInt("harga"));
                    b.setStatus_pesanan(rs.getString("status_pesanan"));
                    b.setStatus_antar(rs.getString("status_antar"));
                    b.setNama_driver(rs.getString("nama_driver"));
                    lb.add(b);
                }
            } catch (SQLException ex){
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lb;
        }
    
    public void update(Adminpage b){
    PreparedStatement statement = null;
    try {
        statement = connection.prepareStatement(update);
        statement.setString(1, b.getNama());
        statement.setString(2, b.getAlamat());
        statement.setString(3, b.getNohp());
        statement.setFloat(4, b.getBeratAsFloat());
        statement.setInt(5, b.getHargaAsInteger());
        statement.setString(6, b.getParfum());
        statement.setString(7, b.getStatus_pesanan());
        statement.setString(8, b.getStatus_antar());
        statement.setInt(9, b.getDriverId());
        statement.setInt(10, b.getId());

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

    
        public boolean cekLogin(String username, String password) {
            boolean loginBerhasil = false;
            try {
                PreparedStatement stmt = connection.prepareStatement(ALogin);
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    loginBerhasil = true;
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return loginBerhasil;
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
        
    }
