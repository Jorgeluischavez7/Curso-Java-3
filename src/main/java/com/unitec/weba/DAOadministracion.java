/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitec.weba;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author T-107
 */

    
public class DAOadministracion {
    static SessionFactory factory;// staticos para que se carguen inmediatamente
    static Session session;
    static Transaction tranza;
    
    static{//inicializa la sesion (DAOAdministracion dao=new DAOAdministracion()//dao.guardar )
       factory= HibernateUtilidades.getSessionFactory();//solo se abre una sola vez
       session= factory.openSession();
       tranza= session.beginTransaction();
    }
    
    public static void cerrarTodo(){
        tranza.commit();
        session.close();
    }            
            
    public DAOadministracion(){
        
    }
    //Creamos el insert 
    public void guardar(Administracion u)throws Exception{
        //aqui poner el codigo de tu guardado
        //Despues invocas el metodo cerrarTodo
        
        session.save(u);
        cerrarTodo();
    }
    //Creamos el update
    public void actualizar (Administracion u)throws Exception{
        
    }
    //Creamos el buscar todos 
    public List<Administracion> buscarTodos()throws Exception{
        return null;
    }
    //Creamos el buscarPorId
    public Administracion buscarPorId(Integer id)throws Exception{
        return null;
    }
    //]Creamos el de autenticar
    public boolean autenticar(Administracion u)throws Exception{
        return false;
    }
}


