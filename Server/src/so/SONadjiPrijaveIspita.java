/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.PrijavaIspita;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SONadjiPrijaveIspita extends ApstraktnaSO {
    private ArrayList<PrijavaIspita> listaPrijava;

    public ArrayList<PrijavaIspita> getListaPrijava() {
        return listaPrijava;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof PrijavaIspita)) {
            throw new Exception("Nevalidan objekat!");
        }        
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        ArrayList<PrijavaIspita> pronadjenaLista = (ArrayList<PrijavaIspita>) (ArrayList<?>) lista;
        
        PrijavaIspita p = (PrijavaIspita) ado;
        
        ArrayList<PrijavaIspita> listaZaSlanje = new ArrayList<>();
        
        for (PrijavaIspita prijava : pronadjenaLista) {
            if (prijava.getIspit().getNazivIspita().toLowerCase().startsWith(p.getIspit().getNazivIspita().toLowerCase()) || prijava.getStudent().getImePrezime().toLowerCase().startsWith(p.getStudent().getImePrezime().toLowerCase())) {
                listaZaSlanje.add(prijava);
            }
        } 
        
        listaPrijava = listaZaSlanje;
    }
}
