/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.model;

import br.alerario.ICidade;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@XmlRootElement(name = "cidade")
public class Cidade implements ICidade{
    
    private int codigo;
    private String nome;
    
    public Cidade() {
        super();
    }
    
    public Cidade(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int i) {
        this.codigo = i;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String string) {
        this.nome = string;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.codigo;
        hash = 71 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
    
}
