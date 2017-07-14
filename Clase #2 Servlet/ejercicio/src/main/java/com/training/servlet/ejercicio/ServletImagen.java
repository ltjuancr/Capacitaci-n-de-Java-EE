/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.servlet.ejercicio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author training
 */
@WebServlet(name = "ServletImagen", urlPatterns = {"/imagen"})
public class ServletImagen extends HttpServlet {
    
    public void doGet(HttpServletRequest rq,HttpServletResponse re ) throws IOException{
        re.setContentType("image/png");
        Object parametro = rq.getParameter("imagenId");
        String imageName = "";
        int indice = parametro == null?-1: Integer.parseInt(parametro.toString());
        
        switch (indice){
            case 1:
                imageName = "/imagenes/imagen.png";
                break;
            case 2:
                imageName = "/imagenes/imagen2.png";
                break;
           default: 
               re.setContentType("text/html");
               re.setStatus(404);
               return;
        }
        
                        InputStream is = this.getClass().getResourceAsStream(imageName);
                OutputStream os = re.getOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1){
                    os.write(buffer,0,len);
                }
                
    }
}
