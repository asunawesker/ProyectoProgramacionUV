package ejercicioquitandoceros;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
	
private static final String documentoTxt = "/home/asunawesker/Documentos/ProgramaciónParada/Ejemplos/AguirreValenteIrais_Proyecto3_ArrayList/numeros.txt";
	
    public static void main (String args[]){
        //Haciendo un array de dos dimensiones
        ArrayList <ArrayList<Integer>> listaNumeros = new ArrayList<ArrayList<Integer>>();

        File fichero = new File(documentoTxt);
        Scanner sc = null;

        try {
            sc = new Scanner(fichero);
            while (sc.hasNextLine()){
                String renglon = sc.nextLine();                         //Leyendo un renglon
                String [] cortarRenglon = renglon.split(" ");           //todo un renglon va a ser un array nuevo
                ArrayList <Integer> numeros = new ArrayList<Integer>(); 
                for (int i=0; i<cortarRenglon.length; i++){
                    numeros.add(Integer.parseInt(cortarRenglon[i]));
                }
                listaNumeros.add(numeros);	
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                    if (sc != null)
                            sc.close();
            } catch (Exception e2) {
                    e2.printStackTrace();
            }
        }

        System.out.println("\n\tLista de números original");
        Iterator<ArrayList<Integer>> iterador = listaNumeros.iterator();
        while(iterador.hasNext()){
            ArrayList<Integer> numeros = iterador.next();
            Iterator<Integer> iteradorNum = numeros.iterator();
            while(iteradorNum.hasNext()){
                int numero = iteradorNum.next();
                System.out.print(numero+" ");
            }
            System.out.println();
        }

        //eliminando los ceros 
        iterador = listaNumeros.iterator();
        while(iterador.hasNext()){
            ArrayList<Integer> numeros = iterador.next();
            Iterator<Integer> iteradorNum = numeros.iterator();
            while(iteradorNum.hasNext()){
                int numero = iteradorNum.next();
                if (numero == 0)
                        iteradorNum.remove();
            }
        }
        
        //eliminando los renglones que no tengan números
        iterador = listaNumeros.iterator();
        while(iterador.hasNext()){
                ArrayList<Integer> numeros = iterador.next();
                if (numeros.isEmpty())
                        iterador.remove();
        }

        String resultado = "";
        System.out.println("\n\tLista de números sin ceros");
        iterador = listaNumeros.iterator();
        while(iterador.hasNext()){
            ArrayList<Integer> numeros = iterador.next();
            Iterator<Integer> iteradorNum = numeros.iterator();
            while(iteradorNum.hasNext()){
                int numero = iteradorNum.next();
                resultado += numero+" ";
            }
            resultado += "\n";
        }
        
        System.out.println(resultado);

    }

}
