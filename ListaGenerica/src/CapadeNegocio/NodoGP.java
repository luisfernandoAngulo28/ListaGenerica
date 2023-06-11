/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapadeNegocio;


import java.io.Serializable;

/**
 *
 * @author Mario Campos
 */
    public class NodoGP <Tipovar> implements Serializable{   Tipovar Dato;
                                                             NodoGP<Tipovar> Enlace; 
                           
    public NodoGP(){
      Enlace=null;
    }              
    public NodoGP (Tipovar Dato){
       this.Dato=Dato;
      Enlace=null;    
    }
    public void SetDato(Tipovar Dato){
       this.Dato=Dato;
    }
    public Tipovar GetDato(){
        return Dato;
    }
    public void SetEnlace(NodoGP<Tipovar> P){
      Enlace=P;
    }
    public  NodoGP<Tipovar> GetEnlace(){
       return Enlace;
    }

    @Override
    public String toString() {
        String S="";
        S=S+Dato;
        return S ;
    }

    
}

    
    

