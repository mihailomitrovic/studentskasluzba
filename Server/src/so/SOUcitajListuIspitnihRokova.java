/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.IspitniRok;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SOUcitajListuIspitnihRokova extends ApstraktnaSO {
    private ArrayList<IspitniRok> listaRokova;

    public ArrayList<IspitniRok> getListaRokova() {
        return listaRokova;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof IspitniRok)) {
            throw new Exception("Nevalidan objekat!");
        }    
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        listaRokova = (ArrayList<IspitniRok>) (ArrayList<?>) lista;    
    }

}
