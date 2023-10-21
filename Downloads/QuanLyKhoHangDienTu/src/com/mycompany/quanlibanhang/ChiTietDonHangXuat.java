/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlibanhang;

/**
 *
 * @author My HP
 */
public class ChiTietDonHangXuat {
    private String ID;
    private String tenHang;
    private int SoLuong;
    private int GiaTien;
    private int TongGiaTien;
    private String idDonHangXuat;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public ChiTietDonHangXuat(String ID) {
        this.ID = ID;
    }

    public ChiTietDonHangXuat() {
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }

    public int getTongGiaTien() {
        return TongGiaTien;
    }

    public void setTongGiaTien(int TongGiaTien) {
        this.TongGiaTien = TongGiaTien;
    }

    public String getIdDonHangXuat() {
        return idDonHangXuat;
    }

    public void setIdDonHangXuat(String idDonHangXuat) {
        this.idDonHangXuat = idDonHangXuat;
    }
    
    
}
