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

            String strSQL = "Select * from HoaDon where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (maHoaDon = '" + tuKhoa + "'  OR maHang like '%" + 
                        tuKhoa + "%' OR tenHang like '%"+tuKhoa 
                        +"%' OR KhachHang like '%"+ tuKhoa + "%')";
            }
            
            

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            HoaDon objHD;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHD = new HoaDon();

                //Gán giá trị cho các thuộc tính
                objHD.setTenHang(rs.getString("TenHang"));
                objHD.setSoLuong(rs.getInt("SoLuong"));
                objHD.setThoiGian(rs.getDate("ThoiGian"));
                objHD.setKhachHang(rs.getString("KhachHang"));
                objHD.setTongTienHang(rs.getInt("TongTienHang"));
                objHD.setMaHoaDon(rs.getString("MaHoaDon"));

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

            String strSQL = "Select * from HoaDon";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            HoaDon objHD;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHD = new HoaDon();

                //Gán giá trị cho các thuộc tính
                
                objHD.setTenHang(rs.getString("TenHang"));
                objHD.setSoLuong(rs.getInt("SoLuong"));
                objHD.setThoiGian(rs.getDate("ThoiGian"));
                objHD.setKhachHang(rs.getString("KhachHang"));
                objHD.setTongTienHang(rs.getInt("TongTienHang"));
                objHD.setMaHoaDon(rs.getString("MaHoaDon"));

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

            String strSQL = "Select * from HoaDon where maHoaDon='" + maHoaDon + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHD = new HoaDon();

                //Gán giá trị cho các thuộc tính
                objHD.setTenHang(rs.getString("TenHang"));
                objHD.setSoLuong(rs.getInt("SoLuong"));
                objHD.setThoiGian(rs.getDate("ThoiGian"));
                objHD.setKhachHang(rs.getString("KhachHang"));
                objHD.setTongTienHang(rs.getInt("TongTienHang"));
                objHD.setMaHoaDon(rs.getString("MaHoaDon"));
                objHD.setMaHang(rs.getString("MaHang"));
                                  
                
                
                
                
                
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
            String strInsert = "Insert into HoaDon(MaHoaDon, TenHang, MaHang, ThoiGian, "
                    + "KhachHang,SoLuong,TongTienHang) values("
                    + "?,?,?,?,?, ?, ?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objHD.getMaHoaDon());
            comm.setString(2, objHD.getTenHang());
            comm.setString(3, objHD.getMaHang());
            comm.setDate(4, new Date(objHD.getThoiGian().getTime()));
            
            comm.setString(5, objHD.getKhachHang());
            comm.setInt(6, objHD.getSoLuong());
            comm.setInt(7, objHD.getTongTienHang());
             
                
                
                  
            
            
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
            String strUpdate = "Update HoaDon set TenHang=?, MaHang = ?, ThoiGian= ?, "
                    + " KhachHang = ?, "
                    + "SoLuong = ?, TongTienHang=?  where MaHoaDon = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
            
            comm.setString(7, objHD.getMaHoaDon());
            comm.setString(1, objHD.getTenHang());
            comm.setString(2, objHD.getMaHang());
            comm.setDate(3, new Date(objHD.getThoiGian().getTime()));
          
            comm.setString(4, objHD.getKhachHang());
            comm.setInt(5, objHD.getSoLuong());
            comm.setInt(6, objHD.getTongTienHang());
             
                
            
            
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
    public boolean capNhat1(HoaDon objHD)
    {
        int soLuong=0;
        Connection conn = null;
           
        try {
            int SoLuong=0,SoLuongCu=0;
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            String strSQL = "Select * from HoaDon where MaHoaDon='" + objHD.getMaHoaDon()+ "'";

            Statement coa = conn.createStatement();

            ResultSet rs = coa.executeQuery(strSQL);   
            while (rs.next())
            {
                SoLuongCu=rs.getInt("SoLuong");
            }
            //Khai báo công việc
           
             strSQL = "Select * from HangHoa where MaHang='" + objHD.getMaHang() + "'";

            

            rs = coa.executeQuery(strSQL);   
            while (rs.next())
            {
                SoLuong=rs.getInt("TonKho");
            }
                SoLuong=SoLuong-objHD.getSoLuong()+SoLuongCu;
            String strUpdate1 = "Update HangHoa set  TonKho=?  where MaHang = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate1);    
            comm.setInt(1, SoLuong);
            comm.setString(2, objHD.getMaHang());            //Thực hiện công việc
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
     public boolean xoa1(String MaHoaDon)
    {
       Connection conn = null;
           
       
            
            //Khai báo công việc
           try {
            int SoLuong=0;
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            HoaDon objHD = new HoaDon();
            objHD=layChiTietTheoMa(MaHoaDon);
            //Khai báo công việc
            String strSQL = "Select * from HangHoa where MaHang='" + objHD.getMaHang() + "'";

            Statement coa = conn.createStatement();

            ResultSet rs = coa.executeQuery(strSQL);   
            while (rs.next())
            {
                SoLuong=rs.getInt("TonKho");
            }
                SoLuong+=objHD.getSoLuong();
            String strUpdate = "Update HangHoa set  TonKho=?  where MaHang = ?";
            
             PreparedStatement comm = conn.prepareStatement(strUpdate);    
            comm.setInt(1, SoLuong);
            comm.setString(2, objHD.getMaHang());
                
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
     public boolean themMoi1(HoaDon objHD)
    {
        Connection conn = null;
           
        try {
            int SoLuong=0;
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strSQL = "Select * from HangHoa where MaHang='" + objHD.getMaHang() + "'";

            Statement coa = conn.createStatement();

            ResultSet rs = coa.executeQuery(strSQL);   
            while (rs.next())
            {
                SoLuong=rs.getInt("TonKho");
            }
                SoLuong-=objHD.getSoLuong();
            String strUpdate = "Update HangHoa set  TonKho=?  where MaHang = ?";
            
             PreparedStatement comm = conn.prepareStatement(strUpdate);    
            comm.setInt(1, SoLuong);
            comm.setString(2, objHD.getMaHang());
                
                
             
                
                  
            
            
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
    public boolean xoa(String MaHoaDon)
    {
       Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strDelete = "Delete from HoaDon where MaHoaDon = ?";
            
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
