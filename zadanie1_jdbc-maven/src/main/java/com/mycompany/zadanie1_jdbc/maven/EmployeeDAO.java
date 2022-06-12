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

    public void add(Employee p) {
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

    public Employee deleteByID(int prac_id) {
        String query = "delete from pracownicy where prac_id= ?";
        PreparedStatement pst;

        try {

            pst = con.prepareStatement(query);
            pst.setInt(1, prac_id);
            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Employee getByID(int prac_id) {

        String query = "select * from pracownicy where prac_id=?";
        PreparedStatement pst;
        try {

            pst = con.prepareStatement(query);
            pst.setInt(1, prac_id);
            ResultSet rs = pst.executeQuery();
            return setEmp(rs);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void update(int prac_id, String prac_imie, String prac_nazwisko, int prac_wiek, String prac_nr_telefon, String prac_email) {

        String query = "update pracownicy\n"
                + "set prac_imie= ?,prac_nazwisko= ?,prac_wiek= ?,prac_nr_telefonu= ?,prac_email= ?\n"
                + "where prac_id= ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, prac_imie);
            pst.setString(2, prac_nazwisko);
            pst.setInt(3, prac_wiek);
            pst.setString(4, prac_nr_telefon);
            pst.setString(5, prac_email);
            pst.setInt(6, prac_id);
            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public List<Employee> getAll() throws SQLException {

        String query = "SELECT prac_id,prac_imie,prac_nazwisko,prac_wiek,prac_nr_telefonu,prac_email FROM pracownicy";
        List<Employee> list = new ArrayList<Employee>();
        Employee p = null;
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                p = new Employee();
                p.setPracId(rs.getInt("prac_id"));
                p.setPracImie(rs.getString("prac_imie"));
                p.setPracNazwisko(rs.getString("prac_nazwisko"));
                p.setPracWiek(rs.getInt("prac_wiek"));
                p.setPracNrTelefonu(rs.getString("prac_nr_telefonu"));
                p.setPracEmail(rs.getString("prac_email"));
                list.add(p);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return list;
    }

    public List<Employee> findByEmailEndsWith(String s) throws SQLException {

        String query = "select * from pracownicy where prac_email like '%' + ?";
        List<Employee> list = new ArrayList<Employee>();
        Employee p = null;
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                p = new Employee();
                p.setPracId(rs.getInt("prac_id"));
                p.setPracImie(rs.getString("prac_imie"));
                p.setPracNazwisko(rs.getString("prac_nazwisko"));
                p.setPracWiek(rs.getInt("prac_wiek"));
                p.setPracNrTelefonu(rs.getString("prac_nr_telefonu"));
                p.setPracEmail(rs.getString("prac_email"));
                list.add(p);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return list;

    }

    private Employee setEmp(ResultSet rs) throws SQLException {
        Employee p = new Employee();
        rs.next();
        p.setPracId(rs.getInt("prac_id"));
        p.setPracImie(rs.getString("prac_imie"));
        p.setPracNazwisko(rs.getString("prac_nazwisko"));
        p.setPracWiek(rs.getInt("prac_wiek"));
        p.setPracNrTelefonu(rs.getString("prac_nr_telefonu"));
        p.setPracEmail(rs.getString("prac_email"));
        return p;
    }

}
