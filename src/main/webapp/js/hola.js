/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//alert("viendo si se carga mi archivo");
$(document).ready(function (){
$("#boton-hola").click(function (){
      alert("Hola");
    //vamos a enviar el dato del nombre a nuestro servlet
    //y esperar la respuesta del servlet.
    $.ajax({//se definen atributos del objeto ajax
        url:'hola',
        method:'post',
        data:{//estructura tipo JSUN.
            nombre:$("#nombre").val()            
        },
        success: function (datos) {
          
         $("#respuesta").html(datos);   
        },
        failure:function(){
            
        }
    });
    
    });
});
