/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Admin
 */
public class Lectura {
    
    public String nombreArchivo;

    public Lectura(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    
    
    public void LecturaIntermedio(){
        String nombre = this.nombreArchivo;
        
        BufferedReader br = null;
        
        try{
            br = new BufferedReader(new FileReader(nombre));
            String texto = br.readLine();
            
            while(texto != null){
                System.out.println(texto);
                texto = br.readLine();
            }
        }catch(Exception e){
            
        }finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]){
        Lectura arch = new Lectura("C:\\Users\\Admin\\Documents\\compiladores\\Proyecto\\ejecutables\\ejemplo.txt");
        
        arch.LecturaIntermedio();
    }
    
}
