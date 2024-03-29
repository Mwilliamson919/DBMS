/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package dbcars;

import businessObjects.User;
import businessObjects.Vehicle;
import dao.MakerHandler;
import dao.VehicleHandler;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.GlobalData;

/**
 *
 * @author mwill
 */
public class FormView extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormView
     */
    private VehicleHandler vehicleHandler = new VehicleHandler();
    
    
    private void populateVehicles(){
        String keyword = "";
        if (txtSearch.getText().equals("")){
            keyword = "Honda";
        }else {
            keyword = txtSearch.getText();
        }
        List<Vehicle> vehicles = vehicleHandler.loadVehicles(keyword);
        String columns[] = new String[]{"autoID", "makerName", "model", "trim", "year", "color", "mpg", "msrp", "capacity", "drivetrain", "type", "Final Price"};
        DefaultTableModel tblModel = new DefaultTableModel(columns, 0);
        vehicles.forEach((vehicle)->{
            tblModel.addRow(vehicle.getRow());
        });
        tblVehicles.setModel(tblModel);
            
        
    }
    public FormView() {
        initComponents();
        populateVehicles();
        if (GlobalData.usr.getUserRole().equals("Buyer")){
            btnDelete.setVisible(false);
            btnUpdate.setVisible(false);
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

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehicles = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("View");

        jLabel1.setText("Search:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblVehicles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVehicles);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 500, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        populateVehicles();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblVehicles.getSelectedRow();
        if (selectedRow != -1 && (GlobalData.usr.getUserRole().equals("Seller") || GlobalData.usr.getUserRole().equals("Admin"))){
            int autoID = (int) tblVehicles.getValueAt(selectedRow, 0);
            int ret = JOptionPane.showConfirmDialog(this, String.format("Delete Vehicle %d.  Are you sure?", autoID));
            if (ret == JOptionPane.OK_OPTION){
                vehicleHandler.deleteVehicle(autoID);
            }
            
        }else {
            JOptionPane.showMessageDialog(this, "Either no row selected or insufficient permission");
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int selectedRow = tblVehicles.getSelectedRow();
        if (selectedRow != -1 && (GlobalData.usr.getUserRole().equals("Seller")) || GlobalData.usr.getUserRole().equals("Admin")){
            int autoID = (int) tblVehicles.getValueAt(selectedRow,0);
            int ret = JOptionPane.showConfirmDialog(this, String.format("Update vehicle %d?", autoID));
            if (ret == JOptionPane.OK_OPTION){
                int makerId = new MakerHandler().getMakerIdFromName((String)tblVehicles.getValueAt(selectedRow,1));
                String model = (String)tblVehicles.getValueAt(selectedRow,2);
                String trim = (String)tblVehicles.getValueAt(selectedRow,3);
                int year = (int) tblVehicles.getValueAt(selectedRow, 4);
                String color = (String)tblVehicles.getValueAt(selectedRow,5);
                int mpg = (int) tblVehicles.getValueAt(selectedRow, 6);
                double msrp = (double) tblVehicles.getValueAt(selectedRow, 7);
                int capacity = (int) tblVehicles.getValueAt(selectedRow, 8);
                String drivetrain = (String)tblVehicles.getValueAt(selectedRow,9);
                String type = (String)tblVehicles.getValueAt(selectedRow,10);
                double fPrice = (double) tblVehicles.getValueAt(selectedRow, 11);
                String sYear = Integer.toString(year);
                String sMpg = Integer.toString(mpg);
                String sMsrp = Double.toString(msrp);
                String sCapacity = Integer.toString(capacity);
                String sFPrice = Double.toString(fPrice);
                FormUpdate formUpdate = new FormUpdate();
                formUpdate.populateFields(autoID, makerId, model, trim, sYear, color, sMpg, sMsrp, sCapacity, drivetrain, type, sFPrice);
                formUpdate.setVisible(true);
            }
        }else {
            JOptionPane.showMessageDialog(this, "Either no row selected or insufficient permission");
        }
        System.out.println("update pressed");
        
    }//GEN-LAST:event_btnUpdateActionPerformed
    public JButton getUpdateButton(){
        return btnUpdate;
    }
    
    public JButton getDeleteButton(){
        return btnDelete;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVehicles;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
