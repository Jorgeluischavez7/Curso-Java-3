/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitec.weba;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;//clases de java empresarial
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author T-107
 */
public class ServletAutenticar extends HttpServlet {

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Por el request sale toda la info.
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //aqui seguiria la capa model, donde nos indica si la autenticacion fue exitosa.
        
        
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String ip= request.getRemoteAddr();//regresa la ip de acceso
        Date fecha= Calendar.getInstance().getTime();
        
        //buscar aqui el usuario cuyo loggon y password se le proporciono
        //una vez buscado verifiacr su id, supongamos que es uno
        Usuario u1=new Usuario();
        u1.setIdUsuario(1);
        //Despues de esto guardar la sesion con la clase administracion.
        Administracion a=new Administracion();
        a.setFecha(fecha);
        a.setIdUsuario(u1);
        a.setIp(ip);
        DAOadministracion daoadmon=new DAOadministracion();
        try{
        daoadmon.guardar(a);
        }catch(Exception ex){
            
        }
        
        //Creamos un model.
        Usuario u=new Usuario();
        //Ajustamos su login y password
        u.setLogin(login);
        u.setPassword(password);
        //Redireccionamineto del servlet
        ModeloAutenticar modelo=new ModeloAutenticar();
        if(modelo.autenticar(u)){
            RequestDispatcher despachador=request.getRequestDispatcher("/bienvenido.jsp");// ruta que se va a despachar
        despachador.forward(request, response);//ya se despacha
        }else{
            RequestDispatcher despachador=request.getRequestDispatcher("/error.jsp");// ruta que se va a despachar
        despachador.forward(request, response);
        }
    }
}