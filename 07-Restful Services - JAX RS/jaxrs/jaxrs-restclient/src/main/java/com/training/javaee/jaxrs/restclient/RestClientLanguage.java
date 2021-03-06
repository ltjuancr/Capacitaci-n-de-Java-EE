/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.javaee.jaxrs.restclient;

import com.training.javaee.jaxrs.model.ModeloFilm;
import com.training.javaee.jaxrs.model.ModeloLanguage;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author training
 */
@ApplicationScoped
public class RestClientLanguage {
    
    private Client client = ClientBuilder.newClient();
    
    public List<ModeloLanguage> consultar(){
        List<ModeloLanguage> idiomas =
            client.target("http://localhost:8080/jaxrs-rest/rest/language")
            .request(MediaType.APPLICATION_XML)
            .get(new GenericType<List<ModeloLanguage>>() {
        });
        return idiomas;
    }
}
