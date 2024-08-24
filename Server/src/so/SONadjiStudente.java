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
public class SONadjiStudente extends ApstraktnaSO {
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
        ArrayList<Student> pronadjenaLista = (ArrayList<Student>) (ArrayList<?>) lista;
        
        Student s = (Student) ado;
        
        ArrayList<Student> listaZaSlanje = new ArrayList<>();
        
        for (Student student : pronadjenaLista) {
            if (student.getImePrezime().toLowerCase().startsWith(s.getImePrezime().toLowerCase())) {
                listaZaSlanje.add(student);
            }
        } 
        
        listaStudenata = listaZaSlanje;
    }
    
}
