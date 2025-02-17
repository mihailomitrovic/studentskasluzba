/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forma;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import niti.VremeNit;
import sesija.Sesija;

/**
 *
 * @author mihailomitrovic
 */
public class KlijentskaForma extends javax.swing.JFrame {

    VremeNit nit;
    
    /**
     * Creates new form KlijentskaForma
     */
    public KlijentskaForma() {
        initComponents();
        setLocationRelativeTo(null);
        lblUlogovani.setText(lblUlogovani.getText() + Sesija.getInstance().getUlogovani().getImeVokativ());
        prikaziVreme();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        lblTrenutno = new javax.swing.JLabel();
        lblVreme = new javax.swing.JLabel();
        btnOdjava = new javax.swing.JButton();
        lblUlogovani = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuStudenti = new javax.swing.JMenu();
        menuNoviStudent = new javax.swing.JMenuItem();
        menuPretragaStudenta = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuPretragaIspita = new javax.swing.JMenuItem();
        menuPrijave = new javax.swing.JMenu();
        menuPretragaPrijava = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Studentska služba");

        lblTrenutno.setText("Trenutni datum i vreme:");

        lblVreme.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblVreme.setText("00:00:00");

        btnOdjava.setText("Odjavi se");
        btnOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdjavaActionPerformed(evt);
            }
        });

        lblUlogovani.setText("Dobro došli, ");

        menuStudenti.setText("Studenti");

        menuNoviStudent.setText("Novi student");
        menuNoviStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNoviStudentActionPerformed(evt);
            }
        });
        menuStudenti.add(menuNoviStudent);

        menuPretragaStudenta.setText("Pretraga studenta");
        menuPretragaStudenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPretragaStudentaActionPerformed(evt);
            }
        });
        menuStudenti.add(menuPretragaStudenta);

        menu.add(menuStudenti);

        jMenu1.setText("Ispiti");

        menuPretragaIspita.setText("Informacije o ispitima");
        menuPretragaIspita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPretragaIspitaActionPerformed(evt);
            }
        });
        jMenu1.add(menuPretragaIspita);

        menu.add(jMenu1);

        menuPrijave.setText("Prijave");

        menuPretragaPrijava.setText("Pretraga prijava");
        menuPretragaPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPretragaPrijavaActionPerformed(evt);
            }
        });
        menuPrijave.add(menuPretragaPrijava);

        menu.add(menuPrijave);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOdjava)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTrenutno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVreme))
                    .addComponent(lblUlogovani))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblUlogovani)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrenutno)
                    .addComponent(lblVreme))
                .addGap(18, 18, 18)
                .addComponent(btnOdjava)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdjavaActionPerformed
        Object[] opcije = { "Da", "Ne" };
        int izbor = JOptionPane.showOptionDialog(null, "Da li želite da se odjavite?", "Odjava",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcije, opcije[0]);
        
        if (izbor == 0) {
            new FormaPrijava().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnOdjavaActionPerformed

    private void menuNoviStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNoviStudentActionPerformed
        new FormaNoviStudent(this, true).setVisible(true);
    }//GEN-LAST:event_menuNoviStudentActionPerformed

    private void menuPretragaStudentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPretragaStudentaActionPerformed
        new FormaPretragaStudenata(this, true).setVisible(true);
    }//GEN-LAST:event_menuPretragaStudentaActionPerformed

    private void menuPretragaPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPretragaPrijavaActionPerformed
        new FormaPretragaPrijava(this, true).setVisible(true);
    }//GEN-LAST:event_menuPretragaPrijavaActionPerformed

    private void menuPretragaIspitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPretragaIspitaActionPerformed
        new FormaPretragaIspita(this, true).setVisible(true);
    }//GEN-LAST:event_menuPretragaIspitaActionPerformed

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
            java.util.logging.Logger.getLogger(KlijentskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KlijentskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KlijentskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KlijentskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KlijentskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdjava;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel lblTrenutno;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JLabel lblVreme;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuNoviStudent;
    private javax.swing.JMenuItem menuPretragaIspita;
    private javax.swing.JMenuItem menuPretragaPrijava;
    private javax.swing.JMenuItem menuPretragaStudenta;
    private javax.swing.JMenu menuPrijave;
    private javax.swing.JMenu menuStudenti;
    // End of variables declaration//GEN-END:variables

    public JLabel getLblVreme() {
        return lblVreme;
    }

    private void prikaziVreme() {
        nit = new VremeNit(this);
        nit.start();    
    }

    
    
}
