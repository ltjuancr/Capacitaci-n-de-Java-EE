/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.InputStream;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author training
 */
@RequestScoped
public class ControlImagen {
    
    public InputStream obtenerImagen(int i){
         String imageName = "";               
                switch (i){
            case 1:
                imageName = "/imagenes/imagen.png";
                break;
            case 2:
                imageName = "/imagenes/imagen2.png";
                break;
           default: 
//               re.setContentType("text/html");
//               re.setStatus(404);
               return  null;
        }
                
          InputStream is = this.getClass().getResourceAsStream(imageName); 
          return is;
    }
    
}
