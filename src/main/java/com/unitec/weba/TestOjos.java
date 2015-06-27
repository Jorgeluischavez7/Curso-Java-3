
package com.unitec.weba;
//falta la biblioteca de sesion y transaccion
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class TestOjos {

       public static void main(String[] args)throws Exception{
       
           System.out.println("Probaremos todas las operaciones sql");
           //primer paso, crear el SessionFactory
           //------falta clase hibernateutilidades
           SessionFactory factory = HibernateUtilidades.getSessionFactory();
           
           //Obtenemos la apertura de sesion actual
           Session sesion = factory.openSession();
           
           //creamos la transaccion
            Transaction tranza=sesion.beginTransaction();
           
           //nos apuramos a hacer una transaccion
           
            Usuario u =new Usuario();
                u.setEmail("jorge@jorge");
                u.setIdUsuario(1);
                u.setNombre("jorge");
                u.setLogin("jorge luis");
                u.setPassword("123");
                sesion.save(u);
               //Liberar la transaccion y cerrar la sesion
               tranza.commit();
               sesion.close();
                
                DAOUsuario daou=new DAOUsuario();
                daou.guardar(u);
                System.out.println("Se actualizo correctamente"); 
              
              //__________________________________________________________________
    //UPDATE
            /*
       Usuario u=new Usuario();
       u.setIdUsuario(2);
       u.setLogin("pancha");
       u.setNombre("pancha juarez");
       u.setEmail("pancha@hotmail.com ");
       u.setPassword("123");
       sesion.update(u);
       tranza.commit();
       sesion.close();
       
        
        System.out.println("Se actualizo correctamente");
       //_________________________________________________________________
       */
       
         
            /*
       Usuario u = (Usuario) sesion.createCriteria(Usuario.class).add(Restrictions.idEq(1)).uniqueResult();
       
       tranza.commit();
       sesion.close();
           System.out.println("El usuario buscado tiene nombre: " +u.getNombre());
            
        */
           
        /*        
//enlista todo lo que va haber en la tabla
            List<Usuario> usuarios = sesion.createCriteria(Usuario.class).list();
             tranza.commit();
       sesion.close();
       for(Usuario usu:usuarios){
            System.out.println("Usuarios encontrados: " +usu.getNombre());
            
       }*/
    
       }}
