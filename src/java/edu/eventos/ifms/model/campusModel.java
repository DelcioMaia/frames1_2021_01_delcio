/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author delci
 */

@Entity
@Table(name = "campus")
public class campusModel implements Serializable {
    @Id
    @GeneratedValue
    private long idCampus;
    
    @Column(nullable = false, length = 80)
    private String campusNome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCidade", insertable = true, updatable = true)
    private cidadeModel cidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idEstado", insertable = true, updatable = true)
    private estadoModel estado;
    
    public void campusModel() {
        this.setCidade(new cidadeModel());
        this.setEstado(new estadoModel());
    }

    /**
     * @return the idCampus
     */
    public long getIdCampus() {
        return idCampus;
    }

    /**
     * @param idCampus the idCampus to set
     */
    public void setIdCampus(long idCampus) {
        this.idCampus = idCampus;
    }

    /**
     * @return the campusNome
     */
    public String getCampusNome() {
        return campusNome;
    }

    /**
     * @param campusNome the campusNome to set
     */
    public void setCampusNome(String campusNome) {
        this.campusNome = campusNome;
    }

    /**
     * @return the cidade
     */
    public cidadeModel getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(cidadeModel cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public estadoModel getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(estadoModel estado) {
        this.estado = estado;
    }
            
    
}
