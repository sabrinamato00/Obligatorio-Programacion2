//Sabrina Mato(222071) y Pamela Quesada(171498)
package Interfaz;


import Dominio.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatorio2_syp.Obligatorio2_SyP;

public class PantallaBienvenida extends javax.swing.JFrame {
Sistema sistema = new Sistema();
    public PantallaBienvenida() {
        initComponents();
        Timer timer = new Timer(3000, new ActionListener() { // 3000 ms = 3 segundos
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer) e.getSource()).stop();
                try {
                    mostrarConfirmDialog();
                } catch (IOException ex) {
                    Logger.getLogger(PantallaBienvenida.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaBienvenida.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        timer.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblBienvenido = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/oblsp.png"))); // NOI18N
        jPanel2.add(lblLogo);
        lblLogo.setBounds(131, 92, 225, 225);

        lblBienvenido.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBienvenido.setForeground(new java.awt.Color(0, 51, 153));
        lblBienvenido.setText("¡¡Bienvenido!!");
        lblBienvenido.setMinimumSize(new java.awt.Dimension(76, 20));
        jPanel2.add(lblBienvenido);
        lblBienvenido.setBounds(179, 24, 156, 50);

        lblNombres.setText("         Sabrina Mato (222071)                                      Pamela Quesada (171498)");
        jPanel2.add(lblNombres);
        lblNombres.setBounds(23, 343, 440, 16);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 490, 390);

        setSize(new java.awt.Dimension(523, 415));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PantallaBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaBienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaBienvenida().setVisible(true);
            }
        });
    }
    
    
    private void mostrarConfirmDialog() throws IOException, ClassNotFoundException {
        Object[] options = {"Sistema Vacío", "Sistema Anterior", "Sólo Rubros"};

        int respuesta = JOptionPane.showOptionDialog(this,
                "Selecciona una opción:",
                "Comenzar con: ",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);


        switch (respuesta) {
            case 0:

                System.out.println("Sistema Vacío seleccionado");
                mostrarMenuPrincipal(sistema);
                break;
            case 1:
        
                System.out.println("Sistema Anterior seleccionado");
                sistema = Obligatorio2_SyP.traerDatosSistema();
                System.out.println(sistema.getListaRubros());
                mostrarMenuPrincipal(sistema);
                break;
            case 2:
      
                System.out.println("Sólo Rubros seleccionado");
                sistema=Obligatorio2_SyP.traerRubrosPrecargados();
                mostrarMenuPrincipal(sistema);
                break;
            default:
                System.exit(0);
                break;
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombres;
    // End of variables declaration//GEN-END:variables


    
    private void mostrarMenuPrincipal(Sistema sistema){
        setVisible(false);
        
        MenuPpal menPpal = new MenuPpal(sistema);
        menPpal.setVisible(true);
    }
    
}