/*
 * @fileoverview    {RegexConcat}
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
package com.project.dev.regexitem;

/**
 * TODO: Description of {@code RegexConcat}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class RegexConcat extends RegexItem {

    /**
     * TODO: Description of {@code RegexConcat}.
     *
     * @param code   indica el codigo del RegexItem.
     * @param father indica el padre del RegexItem.
     */
    public RegexConcat(int code, RegexItem father) {
        this.setCode(code);                                                     // Asigna codigo al RegexItem actual.
        this.setType("Concat");                                                 // Asigna tipo al RegexItem actual.
        this.setValue(".");                                                     // Asigna valor al RegexItem actual.
        this.setKleeneType(0);                                                  // Asigna tipo de clausura de kleene al RegexItem actual.

        this.setFather(father);                                                 // Asigna padre al RegexItem.

        if (father != null) {                                                   // Si si especifica un padre para el RegexItem.
            this.setLevel(father.getLevel() + 1);                               // Asigna al RegexItem el nivel del padre mas uno.
            this.setPrev(father.getLastChild());                                // Asigna como anterior hermano el ultimo hijo del padre.

            if (father.getFirstChild() == null)                                 // Si el padre no tiene hijos.
                father.setFirstChild(this);                                     // Indica que el RegexItem actual es el primer hijo.
            else                                                                // Si el padre si tiene hijos.
                father.getLastChild().setNext(this);                            // Indica que el RegexItem actual es ahora el siguiente hermano del ultimo hijo.

            father.setLastChild(this);                                          // Indica que el RegexItem actual es ahora el ultimo hijo.
        }
    }

    /**
     * FIXME: Description of {@code printDebugRegexItem}. Imprime el RegexItem con informacion
     * detallada.
     *
     * @param maxLevel es el maximo nivel dentro de la expresion regular a la que pertenece el
     *                 RegexItem actual.
     */
    @Override
    public void printDebugRegexItem(int maxLevel) {
        for (int i = 0; i < getLevel(); i++)
            System.out.print("           ");

        System.out.printf("(%8s) (%8s) (%8s) (%8s)", getFather(), this, getPrev(), getNext());

        for (int i = 0; i < maxLevel - getLevel(); i++)
            System.out.print("           ");

        System.out.printf("  '%6s' '%s'\n", getType(), getValue());
    }

    /**
     * FIXME: Description of {@code printThompsonRegexItem}. Imprime el valor del RegexItem actual y
     * la contruccion de Thompson asociada.
     *
     * @param maxLevel    es el maximo nivel dentro de la expresion regular a la que pertenece el
     *                    RegexItem actual.
     * @param tabs        Es la cantidad de espacios que se escribiran antes del valor del
     *                    RegexItem.
     * @param endSpaces   Es la cantidad de espacios luego de imprimir el valor del RegexItem.
     * @param isOpen      indica si se escribira el valor de cerradura o de apertura del RegexItem
     *                    actual.
     * @param printChilds indica si tambien se imprimiran los hijos del RegexItem acual y sus
     *                    respectivas construcciones de Thompson.
     */
    @Override
    public void printThompsonRegexItem(int maxLevel, int tabs, int endSpaces, boolean isOpen, boolean printChilds) {
        String openValue = getValue().concat(" ");
        String toPrint = getValueToprint(openValue, maxLevel, tabs, endSpaces);
        System.out.print(toPrint);
        printThompsonConstruction();
    }
}
