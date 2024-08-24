/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author mihailomitrovic
 */
public class Student extends ApstraktniObjekat {
    private int studentID;
    private String imePrezime;
    private Date datumRodjenja;
    private String kontakt;
    private Mesto mesto;

    public Student() {
    }

    public Student(int studentID, String imePrezime, Date datumRodjenja, String kontakt, Mesto mesto) {
        this.studentID = studentID;
        this.imePrezime = imePrezime;
        this.datumRodjenja = datumRodjenja;
        this.kontakt = kontakt;
        this.mesto = mesto;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return imePrezime;
    }
      
    @Override
    public String tabela() {
        return "student";
    }

    @Override
    public String alijas() {
        return "st";
    }

    @Override
    public String spajanje() {
        return "JOIN mesto m ON (m.MestoID = st.MestoID)";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "(ImePrezime, DatumRodjenja, Kontakt, MestoID)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imePrezime + "','" + new java.sql.Date(datumRodjenja.getTime()) + "','" + kontakt + "'," + mesto.getMestoID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "ImePrezime = '" + imePrezime + "', DatumRodjenja = '" + new java.sql.Date(datumRodjenja.getTime()) + "', Kontakt = '" + kontakt + "', MestoID = " + mesto.getMestoID();
    }

    @Override
    public String id() {
        return "StudentID = " + studentID;
    }
    
    @Override
    public ArrayList<ApstraktniObjekat> lista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getString("NazivMesta"));
            Student st = new Student(rs.getInt("StudentID"), rs.getString("ImePrezime"), rs.getDate("DatumRodjenja"), rs.getString("Kontakt"), m);
            lista.add(st);
        }
        
        rs.close();
        return lista;
    }
    
}
