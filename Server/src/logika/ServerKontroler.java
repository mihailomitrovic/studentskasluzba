/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import so.SONadjiStudente;
import db.DBBroker;
import domen.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import so.*;

/**
 *
 * @author mihailomitrovic
 */
public class ServerKontroler {
    private static ServerKontroler instance;

    public ServerKontroler() {
    }
    
    public static ServerKontroler getInstance() {
        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }
    
    public Sluzbenik nadjiSluzbenika(Sluzbenik sluzbenik) throws Exception {
        SONadjiSluzbenika so = new SONadjiSluzbenika();
        so.template(sluzbenik);
        return so.getSluzbenik();
    }
    
    public ArrayList<Mesto> ucitajListuMesta() throws Exception {
        SOUcitajListuMesta so = new SOUcitajListuMesta();
        so.template(new Mesto());
        return so.getListaMesta();
    }
    
    public void zapamtiStudenta(Student student) throws Exception {
        SOZapamtiStudenta so = new SOZapamtiStudenta();
        so.template(student);
    }
    
    public ArrayList<Student> nadjiStudente(Student student) throws Exception {
        SONadjiStudente so = new SONadjiStudente();
        so.template(student);
        return so.getListaStudenata();
    }
    
    public ArrayList<Student> vratiStudente() throws Exception {
        SOVratiStudente so = new SOVratiStudente();
        so.template(new Student());
        return so.getListaStudenata();
    }
    
    public Student ucitajStudenta(Student student) throws Exception {
        SOUcitajStudenta so = new SOUcitajStudenta();
        so.template(student);
        return so.getStudent();
    }
    
    public void izmeniStudenta(Student student) throws Exception {
        SOIzmeniStudenta so = new SOIzmeniStudenta();
        so.template(student);
    }
     
    public ArrayList<Ispit> ucitajListuIspita() throws Exception {
        SOUcitajListuIspita so = new SOUcitajListuIspita();
        so.template(new Ispit());
        return so.getListaIspita();
    }
    
    public ArrayList<IspitniRok> ucitajListuIspitnihRokova() throws Exception {
        SOUcitajListuIspitnihRokova so = new SOUcitajListuIspitnihRokova();
        so.template(new IspitniRok());
        return so.getListaRokova();
    }
    
    public void zapamtiPrijavuIspita(PrijavaIspita prijava) throws Exception {
        SOZapamtiPrijavuIspita so = new SOZapamtiPrijavuIspita();
        so.template(prijava);
    }
    
    public ArrayList<PrijavaIspita> nadjiPrijaveIspita(PrijavaIspita prijava) throws Exception {
        SONadjiPrijaveIspita so = new SONadjiPrijaveIspita();
        so.template(prijava);
        return so.getListaPrijava();
    }
    
    public ArrayList<PrijavaIspita> vratiPrijaveIspita() throws Exception {
        SOVratiPrijaveIspita so = new SOVratiPrijaveIspita();
        so.template(new PrijavaIspita());
        return so.getListaPrijava();
    }
    
    public PrijavaIspita ucitajPrijavuIspita(PrijavaIspita prijava) throws Exception {
        SOUcitajPrijavuIspita so = new SOUcitajPrijavuIspita();
        so.template(prijava);
        return so.getPrijavaIspita();
    }
    
    public ArrayList<Ispit> nadjiIspite(Ispit ispit) throws Exception {
        SONadjiIspite so = new SONadjiIspite();
        so.template(ispit);
        return so.getListaIspita();
    }  
    
    public Ispit ucitajIspit(Ispit ispit) throws Exception {
        SOUcitajIspit so = new SOUcitajIspit();
        so.template(ispit);
        return so.getIspit();
    }
    
    public void obrisiPrijavuIspita(PrijavaIspita prijava) throws Exception {
        SOObrisiPrijavuIspita so = new SOObrisiPrijavuIspita();
        so.template(prijava);
    }
    
    public RacunPrijaveIspita vratiRacunPrijaveIspita(PrijavaIspita prijava) throws Exception {
        SOVratiRacunPrijaveIspita so = new SOVratiRacunPrijaveIspita();
        RacunPrijaveIspita racun = new RacunPrijaveIspita();
        racun.setPrijavaIspita(prijava);
        so.template(racun);
        return so.getRacun();
    }
    
    public void zapamtiRacunPrijaveIspita(PrijavaIspita prijava) throws Exception {
        SOZapamtiRacunPrijaveIspita so = new SOZapamtiRacunPrijaveIspita();
        RacunPrijaveIspita racun = new RacunPrijaveIspita();
        racun.setPrijavaIspita(prijava);
        racun.setDatumIzdavanja(new Date());
        so.template(racun);
    }

}
