package sandpiles;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTable;

public class Sandpile extends javax.swing.JFrame {

    JTable sandpile;
    Cola cola = new Cola();

    public Sandpile() {
        initComponents();

        int size = 80;
        String[][] entradas = new String[size][size];
        String[] nombres = new String[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                entradas[i][j] = "0";
            }
            nombres[i] = "0";
        }
        sandpile = new JTable(entradas, nombres);
        sandpile.setSize(16 * size, 16 * size);
        sandpile.setDefaultRenderer(Object.class, new Render());
        panel.add(sandpile);
//        JScrollPane scroll = new JScrollPane(sandpile, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        panel.add(scroll);
        sandpile.setValueAt("7507", size / 2, size / 2);
        Pos celda = new Pos(size / 2, size / 2);
        cola.encolar(celda);

        boolean deseaVerGenerarElSandPile = false;
        boolean quePierdaArena = true;

        if (deseaVerGenerarElSandPile) {
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    if (cola.esVacia()) {
                        timer.cancel();
                    } else {
                        Pos celda = (Pos) cola.desencolar();
                        int i = celda.getI();
                        int j = celda.getJ();
                        int aux;
                        int valor = Integer.parseInt((String) sandpile.getValueAt(i, j));
                        if (valor > 3) {
                            aux = valor % 4;
                            sandpile.setValueAt(String.valueOf(aux), i, j);
                            aux = (valor - aux) / 4;
                            if (i > 0) {
                                evaluar(aux, i - 1, j);
                            } else if (!quePierdaArena) {
                                evaluar(aux, size - 1, j);
                            }
                            if (i < size - 1) {
                                evaluar(aux, i + 1, j);
                            } else if (!quePierdaArena) {
                                evaluar(aux, 0, j);
                            }
                            if (j > 0) {
                                evaluar(aux, i, j - 1);
                            } else if (!quePierdaArena) {
                                evaluar(aux, i, size - 1);
                            }
                            if (j < size - 1) {
                                evaluar(aux, i, j + 1);
                            } else if (!quePierdaArena) {
                                evaluar(aux, i, 0);
                            }
                        }
                    }
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, 1);
        } else {
            while (!cola.esVacia()) {
                celda = (Pos) cola.desencolar();
                int i = celda.getI();
                int j = celda.getJ();
                int aux;
                int valor = Integer.parseInt((String) sandpile.getValueAt(i, j));
                if (valor > 3) {
                    aux = valor % 4;
                    sandpile.setValueAt(String.valueOf(aux), i, j);
                    aux = (valor - aux) / 4;
                    if (i > 0) {
                        evaluar(aux, i - 1, j);
                    } else if (!quePierdaArena) {
                        evaluar(aux, size - 1, j);
                    }
                    if (i < size - 1) {
                        evaluar(aux, i + 1, j);
                    } else if (!quePierdaArena) {
                        evaluar(aux, 0, j);
                    }
                    if (j > 0) {
                        evaluar(aux, i, j - 1);
                    } else if (!quePierdaArena) {
                        evaluar(aux, i, size - 1);
                    }
                    if (j < size - 1) {
                        evaluar(aux, i, j + 1);
                    } else if (!quePierdaArena) {
                        evaluar(aux, i, 0);
                    }
                }
            }
        }

    }

    public void evaluar(int aux, int i, int j) {
        int valor = Integer.parseInt((String) sandpile.getValueAt(i, j));
        valor = valor + aux;
        if (valor > 3) {
            cola.encolar(new Pos(i, j));
        }
        sandpile.setValueAt(String.valueOf(valor), i, j);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sandpile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
