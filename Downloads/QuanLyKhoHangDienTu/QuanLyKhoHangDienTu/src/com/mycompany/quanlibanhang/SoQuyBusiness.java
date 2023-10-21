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

/**
 *
 * @author My HP
 */
public class SoQuyBusiness {
    public boolean ThemTien(int tien)
    {
        int tonQuy=0,quyDauKy=0;
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
             String strSQL = "Select * from SoQuy where SoQuy='" + 1 + "'";
             Statement comm = conn.createStatement();
             ResultSet rs = comm.executeQuery(strSQL);
            //Khai báo công việc
            while (rs.next())
            {
            tonQuy=rs.getInt("TonQuy");
            quyDauKy=rs.getInt("QuyDauKy");
            }
            tonQuy+=tien;
            quyDauKy+=tien;
            String strUpdate = "Update SoQuy set quyDauKy=?, TonQuy = ? where SoQuy = '1'";
            
            PreparedStatement commm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            commm.setInt(1, quyDauKy);
            commm.setInt(2, tonQuy);
            
             
                
                
                  
            
            
            //Thực hiện công việc
           return (commm
                   .executeUpdate() > 0);
           
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
           public boolean TruTien(int tien)
    {
        int tonQuy=0,quyDauKy=0;
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
             String strSQL = "Select * from SoQuy where SoQuy='" + 1 + "'";
             Statement comm = conn.createStatement();
             ResultSet rs = comm.executeQuery(strSQL);
            //Khai báo công việc
            while (rs.next())
            {
            tonQuy=rs.getInt("TonQuy");
            quyDauKy=rs.getInt("QuyDauKy");
            }
            tonQuy-=tien;
            quyDauKy-=tien;
            String strUpdate = "Update SoQuy set quyDauKy=?, TonQuy = ? where SoQuy = '1'";
            
            PreparedStatement commm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            commm.setInt(1, quyDauKy);
            commm.setInt(2, tonQuy);
            
             
                
                
                  
            
            
            //Thực hiện công việc
           return (commm
                   .executeUpdate() > 0);
           
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
    
           public boolean TongThu()
    {
        int tongThu=0;
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
             String strSQL = "Select * from HoaDon ";
             Statement comm = conn.createStatement();
             ResultSet rs = comm.executeQuery(strSQL);
            //Khai báo công việc
            while (rs.next())
            {
            
                tongThu+=rs.getInt("TongTienHang");
            }
            
            String strUpdate = "Update SoQuy set TongThu = ? where SoQuy = '1'";
            
            PreparedStatement commm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            commm.setInt(1, tongThu);
            
            
             
                
                
                  
            
            
            //Thực hiện công việc
           return (commm
                   .executeUpdate() > 0);
           
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
    
            public boolean TongChi()
    {
        int tongChi=0;
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
             String strSQL = "Select * from NhapHang ";
             Statement comm = conn.createStatement();
             ResultSet rs = comm.executeQuery(strSQL);
            //Khai báo công việc
            while (rs.next())
            {
            
                tongChi+=rs.getInt("TongTienNhap");
            }
            
            String strUpdate = "Update SoQuy set TongChi = ? where SoQuy = '1'";
            
            PreparedStatement commm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            commm.setInt(1, tongChi);
            
            
             
                
                
                  
            
            
            //Thực hiện công việc
           return (commm
                   .executeUpdate() > 0);
           
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
     public boolean TonQuy()
    {
        int tongThu=0,tongChi=0,quyDauKy=0,tonQuy=0;
        Connection conn = null;
           
        try {
            
            //Kết nối đến db làm việc
            conn = DataProvider.ketNoi();
             String strSQL = "Select * from SoQuy ";
             Statement comm = conn.createStatement();
             ResultSet rs = comm.executeQuery(strSQL);
            //Khai báo công việc
            while (rs.next())
            {
                tongChi=rs.getInt("TongChi");
                tongThu=rs.getInt("TongThu");
                quyDauKy=rs.getInt("quyDauKy");
            }
            tonQuy=quyDauKy-tongChi+tongThu;
            String strUpdate = "Update SoQuy set tonQuy = ? where SoQuy = '1'";
            
            PreparedStatement commm = conn.prepareStatement(strUpdate);
            
            //Thiết lập các giá trị cho tham số
            commm.setInt(1, tonQuy);
            
            
             
                
                
                  
            
            
            //Thực hiện công việc
           return (commm
                   .executeUpdate() > 0);
           
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
}
