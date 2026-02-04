package com.rayya.registro.model;

public class Mahasiswa {
    private String mahasiswa_fullname;
    private String mahasiswa_username;
    private String mahasiswa_email;
    private String mahasiswa_gender;
    private String mahasiswa_bdate;

    public Mahasiswa() {
    }

    public Mahasiswa(String mahasiswa_fullname, String mahasiswa_username, String mahasiswa_email, String mahasiswa_gender, String mahasiswa_bdate) {
        this.mahasiswa_fullname = mahasiswa_fullname;
        this.mahasiswa_username = mahasiswa_username;
        this.mahasiswa_email = mahasiswa_email;
        this.mahasiswa_gender = mahasiswa_gender;
        this.mahasiswa_bdate = mahasiswa_bdate;
    }

    public String getMahasiswa_fullname() {
        return mahasiswa_fullname;
    }

    public void setMahasiswa_fullname(String mahasiswa_fullname) {
        this.mahasiswa_fullname = mahasiswa_fullname;
    }

    public String getMahasiswa_username() {
        return mahasiswa_username;
    }

    public void setMahasiswa_username(String mahasiswa_username) {
        this.mahasiswa_username = mahasiswa_username;
    }

    public String getMahasiswa_email() {
        return mahasiswa_email;
    }

    public void setMahasiswa_email(String mahasiswa_email) {
        this.mahasiswa_email = mahasiswa_email;
    }

    public String getMahasiswa_gender() {
        return mahasiswa_gender;
    }

    public void setMahasiswa_gender(String mahasiswa_gender) {
        this.mahasiswa_gender = mahasiswa_gender;
    }

    public String getMahasiswa_date() {
        return mahasiswa_bdate;
    }

    public void setMahasiswa_date(String mahasiswa_date) {
        this.mahasiswa_bdate = mahasiswa_date;
    }

}
