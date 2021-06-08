/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author delci
 */

@Entity
@Table(name = "area")
public class areaModel implements Serializable{
    @Id
    @GeneratedValue
    private long idArea;
    
    @Column(nullable = false, length = 80)
    private String areaNome;

    /**
     * @return the idArea
     */
    public long getIdArea() {
        return idArea;
    }

    /**
     * @param idArea the idArea to set
     */
    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    /**
     * @return the areaNome
     */
    public String getAreaNome() {
        return areaNome;
    }

    /**
     * @param areaNome the areaNome to set
     */
    public void setAreaNome(String areaNome) {
        this.areaNome = areaNome;
    }

}
