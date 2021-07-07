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
import javax.persistence.JoinColumn;
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
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idPessoa")

public class alunoModel extends pessoaInternaModel implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCampus", insertable = true, updatable = true)
    private campusModel campus;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCurso", insertable = true, updatable = true)
    private cursoModel curso;

    @Column(nullable = false)
    private Long RA;

    public alunoModel() {
        this.campus = new campusModel();
        this.curso = new cursoModel();
    }

    /**
     * @return the campus
     */
    public campusModel getCampus() {
        return campus;
    }

    /**
     * @param campus the campus to set
     */
    public void setCampus(campusModel campus) {
        this.campus = campus;
    }

    /**
     * @return the curso
     */
    public cursoModel getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(cursoModel curso) {
        this.curso = curso;
    }

    /**
     * @return the RA
     */
    public Long getRA() {
        return RA;
    }

    /**
     * @param RA the RA to set
     */
    public void setRA(Long RA) {
        this.RA = RA;
    }
    
    
}
