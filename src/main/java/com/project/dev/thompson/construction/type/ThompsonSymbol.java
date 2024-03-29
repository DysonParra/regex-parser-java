/*
 * @fileoverview    {ThompsonSymbol}
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
import com.project.dev.thompson.construction.InputSymbol;
import com.project.dev.thompson.construction.State;
import com.project.dev.thompson.construction.ThompsonConstruction;

/**
 * TODO: Description of {@code ThompsonSymbol}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class ThompsonSymbol extends ThompsonConstruction {

    /**
     * TODO: Description of {@code ThompsonSymbol}.
     *
     * @param codes       indica el codigo actual de cada estado y de cada simbolo a crear.
     * @param regexSymbol indica el regexSymbol asociado al simbolo de la construccion de Thompson.
     */
    public ThompsonSymbol(int[] codes, RegexItem regexSymbol) {
        setType("Symbol");                                                      // Indica el tipo de construccion de Thompson que es.
        setRegexItem(regexSymbol);                                              // Indica el regxItem asociado a la construccion de Thompson.
        setStateQuantity(2);                                                    // Indica la cantidad de estados de la construccion de Thompson.

        State state1 = State.builder()
                .code(++codes[0])
                .build();
        InputSymbol symbol1 = InputSymbol.builder()
                .code(++codes[1])
                .backSymbol(false)
                .regexItem(regexSymbol)
                .build();
        State state2 = State.builder()
                .code(++codes[0])
                .build();

        state1.addNextSymbol(symbol1.getCode(), symbol1);                       // Indica que desde state1 se puede llegar a symbol1.
        symbol1.setPrevState(state1);                                           // Indica que a symbol1 se llega desde state1.
        symbol1.setNextState(state2);                                           // Indica que desde symbol1 se llega a state2.
        state2.addPrevSymbol(symbol1.getCode(), symbol1);                       // Indica que a state2 se puede llegar desde symbol1.

        setFirstState(state1);                                                  // Indica cual es el primer estado de la construccion de Thompson.
        setLastState(state2);                                                   // Indica cual es el ultimo estado de la construccion de Thompson.

        regexSymbol.setSymbol(symbol1);                                         // indica que symbol1 es el simbolo de regexSymbol.
    }
}
