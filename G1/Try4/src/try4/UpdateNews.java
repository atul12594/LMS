/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package try4;

import com.sun.org.apache.bcel.internal.generic.TABLESWITCH;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */
public class UpdateNews extends javax.swing.JFrame {

    /**
     * Creates new form UpdateNews
     */
    String id,topic,date,categ;
    public UpdateNews() {
        initComponents();
    }
    public UpdateNews(String newsid,String newstopic, String newsdate, String newscateg)
    {
        initComponents();
        id=newsid;
        topic=newstopic;
        date=newsdate;
        categ=newscateg;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_AddNews = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        TextField_NewsTopic = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TextField_NewsDate = new javax.swing.JTextField();
        Button_Done_News = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        Button_CancelNews = new javax.swing.JButton();
        Button_NewsUp = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Button_DateTime = new javax.swing.JButton();
        ComboBox_Categ = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TextField_NewsID = new javax.swing.JTextField();
        Button_GenID = new javax.swing.JButton();
        Label_SetFileLocation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update News");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Panel_AddNews.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel5.setText("Please enter following details");

        jLabel6.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel6.setText("News Topic:");

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        TextField_NewsTopic.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        TextField_NewsTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_NewsTopicActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel12.setText("Date and Time:");

        TextField_NewsDate.setEditable(false);
        TextField_NewsDate.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N

        Button_Done_News.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        Button_Done_News.setText("Done");
        Button_Done_News.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Done_NewsActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));

        Button_CancelNews.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        Button_CancelNews.setText("Cancel");
        Button_CancelNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CancelNewsActionPerformed(evt);
            }
        });

        Button_NewsUp.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        Button_NewsUp.setText("Click Here");
        Button_NewsUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NewsUpActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel13.setText("Click to Upload:");

        Button_DateTime.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        Button_DateTime.setText("Get Today's Date and Time");
        Button_DateTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DateTimeActionPerformed(evt);
            }
        });

        ComboBox_Categ.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        ComboBox_Categ.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Select Category ---", "Faculty", "Clerk", "Student", "All" }));

        jLabel14.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel14.setText("Select Category:");

        jLabel15.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel15.setText("Generate News ID:");

        TextField_NewsID.setEditable(false);
        TextField_NewsID.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N

        Button_GenID.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        Button_GenID.setText("Generate News ID");
        Button_GenID.setEnabled(false);
        Button_GenID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_GenIDActionPerformed(evt);
            }
        });

        Label_SetFileLocation.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N

        javax.swing.GroupLayout Panel_AddNewsLayout = new javax.swing.GroupLayout(Panel_AddNews);
        Panel_AddNews.setLayout(Panel_AddNewsLayout);
        Panel_AddNewsLayout.setHorizontalGroup(
            Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(Button_Done_News, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_CancelNews, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                        .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3))
                        .addContainerGap())
                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                        .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addGap(85, 85, 85)
                                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                                        .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(ComboBox_Categ, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Button_NewsUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Label_SetFileLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(TextField_NewsTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                                        .addComponent(TextField_NewsDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Button_DateTime))
                                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                                        .addComponent(TextField_NewsID, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Button_GenID, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 25, Short.MAX_VALUE))))
        );
        Panel_AddNewsLayout.setVerticalGroup(
            Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextField_NewsTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TextField_NewsDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_DateTime))
                .addGap(18, 18, 18)
                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(TextField_NewsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_GenID))
                .addGap(17, 17, 17)
                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(Panel_AddNewsLayout.createSequentialGroup()
                        .addComponent(ComboBox_Categ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_NewsUp)
                            .addComponent(Label_SetFileLocation))))
                .addGap(200, 200, 200)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Panel_AddNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Done_News, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_CancelNews, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_AddNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_AddNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextField_NewsTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_NewsTopicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_NewsTopicActionPerformed
String filelocation;
    private void Button_Done_NewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Done_NewsActionPerformed
        // TODO add your handling code here:
        String topic = TextField_NewsTopic.getText();
        String date = TextField_NewsDate.getText();
        String id = TextField_NewsID.getText();
        String categ = ComboBox_Categ.getSelectedItem().toString();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "sagar");
            String sql = "update newsfeed set news_topic=?,news_date=?,news_cat=?,news_link=? where news_id=?)";
            PreparedStatement ps = con.prepareStatement(sql);
            File f = new File(filelocation);
            FileReader fr = new FileReader(f);
            ps.setString(1, topic);
            ps.setString(2, date);
            ps.setString(3, categ);
            ps.setCharacterStream(4, fr, (int) f.length());
            ps.setString(5, id);
            int i = ps.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "News Updated");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        this.setVisible(false);
    }//GEN-LAST:event_Button_Done_NewsActionPerformed

    private void Button_CancelNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelNewsActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_Button_CancelNewsActionPerformed

    private void Button_NewsUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_NewsUpActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "File Selected");
            filelocation = selectedFile.getAbsolutePath();
            Label_SetFileLocation.setText(filelocation);
        }
    }//GEN-LAST:event_Button_NewsUpActionPerformed
String getdate;
    private void Button_DateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DateTimeActionPerformed
        // TODO add your handling code here:
        java.util.Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh.mm.ss");
        getdate = formatter.format(today);
        TextField_NewsDate.setText(getdate);
    }//GEN-LAST:event_Button_DateTimeActionPerformed
String newsid,newsid1;
int newsid2;
    private void Button_GenIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_GenIDActionPerformed
        // TODO add your handling code here:
        /*try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "sagar");
            String sql = "select news_link from newsfeed";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                newsid2 = rs.getInt("news_id");
            }
        } catch (ClassNotFoundException e) {
        } catch (Exception e) {
        }
        newsid2 = newsid2 + 1;
        newsid = newsid1 + newsid2;
        TextField_NewsID.setText(newsid);*/
    }//GEN-LAST:event_Button_GenIDActionPerformed
String newstopic,newsdate,newscat;
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Home1Page hp = new Home1Page();
        //int i = hp.Table_NewsHome.getSelectedRowCount();
        //String getid = hp.Table_NewsHome.getValueAt(hp.rwct, 1).toString();
        /*try
        {
            Class.forName("oracle.jdbc.driver.Oracle.Driver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","sagar");
            String sql = "select * from newsfeed where newsid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                newstopic=rs.getString("news_topic");
                newsdate=rs.getString("news_date");
                newscat=rs.getString("news_cat");
            }
        }
        catch(ClassNotFoundException e)
        {}
        catch(Exception e)
        {}*/
        //String gettopic = hp.Table_NewsHome.getValueAt(hp.rwct, 2).toString();
        //String getdate = hp.Table_NewsHome.getValueAt(hp.rwct, 3).toString();
        //String getcateg = hp.Table_NewsHome.getValueAt(hp.rwct, 4).toString();
        TextField_NewsID.setText(id);
        TextField_NewsTopic.setText(topic);
        TextField_NewsDate.setText(date);
        ComboBox_Categ.setModel(new javax.swing.DefaultComboBoxModel(new String[] {categ}));
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UpdateNews().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Button_CancelNews;
    private javax.swing.JButton Button_DateTime;
    public javax.swing.JButton Button_Done_News;
    private javax.swing.JButton Button_GenID;
    public javax.swing.JButton Button_NewsUp;
    private javax.swing.JComboBox ComboBox_Categ;
    private javax.swing.JLabel Label_SetFileLocation;
    public javax.swing.JPanel Panel_AddNews;
    public javax.swing.JTextField TextField_NewsDate;
    public javax.swing.JTextField TextField_NewsID;
    public javax.swing.JTextField TextField_NewsTopic;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
