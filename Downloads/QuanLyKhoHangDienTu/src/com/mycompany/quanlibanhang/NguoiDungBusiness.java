/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlibanhang;

import java.sql.Connection;
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
public class NguoiDungBusiness {
    
     private List<NguoiDung> lstNguoiDung = new ArrayList<NguoiDung>();
    
    public NguoiDung layThongTinTaiKhoan(String tenDangNhap)
    {
        NguoiDung objNguoiDung = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from nguoidung where Username = ?";

            PreparedStatement comm = conn.prepareStatement(strSQL);

            comm.setString(1, tenDangNhap);
            
            ResultSet rs = comm.executeQuery();

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objNguoiDung = new NguoiDung();

                //Gán giá trị cho các thuộc tính
                objNguoiDung.setId(rs.getString("UserID"));
                objNguoiDung.setHoTen(rs.getString("Full_Name"));
                objNguoiDung.setTenDangNhap(rs.getString("Username"));
                objNguoiDung.setMatKhau(rs.getString("PASSWORD"));
                objNguoiDung.setQuyenSuDung(rs.getString("Access_Level"));
                
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
    
    
     public List<NguoiDung> layDanhSach() {
        //Khai báo danh sách sv
        List<NguoiDung> lstNguoiDung = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from NguoiDung";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            NguoiDung objCT;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objCT = new NguoiDung();

                //Gán giá trị cho các thuộc tính
                objCT.setId(rs.getString("UserID"));
                objCT.setTenDangNhap(rs.getString("Username"));
                objCT.setMatKhau(rs.getString("PASSWORD"));
                objCT.setHoTen(rs.getString("Full_Name"));
                
                objCT.setQuyenSuDung(rs.getString("Access_Level"));

                //Thêm vào danh sách
                lstNguoiDung.add(objCT);
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

        return lstNguoiDung;
    }
    public List<NguoiDung> timKiemNguoiDung(String tuKhoa) {
        //Khai báo danh sách sv
        List<NguoiDung> lstNguoiDung = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from nguoiDung where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (UserID = '" + tuKhoa + "'  OR Username like '%" + 
                        tuKhoa + "%' OR Full_Name like '%" + 
                        tuKhoa + "%')";
            }
            
            

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            NguoiDung objCT;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objCT = new NguoiDung();

                //Gán giá trị cho các thuộc tính
                objCT.setId(rs.getString("UserID"));
                objCT.setTenDangNhap(rs.getString("Username"));
                objCT.setMatKhau(rs.getString("PASSWORD"));
                objCT.setHoTen(rs.getString("Full_Name"));
                
                objCT.setQuyenSuDung(rs.getString("Access_Level"));
                

                //Thêm vào danh sách
                lstNguoiDung.add(objCT);
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

        return lstNguoiDung;
    }
    public NguoiDung layChiTietTheoMa(String ID)
    {
        NguoiDung objCT = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from nguoiDung where UserID='" + ID + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objCT = new NguoiDung();

                //Gán giá trị cho các thuộc tính
                objCT.setId(rs.getString("UserID"));
                objCT.setTenDangNhap(rs.getString("Username"));
                objCT.setMatKhau(rs.getString("PASSWORD"));
                objCT.setHoTen(rs.getString("Full_Name"));
                
                objCT.setQuyenSuDung(rs.getString("Access_Level"));
             
                
                
                lstNguoiDung.add(objCT);
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
        
        return objCT;
    }
    public boolean themMoi(NguoiDung objKH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strInsert = "Insert into nguoiDung(UserID, Username, PASSWORD, Full_Name, Access_Level "
                    + ") values("
                    + "?,?,?,?,?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objKH.getId());
            comm.setString(2, objKH.getTenDangNhap());
            comm.setString(3, objKH.getMatKhau());
            comm.setString(4, objKH.getHoTen());
            comm.setString(5, objKH.getQuyenSuDung());
           
            
               
                
                  
            
            
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
    public boolean capNhat(NguoiDung objKH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strUpdate = "Update nguoiDung set Username=?, PASSWORD = ?, Full_Name = ?,Access_Level=? "
                   
                    + "  where UserID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
           comm.setString(1, objKH.getTenDangNhap());
            comm.setString(2, objKH.getMatKhau());
            comm.setString(3, objKH.getHoTen());
            comm.setString(4, objKH.getQuyenSuDung());
            
            
                comm.setString(5, objKH.getId());
            
            
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
            String strDelete = "Delete from nguoiDung where UserID = ?";
            
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
