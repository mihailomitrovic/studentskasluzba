/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mihailomitrovic
 */
public class IspitniRok extends ApstraktniObjekat {
    private int ispitniRokID;
    private String nazivIspitnogRoka;
    private String pridevIspitnogRoka;
    private Date datumOd;
    private Date datumDo;

    public IspitniRok() {
    }

    public IspitniRok(int ispitniRokID, String nazivIspitnogRoka, String pridevIspitnogRoka, Date datumOd, Date datumDo) {
        this.ispitniRokID = ispitniRokID;
        this.nazivIspitnogRoka = nazivIspitnogRoka;
        this.pridevIspitnogRoka = pridevIspitnogRoka;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public int getIspitniRokID() {
        return ispitniRokID;
    }

    public void setIspitniRokID(int ispitniRokID) {
        this.ispitniRokID = ispitniRokID;
    }

    public String getNazivIspitnogRoka() {
        return nazivIspitnogRoka;
    }

    public void setNazivIspitnogRoka(String nazivIspitnogRoka) {
        this.nazivIspitnogRoka = nazivIspitnogRoka;
    }

    public String getPridevIspitnogRoka() {
        return pridevIspitnogRoka;
    }

    public void setPridevIspitnogRoka(String pridevIspitnogRoka) {
        this.pridevIspitnogRoka = pridevIspitnogRoka;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    @Override
    public String toString() {
        return nazivIspitnogRoka;
    }

    @Override
    public String tabela() {
        return "ispitnirok";
    }

    @Override
    public String alijas() {
        return "ir";
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
            IspitniRok ir = new IspitniRok(rs.getInt("IspitniRokID"), rs.getString("NazivIspitnogRoka"), rs.getString("PridevIspitnogRoka"), rs.getDate("DatumOd"), rs.getDate("DatumDo"));
            lista.add(ir);
        }
        
        rs.close();
        return lista;
    }
    
    
}
