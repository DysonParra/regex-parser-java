/*
 * @fileoverview    {Automat}
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
package com.project.dev.automat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Description of {@code Automat}.
 *
 * @author Dyson Parra
 * @since 11
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Automat {

    /* Codigo del automata */
    private String code;
    /* Estados del automata */
    @Builder.Default
    private ArrayList<Status> statuses = new ArrayList<>();
    /* Simbolos de entrada */
    @Builder.Default
    private Map<String, String> inputSymbols = new HashMap<>();
    /* Caracter de fin de secuencia */
    private String endSequence;
    /* Caracter de secuencia nula */
    private String nullSequence;

    /**
     * TODO: Description of {@code getEndSequenceChar}.
     *
     * @return
     */
    public char getEndSequenceChar() {
        return endSequence.charAt(0);
    }

    /**
     * TODO: Description of {@code getNullSequenceChar}.
     *
     * @return
     */
    public char getNullSequenceChar() {
        return nullSequence.charAt(0);
    }

}
