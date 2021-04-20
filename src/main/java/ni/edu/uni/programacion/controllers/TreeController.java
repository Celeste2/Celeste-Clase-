/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import ni.edu.uni.programacion.views.FrameTree;

/**
 *
 * @author JADPA07
 */
public class TreeController {
    private FrameTree frameTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;
    

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
        
        frameTree.getTreeAccount().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                treeXdMouseListener(e);
            }
        });
   }      
  
   public void initComponent(){
        root = new DefaultMutableTreeNode("Xd");
        treeModel = new DefaultTreeModel(root);
        
        frameTree.getTreeAccount().setModel(treeModel);
    }
   
     public void btnAddActionListener(ActionEvent e){
        TreePath treePath = frameTree.getTreeAccount().getSelectionPath();
        if(treePath == null){
            return;
        }
    
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode)
                treePath.getLastPathComponent();
         String accountName = JOptionPane.showInputDialog(null, 
                "Account Name: ", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);

        if(accountName.isEmpty()){
            return;
        }
            DefaultMutableTreeNode child =new DefaultMutableTreeNode(accountName);
                treeModel.insertNodeInto(child, parent, parent.getChildCount());          
     }     
                
    private void btnRemoveActionListener(ActionEvent e) {
         TreePath treePath = frameTree.getTreeAccount().getSelectionPath();
        if(treePath == null){
            return;
        }
       DefaultMutableTreeNode node = (DefaultMutableTreeNode)
          treePath.getLastPathComponent();
       if(node.isRoot()){
            return;
        }
        treeModel.removeNodeFromParent(node);
    }
    
    private void treeXdMouseListener(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
            TreePath treePath = frameTree.getTreeAccount()
                    .getPathForLocation(e.getX(), e.getY());
            if(treePath == null){
                treePath = frameTree.getTreeAccount().getSelectionPath();
            }
            
            if(treePath == null){
                return;
            }
            
            frameTree.getpmnTree().show(frameTree.getTreeAccount(), 
                    e.getX(), e.getY());
            
        }
        
    }
       
}