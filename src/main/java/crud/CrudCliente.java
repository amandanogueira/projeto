/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.crud;

import br.data.model.Cidade;
import br.data.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CrudCliente {
    
    public CrudCliente(){
    }
    
    public static ArrayList<Cliente> listCliente = new ArrayList();
    
    public void insertCliente(Cliente cliente){
        listCliente.add(cliente);
    }
    
    public ArrayList<Cliente> getAllCliente(){
        return listCliente;
    }
    
    public Cliente getCliente(int codigo){
        for(Cliente cliente: listCliente){
            if(cliente.getCodigo()==codigo){
                return cliente;
            }
        }
        
        return null;
    }
    
    public void deleteCliente(int codigo){
        Cliente cli = getCliente(codigo);
        if(cli!=null){
            listCliente.remove(cli);
        }
        
    }

    public void merge(Cliente cliente) {
        Cliente cli = getCliente(cliente.getCodigo());
        cli.setNome(cli.getNome());
        cli.setCidade(cli.getCidade());
    }
}
