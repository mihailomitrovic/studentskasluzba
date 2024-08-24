/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.Mesto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SOUcitajListuMesta extends ApstraktnaSO {

    private ArrayList<Mesto> listaMesta;

    public ArrayList<Mesto> getListaMesta() {
        return listaMesta;
    }
    
    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Mesto)) {
            throw new Exception("Nevalidan objekat!");
        }    
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        listaMesta = (ArrayList<Mesto>) (ArrayList<?>) lista;    
    }
    
}
