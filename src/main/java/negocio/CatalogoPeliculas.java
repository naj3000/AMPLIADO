/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author USUARIO
 */
public interface  CatalogoPeliculas {
    public void agregarPeliculas(String nombrePelicula, String  nombreArchivo);
    public void ListarPeliculas(String nombreArchivo);
    public void buscarPeliculas(String nombreArchivo,String buscar);
    public void iniciarArchivo(String nombreArchivo);

    public void listarPeliculas(String nombreArchivo);
    
}
