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

public class Sluzbenik extends ApstraktniObjekat {

    private int sluzbenikID;
    private String korisnickoIme;
    private String lozinka;
    private String imePrezime;
    private String imeVokativ;

    public Sluzbenik() {
    }

    public Sluzbenik(int sluzbenikID, String korisnickoIme, String lozinka, String imePrezime, String imeVokativ) {
        this.sluzbenikID = sluzbenikID;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.imePrezime = imePrezime;
        this.imeVokativ = imeVokativ;
    }

    public int getSluzbenikID() {
        return sluzbenikID;
    }

    public void setSluzbenikID(int sluzbenikID) {
        this.sluzbenikID = sluzbenikID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getImeVokativ() {
        return imeVokativ;
    }

    public void setImeVokativ(String imeVokativ) {
        this.imeVokativ = imeVokativ;
    }

    @Override
    public String toString() {
        return imePrezime;
    }  
    
    @Override
    public String tabela() {
        return "sluzbenik";
    }

    @Override
    public String alijas() {
        return "sl";
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
        return "";
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
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
            Sluzbenik sl = new Sluzbenik(rs.getInt("SluzbenikID"), rs.getString("KorisnickoIme"), rs.getString("Lozinka"), rs.getString("ImePrezimeSluzbenika"), rs.getString("ImeVokativ"));
            lista.add(sl);
        }
        
        rs.close();
        return lista;
    }
    
}
