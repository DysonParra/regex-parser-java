/*
 * @fileoverview    {InputSymbol}
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
package com.project.dev.thompson.construction;

import com.project.dev.regexitem.RegexItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * TODO: Description of {@code InputSymbol}.
 *
 * @author Dyson Parra
 * @since 11
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"regexItem", "prevState", "nextState"})
public class InputSymbol {

    @NonNull
    private Integer code;                                   // Codigo del simbolo actual.
    private boolean backSymbol;                             // Si el simbolo se utiliza para devolverse.
    @NonNull
    private RegexItem regexItem;                            // Valor del simbolo actual.
    private State prevState;                                // Anterior estado de este simbolo.
    private State nextState;                                // Siguiente estado de este simbolo.

    /**
     * Obtiene el valor en {String} del objeto actual.
     *
     * @return un {String} con la representación del objeto.
     */
    @Override
    public String toString() {
        return Integer.toHexString(hashCode());
    }

    /**
     * FIXME: Description of {@code printSymbolDebug}. Imprime el simbolo y el estado al que lleva
     * con informacion detallada.
     */
    public void printSymbolDebug() {
        System.out.printf("[%2s][%8s][%8s]---> ", code, this, regexItem);
        nextState.printStateDebug(backSymbol);
    }

    /**
     * FIXME: Description of {@code printSymbol}. Imprime el simbolo y el estado al que leva.
     */
    public void printSymbol() {
        System.out.printf("[%2s][%s]---> ", code, regexItem.getValue());
        nextState.printState(backSymbol);
    }
}
