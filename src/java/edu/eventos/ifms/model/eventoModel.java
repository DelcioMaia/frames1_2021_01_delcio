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
@Table(name = "evento")
public class eventoModel implements Serializable {
    @Id
    @GeneratedValue
    private long idEvento;
    
    @Column(nullable = false, length = 80)
    private String eventoNome;
    @Column(nullable = false, length = 80)
    private String dataInicioEvento;
    @Column(nullable = false, length = 80)
    private String dataFimEvento;
    
    public void eventoModel() {
        setDataInicioEvento("0");
        setDataFimEvento("0");
    }  

    /**
     * @return the idEvento
     */
    public long getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return the eventoNome
     */
    public String getEventoNome() {
        return eventoNome;
    }

    /**
     * @param eventoNome the eventoNome to set
     */
    public void setEventoNome(String eventoNome) {
        this.eventoNome = eventoNome;
    }

    /**
     * @return the dataInicioEvento
     */
    public String getDataInicioEvento() {
        return dataInicioEvento;
    }

    /**
     * @param dataInicioEvento the dataInicioEvento to set
     */
    public void setDataInicioEvento(String dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    /**
     * @return the dataFimEvento
     */
    public String getDataFimEvento() {
        return dataFimEvento;
    }

    /**
     * @param dataFimEvento the dataFimEvento to set
     */
    public void setDataFimEvento(String dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }    
}
