/*
 * @fileoverview    {CellModel}
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
package com.project.dev.automat.operation;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * TODO: Description of {@code CellModel}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class CellModel extends DefaultTableCellRenderer {

    /**
     * TODO: Description of {@code setHorizontalAlignment}.
     *
     * @param i
     */
    @Override
    public void setHorizontalAlignment(int i) {
        super.setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * FIXME: Description of {@code getTableCellRendererComponent}. Declara un componente con el
     * CellRenderer de la tabla.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        // Crea un componente con el CellRenderer de la tabla.
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Evalua si el tipo de dato de la celda es entero.
        if (value instanceof String) {
            String valor = (String) value;  // A valor le lleva lo que tiene la cada una de las celdas.

            // Evalua si esta en los estados o simbolos de entrada.
            if (row == 0 || column == 0) {
                // Colorea el fondo de la celda, y la letra.
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.black);
            } // Evalua si el valor en esa celda es "" (estado de error).
            else if (valor.isEmpty()) {
                // Colorea el fondo de la celda, y la letra.
                cell.setBackground(Color.red);
                cell.setForeground(Color.yellow);
            } // Evalua si no es estado de error ni simbolo de entrada ni estado de entrada.
            else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.black);
            }
        }

        /*
         * -
         * // Evalua si la celda se puede editar. //if (table.isCellEditable(row, column) == true)
         * { // Colorea el fondo de la celda, y la letra. cell.setBackground(Color.white);
         * //cell.setForeground(Color.black); }
         */
        // Devuelve la celda.
        return cell;
    }
}
