package com.mycompany.quanlibanhang;


import com.mycompany.quanlibanhang.CongTy;
import com.mycompany.quanlibanhang.DataProvider;


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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author My HP
 */
public class CongTyBusiness {
    
    
    private List<CongTy> lstCongTy = new ArrayList<CongTy>();
    
    /**
     * Hàm lấy danh sách sinh viên từ db
     * @return 
     */
    public List<CongTy> layDanhSach() {
        //Khai báo danh sách sv
        List<CongTy> lstCongTy = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from NhaCungCap";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            CongTy objCT;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objCT = new CongTy();

                //Gán giá trị cho các thuộc tính
                objCT.setID(rs.getString("SUPPLIER_ID"));
                objCT.setTenCongTy(rs.getString("SUPPLIER_NAME"));
                objCT.setDienThoai(rs.getString("SUPPLIER_PHONE_NUM"));
                objCT.setEmail(rs.getString("SUPPLIER_EMAIL"));
                objCT.setDiaChi(rs.getString("SUPPLIER_ADDRESS"));

                //Thêm vào danh sách
                lstCongTy.add(objCT);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CongTyBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(CongTyBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstCongTy;
    }
    public List<CongTy> timKiemCongTy(String tuKhoa) {
        //Khai báo danh sách sv
        List<CongTy> lstCongTy = new ArrayList();
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from NhaCungCap where 1=1";
            
            if(!tuKhoa.isEmpty())
            {
                strSQL += " AND (SUPPLIER_ID = '" + tuKhoa + "'  OR SUPPLIER_NAME like '%" + 
                        tuKhoa + "%' OR SUPPLIER_PHONE_NUM like '%"
                        + tuKhoa + "%')";
            }
            
            

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            CongTy objCT;
            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objCT = new CongTy();

                //Gán giá trị cho các thuộc tính
                objCT.setID(rs.getString("SUPPLIER_ID"));
                objCT.setTenCongTy(rs.getString("SUPPLIER_NAME"));
                objCT.setDienThoai(rs.getString("SUPPLIER_PHONE_NUM"));
                objCT.setEmail(rs.getString("SUPPLIER_EMAIL"));
                objCT.setDiaChi(rs.getString("SUPPLIER_ADDRESS"));

                //Thêm vào danh sách
                lstCongTy.add(objCT);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CongTyBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(CongTyBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstCongTy;
    }
    public CongTy layChiTietTheoMa(String ID)
    {
        CongTy objKH = null;
        
        Connection conn = null;
        try {

            conn = DataProvider.ketNoi();

            String strSQL = "Select * from NhaCungCap where SUPPLIER_ID='" + ID + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            //Lấy dữ liệu từng dòng trong rs để đưa vào list
            while (rs.next()) {
                objKH = new CongTy();

                //Gán giá trị cho các thuộc tính
                 objKH.setID(rs.getString("SUPPLIER_ID"));
                objKH.setTenCongTy(rs.getString("SUPPLIER_NAME"));
                objKH.setDienThoai(rs.getString("SUPPLIER_PHONE_NUM"));
                objKH.setEmail(rs.getString("SUPPLIER_EMAIL"));
                objKH.setDiaChi(rs.getString("SUPPLIER_ADDRESS"));
             
                
                
                lstCongTy.add(objKH);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CongTyBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                //Đóng kết nối
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(CongTyBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return objKH;
    }
    public boolean themMoi(CongTy objKH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strInsert = "Insert into NhaCungCap(SUPPLIER_ID, SUPPLIER_NAME, SUPPLIER_PHONE_NUM, SUPPLIER_EMAIL, SUPPLIER_ADDRESS "
                    + ") values("
                    + "?,?,?,?,?)";
            
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Thiết lập các giá trị cho tham số
            comm.setString(1, objKH.getID());
            comm.setString(2, objKH.getTenCongTy());
            comm.setString(3, objKH.getDienThoai());
            comm.setString(4, objKH.getEmail());
            comm.setString(5, objKH.getDiaChi());
           
            
               
                
                  
            
            
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
    public boolean capNhat(CongTy objKH)
    {
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
            
            //Khai báo công việc
            String strUpdate = "Update NhaCungCap set SUPPLIER_NAME=?, SUPPLIER_PHONE_NUM = ?, SUPPLIER_EMAIL = ?,SUPPLIER_ADDRESS=? "
                   
                    + "  where SUPPLIER_ID = ?";
            
            PreparedStatement comm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            
           comm.setString(1, objKH.getTenCongTy());
            comm.setString(2, objKH.getDienThoai());
            comm.setString(3, objKH.getEmail());
            comm.setString(4, objKH.getDiaChi());
            
            
                comm.setString(5, objKH.getID());
            
            
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
            String strDelete = "Delete from NhaCungCap where SUPPLIER_ID = ?";
            
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
