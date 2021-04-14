/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import javax.swing.tree.DefaultTreeModel;
import ni.edu.uni.programacion.backend.pojo.VehicleSubModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.views.FrameTree;

/**
 *
 * @author JADPA07
 */
public class TreeController {
    private TreeController treeController;
    private DefaultTreeModel treeModel;
    private List <VehicleSubModel> vehicleSubModel;
    private DefaultMutableTreeNode root;
    private FrameTree frameTree;
   
   public TreeController(FrameTree frameTree) 
   {
   this.frameTree = frameTree;
    initComponent();
        
        frameTree.getBtnAdd().addActionListener((e) -> {
            btnAddActionListener(e);
        });
        
        frameTree.getBtnRemove().addActionListener((e) -> {
            btnRemoveActionListener(e);
        });
        
        frameTree.getTreexd().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                treeXdMouseListener(e);
            }

       private void treeXdMouseListener(MouseEvent e) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }
        });
   }      
   

    private void btnAddActionListener(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void btnRemoveActionListener(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void initComponent(){
        root = new DefaultMutableTreeNode("Xd");
        treeModel = new DefaultTreeModel(root);
        
        frameTree.getTreexd().setModel(treeModel);
    }
   
     public void btnAddActionListener(ActionEvent e){
        TreePath treePath = frameTree.getTreexd().getSelectionPath();
        if(treePath == null){
            return;
        }
   
   
   
}