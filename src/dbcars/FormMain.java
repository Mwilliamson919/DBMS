/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbcars;

import java.awt.Component;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import utils.GlobalData;

/**
 *
 * @author mwill
 */
public class FormMain extends javax.swing.JFrame {

/**
     * Creates new form FormMain
     */
    private static FormMain frmMain;

    public static FormMain getFrmMain() {
        return frmMain;
    }

    public static void setFrmMain(FormMain frmMain) {
        FormMain.frmMain = frmMain;
    }

    public JMenu getUsersMenu() {
        return usersMenu;
    }

    public void setUsersMenu(JMenu usersMenu) {
        this.usersMenu = usersMenu;
    }
    FormLogin formLogin = new FormLogin();
    FormListVehicle formListVehicle = new FormListVehicle();
    FormView formView;
    FormCreateAccount formCreateAccount = new FormCreateAccount();
    FormViewUsers formViewUsers = new FormViewUsers();
    
    Map<String, JInternalFrame> forms = new HashMap<>();
    
    public FormMain() {
        initComponents();
        usersMenu.setVisible(false);
        forms.put("formLogin", formLogin);
        forms.put("formListVehicle", formListVehicle);
        forms.put("formCreateAccount", formCreateAccount);
        forms.put("formViewUsers", formViewUsers);
        
        forms.values().forEach((frm)->{
            jdpContainer.add(frm);
        });
        
        
         
    }
    
    public void refreshMain(){
        if (GlobalData.usr.getUserRole().equals("Admin")){
            usersMenu.setVisible(true);
        }
    }
    private void showFormNoLogin(String formName){
        showForm(formName, false);
    }
    
    private void showForm(String formName){
        showForm(formName, true);
    }
    private void showForm(String formName, boolean checkLoggedIn){
        if (checkLoggedIn && GlobalData.usr == null){
            showForm("formLogin", false);
        }else{
            try {
                //Authorize
                if(forms.get(formName).isClosed()){
             
                        try {
                            forms.put(formName, forms.get(formName).getClass().newInstance());
                            jdpContainer.add(forms.get(formName));
                        } catch (InstantiationException ex) {
                            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    
                }
                forms.get(formName).setVisible(true);
                forms.get(formName).setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpContainer = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuLogin = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        minCreateAccount = new javax.swing.JMenuItem();
        menuManage = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        updateSeller = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenuItem();
        usersMenu = new javax.swing.JMenu();
        minViewUsers = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdpContainerLayout = new javax.swing.GroupLayout(jdpContainer);
        jdpContainer.setLayout(jdpContainerLayout);
        jdpContainerLayout.setHorizontalGroup(
            jdpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jdpContainerLayout.setVerticalGroup(
            jdpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        getContentPane().add(jdpContainer, java.awt.BorderLayout.CENTER);

        menuFile.setText("File");

        menuLogin.setText("Login...");
        menuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoginActionPerformed(evt);
            }
        });
        menuFile.add(menuLogin);

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuFile.add(menuLogout);

        menuExit.setText("Exit");
        menuFile.add(menuExit);

        minCreateAccount.setText("Create Account");
        minCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minCreateAccountActionPerformed(evt);
            }
        });
        menuFile.add(minCreateAccount);

        jMenuBar1.add(menuFile);

        menuManage.setText("Manage");

        jMenu1.setText("Vehicles");

        updateSeller.setText("List Vehicle");
        updateSeller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSellerActionPerformed(evt);
            }
        });
        jMenu1.add(updateSeller);

        menuView.setText("View");
        menuView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuViewActionPerformed(evt);
            }
        });
        jMenu1.add(menuView);

        menuManage.add(jMenu1);

        usersMenu.setText("Users");

        minViewUsers.setText("View");
        minViewUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minViewUsersActionPerformed(evt);
            }
        });
        usersMenu.add(minViewUsers);

        menuManage.add(usersMenu);

        jMenuBar1.add(menuManage);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoginActionPerformed
        if (GlobalData.usr == null){
            showFormNoLogin("formLogin");
        }else {
            JOptionPane.showMessageDialog(this, "Already logged in.");
        }
        
    }//GEN-LAST:event_menuLoginActionPerformed

    private void updateSellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSellerActionPerformed
        if (GlobalData.usr != null){
            if (GlobalData.usr.getUserRole().equals("Seller") || GlobalData.usr.getUserRole().equals("Admin")){
            showForm("formListVehicle");
            }else {
            JOptionPane.showMessageDialog(this, "Insufficient permissions");
            }
        } else {
            showForm("formLogin", false);
        }
    }//GEN-LAST:event_updateSellerActionPerformed

    private void menuViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuViewActionPerformed
        formView = new FormView();
        forms.put("formView", formView);
        jdpContainer.add(formView);
        showForm("formView");     
    }//GEN-LAST:event_menuViewActionPerformed

    private void minCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minCreateAccountActionPerformed
        if (GlobalData.usr == null){
            showFormNoLogin("formCreateAccount");
        }else {
            JOptionPane.showMessageDialog(this, "Already logged in.");
        }
        
    }//GEN-LAST:event_minCreateAccountActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        GlobalData.usr = null;
        JOptionPane.showMessageDialog(this, "You have been logged out.");
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void minViewUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minViewUsersActionPerformed
        showForm("formViewUsers");
    }//GEN-LAST:event_minViewUsersActionPerformed

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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmMain = new FormMain();
                frmMain.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                frmMain.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane jdpContainer;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuLogin;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenu menuManage;
    private javax.swing.JMenuItem menuView;
    private javax.swing.JMenuItem minCreateAccount;
    private javax.swing.JMenuItem minViewUsers;
    private javax.swing.JMenuItem updateSeller;
    private javax.swing.JMenu usersMenu;
    // End of variables declaration//GEN-END:variables
}
