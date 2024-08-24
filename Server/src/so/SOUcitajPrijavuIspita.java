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
public class SOUcitajPrijavuIspita extends ApstraktnaSO {
    private PrijavaIspita prijava;
    
    public PrijavaIspita getPrijavaIspita() {
        return prijava;
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
        ArrayList<PrijavaIspita> listaPrijava = (ArrayList<PrijavaIspita>) (ArrayList<?>) lista;
        
        PrijavaIspita p = (PrijavaIspita) ado;
        
        for (PrijavaIspita prijava : listaPrijava) {
            if (prijava.getPrijavaID() == p.getPrijavaID()) {
                this.prijava = prijava;
                break;
            }
        }
        
    }
}
