/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domen.Student;
import forma.FormaPretragaStudenata;
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
public class ModelTabeleStudent extends AbstractTableModel {

    private ArrayList<Student> lista;
    private String[] kolone = {"Ime i prezime", "Datum rođenja", "Mesto", "Kontakt"};
    private String pretraga = "";
    
    public ModelTabeleStudent() throws Exception {
        lista = KlijentKontroler.getInstance().vratiStudente();
    }
    
    public ModelTabeleStudent(ArrayList<Student> listaStudenata) throws Exception {
        lista = listaStudenata;
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
        Student student = lista.get(red);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch (kolona) {
            case 0: return student.getImePrezime();
            case 1: return sdf.format(student.getDatumRodjenja());
            case 2: return student.getMesto().getNazivMesta();
            case 3: return student.getKontakt();
            default: return "Greška!";
        }
    }
    
    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public Student getStudent(int red) {
        return lista.get(red);
    }
    
}
