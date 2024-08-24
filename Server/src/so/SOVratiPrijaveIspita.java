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

public class SOVratiPrijaveIspita extends ApstraktnaSO {

    ArrayList<PrijavaIspita> listaPrijava;

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
        listaPrijava = (ArrayList<PrijavaIspita>) (ArrayList<?>) lista;
    }
    
}
