package es.Grupo6.recordatorios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradoFacil {
    //conjunto de métodos para cifrar datos

    /**
     * cifradoHASHMD5 crea un hash a partir de un texto dado usando el algoritmo MD5 de 32 bits de ancho.
     * @param datoACifrar String a cifrar
     * */
    public String cifradoHASHMD5(String datoACifrar){
        String hashCifrado ="Error 3";
        try {
            MessageDigest algoritmo = MessageDigest.getInstance("MD5");//establecemos el algoritmo
            byte[] bitesHash = algoritmo.digest(datoACifrar.getBytes());

            StringBuilder construyeStrings = new StringBuilder();
            for (byte b : bitesHash) {
                construyeStrings.append(String.format("%02x", b));
            }
            hashCifrado = construyeStrings.toString(); //tenemos el hash en forma de String



        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error 2 "+ e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return hashCifrado;
    }

}
