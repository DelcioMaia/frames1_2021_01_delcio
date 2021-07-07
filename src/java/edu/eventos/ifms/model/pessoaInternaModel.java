/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author delci
 */
    @Entity
    @Table(name = "pessoaInterna")
    public abstract class pessoaInternaModel extends pessoaModel implements Serializable{
        
        @Temporal(TemporalType.DATE)
        private Date dataIngresso;

        /**
         * @return the dataIngresso
         */
        public Date getDataIngresso() {
            return dataIngresso;
        }

        /**
         * @param dataIngresso the dataIngresso to set
         */
        public void setDataIngresso(Date dataIngresso) {
            this.dataIngresso = dataIngresso;
        }
              
    }

