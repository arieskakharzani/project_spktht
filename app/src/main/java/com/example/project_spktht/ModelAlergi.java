package com.example.project_spktht;

public class ModelAlergi {
    private String alergi;
    private String tanggalTerjangkit;
    private String bahanAlergen;
    private String jenisAlergi;
    private String gejalaAlergi;
    private String reaksiAlergi;
    private String key;

    public ModelAlergi(){}
    public ModelAlergi(String alergi, String tanggalTerjangkit, String bahanAlergen, String jenisAlergi, String gejalaAlergi, String reaksiAlergi) {
        this.alergi = alergi;
        this.tanggalTerjangkit = tanggalTerjangkit;
        this.bahanAlergen = bahanAlergen;
        this.jenisAlergi = jenisAlergi;
        this.gejalaAlergi = gejalaAlergi;
        this.reaksiAlergi = reaksiAlergi;
    }

    public String getAlergi() {
        return alergi;
    }

    public void setAlergi(String alergi) {
        this.alergi = alergi;
    }

    public String getTanggalTerjangkit() {

        return tanggalTerjangkit;
    }

    public void setTanggalTerjangkit(String tanggalTerjangkit) {
        this.tanggalTerjangkit = tanggalTerjangkit;
    }

    public String getBahanAlergen() {
        return bahanAlergen;
    }

    public void setBahanAlergen(String bahanAlergen) {
        this.bahanAlergen = bahanAlergen;
    }

    public String getJenisAlergi() {
        return jenisAlergi;
    }

    public void setJenisAlergi(String jenisAlergi) {
        this.jenisAlergi = jenisAlergi;
    }

    public String getGejalaAlergi() {
        return gejalaAlergi;
    }

    public void setGejalaAlergi(String gejalaAlergi) {
        this.gejalaAlergi = gejalaAlergi;
    }

    public String getReaksiAlergi() {
        return reaksiAlergi;
    }

    public void setReaksiAlergi(String reaksiAlergi) {
        this.reaksiAlergi = reaksiAlergi;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

