package com.mycompany.mtpa.cliente.cliente.vista;

import com.mycompany.mtpa.cliente.cliente.ComunicacionUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;


public class Partida extends javax.swing.JFrame {

    private String nombre;
    private String sala;
    private int tanda;

    private ComunicacionUsuario comunicador;
    private final int NUM_TANDAS = 3;
    
    public Partida(String nombre,String sala,int tanda,  ComunicacionUsuario comunicador) {
        initComponents();
        this.nombre = nombre;
        this.sala = sala;
        this.tanda = tanda;

        this.comunicador= comunicador;
        this.lblTanda.setText(""+(tanda+1));
        new Temporizador(this.barraProgreso, this).start();
        //nuevaPartida:usuario:sala:partida:tanda
        comunicador.mandarMensaje("nuevaPartida:"+comunicador.getNombre()+":"+sala+":"+nombre+":"+tanda);
        String respuesta = comunicador.recibirMensaje();
        String [] comando = respuesta.split(":");
        this.lblLetras.setText(comando[0]);
       /**/ System.out.println(respuesta);
        for(int i =1; i< comando.length; i++){
            lstJugadores.add(new JLabel(comando[i]));
        }
    }

    //partida que creamos, nombre
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTanda = new javax.swing.JLabel();
        txtRespuesta = new javax.swing.JTextField();
        btnResolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstJugadores = new javax.swing.JList<>();
        barraProgreso = new javax.swing.JProgressBar();
        lblLetras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tanda:");

        lblTanda.setText("jLabel2");

        txtRespuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuestaActionPerformed(evt);
            }
        });

        btnResolver.setText("Ad Astra!");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstJugadores);

        lblLetras.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLetras.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTanda)
                                .addGap(0, 292, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnResolver))
                                    .addComponent(lblLetras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(barraProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTanda))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lblLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnResolver))))
                .addGap(18, 18, 18)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespuestaActionPerformed

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
       String respuesta = txtRespuesta.getText();
       if(respuesta.isEmpty()){
           //error
       }else{
           //resolver:usuario:sala:partida:palabra:tanda
           comunicador.mandarMensaje("resolver:"+comunicador.getNombre()+":"+sala+":"+nombre+":"+respuesta+":"+tanda);
           String mensaje  = comunicador.recibirMensaje();
           if(mensaje.equals("true")){
               if(tanda < NUM_TANDAS){
                  
                   this.btnResolver.setVisible(false);
                   this.txtRespuesta.setVisible(false);
                   this.lblLetras.setText(respuesta);
                  
               }
               this.dispose();
           }
       }
    }//GEN-LAST:event_btnResolverActionPerformed

public void siguientePartida(){
                       this.btnResolver.setVisible(false);
                   this.txtRespuesta.setVisible(false);

    if(tanda+1 < NUM_TANDAS){
        new Partida(nombre, sala, tanda+1, comunicador).setVisible(true);
    } 
    else{
        comunicador.mandarMensaje("terminarPartida:"+comunicador.getNombre()+":"+sala+":"+nombre);
        String puntos = comunicador.recibirMensaje();
        JOptionPane.showMessageDialog(null, "Has obtenido "+puntos+" puntos");
    }
    this.dispose();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton btnResolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLetras;
    private javax.swing.JLabel lblTanda;
    private javax.swing.JList<String> lstJugadores;
    private javax.swing.JTextField txtRespuesta;
    // End of variables declaration//GEN-END:variables
}


class Temporizador extends Thread{
    
    private JProgressBar barra;
    private final int TIEMPO_MAX = 5;
    private Partida p;
    
    public Temporizador(JProgressBar barra, Partida p){
        this.barra = barra;
        this.barra.setMaximum(TIEMPO_MAX);
        this.p = p;
    }

    @Override
    public void run() {
        for(int i =0; i< TIEMPO_MAX; i++){
            try {
                this.sleep(1000);
                barra.setValue(i+1);
               
            }
           
            //no conseguido, tramitar pasar a la siguiente
            catch (InterruptedException ex) {
                Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        p.siguientePartida();
    }
    
    
}