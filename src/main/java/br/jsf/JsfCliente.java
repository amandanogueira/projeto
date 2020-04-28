/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.data.model.Cidade;
import br.data.model.Cliente;
import br.rs.CidadeRest;
import br.rs.ClienteRest;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author PC
 */
@Named(value = "jsfCliente")
@RequestScoped
public class JsfCliente{

    /**
     * Creates a new instance of JsfCliente
     */
    public JsfCliente() {
    }
    
    public ArrayList<Cidade> getAllCidades(){
        //CidadeRest cr = new CidadeRest();
        //cidades = cr.get(ArrayList.class);
        //cr.close();
        //return cidades;
        return null;
    }
    
    public void salvar(){
       // Cliente cli = new Cliente(codigo, nome, cidade);
       // ClienteRest cr = new ClienteRest();
      //  cr.addCliente(cliente);
       // cr.close();
    }
    
    public ArrayList<Cliente> getAllClientes(){
       // ClienteRest cr = new ClienteRest();
      //  ArrayList<Cliente> clientes = cr.getAll(ArrayList.class);
       // cr.close();
       // return clientes;
       return null;
    }
    
    private Cidade cidade = new Cidade();
    private Cliente cliente = new Cliente();
    private ArrayList<Cidade> cidades;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
