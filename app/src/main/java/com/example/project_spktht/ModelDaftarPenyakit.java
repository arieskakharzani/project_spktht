package com.example.project_spktht;

public class ModelDaftarPenyakit {

    private String title;
    private String penjelasan;
    private boolean expanded;

    public ModelDaftarPenyakit(String title, String penjelasan) {
        this.title = title;
        this.penjelasan = penjelasan;
        this.expanded = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public String toString() {
        return "DaftarPenyakit{" +
                "Nama Penyakit='" + title + '\'' +
                ", penjelasan='" + penjelasan + '\'' +
                ", expanded=" + expanded +
                '}';
    }
}