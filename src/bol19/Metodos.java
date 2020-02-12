/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bol19;

/**
 *
 * @author ceque
 */
public class Metodos {

    public int[][] crearTaboa(int[][] taboa) {
        for (int f = 0; f < taboa.length; f++) {
            for (int c = 0; c < taboa[f].length; c++) {
                taboa[f][c] = PedirDatos.pedirInt("Escribe un numero");
            }
        }        
        return taboa;
    }

    public void amosar(int[][] taboa) {       
        for (int f = 0; f < taboa.length; f++) {
            System.out.println("\n");
            for (int c = 0; c < taboa[f].length; c++) {
                System.out.print(taboa[f][c]+" ");
            }
        }
    }
    public void amosaTodo(int[][] taboa,String[]alumnos,String [] xornadas) {
        System.out.print("\n        ");
        for(int i=0; i<xornadas.length;i++)
            System.out.print("  "+xornadas[i]+"  ");
        for (int f = 0; f < alumnos.length; f++) {
            System.out.print("\n"+alumnos[f]+"     ");
            for (int c = 0; c < taboa[f].length; c++) {
                System.out.print(taboa[f][c]+"     ");
                
            }
        }
    }
    public void sair(){
        System.exit(0);
    } 
    public void ordenarEquipos(int[][]goles,String[]equipo){
        int totalg;
        int[]total=new int[equipo.length];
        for(int i=0;i<goles.length;i++){
            totalg=0;
            for(int j=0;j<goles[0].length;j++){
                totalg=goles[i][j]+totalg;
            }
            total[i]=totalg;
        }
        
        int auxg,auxt;
        String auxe;
        for (int i=0;i<total.length-1;i++){
            
            for(int j=i+1;j<total.length;j++){
                if(total[i]<total[j]){
                    auxt=total[i];
                    total[i]=total[j];
                    total[j]=auxt;
                    auxe=equipo[i];
                    equipo[i]=equipo[j];
                    equipo[j]=auxe;
                    for(int k=0;k<goles[0].length;k++){
                        auxg=goles[i][k];
                        goles[i][k]=goles[j][k];
                        goles[j][k]=auxg;
                    }
                }
            }
        } 
    }
    public void consultar(String[]equipo,String[]jornada,int[][]goles){
        String jornadas,equipos;
        int posicionE=0,posicionJ=0;
        equipos=PedirDatos.pedirString("Introduzca el equipo a buscar");
        jornadas=PedirDatos.pedirString("Introduzca la jornada a buscar\nLas jorandas se almacenana como:\n      X+numerodejornada");
        for(int i=0;i<equipo.length;i++){
            if(equipos.equals(equipo[i])){
                posicionE=i;
            }
        }
        for(int i=0;i<jornada.length;i++){
            if(jornadas.equals(jornada[i])){
                posicionJ=i;
            }
        }
        System.out.println("El equipo "+equipos+" marco "+ goles[posicionE][posicionJ]+" en la jornada "+jornadas);
    }
    public void buscarCantidadGolesEnJornada(String[]equipo,String[]jornada,int[][]goles){
        int max;
        String equipom[]=new String[equipo.length];
        int i,j;
        
        for(i=0;i<goles[0].length;i++){
            max=0;
            for(j=0;j<goles.length;j++){
                if(max<=goles[j][i]){
                    max=goles[j][i];
                    equipom[j]=equipo[j];
                }
            }
            for(j=0;j<goles.length;j++){
                if(max==goles[j][i]){
                    System.out.println("El equipo "+ equipom[j] +" marco un total de "+max+" en la jornada "+jornada[i]);
                }
            }
        }
        System.out.println("");
    }
    
}
