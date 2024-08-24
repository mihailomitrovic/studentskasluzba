/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class Ispit extends ApstraktniObjekat {
    private int ispitID;
    private String nazivIspita;
    private String godinaStudija;
    private int brojESPB;
    private int cena;

    public Ispit() {
    }

    public Ispit(int ispitID, String nazivIspita, String godinaStudija, int brojESPB, int cena) {
        this.ispitID = ispitID;
        this.nazivIspita = nazivIspita;
        this.godinaStudija = godinaStudija;
        this.brojESPB = brojESPB;
        this.cena = cena;
    }

    public int getIspitID() {
        return ispitID;
    }

    public void setIspitID(int ispitID) {
        this.ispitID = ispitID;
    }

    public String getNazivIspita() {
        return nazivIspita;
    }

    public void setNazivIspita(String nazivIspita) {
        this.nazivIspita = nazivIspita;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public int getBrojESPB() {
        return brojESPB;
    }

    public void setBrojESPB(int brojESPB) {
        this.brojESPB = brojESPB;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return nazivIspita;
    }

    @Override
    public String tabela() {
        return "ispit";
    }

    @Override
    public String alijas() {
        return "i";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "(NazivIspita, BrojESPB, Cena)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivIspita + "'," + brojESPB + "," + cena;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> lista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            Ispit i = new Ispit(rs.getInt("IspitID"), rs.getString("NazivIspita"), rs.getString("GodinaStudija"), rs.getInt("BrojESPB"), rs.getInt("Cena"));
            lista.add(i);
        }
        
        rs.close();
        return lista;    
    }
        
}
