/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitec.weba;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author T-107
 */
public class ServletBuscarATodosLosUsuarios extends HttpServlet {

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       //Vamos a creaR UN OBJETO QUE NOS SERVIRA PARA MAPEAR UN aRRAYlIST DE
        //JAVA a un objeto JSON
        
        ObjectMapper mapper=new ObjectMapper();
        DAOUsuario du=new DAOUsuario();
        try {
            List<Usuario> usuarios=du.buscarTodos();
            
            out.println(mapper.writeValueAsString(usuarios)); 
            
        } catch (Exception ex) {
        
        }
        
        
    }
}

