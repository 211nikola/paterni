/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductA;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTextField;
import datechooser.*;
import java.util.GregorianCalendar;

/**
 *
 * @author Nikola
 */
public class Panel1_1 extends  Panel_a {

    /**
     * Creates new form Panel1_1
     */
    public Panel1_1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSifraPrijave = new javax.swing.JLabel();
        txtSifraPrijave = new javax.swing.JTextField();
        btnNadji = new javax.swing.JButton();
        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblSifraPrijave2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        lblPozicija = new javax.swing.JLabel();
        cmbPozicija = new javax.swing.JComboBox<>();
        lblDatum = new javax.swing.JLabel();
        btnKreiraj = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        lblPoruka = new javax.swing.JLabel();
        txtPoruka = new javax.swing.JTextField();
        comboDatum = new datechooser.beans.DateChooserCombo();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Prijava"));

        lblSifraPrijave.setText("Sifra prijave:");

        btnNadji.setText("Nadji");
        btnNadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNadjiActionPerformed(evt);
            }
        });

        lblIme.setText("Ime:");

        lblSifraPrijave2.setText("Prezime:");

        lblPozicija.setText("Pozicija:");

        cmbPozicija.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BackEnd", "FrontEnd", "FullStack", "Designer", " " }));

        lblDatum.setText("Datum:");

        btnKreiraj.setText("Kreiraj");

        btnPromeni.setText("Promeni");

        btnObrisi.setText("Obrisi");

        lblPoruka.setText("Poruka:");

        txtPoruka.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDatum)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPozicija)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnKreiraj)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPromeni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSifraPrijave)
                                    .addComponent(lblIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSifraPrijave2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSifraPrijave, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnNadji))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPoruka)
                        .addGap(311, 311, 311))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSifraPrijave)
                    .addComponent(txtSifraPrijave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNadji))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIme)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSifraPrijave2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPozicija)
                    .addComponent(cmbPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatum)
                    .addComponent(comboDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPromeni)
                    .addComponent(btnObrisi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPoruka)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNadjiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNadjiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnNadji;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<String> cmbPozicija;
    private datechooser.beans.DateChooserCombo comboDatum;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JLabel lblPozicija;
    private javax.swing.JLabel lblSifraPrijave;
    private javax.swing.JLabel lblSifraPrijave2;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPoruka;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtSifraPrijave;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getSifraPrijave() {
       return  txtSifraPrijave.getText();
    }

    @Override
    public JTextField getSifraPrijave1() {
        return txtSifraPrijave;
    }

    @Override
    public String getIme() {
        return txtIme.getText();
    }

    @Override
    public String getPrezime() {
        return txtPrezime.getText();
    }

    @Override
    public String getPozicija() {
        return cmbPozicija.getSelectedItem().toString();
    }

    @Override
    public Date getDatum() {
        return comboDatum.getSelectedDate().getTime();
    }

    @Override
    public void setSifrraPrijave(String sifraPrijave) {
        txtSifraPrijave.setText(sifraPrijave);
   }

    @Override
    public void setIme(String ime) {
        txtIme.setText(ime);
    }

    @Override
    public void setPrezime(String prezime) {
        txtPrezime.setText(prezime);
    }

    @Override
    public void setPozicija(String pozicija) {
        cmbPozicija.setSelectedItem(pozicija);
    }

    @Override
    public void setDatum(Date datum) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(datum);
        comboDatum.setSelectedDate(gc);
    }

    @Override
    public void setPoruka(String poruka) {
        txtPoruka.setText(poruka);
    }

    @Override
    public JButton getKreiraj() {
        return btnKreiraj;
    }

    @Override
    public JButton getPromeni() {
        return btnPromeni;
    }

    @Override
    public JButton getObrisi() {
        return btnObrisi;
    }

    @Override
    public JButton getNadji() {
        return btnNadji;
    }
}