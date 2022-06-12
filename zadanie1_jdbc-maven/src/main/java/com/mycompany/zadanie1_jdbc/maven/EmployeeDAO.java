
package com.mycompany.zadanie1_jdbc.maven;
import DBUtil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
      
      public List<Employee> getAllEmployeesList() throws SQLException
     {
        
         String query = "SELECT prac_id,prac_imie,prac_nazwisko,prac_wiek,prac_nr_telefonu,prac_email FROM pracownicy";
         List<Employee> list = new ArrayList<Employee>();
         Employee p=null;
         PreparedStatement pst;
         try{
             pst = con.prepareStatement(query);
         ResultSet rs = pst.executeQuery();
         while (rs.next())
         {
             p=new Employee();
             p.setPracId(rs.getInt("prac_id"));
             p.setPracImie(rs.getString("prac_imie"));
             p.setPracNazwisko(rs.getString("prac_nazwisko"));
             p.setPracWiek(rs.getInt("prac_wiek"));
             p.setPracNrTelefonu(rs.getString("prac_nr_telefonu"));
             p.setPracEmail(rs.getString("prac_email"));
             list.add(p);
         }
         }catch(Exception ex){
             System.out.println(ex);
         }
         
         return list;
     }
      
          
    
    
}
