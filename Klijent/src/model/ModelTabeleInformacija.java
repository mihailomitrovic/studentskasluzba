/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Ispit;
import domen.PrijavaIspita;
import forma.FormaPretragaIspita;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import logika.KlijentKontroler;

/**
 *
 * @author mihailomitrovic
 */
public class ModelTabeleInformacija extends AbstractTableModel {

    private ArrayList<Ispit> lista;
    private String[] kolone = {"Ispit"};
    private String pretraga = "";
    
    public ModelTabeleInformacija() throws Exception {
        lista = KlijentKontroler.getInstance().ucitajListuIspita();
    }
    
    public ModelTabeleInformacija(ArrayList<Ispit> listaIspita) throws Exception {
        lista = listaIspita;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    @Override
    public Object getValueAt(int red, int kolona) {
        Ispit ispit = lista.get(red);
        
        switch (kolona) {
            case 0: return ispit.getNazivIspita();
            default: return "Greška!";
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    
    public ArrayList<Ispit> getLista() {
        return lista;
    }
    
    public Ispit getIspit(int red) {
        return lista.get(red);
    }
    
}
