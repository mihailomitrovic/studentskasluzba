/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forma;

import domen.Ispit;
import domen.IspitniRok;
import domen.PrijavaIspita;
import domen.Sluzbenik;
import domen.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import logika.KlijentKontroler;
import model.ModelTabeleIspit;
import sesija.Sesija;

/**
 *
 * @author mihailomitrovic
 */
public class FormaPrijavaIspita extends javax.swing.JDialog {

    Student student;
    
    /**
     * Creates new form FormaPrijavaIspita
     */
    public FormaPrijavaIspita(JDialog parent, boolean modal, Student student) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.student = student;
        srediFormu();
        popuniCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbRokovi = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbIspiti = new javax.swing.JComboBox();
        btnDodaj = new javax.swing.JButton();
        btnUkloni = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIspiti = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Studentska služba - Prijava ispita");

        jLabel1.setText("Student:");

        lblStudent.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblStudent.setText("???");

        jLabel2.setText("Ispitni rok:");

        cmbRokovi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Datum prijave:");

        lblDatum.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblDatum.setText("???");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ispiti"));

        jLabel4.setText("Ispit:");

        cmbIspiti.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodaj.setText("Dodaj ispit");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnUkloni.setText("Ukloni ispit");
        btnUkloni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniActionPerformed(evt);
            }
        });

        tblIspiti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblIspiti);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbIspiti, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUkloni)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbIspiti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnUkloni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSacuvaj.setText("Sačuvaj prijave");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRokovi, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDatum))
                            .addComponent(btnSacuvaj)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblStudent)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStudent))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbRokovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDatum))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        ModelTabeleIspit mti = (ModelTabeleIspit) tblIspiti.getModel();
        Ispit ispit = (Ispit) cmbIspiti.getSelectedItem();
        
        if (!mti.postoji(ispit)) {
            mti.dodaj(ispit);
            btnSacuvaj.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Ispit je već dodat na listu!");
            return;
        }
        
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnUkloniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniActionPerformed
        ModelTabeleIspit mti = (ModelTabeleIspit) tblIspiti.getModel();
        int red = tblIspiti.getSelectedRow();
        ArrayList<Ispit> lista = mti.getLista();

        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati ispit!");
            return;
        } else {
            mti.izbrisi(red);
            
            if (lista.isEmpty()) {
                btnSacuvaj.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnUkloniActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        ModelTabeleIspit mti = (ModelTabeleIspit) tblIspiti.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ArrayList<Ispit> lista = mti.getLista();
        IspitniRok rok = (IspitniRok) cmbRokovi.getSelectedItem();
        Sluzbenik sluzbenik = Sesija.getInstance().getUlogovani();
        
        for (Ispit ispit : lista) {
            try {
                Date datum = sdf.parse(lblDatum.getText());
                PrijavaIspita prijava = new PrijavaIspita(-1, datum, rok, ispit, student, sluzbenik);
                KlijentKontroler.getInstance().zapamtiPrijavuIspita(prijava);    
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio prijavu za ispit " + prijava.getIspit().getNazivIspita() + "!");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Greška prilikom parsiranja datuma!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti prijavu!");
            }
        }
        
        srediFormu();
        cmbIspiti.setSelectedIndex(0);
        cmbRokovi.setSelectedIndex(0);
     }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormaPrijavaIspita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaPrijavaIspita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaPrijavaIspita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaPrijavaIspita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormaPrijavaIspita dialog = new FormaPrijavaIspita(new JDialog(), true, new Student());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnUkloni;
    private javax.swing.JComboBox cmbIspiti;
    private javax.swing.JComboBox cmbRokovi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JTable tblIspiti;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        try {
            lblStudent.setText(student.toString());
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            lblDatum.setText(sdf.format(new Date()));;
            tblIspiti.setModel(new ModelTabeleIspit());
            btnSacuvaj.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(FormaPrijavaIspita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void popuniCombo() {
        try {
            cmbRokovi.removeAllItems();
            ArrayList<IspitniRok> listaRokova = KlijentKontroler.getInstance().ucitajListuIspitnihRokova();
            
            for (IspitniRok ispitniRok : listaRokova) {
                cmbRokovi.addItem(ispitniRok);
            }
            
            cmbIspiti.removeAllItems();
            ArrayList<Ispit> listaIspita = KlijentKontroler.getInstance().ucitajListuIspita();
            
            for (Ispit ispit : listaIspita) {
                cmbIspiti.addItem(ispit);
            }
        } catch (Exception ex) {
            Logger.getLogger(FormaPrijavaIspita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
