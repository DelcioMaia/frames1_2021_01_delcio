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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author delci
 */

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class pessoaModel implements Serializable{
    @Id
    @GeneratedValue
    private Long idPessoa;
    
    @Column(nullable = false, length = 80, name = "nome")
    private String pessoaNome;
    
    @Column(nullable = false)
    private Long CPF;
    
    @Column(nullable = false)
    private Long telefone;

    /**
     * @return the idPessoa
     */
    public Long getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return the pessoaNome
     */
    public String getPessoaNome() {
        return pessoaNome;
    }

    /**
     * @param pessoaNome the pessoaNome to set
     */
    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    /**
     * @return the CPF
     */
    public Long getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the telefone
     */
    public Long getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
    
}
