/*
 * @fileoverview {FileName} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {FileName} fue realizada el 31/07/2022.
 * @Dev - La primera version de {FileName} fue escrita por Dyson A. Parra T.
 */
package com.project.dev.thompson.operation;

import com.project.dev.thompson.construction.InputSymbol;
import com.project.dev.thompson.construction.State;
import com.project.dev.thompson.construction.ThompsonConstruction;
import com.project.dev.thompson.construction.Transition;
import java.util.Map;

/**
 * TODO: Definición de {@code ThompsonPrinter}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class ThompsonPrinter {

    /**
     * FIXME: Definición de {@code printThompsonConstruction}. Imprime la una construccion de
     * Thompson.
     *
     * @param root               es la construccion de thompson a imprimir.
     * @param printStateQuantity indica si imprime la cantidad de estados.
     */
    public static void printThompsonConstruction(ThompsonConstruction root, boolean printStateQuantity) {
        if (printStateQuantity)                                                  // Si se indico imprimir la cantidad de estados.
            System.out.printf("{%d}\n", root.getStateQuantity());               // Imprime la cantidad de estados.
        root.getFirstState().printState(false);                                 // Imprime la construccion de Thompson acctual.
    }

    /**
     * FIXME: Definición de {@code printNextStates}. Imprime desde un estado cada estado a los
     * cuales es posible llegar
     *
     * @param states es el array con los estados de una construccion de thompson.
     */
    public static void printNextStates(State[] states) {
        InputSymbol nextSymbol;
        State nextState;

        for (State state : states) {                                                            // Recorre el array con los estados.
            System.out.printf("(%s)\n", state.getCode());
            for (Map.Entry<Integer, InputSymbol> entry : state.getNextSymbols().entrySet()) {   // Recorre los cierres lamda del estado actual.
                nextSymbol = entry.getValue();
                nextState = nextSymbol.getNextState();
                System.out.printf("(%s)--[%s]--> (%s)\n", state.getCode(), nextSymbol.getRegexItem().getValue(), nextState.getCode());
            }
            System.out.println("");
        }
    }

    /**
     * FIXME: Definición de {@code printTransition}. Imprime una transicion.
     *
     * @param transition es la trancision.
     */
    public static void printTransition(Transition transition) {
        //System.out.printf("'%s'\n\n", transition.getCode());

        System.out.printf("%s", transition.getStartStatesString());
        System.out.printf("\n[%s]\n", transition.getSymbol());
        System.out.printf("%s", transition.getEndStatesString());
        System.out.println("");
    }

    /**
     * FIXME: Definición de {@code printTransitions}. Imprime un array de transiciones.
     *
     * @param transitions es el array con las trancisiones.
     */
    public static void printTransitions(Transition[] transitions) {
        for (int i = 0; i < transitions.length; i++) {
            printTransition(transitions[i]);

            if (i != transitions.length - 1)
                System.out.println("");
        }
    }

    /**
     * FIXME: Definición de {@code printInputSymbols}. Imprime los simbolos de entrada de una
     * construccion de thompson.
     *
     * @param inputSymbols son los simbolos de entrada de la construccion de thompson.
     */
    public static void printInputSymbols(Map<String, String> inputSymbols) {
        String symbol;
        System.out.println("Input symbols:");
        for (Map.Entry<String, String> entry : inputSymbols.entrySet()) {
            symbol = entry.getKey();
            System.out.printf("'%s' ", symbol);
        }
        System.out.println("");
    }
}