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
public class HoaDonBusiness {
     public List<HoaDon> timKiemHoaDon(String tuKhoa) {
        //Khai báo danh sách sv
        List<HoaDon> lstHoaDon = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from donHangXuat where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (EXPORT_ID = '" + tuKhoa + "' OR CUSTOMER_NAME like '%"+ tuKhoa + "%')";
            }
            
            

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            HoaDon objHD;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHD = new HoaDon();

                //Gán giá trị cho các thuộc tính
                objHD.setThoiGian(rs.getDate("ORDER_TIME_EXP"));
                objHD.setKhachHang(rs.getString("CUSTOMER_NAME"));
                objHD.setTongTienHang(rs.getInt("TOTAL_PRICE_EXP"));
                objHD.setMaHoaDon(rs.getString("EXPORT_ID"));

                //Thêm vào danh sách
                lstHoaDon.add(objHD);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(HoaDonBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstHoaDon;
    }
    private List<HoaDon> lstHoaDon = new ArrayList<HoaDon>();
    
    /**
     * Hàm lấy danh sách sinh viên từ db
     * @return 
     */
    public List<HoaDon> layDanhSach() {
        //Khai báo danh sách sv
        List<HoaDon> lstHoaDon = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from donHangXuat";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            HoaDon objHD;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHD = new HoaDon();

                //Gán giá trị cho các thuộc tính
                
               
                objHD.setThoiGian(rs.getDate("ORDER_TIME_EXP"));
                objHD.setKhachHang(rs.getString("CUSTOMER_NAME"));
                objHD.setTongTienHang(rs.getInt("TOTAL_PRICE_EXP"));
                objHD.setMaHoaDon(rs.getString("EXPORT_ID"));

                //Thêm vào danh sách
                lstHoaDon.add(objHD);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(HoaDonBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstHoaDon;
    }
    public HoaDon layChiTietTheoMa(String maHoaDon)
    {
        HoaDon objHD = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from donHangXuat where EXPORT_ID='" + maHoaDon + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHD = new HoaDon();

                //Gán giá trị cho các thuộc tính
                objHD.setThoiGian(rs.getDate("ORDER_TIME_EXP"));
                objHD.setKhachHang(rs.getString("CUSTOMER_NAME"));
                objHD.setTongTienHang(rs.getInt("TOTAL_PRICE_EXP"));
                objHD.setMaHoaDon(rs.getString("EXPORT_ID"));
                                  
                
                
                
                
                
                //Thêm vào danh sách
                lstHoaDon.add(objHD);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(HoaDonBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return objHD;
    }

    public HoaDonBusiness() {
    }
    public boolean themMoi(HoaDon objHD)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strInsert = "Insert into donHangXuat(EXPORT_ID, ORDER_TIME_EXP, TOTAL_PRICE_EXP, CUSTOMER_NAME "
                    + ") values("
                    + "?,?,?,?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objHD.getMaHoaDon());
          
            comm.setDate(2, new Date(objHD.getThoiGian().getTime()));
            
            comm.setString(4, objHD.getKhachHang());
            
            comm.setInt(3, objHD.getTongTienHang());
             
                
                
                  
            
            
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
    public boolean capNhat(HoaDon objHD)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strUpdate = "Update donHangXuat set  ORDER_TIME_EXP = ?, TOTAL_PRICE_EXP= ?, "
                    + " CUSTOMER_NAME = ? "
                    + "  where EXPORT_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
            
            comm.setString(4, objHD.getMaHoaDon());
           
            comm.setDate(1, new Date(objHD.getThoiGian().getTime()));
          
            comm.setString(3, objHD.getKhachHang());
           
            comm.setInt(2, objHD.getTongTienHang());
             
                
            
            
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
   
    public boolean xoa(String MaHoaDon)
    {
       Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strDelete = "Delete from donhangxuat where EXPORT_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strDelete);
            
            //Thiết lập các giá trị cho tham số
            
            comm.setString(1, MaHoaDon);
            
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
