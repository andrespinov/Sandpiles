package sandpiles;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTable;

public class Sandpile extends javax.swing.JFrame {

    JTable sandpile;

    public Sandpile() {
        initComponents();

        int size = 30;
        String[][] entradas = new String[size][size];
        String[] nombres = new String[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                entradas[i][j] = "0";
            }
            nombres[i] = "0";
        }
        sandpile = new JTable(entradas, nombres);
        sandpile.setSize(600, 600);
        sandpile.setDefaultRenderer(Object.class, new Render());
        this.add(sandpile);

        sandpile.setValueAt("94145", size/2, size/2);
        Cola cola = new Cola();
        Pos celda = new Pos(size/2, size/2);
        cola.encolar(celda);

//        while (!cola.esVacia()) {
//            celda = (Pos) cola.desencolar();
//            int i = celda.getI();
//            int j = celda.getJ();
//            int valor = Integer.parseInt((String) sandpile.getValueAt(i, j));
//            if (valor > 3) {
//                valor = valor - 4;
//                sandpile.setValueAt(String.valueOf(valor), i, j);
//                if (valor > 3) {
//                    cola.encolar(new Pos(i, j));
//                }
//                if (i > 0) {
//                    valor = Integer.parseInt((String) sandpile.getValueAt(i - 1, j));
//                    valor = valor + 1;
//                    if (valor > 3) {
//                        cola.encolar(new Pos(i - 1, j));
//                    }
//                    sandpile.setValueAt(String.valueOf(valor), i - 1, j);
//                }
//                if (i < size - 1) {
//                    valor = Integer.parseInt((String) sandpile.getValueAt(i + 1, j));
//                    valor = valor + 1;
//                    if (valor > 3) {
//                        cola.encolar(new Pos(i + 1, j));
//                    }
//                    sandpile.setValueAt(String.valueOf(valor), i + 1, j);
//                }
//                if (j > 0) {
//                    valor = Integer.parseInt((String) sandpile.getValueAt(i, j - 1));
//                    valor = valor + 1;
//                    if (valor > 3) {
//                        cola.encolar(new Pos(i, j - 1));
//                    }
//                    sandpile.setValueAt(String.valueOf(valor), i, j - 1);
//                }
//                if (j < size - 1) {
//                    valor = Integer.parseInt((String) sandpile.getValueAt(i, j + 1));
//                    valor = valor + 1;
//                    if (valor > 3) {
//                        cola.encolar(new Pos(i, j + 1));
//                    }
//                    sandpile.setValueAt(String.valueOf(valor), i, j + 1);
//                }
//            }
//        }

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                if(cola.esVacia()){
                    System.out.println("vacia");
                    timer.cancel();
                }else{
                    Pos celda = (Pos)cola.desencolar();
                    int i = celda.getI();
                    int j = celda.getJ();
                    int valor = Integer.parseInt((String)sandpile.getValueAt(i, j));
                    if(valor > 3){
                        valor = valor - 4;
                        sandpile.setValueAt(String.valueOf(valor), i, j);
                        if(valor > 3){
                            cola.encolar(new Pos(i,j));
                        }
                        if(i > 0){
                            valor = Integer.parseInt((String)sandpile.getValueAt(i - 1, j));
                            valor = valor + 1;
                            if(valor > 3){
                                cola.encolar(new Pos(i - 1, j));
                            }
                            sandpile.setValueAt(String.valueOf(valor), i - 1, j);
                        }
                        if(i < size - 1){
                            valor = Integer.parseInt((String)sandpile.getValueAt(i + 1, j));
                            valor = valor + 1;
                            if(valor > 3){
                                cola.encolar(new Pos(i + 1, j));
                            }
                            sandpile.setValueAt(String.valueOf(valor), i + 1, j);
                        }
                        if(j > 0){
                            valor = Integer.parseInt((String)sandpile.getValueAt(i, j - 1));
                            valor = valor + 1;
                            if(valor > 3){
                                cola.encolar(new Pos(i, j - 1));
                            }
                            sandpile.setValueAt(String.valueOf(valor), i, j - 1);
                        }
                        if(j < size - 1){
                            valor = Integer.parseInt((String)sandpile.getValueAt(i, j + 1));
                            valor = valor + 1;
                            if(valor > 3){
                                cola.encolar(new Pos(i, j + 1));
                            }
                            sandpile.setValueAt(String.valueOf(valor), i, j + 1);
                        }
                    }
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
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
    // End of variables declaration//GEN-END:variables
}
