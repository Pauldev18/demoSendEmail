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
public class NhapHangBusiness {
    
    public List<NhapHang> timKiemNhapHang(String tuKhoa) {
        //Khai báo danh sách sv
        List<NhapHang> lstNhapHang = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from DonHangNhap where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (IMPORT_ID = '" + tuKhoa + "' )";
            }
            
            

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            NhapHang objNH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNH = new NhapHang();

                //Gán giá trị cho các thuộc tính
               objNH.setMaNhap(rs.getString("IMPORT_ID"));
                objNH.setNgayNhap(rs.getDate("ORDER_TIME_IMP"));
                objNH.setTongTienHang(rs.getInt("TOTAL_COST_IMP"));
                objNH.setTenNhaCungCap(rs.getString("SUPPLIER_NAME"));
                

                //Thêm vào danh sách
                lstNhapHang.add(objNH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhapHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhapHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstNhapHang;
    }
    private List<NhapHang> lstNhapHang = new ArrayList<NhapHang>();
    
    /**
     * Hàm lấy danh sách sinh viên từ db
     * @return 
     */
    public List<NhapHang> layDanhSach() {
        //Khai báo danh sách sv
        List<NhapHang> lstNhapHang = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from donhangnhap";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            NhapHang objNH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNH = new NhapHang();

                //Gán giá trị cho các thuộc tính
                
                objNH.setMaNhap(rs.getString("IMPORT_ID"));
                 objNH.setNgayNhap(rs.getDate("ORDER_TIME_IMP"));
                objNH.setTongTienHang(rs.getInt("TOTAL_COST_IMP"));
                objNH.setTenNhaCungCap(rs.getString("SUPPLIER_NAME"));
                //Thêm vào danh sách
                lstNhapHang.add(objNH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhapHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhapHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstNhapHang;
    }
    public NhapHang layChiTietTheoMa(String maNhap)
    {
        NhapHang objNH = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from donhangnhap where IMPORT_ID='" + maNhap + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNH = new NhapHang();

                //Gán giá trị cho các thuộc tính
               
                 objNH.setNgayNhap(rs.getDate("ORDER_TIME_IMP"));
                objNH.setTongTienHang(rs.getInt("TOTAL_COST_IMP"));
                objNH.setTenNhaCungCap(rs.getString("SUPPLIER_NAME"));
                                  
                
                
                
                
                
                //Thêm vào danh sách
                lstNhapHang.add(objNH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhapHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(NhapHangBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return objNH;
    }

    public NhapHangBusiness() {
    }
    public boolean themMoi(NhapHang objNH)
    {
        Connection conn = null;
           
        try {
            int SoLuong=0;
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strInsert = "Insert into donhangnhap(IMPORT_ID, ORDER_TIME_IMP, TOTAL_COST_IMP, SUPPLIER_NAME "
                    + ") values("
                    + "?,?,?,?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objNH.getMaNhap());
            comm.setInt(3, objNH.getTongTienHang());
            comm.setString(4, objNH.getTenNhaCungCap());
            comm.setDate(2, new Date(objNH.getNgayNhap().getTime()));
            
                
                
             
                
                  
            
            
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
    
    public boolean themMoi1(NhapHang objNH)
    {
        Connection conn = null;
           
        try {
            int SoLuong=0;
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strSQL = "Select * from donhangnhap where IMPORT_ID='" + objNH.getMaHang() + "'";

            Statement coa = conn.createStatement();

            ResultSet rs = coa.executeQuery(strSQL);   
           /* while (rs.next())
            {
                SoLuong=rs.getInt("TonKho");
            }
              SoLuong+=objNH.getSoLuong();*/
            String strUpdate = "Update HangHoa set  TonKho=?  where MaHang = ?";
            
             PreparedStatement comm = conn.prepareStatement(strUpdate);    
            comm.setInt(1, SoLuong);
            comm.setString(2, objNH.getMaHang());
                
                
             
                
                  
            
            
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
     * @param objNH
     * @return 
     */
    public boolean capNhat(NhapHang objNH)
    {
        int soLuong=0;
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            

            
            //Khai báo công việc
            String strUpdate = "Update donhangnhap set ORDER_TIME_IMP=?, TOTAL_COST_IMP = ?, SUPPLIER_NAME= ? "
                    
                    + " where IMPORT_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
            
            comm.setString(4, objNH.getMaNhap());
           
            comm.setDate(1, new Date(objNH.getNgayNhap().getTime()));
            comm.setInt(2, objNH.getTongTienHang());
            comm.setString(3, objNH.getTenNhaCungCap());
            
             
              
            
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
    
    public boolean xoa(String MaNhap)
    {
       Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strDelete = "Delete from donhangnhap where IMPORT_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strDelete);
            
            //Thiết lập các giá trị cho tham số
            
            comm.setString(1, MaNhap);
            
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
