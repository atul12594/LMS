/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lms;

/**
 *
 * @author Admin
 */
public class instru_1 extends javax.swing.JFrame {

    /**
     * Creates new form instru_1
     */
    String exam_id1="",Student_id1="";
        int tot2, hr1,min1;
    public instru_1(String a1,int a2,String a3,int a4, int a5)
    {
        exam_id1=a1;
        tot2=a2;
        Student_id1=a3;
        hr1=a4;
        min1=a5;
        initComponents();
    }
    public instru_1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        check2 = new javax.swing.JCheckBox();
        start_test = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("1. All the questions are compulsory.");

        jLabel3.setText("2. Click on next to move to next question.");

        jLabel4.setText("3. Click on the question button to switch the question.");

        jLabel5.setText("4. Click on the previous button to go back to previous answer.");

        jLabel6.setText("5. Click on save button to save the answer.");

        jLabel7.setText("6. After the test is over, click on Submit test, to confirm your test exit and store all the data.");

        jLabel8.setText("7. Result will be generated after the completion of test.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel1.setText("INSTRUCTIONS");

        check2.setFont(new java.awt.Font("Constantia", 0, 11)); // NOI18N
        check2.setText("CLICK HERE IF YOU HAVE READ ALL THE INSTRUCTIONS");
        check2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check2ActionPerformed(evt);
            }
        });

        start_test.setFont(new java.awt.Font("Constantia", 1, 11)); // NOI18N
        start_test.setText("START TEST");
        start_test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_testActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(check2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(583, 583, 583)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(591, 591, 591)
                        .addComponent(start_test)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(check2)
                .addGap(18, 18, 18)
                .addComponent(start_test)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void check2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check2ActionPerformed
        // TODO add your handling code here:
               if(check2.isSelected())
        {
            //jButton1 = new javax.swing.JButton();
            start_test.setEnabled(true);
         
        }
        else
        {
            start_test.setEnabled(false);
        }
 
 
    }//GEN-LAST:event_check2ActionPerformed
    public void buttonDisable2()
{
    start_test.setEnabled(false);
}
    private void start_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_testActionPerformed
        // TODO add your handling code here:
        Student_inter i=new Student_inter(exam_id1,tot2,Student_id1,hr1,min1);
        i.setVisible(true);
        this.setVisible(false);    
        //i.button();
        i.Submit_disable();
        i.prev_disable();
        i.b2();
        i.b3();
        i.b4();
        i.b5();
        i.b6();
        i.b7();
        i.b8();
        i.b9();
        i.b10();
        i.b11();
        i.b12();
        i.b13();
        i.b14();
        i.b15();
        i.b16();
        i.b17();
        i.b18();
        i.b19();
        i.b20();
        i.b21();
        i.b22();
        i.b23();
        i.b24();
        i.b25();
        i.b26();
        i.b27();
        i.b28();
        i.b29();
        i.b30();
        i.b31();
        i.b32();
        i.b33();
        i.b34();
        i.b35();
        i.b36();
        i.b37();
        i.b38();
        i.b39();
        i.b40();
        i.b41();
        i.b42();
        i.b43();
        i.b44();
        i.b45();
        i.b46();
        i.b47();
        i.b48();
        i.b49();
        i.b50();
        i.b51();
        i.b52();
        i.b53();
        i.b54();
        i.b55();
        i.b56();
        i.b57();
        i.b58();
        i.b59();
        i.b60();
        i.b61();
        i.b62();
        i.b63();
        i.b64();
        i.b65();
        i.b66();
        i.b67();
        i.b68();
        i.b69();
        i.b70();
        i.b71();
        i.b72();
        i.b73();
        i.b74();
        i.b75();
        i.b76();
        i.b77();
        i.b78();
        i.b79();
        i.b80();
        i.b81();
        i.b82();
        i.b83();
        i.b84();
        i.b85();
        i.b86();
        i.b87();
        i.b88();
        i.b89();
        i.b90();
        i.b91();
        i.b92();
        i.b93();
        i.b94();
        i.b95();
        i.b96();
        i.b97();
        i.b98();
        i.b99();
        i.b100();
       
        
        
        //i.initialize_values();
        //i.review();
        //i.b1ActionPerformed(evt);
        //i.b2ActionPerformed(evt);
        //i.b6disable();
        //s.b3.setVisbible(false);
    }//GEN-LAST:event_start_testActionPerformed

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
            java.util.logging.Logger.getLogger(instru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(instru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(instru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(instru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new instru_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton start_test;
    // End of variables declaration//GEN-END:variables
}