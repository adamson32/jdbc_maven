
package com.mycompany.zadanie1_jdbc.maven;
import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAO {
    
    Connection con = DBUtil.getConnection();
    
   
    
      public void add(Employee p)
    {
        String query = "insert into pracownicy(prac_imie,prac_nazwisko,prac_wiek,prac_nr_telefonu,prac_email) values(?,?,?,?,?);";
        PreparedStatement pst;
         try {
             pst = con.prepareStatement(query);
             pst.setString(1, p.getPracImie());
             pst.setString(2, p.getPracNazwisko());
             pst.setInt(3, p.getPracWiek());
             pst.setString(4, p.getPracNrTelefonu());
             pst.setString(5, p.getPracEmail());
             pst.executeUpdate();
         } catch (Exception ex) {
             System.out.println(ex);
         }
        
        
    }
    
}
