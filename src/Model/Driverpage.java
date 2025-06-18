/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class Driverpage {

    /**
     * @return the Motor
     */
    public String getMotor() {
        return Motor;
    }

    /**
     * @param Motor the Motor to set
     */
    public void setMotor(String Motor) {
        this.Motor = Motor;
    }

    /**
     * @return the noHP_driver
     */
    public String getNoHP_driver() {
        return noHP_driver;
    }

    /**
     * @param noHP_driver the noHP_driver to set
     */
    public void setNoHP_driver(String noHP_driver) {
        this.noHP_driver = noHP_driver;
    }

    /**
     * @return the username
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param username the username to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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

        /**
         * @return the tgl_masuk
         */
        public String getTgl_masuk() {
            return tgl_masuk;
        }

        /**
         * @param tgl_masuk the tgl_masuk to set
         */

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

        /**
         * @return the tgl_keluar
         */
        public String getTgl_keluar() {
            return tgl_keluar;
        }

        /**
         * @param tgl_keluar the tgl_keluar to set
         */
        public void setTgl_keluar(String tgl_keluar) {
            try {
                SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
                Date date = parser.parse(tgl_keluar);

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                this.tgl_keluar = formatter.format(date);
            } catch (Exception e) {
                this.tgl_masuk = tgl_keluar;
            }
        }

        /**
         * @return the berat
         */
        public String getBerat() {
            return berat + " kg";
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
         public String getAlamat_antar() {
      return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat=alamat;
    }

    public void setNoHP(String noHP) {
        this.noHP=noHP;
    }

    public String getNo_Pelanggan() {
      return noHP;
    }
            private Integer id;
            private String tgl_masuk;
            private String tgl_keluar;
            private Float berat;
            private Integer harga;
            private String status_pesanan;
            private String status_antar;
            private String nama_driver;
            private String alamat;
            private String noHP;
            private String nama;
            private String password;
            private String noHP_driver;
            private String Motor;
}
