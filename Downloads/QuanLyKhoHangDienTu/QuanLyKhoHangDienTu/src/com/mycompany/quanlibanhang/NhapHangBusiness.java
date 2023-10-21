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

            String strSQL = "Select * from NhapHang where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (maNhap = '" + tuKhoa + "'  OR maHang like '%" + 
                        tuKhoa + "%' OR tenHang like '%"+tuKhoa 
                        +"%' OR tenNhaCungCap like '%"+ tuKhoa + "%')";
            }
            
            

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            NhapHang objNH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNH = new NhapHang();

                //Gán giá trị cho các thuộc tính
                objNH.setTenHang(rs.getString("TenHang"));
                objNH.setSoLuong(rs.getInt("SoLuong"));
                objNH.setNgayNhap(rs.getDate("NgayNhap"));
                objNH.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                objNH.setTrangThai(rs.getString("TrangThai"));
                objNH.setMaNhap(rs.getString("MaNhap"));

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

            String strSQL = "Select * from NhapHang";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            NhapHang objNH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNH = new NhapHang();

                //Gán giá trị cho các thuộc tính
                
                objNH.setTenHang(rs.getString("TenHang"));
                objNH.setSoLuong(rs.getInt("SoLuong"));
                objNH.setNgayNhap(rs.getDate("NgayNhap"));
                objNH.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                objNH.setTrangThai(rs.getString("TrangThai"));
                objNH.setMaNhap(rs.getString("MaNhap"));

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

            String strSQL = "Select * from NhapHang where maNhap='" + maNhap + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNH = new NhapHang();

                //Gán giá trị cho các thuộc tính
                objNH.setMaHang(rs.getString("MaHang"));
                objNH.setTenHang(rs.getString("TenHang"));
                objNH.setMaNhap(rs.getString("MaNhap"));
                objNH.setNgayNhap(rs.getDate("NgayNhap"));
                objNH.setGhiChu(rs.getString("GhiChu"));
                objNH.setSoLuong(rs.getInt("SoLuong"));
                 objNH.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                 objNH.setTrangThai(rs.getString("TrangThai"));
                 objNH.setTongTienHang(rs.getInt("TongTienNhap"));
                                  
                
                
                
                
                
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
            String strInsert = "Insert into NhapHang(MaNhap, TenHang, MaHang, NgayNhap, "
                    + "TrangThai, TenNhaCungCap,SoLuong,TongTienNhap,GhiChu) values("
                    + "?,?,?,?,?, ?, ?, ?,?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objNH.getMaNhap());
            comm.setString(2, objNH.getTenHang());
            comm.setString(3, objNH.getMaHang());
            comm.setDate(4, new Date(objNH.getNgayNhap().getTime()));
            comm.setString(5, objNH.getTrangThai());
            comm.setString(6, objNH.getTenNhaCungCap());
            comm.setInt(7, objNH.getSoLuong());
            comm.setInt(8, objNH.getTongTienHang());
             
                comm.setString(9, objNH.getGhiChu());
                
                
             
                
                  
            
            
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
            String strSQL = "Select * from HangHoa where MaHang='" + objNH.getMaHang() + "'";

            Statement coa = conn.createStatement();

            ResultSet rs = coa.executeQuery(strSQL);   
            while (rs.next())
            {
                SoLuong=rs.getInt("TonKho");
            }
                SoLuong+=objNH.getSoLuong();
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
            String strUpdate = "Update NhapHang set TenHang=?, MaHang = ?, NgayNhap= ?, "
                    + "TrangThai = ?, TenNhaCungCap = ?, "
                    + "SoLuong = ?, TongTienNhap=?,GhiChu= ? where MaNhap = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
            
            comm.setString(9, objNH.getMaNhap());
            comm.setString(1, objNH.getTenHang());
            comm.setString(2, objNH.getMaHang());
            comm.setDate(3, new Date(objNH.getNgayNhap().getTime()));
            comm.setString(4, objNH.getTrangThai());
            comm.setString(5, objNH.getTenNhaCungCap());
            comm.setInt(6, objNH.getSoLuong());
            comm.setInt(7, objNH.getTongTienHang());
             
                comm.setString(8, objNH.getGhiChu());
            
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
     public boolean capNhat1(NhapHang objNH)
    {
        int soLuong=0;
        Connection conn = null;
           
        try {
            int SoLuong=0,SoLuongCu=0;
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            String strSQL = "Select * from NhapHang where MaNhap='" + objNH.getMaNhap()+ "'";

            Statement coa = conn.createStatement();

            ResultSet rs = coa.executeQuery(strSQL);   
            while (rs.next())
            {
                SoLuongCu=rs.getInt("SoLuong");
            }
            //Khai báo công việc
           
             strSQL = "Select * from HangHoa where MaHang='" + objNH.getMaHang() + "'";

            

            rs = coa.executeQuery(strSQL);   
            while (rs.next())
            {
                SoLuong=rs.getInt("TonKho");
            }
                SoLuong=SoLuong+objNH.getSoLuong()-SoLuongCu;
            String strUpdate1 = "Update HangHoa set  TonKho=?  where MaHang = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate1);    
            comm.setInt(1, SoLuong);
            comm.setString(2, objNH.getMaHang());            //Thực hiện công việc
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
    public boolean xoa1(String MaNhap)
    {
       Connection conn = null;
           
       
            
            //Khai báo công việc
           try {
            int SoLuong=0;
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            NhapHang objNH = new NhapHang();
            objNH=layChiTietTheoMa(MaNhap);
            //Khai báo công việc
            String strSQL = "Select * from HangHoa where MaHang='" + objNH.getMaHang() + "'";

            Statement coa = conn.createStatement();

            ResultSet rs = coa.executeQuery(strSQL);   
            while (rs.next())
            {
                SoLuong=rs.getInt("TonKho");
            }
                SoLuong-=objNH.getSoLuong();
            String strUpdate = "Update HangHoa set  TonKho=?  where MaHang = ?";
            
             PreparedStatement comm = conn.prepareStatement(strUpdate);    
            comm.setInt(1, SoLuong);
            comm.setString(2, objNH.getMaHang());
                
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
            
            //Thực hiện công việc
           
        
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
            String strDelete = "Delete from NhapHang where MaNhap = ?";
            
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
