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
public class HangHoaBusiness {
    
/**
 *
 * @author My HP
 */

     private List<HangHoa> lstHangHoa = new ArrayList<HangHoa>();
    
    /**
     * Hàm lấy danh sách sinh viên từ db
     * @return 
     */
    public List<HangHoa> layDanhSach() {
        //Khai báo danh sách sv
        List<HangHoa> lstHangHoa = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from HangHoa ";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            HangHoa objHH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHH = new HangHoa();

                //Gán giá trị cho các thuộc tính
                objHH.setMaHang(rs.getString("PRODUCT_ID"));
                objHH.setTenHang(rs.getString("PRODUCT_NAME"));
                
                objHH.setGiaBan(rs.getInt("PRODUCT_PRICE"));
                objHH.setTenNhomHang(rs.getString("PRODUCT_TYPE"));
                objHH.setTonKho(rs.getInt("PRODUCT_QUANTITY"));
                objHH.setViTri(rs.getString("PRODUCT_LOCATION"));

                //Thêm vào danh sách
                lstHangHoa.add(objHH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HangHoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(HangHoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstHangHoa;
    }
    public List<HangHoa> timKiemHangHoa(String tuKhoa, String nhomHang) {
        //Khai báo danh sách sv
        List<HangHoa> lstHangHoa = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from HangHoa where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (PRODUCT_ID = '" + tuKhoa  + "' OR PRODUCT_NAME like '%"
                        + tuKhoa + "%')";
            }
            
            if(!nhomHang.isEmpty())
            {
                strSQL += " AND PRODUCT_TYPE = '" + nhomHang + "'";
            }

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            HangHoa objHH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHH = new HangHoa();

                //Gán giá trị cho các thuộc tính
               objHH.setMaHang(rs.getString("PRODUCT_ID"));
                objHH.setTenHang(rs.getString("PRODUCT_NAME"));
                
                objHH.setGiaBan(rs.getInt("PRODUCT_PRICE"));
                objHH.setTenNhomHang(rs.getString("PRODUCT_TYPE"));
                objHH.setTonKho(rs.getInt("PRODUCT_QUANTITY"));
                objHH.setViTri(rs.getString("PRODUCT_LOCATION"));

                //Thêm vào danh sách
                lstHangHoa.add(objHH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HangHoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(HangHoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstHangHoa;
    }
    public HangHoa layChiTietTheoMa(String maHang)
    {
        HangHoa objHH = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from HangHoa where PRODUCT_ID='" + maHang + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHH = new HangHoa();

                //Gán giá trị cho các thuộc tính
                objHH.setMaHang(rs.getString("PRODUCT_ID"));
                objHH.setTenHang(rs.getString("PRODUCT_NAME"));
                
                objHH.setGiaBan(rs.getInt("PRODUCT_PRICE"));
                objHH.setTenNhomHang(rs.getString("PRODUCT_TYPE"));
                objHH.setTonKho(rs.getInt("PRODUCT_QUANTITY"));
                objHH.setViTri(rs.getString("PRODUCT_LOCATION"));
                 
                
                
                
                
                
                //Thêm vào danh sách
                lstHangHoa.add(objHH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HangHoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(HangHoaBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return objHH;
    }

    public HangHoaBusiness() {
    }
    public boolean themMoi(HangHoa objHH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strInsert = "Insert into HangHoa(PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE,  "
                    + "PRODUCT_PRICE, PRODUCT_LOCATION,PRODUCT_QUANTITY,PRODUCT_DESCRIPTION) values("
                    + "?,?,?,?,?, ?, ?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objHH.getMaHang());
            comm.setString(2, objHH.getTenHang());
            comm.setString(3, objHH.getTenNhomHang());
           
            comm.setInt(4, objHH.getGiaBan());
            comm.setString(5, objHH.getViTri());
            
            comm.setInt(6, 0);
            
               comm.setString(7, objHH.getMoTa());
                
                
                  
            
            
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
     * @param objHH
     * @return 
     */
    public boolean capNhat(HangHoa objHH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strUpdate = "Update HangHoa set PRODUCT_NAME=?, PRODUCT_TYPE = ?,  "
                    + "PRODUCT_PRICE = ?, PRODUCT_LOCATION = ?, "
                    + "PRODUCT_QUANTITY=?, PRODUCT_DESCRIPTION=? where PRODUCT_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
            
           comm.setString(7, objHH.getMaHang());
            comm.setString(1, objHH.getTenHang());
            comm.setString(2, objHH.getTenNhomHang());
           
            comm.setInt(3, objHH.getGiaBan());
            comm.setString(4, objHH.getViTri());
            
            comm.setInt(5, objHH.getTonKho());
            
               comm.setString(6, objHH.getMoTa());
            
            
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
    public boolean xoa(String MaHang)
    {
       Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strDelete = "Delete from HangHoa where PRODUCT_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strDelete);
            
            //Thiết lập các giá trị cho tham số
            
            comm.setString(1, MaHang);
            
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
