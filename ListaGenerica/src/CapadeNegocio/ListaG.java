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
     public class ListaG <Tipovar extends Comparable> implements Serializable{     NodoGP<Tipovar> L;
                                                                                   int Cant;
                                                    
    public  ListaG(){
        L=null;
        Cant=0;
    }          
    public int cantidad(){
    return Cant;
    }
    public void Insertar(Tipovar Dato){
        if (L==null) { //esta vacia
            NodoGP P=new NodoGP<Tipovar>();
            P.SetDato(Dato);
            L=P;
            Cant++;            
        }else {
            NodoGP<Tipovar> Ant = null;     //-1,1,0
            NodoGP<Tipovar> Aux = L;
                while ((Aux!=null)&&(Aux.GetDato().compareTo(Dato)<=0)) {
                    Ant=Aux;
                    Aux=Aux.GetEnlace();    
                 }
                  NodoGP P= new NodoGP<Tipovar>(Dato);
                if (Ant==null) {//inserta en el primero                
                  P.SetEnlace(L);
                  L=P;
                  Cant++;
                }else {  
                       if (Ant.GetDato().compareTo(Dato)!=0) {                             
                        Ant.SetEnlace(P);
                        P.SetEnlace(Aux);
                        Cant++;
                       }
                }
        }
    }
    public String Mostrar(){
        String S="Vacia !!!";
        if (L!=null) {
            S="";
            NodoGP P=L;
            while (P!=null) {                
                if (P.GetEnlace()==null) S=S+P.GetDato(); else S=S+P.GetDato()+"->";
                P=P.GetEnlace();
            }
        }
        return S;
    }
    
    public Boolean Buscar(Tipovar Dato){
        if (L==null) {
            return (false);
        } else {            
            NodoGP<Tipovar> Aux = L;
                while ((Aux!=null)&&(Aux.GetDato().compareTo(Dato)!=0)) 
                    Aux=Aux.GetEnlace();                     
                    if (Aux!=null)  
                      return true;
                    else return false;
        }
    }
   public Tipovar Getdato(int pos){
       NodoGP<Tipovar> Aux=L;
       for (int i = 1; i <pos; i++) {
           Aux=Aux.GetEnlace();
           
       }
   return(Aux.GetDato());
   }
    public Tipovar BuscarObj(Tipovar Dato){
        if (L==null) {
           return Dato;
        } else {            
            NodoGP<Tipovar> Aux = L;
                while ((Aux!=null)&&(Aux.GetDato().compareTo(Dato)!=0)) 
                    Aux=Aux.GetEnlace();                     
                if (Aux!=null) 
                   Dato=Aux.GetDato(); 
               return Dato;                   
        }    
    }
    public boolean Modificar(Tipovar Dato){
        if (L==null) {
           return false;
        } else {            
            NodoGP<Tipovar> Aux = L;
                while ((Aux!=null)&&(Aux.GetDato().compareTo(Dato)!=0)) 
                    Aux=Aux.GetEnlace();                     
                if (Aux!=null) {
                   Aux.Dato=Dato;
                   return true;
                }
               return false;                   
        }
    }
    
 public void Eliminar(Tipovar ele){
   if (L!=null){
    NodoGP<Tipovar> Aux=L;  
    NodoGP<Tipovar> Ant=null;
         while ((Aux!=null)&&(Aux.GetDato().compareTo(ele)!=0)){
             Ant=Aux;
             Aux=Aux.GetEnlace();
         }
      if (Aux!=null)
           if (Ant==null){
             L=L.GetEnlace();
             Cant--;
           
           }
           else{ Ant.SetEnlace(Aux.GetEnlace());
                 Cant--;
           }
   }
   
   }   

    @Override
    public String toString() {
        String S="";
        NodoGP<Tipovar> Aux=L;
        while (Aux!=null){
          S=S+Aux.toString()+'\n';
          Aux=Aux.GetEnlace();
        
        }
        return S;
    }
    
        public static void main(String[] args) {
        /*
            Alumno A=new Alumno(5202,202058678,"Juan",true,25);
             Alumno B=new Alumno(5242,202158745,"Rene",true,25);
            Alumno C=new Alumno(5111,201758745,"Carlos",true,45);

            ListaG LA= new ListaG<Alumno>();
            LA.Insertar(A);
            LA.Insertar(B);
            LA.Insertar(C);
            
            /*for (int i = 1; i <= LA.Cant; i++) {
                Alumno x=(Alumno)LA.Getdato(i);
                System.out.println(x);
                      
            }
            System.out.println(LA.toString()); */
            //-------------------------------------------------
             Libros M=new Libros(105,"Informatica basica","Pedro garron",1,2020,"Santillana",250);
        Libros N=new Libros(103,"Informatica I","Alberto Suarez",2,2021,"la Hoguera",150);
        Libros O=new Libros(101,"Estructuras","Luis Joyanes",4,2018,"Mc graw",550);
        Libros P=new Libros(107,"Sistemas Operativas I","Felix Ortuste",2,2015,"La estrella",450);
        Libros R=new Libros(103,"Sistemas Operativas I","Felix Ortuste",2,2015,"La estrella",450);
        ListaG LI=new ListaG<Libros>();
        LI.Insertar(M);
        LI.Insertar(N);
        LI.Insertar(O);
        LI.Insertar(P);
        LI.Insertar(R);
        /* for (int i = 1; i <= LI.cantidad(); i++) {
            Libros x=(Libros)LI.Getdato(i);
             System.out.println(x);
                      
        }*/
        
        System.out.println(LI.toString());
        }
    
    
}
