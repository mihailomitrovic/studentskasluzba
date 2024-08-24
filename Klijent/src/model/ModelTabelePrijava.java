/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.PrijavaIspita;
import forma.FormaPretragaPrijava;
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
public class ModelTabelePrijava extends AbstractTableModel {

    private ArrayList<PrijavaIspita> lista;
    private String[] kolone = {"Student", "Ispit", "Rok", "Datum"};
    private String pretraga = "";
    
    public ModelTabelePrijava() throws Exception {
        lista = KlijentKontroler.getInstance().vratiPrijaveIspita();
    }
    
    public ModelTabelePrijava(ArrayList<PrijavaIspita> listaPrijava) throws Exception {
        lista = listaPrijava;
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
        PrijavaIspita prijava = lista.get(red);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch (kolona) {
            case 0:
                return prijava.getStudent().toString();
            case 1:
                return prijava.getIspit().toString();
            case 2:
                return prijava.getIspitniRok().toString();
            case 3:
                return sdf.format(prijava.getDatumPrijave());
            default:
                return null;
        }    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    public PrijavaIspita getPrijava(int red) {
        return lista.get(red);
    }
    
}
