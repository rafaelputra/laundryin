/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rafaelputra
 */
public class Adminpage
    {

    /**
     * @return the driverId
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * @param driverId the driverId to set
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the nohp
     */
    public String getNohp() {
        return nohp;
    }

    /**
     * @param nohp the nohp to set
     */
    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the harga
     */
    public String getHarga() {
        return "Rp" + harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getHargaAsInteger() {
       return harga;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            Date date = parser.parse(tgl_masuk);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            this.tgl_masuk = formatter.format(date);
        } catch (Exception e) {
            this.tgl_masuk = tgl_masuk;
        }
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(String tgl_keluar) {
        try {
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            Date date = parser.parse(tgl_keluar);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            this.tgl_keluar = formatter.format(date);
        } catch (Exception e) {
            this.tgl_keluar = tgl_keluar; 
        }
    }

    public java.sql.Date getSqlDateTglMasuk() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date utilDate = sdf.parse(this.tgl_masuk);
            return new java.sql.Date(utilDate.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public java.sql.Date getSqlDateTglKeluar() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date utilDate = sdf.parse(this.tgl_keluar);
            return new java.sql.Date(utilDate.getTime());
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * @return the berat
     */
    public String getBerat() {
        return berat + " kg";
    }
    
    public float getBeratAsFloat() {
       return berat;
    }
    
    /**
     * @param berat the berat to set
     */
    public void setBerat(Float berat) {
        this.berat = berat;
    }

    /**
     * @return the status_pesanan
     */
    public String getStatus_pesanan() {
        return status_pesanan;
    }

    /**
     * @param status_pesanan the status_pesanan to set
     */
    public void setStatus_pesanan(String status_pesanan) {
        this.status_pesanan = status_pesanan;
    }

    /**
     * @return the status_antar
     */
    public String getStatus_antar() {
        return status_antar;
    }

    /**
     * @param status_antar the status_antar to set
     */
    public void setStatus_antar(String status_antar) {
        this.status_antar = status_antar;
    }
        private String nama;
        private String alamat;
        private String nohp;
        private Integer id;
        private String tgl_masuk;
        private String tgl_keluar;
        private Float berat;
        private Integer harga;
        private String status_pesanan;
        private String status_antar;
        private String parfum;
        private Integer driverId;
        private String nama_driver;

    /**
     * @return the parfum
     */
    public String getParfum() {
        return parfum;
    }

    /**
     * @param parfum the parfum to set
     */
    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    /**
     * @return the nama_driver
     */
    public String getNama_driver() {
        return nama_driver;
    }

    /**
     * @param nama_driver the nama_driver to set
     */
    public void setNama_driver(String nama_driver) {
        this.nama_driver = nama_driver;
    }
    }
