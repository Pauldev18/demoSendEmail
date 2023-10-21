/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlibanhang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author My HP
 */
public class DataProvider {
     private static KhachHangBusiness KhachHangBus = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static KhachHangBusiness getKhachHangBus()
    {
        if(KhachHangBus == null)//True
        {
            KhachHangBus = new KhachHangBusiness();//Singletone
        }
        
        return KhachHangBus;
    }
    private static NguoiDungBusiness NguoiDungBus = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static NguoiDungBusiness getNguoiDungBus()
    {
        if(NguoiDungBus == null)//True
        {
            NguoiDungBus = new NguoiDungBusiness();//Singletone
        }
        
        return NguoiDungBus;
    }
    private static ViTriBusiness ViTriBus = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static ViTriBusiness getViTriBus()
    {
        if(ViTriBus == null)//True
        {
            ViTriBus = new ViTriBusiness();//Singletone
        }
        
        return ViTriBus;
    }
      private static ChiTietDonHangNhapBusiness ChiTietDonHangNhapBus = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static ChiTietDonHangNhapBusiness getChiTietDonHangNhapBus()
    {
        if(ChiTietDonHangNhapBus == null)//True
        {
            ChiTietDonHangNhapBus = new ChiTietDonHangNhapBusiness();//Singletone
        }
        
        return ChiTietDonHangNhapBus;
    }
    private static ChiTietDonHangXuatBusiness ChiTietDonHangXuatBus = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static ChiTietDonHangXuatBusiness getChiTietDonHangXuatBus()
    {
        if(ChiTietDonHangXuatBus == null)//True
        {
            ChiTietDonHangXuatBus = new ChiTietDonHangXuatBusiness();//Singletone
        }
        
        return ChiTietDonHangXuatBus;
    }
    
    private static NhapHangBusiness NhapHangBus = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static NhapHangBusiness getNhapHangBus()
    {
        if(NhapHangBus == null)//True
        {
            NhapHangBus = new NhapHangBusiness();//Singletone
        }
        
        return NhapHangBus;
    }
    private static HoaDonBusiness HoaDonBus = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static HoaDonBusiness getHoaDonBus()
    {
        if(HoaDonBus == null)//True
        {
            HoaDonBus = new HoaDonBusiness();//Singletone
        }
        
        return HoaDonBus;
    }
    private static CongTyBusiness CongTyBus  = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static CongTyBusiness getCongTyBus()
    {
        if(CongTyBus == null)//True
        {
            CongTyBus = new CongTyBusiness();//Singletone
        }
        
        return CongTyBus;
    }
    private static HangHoaBusiness HangHoaBus = null;
    
    /**
     * Hàm trả 1 đối tượng thuộc lớp SinhVienBusiness ở dạng static để sử dụng ở nhiều nơi
     * @return 
     */
    public static HangHoaBusiness getHangHoaBus()
    {
        if(HangHoaBus == null)//True
        {
            HangHoaBus = new HangHoaBusiness();//Singletone
        }
        
        return HangHoaBus;
    }
    
    
    //Khai báo driver mysql cần làm việc
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    //Khai báo db cần làm việc
    private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    
    /**
     * Hàm kết nối đến db cần làm việc
     * @return 
     */
    public static Connection ketNoi()
    {
        Connection conn = null;
        
        try {
            //Nạp driver
            Class.forName(JDBC_DRIVER);
            
            //Kết nối đến db trong mysql cần làm việc
            conn = DriverManager.getConnection(DATABASE_LINK, "root", "123456");
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Lỗi không tìm thấy driver. Chi tiết: " + ex.getMessage());
       
         } catch (SQLException ex) {
             System.err.println("Không kết nối được với Database trên MySQL. Chi tiết: " 
                     + ex.getMessage());
        }
        
        return conn;
        
    }
    
}
