/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.AccesoDatosAdiclmpl;
import datos.AccesoDatoslmpl;
import datos.lAccesoDatos;
import dominio.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author USUARIO
 */

public class CatalogoPeliculaslmpl implements CatalogoPeliculas{

//    private final IAccesoDatos datos;
    private final datos.AccesoDatosAdiclmpl datos;

    public CatalogoPeliculaslmpl(){
//        this.datos= new AccesoDatosImpl(); 
        this.datos = new AccesoDatosAdiclmpl();
    }
    
   
    
    @Override
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        
        boolean anexar = false;
        
        try {
            
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula, nombreArchivo, anexar);
           
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al acceder al archivo");
        }
        
    }

    @Override
    public void ListarPeliculas(String nombreArchivo) {
        try {
            datos.cargarInformacion(nombreArchivo);
           
//            List<Pelicula> peliculas = datos.listar(nombreArchivo);
//            
//            System.out.println("===== Listar Peliculas =====");
//            for (Pelicula peli : peliculas) {               
//                System.out.println("Peli: "+ peli);              
//            }
        } catch (Exception e) {
            System.out.println("Clavos con el acceso a datos");
        }
    }

    @Override
    public void buscarPeliculas(String nombreArchivo, String buscar) {
        String resultado= "No se encontro";
        try {
            
            resultado = datos.Buscar(nombreArchivo, buscar);
            
            
        } catch (Exception e) {
            System.out.println("Error al buscar la peli");
        }
        System.out.println("Resultado: "+ resultado);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
    
        try {
            if (datos.existe(nombreArchivo)) {
                //Si existe se borra el archivo
                datos.borrar(nombreArchivo);
                
            }else{
                //Si no existe crea el archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}