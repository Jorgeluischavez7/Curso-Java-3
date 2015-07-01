//operaciones basicas
package com.unitec.weba;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author T-107
 */
public class DAOUsuario {
    static SessionFactory factory;// staticos para que se carguen inmediatamente
    static Session session;
    static Transaction tranza;
    
    static{//inicializa la sesion (DAOUsuario dao=new DAOUsuario()//dao.guardar )
       factory= HibernateUtilidades.getSessionFactory();//solo se abre una sola vez
       session= factory.openSession();
       tranza= session.beginTransaction();
    }
    
    public static void cerrarTodo(){
        tranza.commit();
        session.close();
    }            
            
    public void abrirSession(){
    factory=HibernateUtilidades.getSessionFactory();
    session=factory.openSession();
    tranza= session.beginTransaction();
    }
    
    public DAOUsuario(){
        
    }
    //Creamos el insert 
    public void guardar(Usuario u)throws Exception{
        //aqui poner el codigo de tu guardado
        //Despues invocas el metodo cerrarTodo
        abrirSession();
        session.save(u);
        cerrarTodo();
    }
    //Creamos el update
    public void actualizar (Usuario u)throws Exception{
         abrirSession();
        session.update(u);
        cerrarTodo();
    }
    //Creamos el buscar todos 
    public List<Usuario> buscarTodos()throws Exception{
        abrirSession();
        List<Usuario> usuarios= session.createCriteria(Usuario.class).list();
        return usuarios;
    }
    //Creamos el buscarPorId
    public Usuario buscarPorId(Integer id)throws Exception{
        return null;
    }
    //]Creamos el de autenticar
    public boolean autenticar(Usuario u)throws Exception{
        return false;
    }
}
