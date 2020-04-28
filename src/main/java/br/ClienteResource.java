/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br;

import br.crud.CrudCliente;
import br.data.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author PC
 */
@Path("cliente")
@RequestScoped
public class ClienteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> getAll() {
        return new CrudCliente().getAllCliente();
    }
    
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getJson(@PathParam("codigo") int codigo) {
        return new CrudCliente().getCliente(codigo);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCliente(Cliente cliente) {
            new CrudCliente().insertCliente(cliente);
    }
    
    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteCliente(@PathParam("codigo") int codigo) {
        new CrudCliente().deleteCliente(codigo);
    }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void merge(String content) {
        ObjectMapper om = new ObjectMapper();
        try{
            Cliente cli =  om.readValue(content, Cliente.class);
            new CrudCliente().merge(cli);
        }catch(Exception e){
            System.out.println("erro: " + e.getMessage());
        }
    }
}
