/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mihailomitrovic
 */
public class RacunPrijaveIspita extends ApstraktniObjekat {
    private int racunID;
    private Date datumIzdavanja;
    private PrijavaIspita prijavaIspita;

    public RacunPrijaveIspita() {
    }

    public RacunPrijaveIspita(int racunID, Date datumIzdavanja, PrijavaIspita prijavaIspita) {
        this.racunID = racunID;
        this.datumIzdavanja = datumIzdavanja;
        this.prijavaIspita = prijavaIspita;
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public PrijavaIspita getPrijavaIspita() {
        return prijavaIspita;
    }

    public void setPrijavaIspita(PrijavaIspita prijavaIspita) {
        this.prijavaIspita = prijavaIspita;
    }
    
    @Override
    public String tabela() {
        return "racunprijaveispita";
    }

    @Override
    public String alijas() {
        return "rpi";
    }

    @Override
    public String spajanje() {
        return "JOIN prijavaispita pi ON (pi.PrijavaID = rpi.PrijavaID)";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "(PrijavaID, DatumIzdavanja)";
    }

    @Override
    public String vrednostiZaInsert() {
        return prijavaIspita.getPrijavaID() + ", '" + new Timestamp(datumIzdavanja.getTime()) + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "PrijavaID = " + prijavaIspita.getPrijavaID();
    }

    @Override
    public ArrayList<ApstraktniObjekat> lista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            PrijavaIspita pi = new PrijavaIspita(rs.getInt("PrijavaID"), rs.getDate("DatumPrijave"), null, null, null, null);
            RacunPrijaveIspita rpi = new RacunPrijaveIspita(rs.getInt("RacunID"), rs.getDate("DatumIzdavanja"), pi);
            lista.add(rpi);
        }
        
        rs.close();
        return lista;    
    }
    
}
