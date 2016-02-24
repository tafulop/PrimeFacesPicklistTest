/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tamas.fulop.test.primefacestest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author fulop
 */
@ManagedBean
public class ProgramBlockSelectControl {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private DualListModel<ProgramBlockKey> programBlockKeys;
    private Map<Integer, ProgramBlock> programBlocks;

    @PostConstruct
    public void init() {
        
        // PBs
        List<ProgramBlockKey> source = new ArrayList<>();
        List<ProgramBlockKey> target = new ArrayList<>();
        
        // Stores the real program block object
        programBlocks = new ConcurrentHashMap<>();
        programBlockKeys = new DualListModel<>(source, target);
        
        // Test data
        addNewElement(new ProgramBlock("URQPRBMX.PAC", 1));
        addNewElement(new ProgramBlock("ZSSPRBMX.PAC", 2));
        addNewElement(new ProgramBlock("IC4_PRBX.PAC", 3));
        
        // Set dummy version in other step
        setVersion(1, "1.1-1");
        setVersion(2, "2.2-2");
        setVersion(3, "3.3-3");
        
    }
    
    public void setVersion(Integer programBlockID, String version){
        ProgramBlock pb = getProgramBlockByID(programBlockID);
        pb.setVersion(version);
    }

    public void addNewElement(ProgramBlock prb){
        programBlockKeys.getSource().add(new ProgramBlockKey(prb.getName(),prb.getId()));
        programBlocks.put(prb.getId(),prb);
    }
    
    public ProgramBlock getProgramBlockByID(Integer id){
        return programBlocks.get(id);
    }

    public void onSelect(SelectEvent event) {
            FacesContext context = FacesContext.getCurrentInstance();
            
            Integer id = Integer.parseInt(event.getObject().toString());
            ProgramBlock prb = getProgramBlockByID(id);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Item Selected", "PAC: \t" + prb.getName() + "<br/> Version: \t" + prb.getVersion()));

    }
    
    public void onTransfer(TransferEvent event){
        printElements();
    }
 
    
    private void printElements(){
        
        System.out.println("Source elements:");
        
        for(Object pb : programBlockKeys.getSource()){
            System.out.println(programBlocks.get(Integer.parseInt(pb.toString())).getName());
        }

        System.out.println("Target elements:");
        
        for(Object pb : programBlockKeys.getTarget()){
            System.out.println(programBlocks.get(Integer.parseInt(pb.toString())).getName());
        }
    
    }
    

    public DualListModel<ProgramBlockKey> getProgramBlockKeys() {
        return programBlockKeys;
    }

    public void setProgramBlockKeys(DualListModel<ProgramBlockKey> programBlockKeys) {
        this.programBlockKeys = programBlockKeys;
    }
    
    
    
}


