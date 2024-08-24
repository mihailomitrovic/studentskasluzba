/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.Ispit;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SONadjiIspite extends ApstraktnaSO {
    private ArrayList<Ispit> listaIspita;

    public ArrayList<Ispit> getListaIspita() {
        return listaIspita;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Ispit)) {
            throw new Exception("Nevalidan objekat!");
        }        
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        ArrayList<Ispit> pronadjenaLista = (ArrayList<Ispit>) (ArrayList<?>) lista;
        
        Ispit i = (Ispit) ado;
        
        ArrayList<Ispit> listaZaSlanje = new ArrayList<>();
        
        for (Ispit ispit : pronadjenaLista) {
            if (ispit.getNazivIspita().toLowerCase().startsWith(i.getNazivIspita().toLowerCase())) {
                listaZaSlanje.add(ispit);
            }
        } 
        
        listaIspita = listaZaSlanje;
    }
}
