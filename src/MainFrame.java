import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;

        /*  AUTHORS : Enes ÇAKİR - Selçuk ÖZDEMİR */


public class MainFrame extends javax.swing.JFrame {

    String cevap = "π = { ";

    int x, y;
    JButton[][] buttons;
    JLabel labelX[], labelY[];

    public MainFrame() {
        initComponents();
        this.setTitle("Kapsama Problemi");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ySpinner = new javax.swing.JSpinner();
        xSpinner = new javax.swing.JSpinner();
        OlusturButton = new javax.swing.JButton();
        hesaplaButton = new javax.swing.JButton();
        cevapText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("y : ");

        jLabel2.setText("x : ");

        OlusturButton.setText("Create");
        OlusturButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OlusturButtonActionPerformed(evt);
            }
        });

        hesaplaButton.setText("Calculate");
        hesaplaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hesaplaButtonActionPerformed(evt);
            }
        });

        cevapText.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ySpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(xSpinner))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cevapText, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hesaplaButton))
                    .addComponent(OlusturButton))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OlusturButton))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(xSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cevapText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesaplaButton))
                .addContainerGap(362, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OlusturButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OlusturButtonActionPerformed
        x = (Integer) (xSpinner.getValue());
        y = (Integer) (ySpinner.getValue());
        labelX = new JLabel[x];
        labelY = new JLabel[y];
        buttons = new JButton[y][x];
        Action action = new Action();

        // x label
        for (int i = 0; i < x; i++) {
            labelX[i] = new JLabel();
            labelX[i].setText(String.valueOf(i + 1));
            labelX[i].setBounds(62 + i * 50, 156, 15, 15);
            labelX[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            this.add(labelX[i]);
        }

        // y label
        for (int i = 0; i < y; i++) {
            labelY[i] = new JLabel();
            labelY[i].setText(String.valueOf(i + 1));
            labelY[i].setBounds(25, i * 50 + 185, 15, 15);
            labelY[i].setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            this.add(labelY[i]);
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setText(String.valueOf(" "));
                buttons[i][j].setBounds(45 + j * 50, i * 50 + 170, 50, 50);
                buttons[i][j].addActionListener(action);
                this.add(buttons[i][j]);
            }
        }
        OlusturButton.setVisible(false);

        this.update(this.getGraphics());
    }//GEN-LAST:event_OlusturButtonActionPerformed

    private void hesaplaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hesaplaButtonActionPerformed

        hesaplaButton.setText("Continue");

        int mutlak = 0;
        int tempJ = 0;

        ArrayList<Integer> tekrarArr = new ArrayList<>();
        // mutlak satır
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                String buton = (buttons[j][i].getText());
                if (buton.equals("1") && labelY[j].getForeground() != Color.RED && labelX[i].getForeground() != Color.RED) {
                    mutlak++;
                    tempJ = j;
                }
            }

            if (mutlak == 1) {
                labelX[i].setForeground(Color.RED);
                labelY[tempJ].setForeground(Color.RED);

                if (!tekrarArr.contains(tempJ + 1)) {
                    cevap += (tempJ + 1) + " ,";
                }
                tekrarArr.add(tempJ);
            }
            mutlak = 0;
        }

        // MUTLAK SATIR SÜTÜNLARINI BOYAMA
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (labelY[i].getForeground() == Color.RED && buttons[i][j].getText().equals("1")) {
                    labelX[j].setForeground(Color.RED);
                }
            }
        }

        // SATIR KAPSAMALARI BULUP SİLME (BOYAMA)
        int kapsananSyc = 0, kapsayanSyc = 0, syc = 0;

        for (int i = 0; i < y; i++) {
            for (int t = 0; t < x; t++) {
                if (buttons[i][t].getText().equals("1")) {
                    kapsayanSyc++;
                }
            }
            for (int j = 0; j < y; j++) {
                if (i != j && labelY[j].getForeground() != Color.RED && labelY[i].getForeground() != Color.RED && kapsayanSyc > 0) {
                    for (int k = 0; k < x; k++) {
                        if (buttons[i][k].getText().equals(" ") && buttons[j][k].getText().equals("1")) {
                            syc++;
                        }
                        if (buttons[j][k].getText().equals("1") && buttons[i][k].getText().equals("1")) {
                            kapsananSyc++;
                        }
                    }
                    if (syc > 0) {
                        kapsananSyc = 0;
                        syc = 0;
                        break;
                    }
                    if (kapsayanSyc >= kapsananSyc && kapsananSyc != 0) {
                        labelY[j].setForeground(Color.RED);
                    }
                    kapsananSyc = 0;
                }
            }
            kapsayanSyc = 0;
        }

        // SÜTUN KAPSAMALARI BULUP SİLME (BOYAMA)
        kapsananSyc = 0;
        kapsayanSyc = 0;
        syc = 0;

        for (int i = 0; i < x; i++) {
            for (int t = 0; t < y; t++) {
                if (buttons[t][i].getText().equals("1")) {
                    kapsayanSyc++;
                }
            }
            for (int j = 0; j < x; j++) {
                if (i != j && labelX[j].getForeground() != Color.RED && labelX[i].getForeground() != Color.RED && kapsayanSyc > 0) {
                    for (int k = 0; k < y; k++) {
                        if (buttons[k][i].getText().equals(" ") && buttons[k][j].getText().equals("1")) {
                            syc++;
                        }
                        if (buttons[k][j].getText().equals("1") && buttons[k][i].getText().equals("1")) {
                            kapsananSyc++;
                        }
                    }
                    if (syc > 0) {
                        kapsananSyc = 0;
                        syc = 0;
                        break;
                    }
                    if (kapsayanSyc >= kapsananSyc && kapsananSyc != 0) {
                        labelX[i].setForeground(Color.RED);
                    }
                    kapsananSyc = 0;
                }
            }
            kapsayanSyc = 0;
        }

        // SEZGİSEL (ROTA) ALGORİTMASINA GEÇİŞ
        ArrayList<Integer> minWeight = new ArrayList<>();
        int minWeightSum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if ((buttons[j][i].getText().equals("1")) && labelY[j].getForeground() != Color.RED && labelX[i].getForeground() != Color.RED) {
                    minWeightSum++;
                }
            }
            minWeight.add(minWeightSum);
            minWeightSum = 0;
        }

        ArrayList<Integer> yedek = new ArrayList<>();
        
        for (int i : minWeight) {
            yedek.add(i);
        }
        
        Collections.sort(yedek);
        int labelYrowSize = 0;

        for (int i = 0; i < labelY.length; i++) {
            if (labelY[i].getForeground() != Color.RED) {
                labelYrowSize++;
            }
        }

        float Stoplam = 0;
        ArrayList<Float> Sarr = new ArrayList<>();
        ArrayList<Integer> SarrIndexi = new ArrayList<>();

        for (int i = 0; i < yedek.size(); i++) {
            if (minWeight.get(i) == yedek.get(0)) {
                // kücüğü bul
                for (int k = 0; k < y; k++) {
                    if (buttons[k][i].getText().equals("1")) {
                        System.out.println("asdfsdaf");
                        for (int j = 0; j < x; j++) {
                            if (labelY[k].getForeground() != Color.RED && labelX[j].getForeground() != Color.RED && buttons[k][j].getText().equals("1")) {
                                Stoplam += ((float) 1 / (float) minWeight.get(j));
                            }
                        }
                    }
                    if (buttons[k][i].getText().equals("1")) {
                        Sarr.add(((float) Stoplam * (float) labelYrowSize));
                        SarrIndexi.add(k);
                        Stoplam = 0;
                    }
                }
            }
        }

        float tempSmaxsize = 0;
        int tempSmaxsizeIndex = 0;

        ArrayList<Float> yedek2 = new ArrayList<>();
        for (float i : Sarr) {
            yedek2.add(i);
        }
        Collections.sort(yedek2);

        int tempMinIndex = 0;
        for (int i = 0; i < yedek2.size(); i++) {
            if (Sarr.get(i).equals(yedek2.get(0))) {
                tempMinIndex = i;
            }
        }

        int asilIndex = SarrIndexi.get(tempMinIndex);
        labelY[asilIndex].setForeground(Color.RED);
        cevapText.setText(cevap + " }");
    }//GEN-LAST:event_hesaplaButtonActionPerformed

    class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        if (buttons[i][j].getText().equals("1")) {
                            buttons[i][j].setText(" ");
                        } else {
                            buttons[i][j].setText("1");

                        }
                    }
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OlusturButton;
    private javax.swing.JTextField cevapText;
    private javax.swing.JButton hesaplaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner xSpinner;
    private javax.swing.JSpinner ySpinner;
    // End of variables declaration//GEN-END:variables
}