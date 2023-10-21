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
public class ViTriBusiness {
    
    private List<ViTri> lstViTri = new ArrayList<ViTri>();
    
    /**
     * Hàm lấy danh sách sinh viên từ db
     * @return 
     */
    public List<ViTri> layDanhSach() {
        //Khai báo danh sách sv
        List<ViTri> lstViTri = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from ViTriLuuTru";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            ViTri objHH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHH = new ViTri();

                //Gán giá trị cho các thuộc tính
                objHH.setID(rs.getString("LOCATION_ID"));
                objHH.setTenViTri(rs.getString("LOCATION_NAME"));
                
               
                objHH.setTrangThai(rs.getString("LOCATION_STATUS"));
                objHH.setMoTa(rs.getString("LOCATION_DESCRIPTION"));
                

                //Thêm vào danh sách
                lstViTri.add(objHH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViTriBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(ViTriBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstViTri;
    }
    public List<ViTri> timKiemViTri(String tuKhoa) {
        //Khai báo danh sách sv
        List<ViTri> lstViTri = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from ViTriLuuTru where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (LOCATION_ID = '" + tuKhoa  + "' OR LOCATION_NAME like '%"
                        + tuKhoa + "%')";
            }
            
            

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            ViTri objHH;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHH = new ViTri();

                //Gán giá trị cho các thuộc tính
                objHH.setID(rs.getString("LOCATION_ID"));
                objHH.setTenViTri(rs.getString("LOCATION_NAME"));
                
               
                objHH.setTrangThai(rs.getString("LOCATION_STATUS"));
                objHH.setMoTa(rs.getString("LOCATION_DESCRIPTION"));

                //Thêm vào danh sách
                lstViTri.add(objHH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViTriBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(ViTriBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstViTri;
    }
    public ViTri layChiTietTheoMa(String ID)
    {
        ViTri objHH = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from ViTriLuuTru where LOCATION_ID='" + ID + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objHH = new ViTri();

                //Gán giá trị cho các thuộc tính
                objHH.setID(rs.getString("LOCATION_ID"));
                objHH.setTenViTri(rs.getString("LOCATION_NAME"));
                
               
                objHH.setTrangThai(rs.getString("LOCATION_STATUS"));
                objHH.setMoTa(rs.getString("LOCATION_DESCRIPTION"));;
                 
                
                
                
                
                
                //Thêm vào danh sách
                lstViTri.add(objHH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViTriBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(ViTriBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return objHH;
    }

    public ViTriBusiness() {
    }
    public boolean themMoi(ViTri objHH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strInsert = "Insert into ViTriLuuTru(LOCATION_ID, LOCATION_NAME, LOCATION_STATUS,  "
                    + "LOCATION_DESCRIPTION) values("
                    + "?,?,?,?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objHH.getID());
            comm.setString(2, objHH.getTenViTri());
            comm.setString(3, objHH.getTrangThai());
           
           
            
               comm.setString(4, objHH.getMoTa());
                
                
                  
            
            
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
    public boolean capNhat(ViTri objHH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strUpdate = "Update ViTriLuuTru set  LOCATION_NAME = ?,  "
                    + "LOCATION_STATUS = ?, LOCATION_DESCRIPTION = ? "
                    + " where LOCATION_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
            
           comm.setString(4, objHH.getID());
            comm.setString(1, objHH.getTenViTri());
            comm.setString(2, objHH.getTrangThai());
           
            comm.setString(3, objHH.getMoTa());
           
            
            
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
            String strDelete = "Delete from ViTriLuuTru where LOCATION_ID = ?";
            
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
