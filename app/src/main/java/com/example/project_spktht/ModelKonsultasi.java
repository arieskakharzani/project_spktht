package com.example.project_spktht;

public class ModelKonsultasi {
    private String konsulke;
    private String tanggal;
    private String dokter;
    private String klinik;
    private String keluhan;
    private String diagnosa;
    private String key;

    public ModelKonsultasi(){}
    public ModelKonsultasi(String konsulke, String tanggal, String dokter, String klinik, String keluhan, String diagnosa) {
        this.konsulke = konsulke;
        this.tanggal = tanggal;
        this.dokter = dokter;
        this.klinik = klinik;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
    }

    public String getKonsulke() {
        return konsulke;
    }

    public void setKonsul(String konsulke) {
        this.konsulke = konsulke;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public String getKlinik() {
        return klinik;
    }

    public void setKlinik(String klinik) {
        this.klinik = klinik;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
