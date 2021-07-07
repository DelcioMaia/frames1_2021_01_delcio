/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author delci
 */

@Entity
@Table(name = "estados")
public class estadoModel implements Serializable {
    @Id
    private long idEstado;
    
    @Column(nullable = false, length = 50)
    private String estadoNome;
    
    @Column(nullable = false, length = 2)
    private String estadoSigla;
   
    /**
     * @return the idEstado
     */
    public long getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the estadoNome
     */
    public String getEstadoNome() {
        return estadoNome;
    }

    /**
     * @param estadoNome the estadoNome to set
     */
    public void setEstadoNome(String estadoNome) {
        this.estadoNome = estadoNome;
    }

    /**
     * @return the estadoSigla
     */
    public String getEstadoSigla() {
        return estadoSigla;
    }

    /**
     * @param estadoSigla the estadoSigla to set
     */
    public void setEstadoSigla(String estadoSigla) {
        this.estadoSigla = estadoSigla;
    }
     
}
