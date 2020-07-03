package ejercicioarrylistpartidosfutbol;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

    private static final String documentoTxt = "/home/asunawesker/Documentos/ProgramaciónParada/Ejemplos/AguirreValenteIrais_Proyecto3_ArrayList/partidos.txt";

    public static void main (String args[]){
        ArrayList<PartidoFutbol> partidos = new ArrayList<PartidoFutbol>();

        File fichero = new File(documentoTxt);
        Scanner s = null;

        try {
            s = new Scanner(fichero);
            while (s.hasNextLine()){
                String renglon = s.nextLine();                //Se obtiene una línea del fichero
                String [] cortarRenglon = renglon.split("::"); //cada atributo se separa por ::
                PartidoFutbol partido = new PartidoFutbol();//Creando un partido

                //Obteniendo los atributos del fichero, cada que se encuentre un :: es un atributo
                partido.setLocal(cortarRenglon[0]);                              //nombre equipo local
                partido.setVisitante(cortarRenglon[1]);                          //nombre equipo visitante
                partido.setGolLocal(Integer.parseInt(cortarRenglon[2]));         //goles local   
                partido.setGolVisitante(Integer.parseInt(cortarRenglon[3]));     //goles visitante

                partidos.add(partido);  //agregando un partido en el array de partidos
            }

        } catch (Exception e) {
                e.printStackTrace();
        } finally{
                try {
                        if (s != null)
                                s.close();
                } catch (Exception e2) {
                        e2.printStackTrace();
                }
        }

        System.out.println("\tTotal de partidos de futbol: "+partidos.size());

        System.out.println("\n\tLista de todos los partidos\n");
        
        Iterator<PartidoFutbol> iterador = partidos.iterator();
        while(iterador.hasNext()){
            PartidoFutbol partido = iterador.next();
            System.out.println(partido.getLocal() + " "
                            + partido.getGolLocal() + " - "
                            + partido.getGolVisitante() + " "
                            + partido.getVisitante());
        }

        iterador = partidos.iterator();
        while(iterador.hasNext()){
            PartidoFutbol partido = iterador.next();
            if(partido.getGolLocal() != partido.getGolVisitante())
                iterador.remove();
        }

        // Imprimimos los elementos del ArrayList
        System.out.println("\n\tTotal partidos de futbol empatados = "+partidos.size());
        System.out.println("\n\tLista de todos los partidos\n");
        
        iterador = partidos.iterator();
        while(iterador.hasNext()){
            PartidoFutbol partido = iterador.next();
            System.out.println(partido.getLocal() + " "
                            + partido.getGolLocal() + " - "
                            + partido.getGolVisitante() + " "
                            + partido.getVisitante());
        }
    }

}
