package sandpiles;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable tabla, Object entrada, boolean isSelected, boolean hasFocus, int i, int j) {
        JLabel celda = (JLabel) super.getTableCellRendererComponent(tabla, entrada, isSelected, hasFocus, i, j);
        if (Integer.parseInt((String) entrada) < 0) {
            celda.setBackground(Color.BLACK);
            celda.setForeground(Color.BLACK);
        } else {
            switch (Integer.parseInt((String) entrada)) {
                case 0:
                    celda.setBackground(Color.BLUE);
                    celda.setForeground(Color.BLUE);
                    break;
                case 1:
                    celda.setBackground(Color.GREEN);
                    celda.setForeground(Color.GREEN);
                    break;
                case 2:
                    celda.setBackground(Color.YELLOW);
                    celda.setForeground(Color.YELLOW);
                    break;
                case 3:
                    celda.setBackground(Color.RED);
                    celda.setForeground(Color.RED);
                    break;
                default:
                    celda.setBackground(Color.BLACK);
                    celda.setForeground(Color.BLACK);
                    break;
            }
        }
        return celda;
    }
}