/*
 * @fileoverview    {ThompsonUnion}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.thompson.construction.type;

import com.project.dev.regexitem.RegexItem;
import com.project.dev.thompson.construction.State;
import com.project.dev.thompson.construction.ThompsonConstruction;

/**
 * TODO: Description of {@code ThompsonUnion}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class ThompsonUnion extends ThompsonConstruction {

    /**
     * TODO: Description of {@code ThompsonUnion}.
     *
     * @param codes  indica el codigo actual de cada estado y de cada simbolo a crear.
     * @param groupU es un RegexItem de tipo union.
     */
    public ThompsonUnion(int[] codes, RegexItem groupU) {
        setType("Union");                                                       // Indica el tipo de construccion de Thompson que es.
        setRegexItem(groupU);                                                   // Indica el regxItem asociado a la construccion de Thompson.
        setStateQuantity(5);                                                    // Indica la cantidad de estados de la construccion de Thompson.

        RegexItem aux = groupU.getFirstChild();                                 // Obtiene el primer grupo del regexItem de tipo union.

        ThompsonConstruction first = new ThompsonNullSymbol(codes);             // Crea simbolo nulo de Thompson.
        codes[0]--;                                                             // Reduce el numero de codigo del proximo estado.
        ThompsonConstruction second = new ThompsonSymbol(codes, aux);           // Crea simbolo de Thompson.
        codes[0]--;                                                             // Reduce el numero de codigo del proximo estado.
        ThompsonConstruction third = new ThompsonNullSymbol(codes);             // Crea simbolo nulo de Thompson.
        codes[0]--;                                                             // Reduce el numero de codigo del proximo estado.
        ThompsonConstruction fouth = new ThompsonNullSymbol(codes);             // Crea simbolo nulo de Thompson.

        setFirstState(first.getFirstState());                                   // Indica cual es el primer estado de la construccion de Thompson.
        setLastState(fouth.getLastState());                                     // Indica cual es el ultimo estado de la construccion de Thompson.

        State prevLast = third.getLastState();                                  // Obtiene el ultimo estado de third.

        first.concat(second);                                                   // Concatena first y second.
        first.concat(third);                                                    // Concatena first y third.
        first.concat(fouth);                                                    // Concatena first y fouth.

        aux = aux.getNext();                                                    // Obtiene el siguiente grupo.

        while (aux != null) {                                                   // Recorre los grupos.
            codes[0]--;                                                         // Reduce el numero de codigo del proximo estado.
            ThompsonConstruction one = new ThompsonNullSymbol(codes);           // Crea simbolo nulo de Thompson.
            codes[0]--;                                                         // Reduce el numero de codigo del proximo estado.
            ThompsonConstruction two = new ThompsonSymbol(codes, aux);          // Crea simbolo de Thompson.
            codes[0] -= 2;                                                      // Reduce el numero de codigo del proximo estado.
            ThompsonConstruction three = new ThompsonNullSymbol(codes);         // Crea simbolo nulo de Thompson.

            one.concat(two);                                                    // Concatena one y two.
            one.concat(three);                                                  // Concatena one y three.

            prevLast.merge(one.getLastState());                                 // Combina prevLast y el ultimo estado de one.
            first.getFirstState().merge(one.getFirstState());                   // Combina el primer estado de first con el primero de one.
            setStateQuantity(getStateQuantity() + 2);                           // Actualiza la cantiad de estados de la construccion de Thompson.

            aux = aux.getNext();                                                // Obtiene el siguiente grupo.
        }
    }
}
