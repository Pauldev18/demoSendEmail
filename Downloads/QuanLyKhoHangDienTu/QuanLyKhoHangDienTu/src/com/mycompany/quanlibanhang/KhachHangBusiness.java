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
public class KhachHangBusiness {
     private List<KhachHang> lstKhachHang = new ArrayList<KhachHang>();
    
    /**
     * Hàm lấy danh sách sinh viên từ db
     * @return 
     */
    public List<KhachHang> layDanhSach() {
        //Khai báo danh sách sv
        List<KhachHang> lstKhachHang = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from KhachHang";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            KhachHang objKH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objKH = new KhachHang();

                //Gán giá trị cho các thuộc tính
                objKH.setId(rs.getString("CUSTOMER_ID"));
                objKH.setHoTen(rs.getString("CUSTOMER_NAME"));
                objKH.setDienThoai(rs.getString("CUSTOMER_ADDRESS"));
                objKH.setEmail(rs.getString("CUSTOMER_PHONE_NUMBER"));
                objKH.setDiaChi(rs.getString("CUSTOMER_EMAIL"));

                //Thêm vào danh sách
                lstKhachHang.add(objKH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhachHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(KhachHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstKhachHang;
    }
    
     public List<KhachHang> timKiemKhachHang(String tuKhoa) {
        //Khai báo danh sách sv
        List<KhachHang> lstKhachHang = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from KhachHang where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (CUSTOMER_ID = '" + tuKhoa + "'  OR CUSTOMER_NAME like '%" + 
                        tuKhoa + "%' OR CUSTOMER_PHONE_NUMBER like '%"
                        + tuKhoa + "%')";
            }
            
            
            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            KhachHang objKH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objKH = new KhachHang();

                //Gán giá trị cho các thuộc tính
                objKH.setId(rs.getString("CUSTOMER_ID"));
                objKH.setHoTen(rs.getString("CUSTOMER_NAME"));
                objKH.setDiaChi(rs.getString("CUSTOMER_ADDRESS"));
                objKH.setDienThoai(rs.getString("CUSTOMER_PHONE_NUMBER"));
                objKH.setEmail(rs.getString("CUSTOMER_EMAIL"));

                //Thêm vào danh sách
                lstKhachHang.add(objKH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhachHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(KhachHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstKhachHang;
    }
    public KhachHang layChiTietTheoMa(String ID)
    {
        KhachHang objKH = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from KhachHang where CUSTOMER_ID='" + ID + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objKH = new KhachHang();

                //Gán giá trị cho các thuộc tính
                objKH.setId(rs.getString("CUSTOMER_ID"));
                objKH.setHoTen(rs.getString("CUSTOMER_NAME"));
                objKH.setDiaChi(rs.getString("CUSTOMER_ADDRESS"));
                objKH.setDienThoai(rs.getString("CUSTOMER_PHONE_NUMBER"));
                objKH.setEmail(rs.getString("CUSTOMER_EMAIL"));
                //Thêm vào danh sách
                lstKhachHang.add(objKH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhachHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(KhachHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return objKH;
    }
    public boolean themMoi(KhachHang objKH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strInsert = "Insert into KhachHang(CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE_NUMBER, CUSTOMER_EMAIL "
                    + ") values("
                    + "?,?,?,?,?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objKH.getId());
            comm.setString(2, objKH.getHoTen());
            comm.setString(3, objKH.getDiaChi());
            comm.setString(4, objKH.getDienThoai());
            comm.setString(5, objKH.getEmail());
           
                
                  
            
            
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
     * @param objKH
     * @return 
     */
    public boolean capNhat(KhachHang objKH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strUpdate = "Update KhachHang set CUSTOMER_NAME=?, CUSTOMER_ADDRESS = ?, CUSTOMER_PHONE_NUMBER = ?, "
                    + "CUSTOMER_EMAIL = ? "
                    + "where CUSTOMER_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
           comm.setString(5, objKH.getId());
            comm.setString(1, objKH.getHoTen());
            comm.setString(2, objKH.getDiaChi());
            comm.setString(3, objKH.getDienThoai());
            comm.setString(4, objKH.getEmail());
            
            
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
    
    /**
     * Xóa sinh viên trong hệ thống
     * @param ID
     * @return 
     */
    public boolean xoa(String ID)
    {
       Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strDelete = "Delete from KhachHang where CUSTOMER_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strDelete);
            
            //Thiết lập các giá trị cho tham số
            
            comm.setString(1, ID);
            
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
