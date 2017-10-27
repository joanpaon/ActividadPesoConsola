/* 
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Constantes
        final int PESO_MIN = 1;
        final int PESO_MAX = 10;
        final int NUM_DIAS = 7;

        // Locale ---> Reales con punto
        Locale lcl = new Locale("EN", "uk");

        // Scanner --- > Entrada de acentos con Windows
        Scanner scn = new Scanner(System.in, "ISO-8859-1");
        scn.useLocale(lcl);

        // Variables
        double acumulador = 0;
        double peso = 0;

        // Cabecera
        System.out.println("CONTROL SEMANAL DE PESO");
        System.out.println("=======================");
        
        // Turno Persona
        for (int dia = 0; dia < NUM_DIAS; dia++) {
            // Validación de Piso
            boolean pesoOK = true;
            do {
                // Selección Piso
                boolean entradaOK = true;
                do {
                    try {
                        // Nombre dia
                        String nombre = "indefinido";
                        switch (dia + 1) {
                            case 1:
                                nombre = "lunes";
                                break;
                            case 2:
                                nombre = "martes";
                                break;
                            case 3:
                                nombre = "miércoles";
                                break;
                            case 4:
                                nombre = "jueves";
                                break;
                            case 5:
                                nombre = "viernes";
                                break;
                            case 6:
                                nombre = "sábado";
                                break;
                            case 7:
                                nombre = "domingo";
                        }

                        // Mensaje de entrada
                        System.out.printf("[ %-9s ] - Peso .: ", nombre);

                        // Entrada dato
                        peso = scn.nextDouble();

                        // Entrada Correcta
                        entradaOK = false;
                    } catch (Exception e) {
                        // Entrada incorrecta
                        System.out.println("ERROR: Entrada Incorrecta");
                    } finally {
                        // Vaciar buffer
                        scn.nextLine();
                    }
                } while (entradaOK);

                // Validar Peso
                pesoOK = peso >= PESO_MIN && peso <= PESO_MAX;
                if (!pesoOK) {
                    System.out.println("ERROR: Valor de peso incorrecto");
                }
            } while (!pesoOK);

            // Acumular Peso
            acumulador += peso;
        }

        // Peso Medio
        System.out.println("---");
        System.out.printf(lcl, "Peso medio semanal ...: %.2f Kg\n", acumulador / 7);
    }
}
