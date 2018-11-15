package com.scantext.ilus.scantext;

/**
 * Created by ilus on 15/11/2017.
 */

public class Buscar_Datos {

    static int temp = 0;
    static String resultado_Nombre = "";
    static String resultado_Edad = "";
    static String resultado_Sala = "";
    static String resultado_FechaConsulta = "";
    static String resultado_Telefono = "";
    static String resultado_Direccion = "";
    static String resultado_Correo = "";

    public static String busca_Correo(String linea_Actual) {

        for (int i = 0; i < linea_Actual.length(); i++) {
            if (linea_Actual.charAt(i) == ' ') {
                if (i == 0) {
                    temp = 1;
                }//estructura que se debe de cumplir
                else if (linea_Actual.charAt(i) == ' ' && linea_Actual.charAt(i - 1) == ':'
                        && (linea_Actual.charAt(i - 2) == 'O' || linea_Actual.charAt(i - 2) == 'o')
                        && (linea_Actual.charAt(i - 3) == 'E' || linea_Actual.charAt(i - 3) == 'e')
                        && (linea_Actual.charAt(i - 4) == 'R' || linea_Actual.charAt(i - 4) == 'r')
                        && (linea_Actual.charAt(i - 5) == 'R' || linea_Actual.charAt(i - 5) == 'r')
                        && (linea_Actual.charAt(i - 6) == 'O' || linea_Actual.charAt(i - 6) == 'o')
                        && (linea_Actual.charAt(i - 7) == 'C' || linea_Actual.charAt(i - 7) == 'c')
                        || linea_Actual.charAt(i) == ' ' && linea_Actual.charAt(i - 1) == ':'
                        && (linea_Actual.charAt(i - 2) == 'L' || linea_Actual.charAt(i - 2) == 'l')
                        && (linea_Actual.charAt(i - 3) == 'A' || linea_Actual.charAt(i - 3) == 'i')
                        && (linea_Actual.charAt(i - 4) == 'I' || linea_Actual.charAt(i - 4) == 'a')
                        && (linea_Actual.charAt(i - 5) == 'M' || linea_Actual.charAt(i - 5) == 'm')
                        && (linea_Actual.charAt(i - 6) == '-' || linea_Actual.charAt(i - 6) == '-')
                        && (linea_Actual.charAt(i - 7) == 'E' || linea_Actual.charAt(i - 7) == 'e')) {
                    temp = 1;
                }
            }

            if (temp == 1) {
                if (linea_Actual.charAt(i + 1) != ' ') {//fin de impresion
                    resultado_Correo = resultado_Correo + linea_Actual.charAt(i + 1);
                    //System.out.print(linea_Actual.charAt(i + 1));
                } else {
                    temp = 0;
                    System.out.print(' ');
                }
            }
        }
        return resultado_Correo;
    }

    public static String busca_Telefono(String linea_Actual) {
        for (int i = 0; i < linea_Actual.length(); i++) {
            if (linea_Actual.charAt(i) == ' ') {
                if (i == 0) {
                    temp = 1;
                }//estructura que se debe de cumplir
                else if (linea_Actual.charAt(i) == ' ' && linea_Actual.charAt(i - 1) == ':'
                        && (linea_Actual.charAt(i - 2) == 'O' || linea_Actual.charAt(i - 2) == 'o')
                        && (linea_Actual.charAt(i - 3) == 'N' || linea_Actual.charAt(i - 3) == 'n')
                        && (linea_Actual.charAt(i - 4) == 'O' || linea_Actual.charAt(i - 4) == 'o')
                        && (linea_Actual.charAt(i - 5) == 'F' || linea_Actual.charAt(i - 5) == 'f')
                        && (linea_Actual.charAt(i - 6) == 'E' || linea_Actual.charAt(i - 6) == 'e')
                        && (linea_Actual.charAt(i - 7) == 'L' || linea_Actual.charAt(i - 7) == 'l')
                        && (linea_Actual.charAt(i - 8) == 'E' || linea_Actual.charAt(i - 8) == 'e')
                        && (linea_Actual.charAt(i - 9) == 'T' || linea_Actual.charAt(i - 9) == 't')) {
                    temp = 1;
                }
            }

            if (temp == 1) {
                if (linea_Actual.charAt(i + 1) != '.') {//fin de impresion
                    resultado_Telefono = resultado_Telefono + linea_Actual.charAt(i + 1);
                    //System.out.print(linea_Actual.charAt(i + 1));
                } else {
                    temp = 0;
                    System.out.print(' ');
                }
            }
        }
        return resultado_Telefono;
    }

