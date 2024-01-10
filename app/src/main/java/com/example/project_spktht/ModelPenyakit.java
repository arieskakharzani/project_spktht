package com.example.project_spktht;

public class ModelPenyakit {
    private String penyakit;
    private String tanggalTerjangkit;
    private String gangguanTelinga;
    private String gangguanHidung;
    private String gangguanTenggorokan;
    private String obat;
    private String key;

    public ModelPenyakit() {
    }

    public ModelPenyakit(String penyakit, String tanggalTerjangkit, String gangguanTelinga, String gangguanHidung, String gangguanTenggorokan, String obat) {
        this.penyakit = penyakit;
        this.tanggalTerjangkit = tanggalTerjangkit;
        this.gangguanTelinga = gangguanTelinga;
        this.gangguanHidung = gangguanHidung;
        this.gangguanTenggorokan = gangguanTenggorokan;
        this.obat = obat;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getTanggalTerjangkit() {
        return tanggalTerjangkit;
    }

    public void setTanggalTerjangkit(String tanggalTerjangkit) {
        this.tanggalTerjangkit = tanggalTerjangkit;
    }

    public String getGangguanTelinga() {
        return gangguanTelinga;
    }

    public void setGangguanTelinga(String gangguanTelinga) {
        this.gangguanTelinga = gangguanTelinga;
    }

    public String getGangguanHidung() {
        return gangguanHidung;
    }

    public void setGangguanHidung(String gangguanHidung) {
        this.gangguanHidung = gangguanHidung;
    }

    public String getGangguanTenggorokan() {
        return gangguanTenggorokan;
    }

    public void setGangguanTenggorokan(String gangguanTenggorokan) {
        this.gangguanTenggorokan = gangguanTenggorokan;
    }

    public String getObat() {
        return obat;
    }

    public void setObat(String obat) {
        this.obat = obat;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

