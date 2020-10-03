/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EstruturaBanco;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Fernando-PC
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public Menu() {
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

        mnuBar = new javax.swing.JMenuBar();
        mnuCursos = new javax.swing.JMenu();
        mnuCursosM = new javax.swing.JMenuItem();
        mnuAlunos = new javax.swing.JMenu();
        mnuAlunosM = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBackground(new java.awt.Color(204, 204, 204));
        setType(java.awt.Window.Type.UTILITY);

        mnuCursos.setText("Cursos");

        mnuCursosM.setText("Manutenção");
        mnuCursosM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuCursosMMousePressed(evt);
            }
        });
        mnuCursosM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCursosMActionPerformed(evt);
            }
        });
        mnuCursos.add(mnuCursosM);

        mnuBar.add(mnuCursos);

        mnuAlunos.setText("Alunos");

        mnuAlunosM.setText("Manutenção");
        mnuAlunosM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuAlunosMMousePressed(evt);
            }
        });
        mnuAlunos.add(mnuAlunosM);

        mnuBar.add(mnuAlunos);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCursosMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCursosMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuCursosMActionPerformed

    private void mnuCursosMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCursosMMousePressed
        ManutencaoCursos manCursos = new ManutencaoCursos();
        manCursos.setVisible(true);
    }//GEN-LAST:event_mnuCursosMMousePressed

    private void mnuAlunosMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAlunosMMousePressed
        ManutencaoAlunos manAlunos = new ManutencaoAlunos();
        manAlunos.setVisible(true);
    }//GEN-LAST:event_mnuAlunosMMousePressed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EstruturaBanco banco = new EstruturaBanco();
                banco.criaBanco();
                banco.criarTabelas();
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu mnuAlunos;
    private javax.swing.JMenuItem mnuAlunosM;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuCursos;
    private javax.swing.JMenuItem mnuCursosM;
    // End of variables declaration//GEN-END:variables
}