    public static String busca_Direccion(String linea_Actual) {
        for (int i = 0; i < linea_Actual.length(); i++) {
            if (linea_Actual.charAt(i) == ' ') {
                if (i == 0) {
                    temp = 1;
                }//estructura que se debe de cumplir
                else if (linea_Actual.charAt(i) == ' ' && linea_Actual.charAt(i - 1) == ':'
                        && (linea_Actual.charAt(i - 2) == 'N' || linea_Actual.charAt(i - 2) == 'n')
                        && (linea_Actual.charAt(i - 3) == 'O' || linea_Actual.charAt(i - 3) == 'o')
                        && (linea_Actual.charAt(i - 4) == 'I' || linea_Actual.charAt(i - 4) == 'i')
                        && (linea_Actual.charAt(i - 5) == 'C' || linea_Actual.charAt(i - 5) == 'c')
                        && (linea_Actual.charAt(i - 6) == 'C' || linea_Actual.charAt(i - 6) == 'c')
                        && (linea_Actual.charAt(i - 7) == 'E' || linea_Actual.charAt(i - 7) == 'e')
                        && (linea_Actual.charAt(i - 8) == 'R' || linea_Actual.charAt(i - 8) == 'r')
                        && (linea_Actual.charAt(i - 9) == 'I' || linea_Actual.charAt(i - 9) == 'i')
                        && (linea_Actual.charAt(i - 10) == 'D' || linea_Actual.charAt(i - 10) == 'd')) {
                    temp = 1;
                }
            }

            if (temp == 1) {
                if (linea_Actual.charAt(i + 1) != '.') {//fin de impresion
                    resultado_Direccion = resultado_Direccion + linea_Actual.charAt(i + 1);
                    //System.out.print(linea_Actual.charAt(i + 1));
                } else {
                    temp = 0;
                    System.out.print(' ');
                }
            }
        }
        return resultado_Direccion;
    }

    public static String busca_FechaConsulta(String linea_Actual) {
        for (int i = 0; i < linea_Actual.length(); i++) {
            if (linea_Actual.charAt(i) == ' ') {
                if (i == 0) {
                    temp = 1;
                }//estructura que se debe de cumplir
                else if (linea_Actual.charAt(i) == ' ' && linea_Actual.charAt(i - 1) == ':'
                        && (linea_Actual.charAt(i - 2) == 'A' || linea_Actual.charAt(i - 2) == 'a')
                        && (linea_Actual.charAt(i - 3) == 'T' || linea_Actual.charAt(i - 3) == 't')
                        && (linea_Actual.charAt(i - 4) == 'L' || linea_Actual.charAt(i - 4) == 'l')
                        && (linea_Actual.charAt(i - 5) == 'U' || linea_Actual.charAt(i - 5) == 'u')
                        && (linea_Actual.charAt(i - 6) == 'S' || linea_Actual.charAt(i - 6) == 's')
                        && (linea_Actual.charAt(i - 7) == 'N' || linea_Actual.charAt(i - 7) == 'n')
                        && (linea_Actual.charAt(i - 8) == 'O' || linea_Actual.charAt(i - 8) == 'o')
                        && (linea_Actual.charAt(i - 9) == 'C' || linea_Actual.charAt(i - 9) == 'c')) {
                    temp = 1;
                }
            }

            if (temp == 1) {
                if (linea_Actual.charAt(i + 1) != '.') {//fin de impresion
                    resultado_FechaConsulta = resultado_FechaConsulta + linea_Actual.charAt(i + 1);
                    //System.out.print(linea_Actual.charAt(i + 1));
                } else {
                    temp = 0;
                    System.out.print(' ');
                }
            }
        }
        return resultado_FechaConsulta;
    }

