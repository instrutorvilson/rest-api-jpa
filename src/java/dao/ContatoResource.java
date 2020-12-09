/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import entidades.Contato;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("Contatos")
public class ContatoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AgendaResource
     */
    public ContatoResource() {
    }
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getContatos() {        
        Gson gson = new Gson();
        return gson.toJson(DaoContato.getAll());       
    }
    
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public boolean inserirContato(String content) {
        Gson gson = new Gson();
        Contato ct = (Contato) gson.fromJson(content, Contato.class);
        return DaoContato.persist(ct);
    }

    @Path("{contatoId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getContato(@PathParam("contatoId") String id) {        
        Gson gson = new Gson();
        Contato ct = new Contato();
        ct = DaoContato.getOne(Long.parseLong(id));
        return gson.toJson(ct);     
    }
    
    @Path("excluir/{contatoId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean excluir(@PathParam("contatoId") String id) {
      return DaoContato.excluir(Long.parseLong(id));
    }    
     
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean alterarContato(String content) {
        Gson gson = new Gson();
        Contato ct = (Contato) gson.fromJson(content, Contato.class);
        return DaoContato.editar(ct);
    }
}
