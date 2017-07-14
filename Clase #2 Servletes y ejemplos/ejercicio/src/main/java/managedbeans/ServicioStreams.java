/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author training
 */
@ApplicationScoped 
public class ServicioStreams {
    
    private int contador;
    public void copiarInputStreamOutStream(InputStream is, OutputStream os) throws IOException{

                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1){
                    os.write(buffer,0,len);
                }
                contador++;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
