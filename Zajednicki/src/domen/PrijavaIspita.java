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

public class PrijavaIspita extends ApstraktniObjekat {
    private int prijavaID;
    private Date datumPrijave;
    private IspitniRok ispitniRok;
    private Ispit ispit;
    private Student student;
    private Sluzbenik sluzbenik;

    public PrijavaIspita() {
    }

    public PrijavaIspita(int prijavaID, Date datumPrijave, IspitniRok ispitniRok, Ispit ispit, Student student, Sluzbenik sluzbenik) {
        this.prijavaID = prijavaID;
        this.datumPrijave = datumPrijave;
        this.ispitniRok = ispitniRok;
        this.ispit = ispit;
        this.student = student;
        this.sluzbenik = sluzbenik;
    }

    public int getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(int prijavaID) {
        this.prijavaID = prijavaID;
    }

    public Date getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(Date datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public IspitniRok getIspitniRok() {
        return ispitniRok;
    }

    public void setIspitniRok(IspitniRok ispitniRok) {
        this.ispitniRok = ispitniRok;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }

    public void setSluzbenik(Sluzbenik sluzbenik) {
        this.sluzbenik = sluzbenik;
    }
    
    @Override
    public String tabela() {
        return "prijavaispita";
    }

    @Override
    public String alijas() {
        return "pi";
    }

    @Override
    public String spajanje() {
        return "JOIN ispitnirok ir ON (ir.IspitniRokID = pi.IspitniRokID)" +
                "JOIN ispit i ON (i.IspitID = pi.IspitID)" +
                "JOIN student st ON (st.StudentID = pi.StudentID)" +
                "JOIN sluzbenik sl ON (sl.SluzbenikID = pi.SluzbenikID)";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "(DatumPrijave, IspitniRokID, IspitID, StudentID, SluzbenikID)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumPrijave.getTime()) + "'," + ispitniRok.getIspitniRokID()+ "," + ispit.getIspitID()+ "," + student.getStudentID()+ "," + sluzbenik.getSluzbenikID();
    }
    
    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "PrijavaID = " + prijavaID;
    }

    @Override
    public ArrayList<ApstraktniObjekat> lista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            IspitniRok ir = new IspitniRok(rs.getInt("IspitniRokID"), rs.getString("NazivIspitnogRoka"), rs.getString("PridevIspitnogRoka"), rs.getDate("DatumOd"), rs.getDate("DatumDo"));
            Ispit i = new Ispit(rs.getInt("IspitID"), rs.getString("NazivIspita"), rs.getString("GodinaStudija"), rs.getInt("BrojESPB"), rs.getInt("Cena"));
            Student st = new Student(rs.getInt("StudentID"), rs.getString("ImePrezime"), rs.getDate("DatumRodjenja"), rs.getString("Kontakt"), null);
            Sluzbenik sl = new Sluzbenik(rs.getInt("SluzbenikID"), rs.getString("KorisnickoIme"), rs.getString("Lozinka"), rs.getString("ImePrezimeSluzbenika"), rs.getString("ImeVokativ"));
            PrijavaIspita pi = new PrijavaIspita(rs.getInt("PrijavaID"), rs.getDate("DatumPrijave"), ir, i, st, sl);
            lista.add(pi);
        }
        
        rs.close();
        return lista;    
    }
    
    
}
