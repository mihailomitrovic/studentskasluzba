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
public class SOUcitajStudenta extends ApstraktnaSO {
    private Student student;
    
    public Student getStudent() {
        return student;
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
        ArrayList<Student> listaStudenata = (ArrayList<Student>) (ArrayList<?>) lista;
        
        Student s = (Student) ado;
        
        for (Student student : listaStudenata) {
            if (student.getStudentID() == s.getStudentID()) {
                this.student = student;
                break;
            }
        }
        
    }
}
