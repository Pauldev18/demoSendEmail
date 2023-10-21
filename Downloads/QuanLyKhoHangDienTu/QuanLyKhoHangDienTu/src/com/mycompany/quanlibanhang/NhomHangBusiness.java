/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlibanhang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author My HP
 */
public class NhomHangBusiness {
    
    
     public List<NhomHang> layDanhSach() {
        //Khai báo danh sách ck
        List<NhomHang> lstNhomHang = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from NhomHang";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            NhomHang objNH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNH = new NhomHang();

                //Gán giá trị cho các thuộc tính
                objNH.setMaNhomHang(rs.getString("TYPE_ID"));
                objNH.setTenNhomHang(rs.getString("TYPE_NAME"));
                

                //Thêm vào danh sách
                lstNhomHang.add(objNH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhomHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhomHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstNhomHang;
    }
    
    /**
     * Hàm chi tiết khoa theo mã từ db
     * @return 
     */
    public NhomHang layChiTietTheoMa(String maNH) {
        //Khai đối tượng ck
        
        NhomHang objNH = null;
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from NhomHang where TYPE_ID='" + maNH + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNH = new NhomHang();

                //Gán giá trị cho các thuộc tính
                objNH.setMaNhomHang(rs.getString("TYPE_ID"));
                objNH.setTenNhomHang(rs.getString("TYPE_NAME"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhomHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhomHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return objNH;
    }
    public boolean themMoi(NhomHang objHD)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strInsert = "Insert into NhomHang(TYPE_ID, TYPE_NAME) values("
                    + "?,?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objHD.getMaNhomHang());
            comm.setString(2, objHD.getTenNhomHang());
           
             
                
                
                  
            
            
            //Thực hiện công việc
           return (comm.executeUpdate() > 0);
           
        } catch (SQLException ex) {
            System.err.println("Co loi xay ra trong qua trinh them thong tin. "
                    + "Chi tiet: " + ex.getMessage());
        }
        finally
        {
             try {
                if(conn != null){
                //Đóng kết nối
                conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Co loi xay ra. Chi tiet: " + ex.getMessage());
            }
        }
        
        return false;
    }
    
    /**
     * Hàm cập nhật thông tin sinh viên mới
     * @param objHD
     * @return 
     */
    public boolean capNhat(NhomHang objHD)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strUpdate = "Update NhomHang set  TYPE_NAME = ? where TYPE_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
            
            comm.setString(2, objHD.getMaNhomHang());
            comm.setString(1, objHD.getTenNhomHang());
            
                
            
            
            //Thực hiện công việc
           return (comm.executeUpdate() > 0);
           
        } catch (SQLException ex) {
            System.err.println("Co loi xay ra trong qua trinh cap nhat thong tin. "
                    + "Chi tiet: " + ex.getMessage());
        }
        finally
        {
             try {
                if(conn != null){
                //Đóng kết nối
                conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Co loi xay ra. Chi tiet: " + ex.getMessage());
            }
        }
        
        return false;
    }
    
    public boolean xoa(String MaNhomHang)
    {
       Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strDelete = "Delete from NhomHang where TYPE_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strDelete);
            
            //Thiết lập các giá trị cho tham số
            
            comm.setString(1, MaNhomHang);
            
            //Thực hiện công việc
           return (comm.executeUpdate() > 0);
           
        } catch (SQLException ex) {
            System.err.println("Co loi xay ra trong qua trinh cap nhat thong tin. "
                    + "Chi tiet: " + ex.getMessage());
        }
        finally
        {
             try {
                if(conn != null){
                //Đóng kết nối
                conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Co loi xay ra. Chi tiet: " + ex.getMessage());
            }
        }
        
        return false;
    }
    
}
