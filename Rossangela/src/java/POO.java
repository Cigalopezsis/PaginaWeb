/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
@WebServlet(urlPatterns = {"/POO"})
public class POO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @m response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados</title>");            
            out.println("</head>");
            out.println("<body  style=\"background: rgb(252, 246, 170 )\">");
            out.println("<div class=\"bannersalida\"></div>");
            out.println("<br/><br/>");
            out.println("<link rel=\"stylesheet\" href=\"Banner.css\" > </link>");
            
             
         //Varibles decimales de Altura y Peso.
            float Altura = (float) Double.parseDouble(request.getParameter("txtAltura")); //Obtiene el texto dentro del campo.
            float Peso = (float) Double.parseDouble(request.getParameter("txtPeso"));
            
            //Obtener los parámetros del RadioButton
            String AlturaRadio = request.getParameter("altura");
            String PesoRadio = request.getParameter("peso");
            String alturaa = request.getParameter("txtAltura");
            String pesoo = request.getParameter("txtPeso");
            
            String Clasificacion = null;
            String Resultado = null;
            
            String url_2 = "<a href=\""
           + request.getContextPath()
           + "/Salida.html\"> Formulario de Salida.</a>";
            double resultado = 0;
            
            
            
            //Si la opción registrada es en Metros y Kilos:
            
            
            if ("Metros".equals(AlturaRadio) && ("Kilos".equals(PesoRadio)))
            {
                //Válida que los número ingresados sean positivos.
           if ((Altura >= 0) && (Peso >= 0))
           {         
               
               
               //Si el campo tiene letras o símbolos tira un error.
               if (alturaa.equals("abcdefghijklmnñopqrstuvwxyz!#$%&/()?¡¿") && pesoo.equals("abcdefghijklmnñopqrstuvwxyz!#$%&/()?¡¿"))
               {
                  // out.println("No se permiten letras ni simbolos");
               }
              
               else
               {
                   //Si el campo es vacío tira un error.
                    if (alturaa.equals(" ") && pesoo.equals(" "))
                    {
                       // out.println("LLENE LOS CAMPOS.");
                    }
                    else
                    {
                        //Caso contrario se realiza el cálculo
                      
                        resultado = CalculaMasaMetrosYKilos (Altura, Peso);
                        
                        Resultado = Double.toString(resultado);
                       // out.println(  CalculaMasaMetrosYKilos (Altura, Peso));
                        
                        
                                //Clasificación del IMC
         if (resultado >= 0 && resultado<16)
         {
             Clasificacion = "Delgadez Severa";
             
             //out.println("Delgadez Severa");
             
             //out.println(url_2);
             
         }
         else if(resultado >=16  && resultado<= 16.99)
         {
            // out.println("Delgadez Moderada");
            Clasificacion = "Delgadez Moderada";
           // out.println(url_2);
         }
         
         else if(resultado >=17  && resultado<= 18.49)
         {
             Clasificacion = "Delgadez Leve";
           // out.println("Delgadez Leve");
         //  out.println(url_2);
         }
         
         else if(resultado >=18.5  && resultado<= 24.99)
         {
             Clasificacion = "Peso Normal";
          //   out.println("Peso Normal");
          //out.println(url_2);
         }
         
         else if(resultado >=25  && resultado<= 29.99)
         {
             Clasificacion = "Preobeso";
           //  out.println("Preobeso");
           // out.println(url_2);
         }
         
         else if(resultado >=30  && resultado<= 34.99)
         {
             Clasificacion = "Obesidad Leve";
            // out.println("Obesidad Leve");
            //out.println(url_2);
         }
         
         else if(resultado >=35  && resultado<= 39.99)
         {
             Clasificacion = "Obesidad Media";
            // out.println("Obesidad Media");
          //  out.println(url_2);
         }
         else if(resultado >=40)
         {
             Clasificacion = "Obesidad Mórbida";
          //  out.println(Clasificacion); 
           
         // out.println(url_2);
         }
                    }
               }
           }
           else
           {
               //No se permite el uso de números negativos.
             //  out.println("No se permiten números negativos.");
           }
            }
            
            //----------------------------------------------------------------------------------------------------------------
            
            //Si la opción registrada es en Pies y Libras:
            else if ("Pies".equals(AlturaRadio) && ("Libras".equals(PesoRadio)))
            {
                if ((Altura >= 0) && (Peso >= 0))
           {         
              
               
               //Si el campo tiene letras o símbolos tira un error.
               if (alturaa.equals("abcdefghijklmnñopqrstuvwxyz!#$%&/()?¡¿") && pesoo.equals("abcdefghijklmnñopqrstuvwxyz!#$%&/()?¡¿"))
               {
                //   out.println("No se permiten letras ni simbolos");
               }
              
               else
               {
                   //Si el campo es vacío tira un error.
                    if (alturaa.equals(" ") && pesoo.equals(" "))
                    {
                        //out.println("LLENE LOS CAMPOS.");
                    }
                    else
                    {
                        //Caso contrario se realiza el cálculo
                        
                        resultado = CalcusaMadaPiesyLibras(Altura, Peso);
                        Resultado = Double.toString(resultado);
                      //  out.println( CalcusaMadaPiesyLibras (Altura, Peso));
                     
                                //Clasificación del IMC
         if (resultado >= 0 && resultado<16)
         {
             Clasificacion = "Delgadez Severa";
             //out.println("Delgadez Severa");
           //  out.println(url_2);
         }
         else if(resultado >=16  && resultado<= 16.99)
         {
             Clasificacion = "Delgadez Moderada";
             //out.println("Delgadez Moderada");
            // out.println(url_2);
         }
         
         else if(resultado >=17  && resultado<= 18.49)
         {
             Clasificacion = "Delgadez Leve";
           // out.println("Delgadez Leve");
         //  out.println(url_2);
         }
         
         else if(resultado >=18.5  && resultado<= 24.99)
         {
             Clasificacion = "Peso Normal";
            // out.println("Peso Normal");
           // out.println(url_2);
         }
         
         else if(resultado >=25  && resultado<= 29.99)
         {
             Clasificacion = "Preobeso";
            // out.println("Preobeso");
           // out.println(url_2);
         }
         
         else if(resultado >=30  && resultado<= 34.99)
         {
             Clasificacion = "Obesidad Leve";
            // out.println("Obesidad Leve");
            //out.println(url_2);
         }
         
         else if(resultado >=35  && resultado<= 39.99)
         {
             Clasificacion = "Obesidad Media";
             //out.println("Obesidad Media");
            // out.println(url_2);
         }
         else if(resultado >=40)
         {
             Clasificacion = "Obesidad Mórbida";
             //out.println("Obesidad Mórbida");
            // out.println(url_2);
         }
                    }
               }
           }
           else
           {
               //No se permite el uso de números negativos.
              // out.println("No se permiten números negativos.");
           }
            }
            
            //----------------------------------------------------------------------------------------------------------------
            //Si la opción registrada es en Pies y Kilos.
            else if ("Pies".equals(AlturaRadio) && ("Kilos".equals(PesoRadio)))
            {
               if ((Altura >= 0) && (Peso >= 0))
           {         
               
               
               //Si el campo tiene letras o símbolos tira un error.
               if (alturaa.equals("abcdefghijklmnñopqrstuvwxyz!#$%&/()?¡¿") && pesoo.equals("abcdefghijklmnñopqrstuvwxyz!#$%&/()?¡¿"))
               {
                 //  out.println("No se permiten letras ni simbolos");
               }
              
               else
               {
                   //Si el campo es vacío tira un error.
                    if (alturaa.equals(" ") && pesoo.equals(" "))
                    {
                       // out.println("LLENE LOS CAMPOS.");
                    }
                    else
                    {
                        //Caso contrario se realiza el cálculo
                       
                        resultado = CalculaMasaPiesKilos (Altura, Peso);
                        Resultado = Double.toString(resultado);
                       // out.println(  CalculaMasaPiesKilos (Altura, Peso));
                     
                                //Clasificación del IMC
         if (resultado >= 0 && resultado<16)
         {
             Clasificacion = "Delgadez Severa";
             //out.println("Delgadez Severa");
           //  out.println(url_2);
         }
         else if(resultado >=16  && resultado<= 16.99)
         {
             Clasificacion = "Delgadez Moderada";
            // out.println("Delgadez Moderada");
         //   out.println(url_2);
         }
         
         else if(resultado >=17  && resultado<= 18.49)
         {
             Clasificacion = "Delgadez Leve";
           // out.println("Delgadez Leve");
         //  out.println(url_2);
         }
         
         else if(resultado >=18.5  && resultado<= 24.99)
         {
             Clasificacion = "Peso Normal";
           //  out.println("Peso Normal");
         //  out.println(url_2);
         }
         
         else if(resultado >=25  && resultado<= 29.99)
         {
             Clasificacion = "Preobeso";
            // out.println("Preobeso");
            //out.println(url_2);
         }
         
         else if(resultado >=30  && resultado<= 34.99)
         {
             Clasificacion = "Obesidad Leve";
           //  out.println("Obesidad Leve");
          // out.println(url_2);
         }
         
         else if(resultado >=35  && resultado<= 39.99)
         {
             Clasificacion = "Obesidad Media";
            // out.println("Obesidad Media");
           // out.println(url_2);
         }
         else if(resultado >=40)
         {
             Clasificacion = "Delgadez Mórbida";
            // out.println("Obesidad Mórbida");
          //  out.println(url_2);
         }
                    }
               }
           }
           else
           {
               //No se permite el uso de números negativos.
               //out.println("No se permiten números negativos.");
           } 
            }
            //----------------------------------------------------------------------------------------
            //Si la opción registrada es en Metros y Libras:
            else if ("Metros".equals(AlturaRadio) && ("Libras".equals(PesoRadio)))
            {
                     if ((Altura >= 0) && (Peso >= 0))
           {         
               
               
               //Si el campo tiene letras o símbolos tira un error.
               if (alturaa.equals("abcdefghijklmnñopqrstuvwxyz!#$%&/()?¡¿") && pesoo.equals("abcdefghijklmnñopqrstuvwxyz!#$%&/()?¡¿"))
               {
                  // out.println("No se permiten letras ni simbolos");
               }
              
               else
               {
                   //Si el campo es vacío tira un error.
                    if (alturaa.equals(" ") && pesoo.equals(" "))
                    {
                      //  out.println("LLENE LOS CAMPOS.");
                    }
                    else
                    {
                        //Caso contrario se realiza el cálculo
                     
                        resultado = CalculaMasaMetrosLibras (Altura, Peso);
                        Resultado = Double.toString(resultado);
                       // out.println(  CalculaMasaMetrosLibras (Altura, Peso));
                     
                                //Clasificación del IMC
         if (resultado >= 0 && resultado<16)
         {
             Clasificacion = "Delgadez Severa";
            // out.println("Delgadez Severa");
           // out.println(url_2);
         }
         else if(resultado >=16  && resultado<= 16.99)
         {
             Clasificacion = "Delgadez Moderada";
           //  out.println("Delgadez Moderada");
          // out.println(url_2);
         }
         
         else if(resultado >=17  && resultado<= 18.49)
         {
             Clasificacion = "Delgadez Leve";
            //out.println("Delgadez Leve");
           // out.println(url_2);
         }
         
         else if(resultado >=18.5  && resultado<= 24.99)
         {
             Clasificacion = "Peso Normal";
           //  out.println("Peso Normal");
         //  out.println(url_2);
         }
         
         else if(resultado >=25  && resultado<= 29.99)
         {
             Clasificacion = "Preobeso";
           //  out.println("Preobeso");
          // out.println(url_2);
         }
         
         else if(resultado >=30  && resultado<= 34.99)
         {
             Clasificacion = "Obesidad Leve";
            // out.println("Obesidad Leve");
          //  out.println(url_2);
         }
         
         else if(resultado >=35  && resultado<= 39.99)
         {
             Clasificacion = "Obesidad Media";
           //  out.println("Obesidad Media");
          // out.println(url_2);
         }
         else if(resultado >=40)
         {
             Clasificacion = "Obesdad Mórbida";
            // out.println("Obesidad Mórbida");
          //  out.println(url_2);
         }
                    }
               }
           }
           else
           {
               //No se permite el uso de números negativos.
              // out.println("No se permiten números negativos.");
           }
            }
            
           Conexionn CrearConexion = new Conexionn();
           
           CrearConexion.insertarDatos(alturaa, AlturaRadio, pesoo, PesoRadio, Resultado, Clasificacion);
            String HolaMundo = "HolaMundo";
            
            out.println(" <div id=Tabla2>");
         
            
          
            out.println("<div id=Cuerpotab2>");
            out.println("RESULTADOS.");
            out.println("</div></div>");
            out.println("<br/><br/>");
             
          //  out.println("<br/><br/><center><div>Resultados:</div><br/><br/>");
            out.println("<center><div>Indice de Masa corporal: <b><i>" +Resultado+ "</i></b></div><br/>");
            out.println(" <center><div>Atendiendo al IMC tiene: <b><i>" +Clasificacion+"</i> </b></div><br/><br/>");
            out.println(" <br/><br/>");
            out.println("<table border=\"1\" style=”width: 100%”>");
            out.println("<colgroup>");
            out.println("<col style=\"width: 40%\"/>");
            out.println("<col style=\"width: 40%\"/>");
            out.println("</colgroup>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th colspan=\"2\" style=\"background: rgb(192, 222, 252)\">CLASIFICACIÓN DE LA OMS DEL ESTADO NUTRICIONAL DE ACUERDO</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th style=\"background: rgb(254, 172, 69)\">Clasificación</th>");
            out.println("<th style=\"background: rgb(254, 172, 69)\">IMC (kg/m2)</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr style=\"background: rgba(128, 255, 0, 0.3)\">");
            out.println("<th>Bajo Peso</th>");
            out.println("<th><18,50</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Delgadez severa</td>");
            out.println("<td><16,00</td>");
            out.println("</tr>");
            out.println(" <tr>");
            out.println("<td>Delgadez moderada</td>");
            out.println("<td>16,00-16,99</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Delgadez leve</td>");
            out.println("<td>17,00-18,49</td>");
            out.println("</tr>");
            out.println("<tr style=\"background: rgba(128, 255, 0, 0.3)\">");
            out.println("<th>Peso Nomal</th>");
            out.println("<th>18,5-24,99</th>");
            out.println("</tr>");
            out.println("<tr style=\"background: rgba(128, 255, 0, 0.3)\">");
            out.println("<th>Sobrepeso</th>");
            out.println("<th>≥25,00</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Preobeso</td>");
            out.println("<td>25,00-29,99</td>");
            out.println("</tr>");
            out.println(" <tr style=\"background: rgba(128, 255, 0, 0.3)\">");
            out.println("<th>Obesidad</th>");
            out.println("<th>≥30,00</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Obesidad leve</td>");
            out.println("<td>30,00-34,99</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Obesidad media</td>");
            out.println("<td>35,00-39,99</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Obesidad mórbida</td>");
            out.println("<td>≥40,00</td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            
            
            //out.println("<h1>Servlet POO at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    
    
    //Función que calcula la masa si el peso está en Kilos y la altura en Metros.
    public double CalculaMasaMetrosYKilos (double altura, double peso)
    {
        double resultado;
        double elevado;
        
        elevado = Math.pow(altura, 2);
        resultado = peso / elevado;
        

        
         //Devuelve el resultado del cálculo.
        return resultado;
        
    }
  
    //Función que calcula la masa si el peso está en libras y la altura en Pies.
    public double CalcusaMadaPiesyLibras (double altura, double peso)
    {
        double result;
        double ele;
        
        double alturaMetros = altura * 0.3048;
        double PesoenKilogramos = peso * 0.43592;
        
        ele = Math.pow(alturaMetros, 2);
        result = PesoenKilogramos / ele;
        
        
        return result;
    }
    
    //Función que calcula la masa si la altura está en metros y el peso en libras.
    public double CalculaMasaMetrosLibras (double altura, double peso)
    {
        double re;
        double el;
        double PesoenKilogramos = peso * 0.43592;
        
        el = Math.pow(altura, 2);
        re = PesoenKilogramos / el;
        
        
        return re;
    }
    
    //Función que calcula si el peso está en kilos y la altura en pies
    public double CalculaMasaPiesKilos(double altura, double peso)
    {
        double r ;
        double e;
        
        double alturaMetros = altura * 0.3048;
        
        e = Math.pow(alturaMetros, 2);
        r = peso / e;
        
        return r;
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    
            
     
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
    
    
}
