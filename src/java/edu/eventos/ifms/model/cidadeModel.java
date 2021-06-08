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
@Table(name = "cidades")
public class cidadeModel implements Serializable {
    @Id
    private long idCidade;
    
    @Column(nullable = false, length = 80)
    private String cidadeNome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idEstado", insertable = true, updatable = true)
    private estadoModel estado;

    /**
     * @return the idCidade
     */
    public long getIdCidade() {
        return idCidade;
    }

    /**
     * @param idCidade the idCidade to set
     */
    public void setIdCidade(long idCidade) {
        this.idCidade = idCidade;
    }

    /**
     * @return the cidadeNome
     */
    public String getCidadeNome() {
        return cidadeNome;
    }

    /**
     * @param cidadeNome the cidadeNome to set
     */
    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
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
