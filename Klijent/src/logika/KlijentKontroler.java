/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domen.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konst.Operacije;
import konst.StatusOdgovora;
import sesija.Sesija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author mihailomitrovic
 */
public class KlijentKontroler {
    private static KlijentKontroler instance;

    public KlijentKontroler() {
    }
    
    public static KlijentKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }
    
    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(operacija, parametar);
        ObjectOutputStream oos = new ObjectOutputStream(Sesija.getInstance().getSocket().getOutputStream());
        oos.writeObject(kz);
        
        ObjectInputStream ois = new ObjectInputStream(Sesija.getInstance().getSocket().getInputStream());
        ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
        
        if (so.getStatus().equals(StatusOdgovora.Error)) {
            throw so.getGreska();
        } else {
            return so.getOdgovor();
        }
    }

    public Sluzbenik nadjiSluzbenika(Sluzbenik sluzbenik) throws Exception {
        return (Sluzbenik) posaljiZahtev(Operacije.NADJI_SLUZBENIKA, sluzbenik);
    }
    
    public ArrayList<Mesto> ucitajListuMesta() throws Exception {
        return (ArrayList<Mesto>) posaljiZahtev(Operacije.UCITAJ_LISTU_MESTA, null);
    }
    
    public void zapamtiStudenta(Student student) throws Exception {
        posaljiZahtev(Operacije.ZAPAMTI_STUDENTA, student);
    }
    
    public ArrayList<Student> nadjiStudente(Student student) throws Exception {
        return (ArrayList<Student>) posaljiZahtev(Operacije.NADJI_STUDENTE, student);
    }
    
    public ArrayList<Student> vratiStudente() throws Exception {
        return (ArrayList<Student>) posaljiZahtev(Operacije.VRATI_STUDENTE, null);
    }
    
    public Student ucitajStudenta(Student student) throws Exception {
        return (Student) posaljiZahtev(Operacije.UCITAJ_STUDENTA, student);
    }
    
    public void izmeniStudenta(Student student) throws Exception {
        posaljiZahtev(Operacije.IZMENI_STUDENTA, student);
    }
    
    public ArrayList<Ispit> ucitajListuIspita() throws Exception {
        return (ArrayList<Ispit>) posaljiZahtev(Operacije.UCITAJ_LISTU_ISPITA, null);
    }
        
    public ArrayList<IspitniRok> ucitajListuIspitnihRokova() throws Exception {
        return (ArrayList<IspitniRok>) posaljiZahtev(Operacije.UCITAJ_LISTU_ISPITNIH_ROKOVA, null);
    }
    
    public void zapamtiPrijavuIspita(PrijavaIspita prijava) throws Exception {
        posaljiZahtev(Operacije.ZAPAMTI_PRIJAVU_ISPITA, prijava);
    }
    
    public ArrayList<PrijavaIspita> nadjiPrijaveIspita(PrijavaIspita prijava) throws Exception {
        return (ArrayList<PrijavaIspita>) posaljiZahtev(Operacije.NADJI_PRIJAVE_ISPITA, prijava);
    }

    public ArrayList<PrijavaIspita> vratiPrijaveIspita() throws Exception {
        return (ArrayList<PrijavaIspita>) posaljiZahtev(Operacije.VRATI_PRIJAVE_ISPITA, null);
    }
    
    public PrijavaIspita ucitajPrijavuIspita(PrijavaIspita prijava) throws Exception {
        return (PrijavaIspita) posaljiZahtev(Operacije.UCITAJ_PRIJAVU_ISPITA, prijava);
    }
    
    public ArrayList<Ispit> nadjiIspite(Ispit ispit) throws Exception {
        return (ArrayList<Ispit>) posaljiZahtev(Operacije.NADJI_ISPITE, ispit);
    }
    
    public Ispit ucitajIspit(Ispit ispit) throws Exception {
        return (Ispit) posaljiZahtev(Operacije.UCITAJ_ISPIT, ispit);
    }
    
    public void obrisiPrijavuIspita(PrijavaIspita prijava) throws Exception {
        posaljiZahtev(Operacije.OBRISI_PRIJAVU_ISPITA, prijava);
    }
    
    public RacunPrijaveIspita vratiRacunPrijaveIspita(PrijavaIspita prijava) throws Exception {
        return (RacunPrijaveIspita) posaljiZahtev(Operacije.VRATI_RACUN_PRIJAVE_ISPITA, prijava);
    }
    
    public void zapamtiRacunPrijaveIspita(PrijavaIspita prijava) throws Exception {
        posaljiZahtev(Operacije.ZAPAMTI_RACUN_PRIJAVE_ISPITA, prijava);
    }
}
