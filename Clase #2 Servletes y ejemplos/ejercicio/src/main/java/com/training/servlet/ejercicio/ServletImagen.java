/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.servlet.ejercicio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managedbeans.ControlImagen;
import managedbeans.ServicioStreams;

/**
 *
 * @author training
 */
@WebServlet(name = "ServletImagen", urlPatterns = {"/imagen"})
public class ServletImagen extends HttpServlet {
    @Inject
    private ControlImagen ci;
     @Inject
    private ServicioStreams ss;
     
    public void doGet(HttpServletRequest rq,HttpServletResponse re ) throws IOException{
        Object parametro = rq.getParameter("imagenId");
        
        int indice = parametro == null?-1: Integer.parseInt(parametro.toString());
               
        InputStream is = ci.obtenerImagen(indice);       
        if(is==null){
               re.setContentType("text/html");
        try (PrintWriter out = re.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1>Ejercicio de Prueba</h1>");
            out.println(" <h1><FONT COLOR='red'>Se han cargado "+ss.getContador()+"</FONT></h1>");                
            out.println("</body>");
            out.println("</html>");
        }
        }else{
            ss.copiarInputStreamOutStream(is, re.getOutputStream());
              re.setContentType("image/png");              
        }
    }
}