    public static String busca_Sala(String linea_Actual) {
        for (int i = 0; i < linea_Actual.length(); i++) {
            if (linea_Actual.charAt(i) == ' ') {
                if (i == 0) {
                    temp = 1;
                }//estructura que se debe de cumplir
                else if (linea_Actual.charAt(i) == ' ' && linea_Actual.charAt(i - 1) == ':'
                        && (linea_Actual.charAt(i - 2) == 'A' || linea_Actual.charAt(i - 2) == 'a')
                        && (linea_Actual.charAt(i - 3) == 'L' || linea_Actual.charAt(i - 3) == 'l')
                        && (linea_Actual.charAt(i - 4) == 'A' || linea_Actual.charAt(i - 4) == 'a')
                        && (linea_Actual.charAt(i - 5) == 'S' || linea_Actual.charAt(i - 5) == 's')) {
                    temp = 1;
                }
            }

            if (temp == 1) {
                if (linea_Actual.charAt(i + 1) != '.') {//fin de impresion
                    resultado_Sala = resultado_Sala + linea_Actual.charAt(i + 1);
                    //System.out.print(linea_Actual.charAt(i + 1));
                } else {
                    temp = 0;
                    System.out.print(' ');
                }
            }
        }
        return resultado_Sala;
    }

    public static String busca_Edad(String linea_Actual) {
        for (int i = 0; i < linea_Actual.length(); i++) {
            if (linea_Actual.charAt(i) == ' ') {
                if (i == 0) {
                    temp = 1;
                }//estructura que se debe de cumplir
                else if (linea_Actual.charAt(i) == ' ' && linea_Actual.charAt(i - 1) == ':'
                        && (linea_Actual.charAt(i - 2) == 'D' || linea_Actual.charAt(i - 2) == 'd')
                        && (linea_Actual.charAt(i - 3) == 'A' || linea_Actual.charAt(i - 3) == 'a')
                        && (linea_Actual.charAt(i - 4) == 'D' || linea_Actual.charAt(i - 4) == 'd')
                        && (linea_Actual.charAt(i - 5) == 'E' || linea_Actual.charAt(i - 5) == 'e')) {
                    temp = 1;
                }
            }

            if (temp == 1) {
                if (linea_Actual.charAt(i + 1) != '.') {//fin de impresion
                    resultado_Edad = resultado_Edad + linea_Actual.charAt(i + 1);
                    //System.out.print(linea_Actual.charAt(i + 1));
                } else {
                    temp = 0;
                    System.out.print(' ');
                }
            }
        }
        return resultado_Edad;
    }

    public static String busca_Nombre(String linea_Actual) {
        for (int i = 0; i < linea_Actual.length(); i++) {
            //Posicion apartir de la cual se va a imprimir
            if (linea_Actual.charAt(i) == ' ') {
                if (i == 0) {
                    temp = 1;
                }//estructura que se debe de cumplir
                else if (linea_Actual.charAt(i) == ' ' && linea_Actual.charAt(i - 1) == ':'
                        && (linea_Actual.charAt(i - 2) == 'E' || linea_Actual.charAt(i - 2) == 'e')
                        && (linea_Actual.charAt(i - 3) == 'R' || linea_Actual.charAt(i - 3) == 'r')
                        && (linea_Actual.charAt(i - 4) == 'B' || linea_Actual.charAt(i - 4) == 'b')
                        && (linea_Actual.charAt(i - 5) == 'M' || linea_Actual.charAt(i - 5) == 'm')
                        && (linea_Actual.charAt(i - 6) == 'O' || linea_Actual.charAt(i - 6) == 'o')
                        && (linea_Actual.charAt(i - 7) == 'N' || linea_Actual.charAt(i - 7) == 'n')) {

                    temp = 1;
                }
            }

            if (temp == 1) {
                if (linea_Actual.charAt(i + 1) != '.') {//fin de impresion
                    resultado_Nombre = resultado_Nombre + linea_Actual.charAt(i + 1);
                    //System.out.print(linea_Actual.charAt(i + 1));
                } else {
                    temp = 0;
                    System.out.print(' ');
                }
            }

        }
        return resultado_Nombre;
    }


}
