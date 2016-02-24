/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tamas.fulop.test.primefacestest;

/**
 *
 * @author fulop
 */
public class ProgramBlock{
    
    private String name;
    private String version;
    private Integer id;

    public ProgramBlock(String name, Integer key){
        this.name = name;
        this.id = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
}
