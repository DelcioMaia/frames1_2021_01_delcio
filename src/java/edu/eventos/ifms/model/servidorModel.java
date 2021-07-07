/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author delci
 */
    @Entity
    @Table(name = "servidor")
    @PrimaryKeyJoinColumn(name="idPessoa")
    
    public class servidorModel extends pessoaInternaModel implements Serializable{
        
        @ManyToOne(fetch = FetchType.EAGER)
        @Fetch(FetchMode.JOIN)
        @JoinColumn(name = "idArea", insertable = true, updatable = true)
        private areaModel area;
        
        @Column(nullable = false)
        private Long SIAPE;
        
        @Column(nullable = false, length = 30)
        private String cargo;
        
        @ManyToMany(mappedBy = "servidores")
        private List<campusModel> campusAoQualPertence;
        
        public servidorModel(){
            this.area = new areaModel();
        }

    /**
     * @return the area
     */
    public areaModel getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(areaModel area) {
        this.area = area;
    }

    /**
     * @return the SIAPE
     */
    public Long getSIAPE() {
        return SIAPE;
    }

    /**
     * @param SIAPE the SIAPE to set
     */
    public void setSIAPE(Long SIAPE) {
        this.SIAPE = SIAPE;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the campusAoQualPertence
     */
    public List<campusModel> getCampusAoQualPertence() {
        return campusAoQualPertence;
    }

    /**
     * @param campusAoQualPertence the campusAoQualPertence to set
     */
    public void setCampusAoQualPertence(List<campusModel> campusAoQualPertence) {
        this.campusAoQualPertence = campusAoQualPertence;
    }
                
}
