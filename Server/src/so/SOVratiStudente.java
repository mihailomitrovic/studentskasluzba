/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.Student;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SOVratiStudente extends ApstraktnaSO {
    private ArrayList<Student> listaStudenata;

    public ArrayList<Student> getListaStudenata() {
        return listaStudenata;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Student)) {
            throw new Exception("Nevalidan objekat!");
        }     
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        listaStudenata = (ArrayList<Student>) (ArrayList<?>) lista;        
    }

    
    
}
