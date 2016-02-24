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
public class ProgramBlockKey {
    
    private String name;
    private Integer id;

    public ProgramBlockKey(String name, Integer key){
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

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return this.id.toString();
    }
    
}
