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
public class Mesto extends ApstraktniObjekat {

    private int mestoID;
    private String nazivMesta;

    public Mesto() {
    }

    public Mesto(int mestoID, String nazivMesta) {
        this.mestoID = mestoID;
        this.nazivMesta = nazivMesta;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public String getNazivMesta() {
        return nazivMesta;
    }

    public void setNazivMesta(String nazivMesta) {
        this.nazivMesta = nazivMesta;
    }

    @Override
    public String toString() {
        return nazivMesta;
    }
    
    @Override
    public String tabela() {
        return "mesto";
    }

    @Override
    public String alijas() {
        return "m";
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
            Mesto m = new Mesto(rs.getInt("MestoID"), rs.getString("NazivMesta"));
            lista.add(m);
        }
        
        rs.close();
        return lista;
    }
}
