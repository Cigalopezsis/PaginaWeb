<%-- 
    Document   : index
    Created on : 16/01/2020, 01:03:46 PM
    Author     : cinth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Calculo del IMC</title>
        <meta name="viewport" hhttp-equiv="content-Type" content="text/html; charset = UTF-8">
        <link rel="stylesheet" href="Banner.css" > </link>
       
     
         
    </head>
    <body style="background: rgb(252, 246, 170 )">
         <div class="banner"></div>
          <br/><br/>
        
                   <div id=Tabla1>
   <div id=Cabtab1>
   
   </div>
   <div id=Cuerpotab1>
            Calculo IMC
   </div>
</div>
        <form name="Calculo" method = "POST" action = "POO" >
        <br/><br/><center><table border="1">

               
<tr><br/> 
<th style="background: rgb(252, 214, 208)"><br/>&nbsp;&nbsp;Altura: <input type = "text" name = "txtAltura" id = "idAltura"/>&nbsp;&nbsp;&nbsp;<br/><br/></th>
<th style="background: rgb(252, 214, 208)"><input type="radio" id="idmetros" name="altura" value="Metros" checked>
                            <label for="Metros">Metros</label> &nbsp;&nbsp;&nbsp;
                            <input type="radio" id="idpies" name="altura" value="Pies" checked>
                            <label for="Pies">Pies</label>&nbsp;&nbsp;&nbsp;
                        </th>
</tr>
<tr>
<th style="background: rgb(252, 214, 208)"><br/>&nbsp;&nbsp;Peso:     &nbsp;&nbsp;&nbsp;   <input type = "text" name = "txtPeso" id = "idPeso"/>&nbsp;&nbsp;&nbsp;<br/><br/></th>
<th style="background: rgb(252, 214, 208)"><input type="radio" id="idkilos" name="peso" value="Kilos" checked>
                            <label for="Kilos">Kilos</label> &nbsp;&nbsp;&nbsp;
                            <input type="radio" id="idlibras" name="peso" value="Libras" checked>
                            <label for="Libras">Libras</label>&nbsp;&nbsp;&nbsp;
                        </th>
</tr>
               
                <tr>
                    <th  style="background: rgb(252, 214, 208)" colspan="2">
                    <input style="background: rgb(250, 232, 229)" type="submit" name ="btnCalcular" value ="Calcular" >
                   
                    </th>
                   
                </tr>
               
</table>
     
   
    
            </form>
       
        <br/><br/>
        
        
    </body>
</html>