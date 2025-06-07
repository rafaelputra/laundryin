/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DAOInterface.IDriver;
import Helper.KoneksiDB;
import Model.Driverpage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Asus
 */
public class DriverDAO  implements IDriver{
       Connection connection;
      final String SelectbyDR = "SELECT p.id, p.tgl_masuk, p.tgl_keluar, p.berat, p.harga, p.status_pesanan, p.status_antar, p.alamat, p.no_hp, d.nama AS nama_driver FROM pesanan p LEFT JOIN driver d ON p.driver_id = d.id WHERE d.nama = ?;";
      final String getCariId = "SELECT p.id, p.tgl_masuk, p.tgl_keluar, p.berat, p.harga, p.status_pesanan, p.status_antar, p.alamat, p.no_hp, d.nama AS nama_driver FROM pesanan p LEFT JOIN driver d ON p.driver_id = d.id WHERE p.id = ? AND d.nama = ?";

    public DriverDAO() {
        connection = KoneksiDB.getConnection();
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
}
