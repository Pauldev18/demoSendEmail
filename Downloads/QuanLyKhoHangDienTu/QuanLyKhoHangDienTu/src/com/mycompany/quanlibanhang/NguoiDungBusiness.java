/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlibanhang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author My HP
 */
public class NguoiDungBusiness {
    
    public NguoiDung layThongTinTaiKhoan(String tenDangNhap)
    {
        NguoiDung objNguoiDung = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from nguoidung where TenDangNhap = ?";

            PreparedStatement comm = conn.prepareStatement(strSQL);

            comm.setString(1, tenDangNhap);
            
            ResultSet rs = comm.executeQuery();

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNguoiDung = new NguoiDung();

                //Gán giá trị cho các thuộc tính
                objNguoiDung.setId(rs.getInt("Id"));
                objNguoiDung.setHoTen(rs.getString("HoTen"));
                objNguoiDung.setTenDangNhap(rs.getString("TenDangNhap"));
                objNguoiDung.setMatKhau(rs.getString("MatKhau"));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(NguoiDungBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return objNguoiDung;
    }
    
}
