/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dbdata.Retriever;
import entity.NessusStructure;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;

public class TreeViewHelper {
    private int reportHostCount = 0;
    
    public void setReportHostCount (int reportHostCount) {
        this.reportHostCount = reportHostCount;
    }
    
    public List<String> getChildren(String parentName) {
        Retriever retriever = new Retriever();
        List<NessusStructure> childrenList = retriever.getNessusStructureChildren(parentName);
        List<String> childrenNameList = new ArrayList();
        
        for(NessusStructure nessusStructure:childrenList) {
            childrenNameList.add(nessusStructure.getName());
        }

        return childrenNameList;
    }
    
    public TreeItem<String> addTreeViewItem(TreeItem<String> treeItem, String parentName) {
        TreeItem<String> parentTreeItem = treeItem;
        
        List<String> childrenNameList = getChildren(parentName);
        for (String itemName: childrenNameList) {
            if (itemName.equals(ConstantValues.treeReportHost)) {
                int number = 1;
                for (int i = 0; i < reportHostCount; i++) {
                    treeItem = new TreeItem<String>(number + ": " + itemName);    
                    
                    if (i < reportHostCount) {
                        TreeItem<String> treeItemHostProperties = new TreeItem<String>(number + ": " + ConstantValues.treeHostProperties);                        
                        treeItem.getChildren().add(treeItemHostProperties);

                        TreeItem<String> treeItemReportItem = new TreeItem<String>(number + ": " + ConstantValues.treeReportItem);                        
                        treeItem.getChildren().add(treeItemReportItem);

                        TreeItem<String> treeItemItem = new TreeItem<String>(number + ": " + ConstantValues.treeItem);                        
                        treeItem.getChildren().add(treeItemItem);
                        
                        parentTreeItem.getChildren().add(treeItem);
                        number++;
                    }
                }
            }
            else {
                treeItem = new TreeItem<String>(itemName);    
                parentTreeItem.getChildren().add(treeItem);
                addTreeViewItem(treeItem, itemName);
            }          
        }  
        return parentTreeItem;
    }
}
