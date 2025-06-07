/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.KoneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Homepage;
import DAOInterface.ILaundryin;
import DAOInterface.IDriver;
import java.sql.PreparedStatement;

/**
 *
 * @author rafaelputra
 */
public class DAO implements ILaundryin
    {
        Connection connection;
        final String select = "SELECT p.id, p.tgl_masuk, p.tgl_keluar, p.berat, p.harga, p.status_pesanan, p.status_antar, d.nama AS nama_driver FROM pesanan p LEFT JOIN driver d ON p.driver_id = d.id;";
        final String cariId = "SELECT p.*, d.nama AS nama_driver FROM pesanan p LEFT JOIN driver d ON p.driver_id = d.id WHERE p.id LIKE ?";
        final String DRLogin ="SELECT * FROM driver WHERE nama = ? AND password = ?";
        final String admLogin ="SELECT * FROM admin WHERE username = ? AND password = ?";

        
        public DAO(){
            connection = KoneksiDB.getConnection();
        }
        @Override
        public List<Homepage> getAll(){
            List<Homepage> lb = null;
            try{
                lb = new ArrayList<Homepage>();
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(select);
                while (rs.next()){
                    Homepage b = new Homepage();
                    b.setId(rs.getInt("id"));
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
            
        public List<Homepage> getCariId(int id){
            List<Homepage> lb = null;
            try{
                lb = new ArrayList<Homepage>();
                PreparedStatement st = connection.prepareStatement(cariId);
                st.setInt(1,id);
                ResultSet rs = st.executeQuery();
                while (rs.next()){
                    Homepage b = new Homepage();
                    b.setId(rs.getInt("id"));
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
        
        public boolean cekLogin(String username, String password) {
            boolean loginBerhasil = false;
            try {
                PreparedStatement stmt = connection.prepareStatement(DRLogin);
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
        
      
        
        public boolean admLogin (String username, String password) {
            boolean loginBerhasil = false;
            try {
                PreparedStatement stmt = connection.prepareStatement(admLogin);
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



    }
