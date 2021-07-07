/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    
    @Temporal(TemporalType.DATE)
        private Date dataInicioEvento;

   @Temporal(TemporalType.DATE)
        private Date dataFimEvento;

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
    public Date getDataInicioEvento() {
        return dataInicioEvento;
    }

    /**
     * @param dataInicioEvento the dataInicioEvento to set
     */
    public void setDataInicioEvento(Date dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    /**
     * @return the dataFimEvento
     */
    public Date getDataFimEvento() {
        return dataFimEvento;
    }

    /**
     * @param dataFimEvento the dataFimEvento to set
     */
    public void setDataFimEvento(Date dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }

}
