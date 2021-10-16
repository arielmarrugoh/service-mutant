package com.magneto.servicemutant.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MatrizUtil {

    public static  char[][] matrizDna(String[] dnas){
        final int columnsSize = columns(dnas);
        int rowsSize = dnas.length;


        char[][] matrizDna= new char[rowsSize][columnsSize];
        for (int i = 0; i < rowsSize; i++) {
            String dna= dnas[i];
            for (int j = 0; j < columnsSize; j++) {
                try{
                matrizDna[i][j] = dna.charAt(j);
                }catch (Exception e){
                    log.info("Celda no existe");
                }

            }
        }
        return matrizDna;
    }

    public static int columns(String[] dnas){
        int columnsSize = 0;
        for (String dna : dnas) {
            int sizeDna = dna.length();
            if(columnsSize < sizeDna){
                columnsSize = sizeDna;
            }
        }
        return columnsSize;
    }
}
