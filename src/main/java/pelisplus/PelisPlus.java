/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pelisplus;

import datos.AccesoDatosAdiclmpl;
import datos.AccesoDatoslmpl;
import dominio.PeliculaAmpliado;
import java.util.Scanner;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculaslmpl;


/**
 *
 * @author USUARIO
 */
public class PelisPlus {
   private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\Users\\USUARIO\\Documents\\interfaces\\prueba.txt";
    private static final CatalogoPeliculas catalogoPeli = new CatalogoPeliculaslmpl();
   
        
    public static void main(String[] args) {
        //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Iniciar catalogo peliculas"
                        + "\n2.- Agregar pelicula\n"
                        + "3.- Listar Peliculas\n"
                        + "4.- Buscar Pelicula\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        catalogoPeli.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        System.out.println("HOLAAAA CUATE INTRODUCE EL NOMBRE DE TU PELICULA QUE QUERAS AGREGAR AL ARCHIVO,"
                                + "\ny TAMBIEN INTRODUCE EL AÑO   <;> :");
                        String nombre = scanner.nextLine();
                        catalogoPeli.agregarPeliculas(nombre, nombreArchivo);                       
                     
                        break;
                    case 3:
                        //3. listar catalogo completo
                        catalogoPeli.ListarPeliculas(nombreArchivo);
                        
                        break;
                    case 4:
                           
                        //4. Buscar pelicula
                        System.out.println("INTRODUCE EL NOMBRE DE LA PELICULA A BUSCAR:");
                        String buscar = scanner.nextLine();
                        catalogoPeli.buscarPeliculas(nombreArchivo, buscar);
                        break;
                    case 0:
                        System.out.println("    ............... MUY BIEN ADIOOOS.........");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }
}