/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlibanhang;

/**
 *
 * @author My HP
 */
public class HangHoa {
    
    
    private String maHang;
    private String tenHang;
    private int giaVon;
    private int giaBan;
    private int tonKho;
    private int trongLuong;
    private String moTa;
    private String xuatXu;
    private String viTri;
    private String maNhomHang;
    private String tenNhomHang;

    public String getTenNhomHang() {
        return tenNhomHang;
    }

    public void setTenNhomHang(String tenNhomHang) {
        this.tenNhomHang = tenNhomHang;
    }

    public String getMaNhomHang() {
        return maNhomHang;
    }

    public void setMaNhomHang(String maNhomHang) {
        this.maNhomHang = maNhomHang;
    }
    private String donViTinh;

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(int giaVon) {
        this.giaVon = giaVon;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public int getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(int trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    
    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getMinTonKho() {
        return minTonKho;
    }

    public void setMinTonKho(int minTonKho) {
        this.minTonKho = minTonKho;
    }

    public int getMaxTonKho() {
        return maxTonKho;
    }

    public void setMaxTonKho(int maxTonKho) {
        this.maxTonKho = maxTonKho;
    }

   
    private int minTonKho;
    private int maxTonKho;

   
    public HangHoa()
    {
        
    }
    public HangHoa(String maHang)
    {
        this.maHang=maHang;
    }
    
    
    
}
