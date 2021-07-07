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
@Table(name = "curso")
public class cursoModel implements Serializable{
    @Id
    @GeneratedValue
    private long idCurso;
    
    @Column(nullable = false, length = 80)
    private String cursoNome;

    /**
     * @return the idCurso
     */
    public long getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @return the cursoNome
     */
    public String getCursoNome() {
        return cursoNome;
    }

    /**
     * @param cursoNome the cursoNome to set
     */
    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }   
}
