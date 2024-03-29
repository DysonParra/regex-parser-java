/*
 * @fileoverview    {Status}
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

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Description of {@code Status}.
 *
 * @author Dyson Parra
 * @since 11
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Status {

    /* Codigo del estado actual */
    private String code;
    /* Si es posible terminar la lectura en el estado actual */
    private boolean endStatus;
    /* Hacia cuales estados se puede llegar desde este */
    @Builder.Default
    private Map<String, Status> nextStatuses = new HashMap<>();

    /**
     * TODO: Description of {@code addNextStatus}.
     *
     * @param symbol
     * @param status
     */
    public void addNextStatus(String symbol, Status status) {
        this.nextStatuses.put(symbol, status);
    }

    /**
     * TODO: Description of {@code addNextStatus}.
     *
     * @param statuses
     */
    public void addNextStatus(Map<String, Status> statuses) {
        statuses.entrySet().stream().forEach((entry) -> {
            this.nextStatuses.put(entry.getKey(), entry.getValue());
        });
    }

    /**
     * Obtiene el valor en {String} del objeto actual.
     *
     * @return un {String} con la representación del objeto.
     */
    @Override
    public String toString() {
        return code;
    }

    /**
     * TODO: Description of {@code getSimpleValue}.
     *
     * @return
     */
    public String getSimpleValue() {
        return "Status{" + "code=" + code + ", accept=" + endStatus + '}';
    }

    /**
     * TODO: Description of {@code simplePrint}.
     *
     */
    public void simplePrint() {
        System.out.println(getSimpleValue());
    }

    /**
     * TODO: Description of {@code print}.
     *
     * @param recursive
     * @param spaces
     */
    public void print(boolean recursive, int spaces) {

        if (recursive)
            for (int i = 0; i < spaces; i++)
                System.out.print(" ");
        simplePrint();
        if (recursive) {
            for (Map.Entry<String, Status> entry : nextStatuses.entrySet()) {
                for (int i = 0; i < spaces; i++)
                    System.out.print(" ");
                System.out.print("   " + entry.getKey() + " --> ");
                entry.getValue().print(false, spaces);
            }
            System.out.println("");
        }
    }
}
