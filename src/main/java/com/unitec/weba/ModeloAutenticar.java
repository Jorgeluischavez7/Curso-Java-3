
package com.unitec.weba;

public class ModeloAutenticar {
    public boolean autenticar(Usuario u){
        boolean autenticado=false;
        //Autenticamos sin base de datos.
        if (u.getLogin().equals("jorge")&&u.getPassword().equals("jorge")){
            autenticado=true;
        }
        
        return autenticado;
    }
    
}
