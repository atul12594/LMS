/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lms;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Student_inter extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form NewJFrame
     */
   Thread t;
    public void run()
    {
        java.util.Date dt = new java.util.Date();
        
        int hr = hours1;
        int min =minutes1;
        int sec = 60;
        System.out.println(hr+":"+min+":"+sec);
        try
        {
        while(true)
        {
            
            if(sec>=0)
            {
                if(sec==0)
                {
                    sec=60;
                    --min;
                    if(min==0)
                    {
                        break;
                    }
                }
                else
                {
                    
                    if(min>=0)
                    {
                        if(min==0)
                        {
                            min=60;
                            --hr;
                            if(hr==0)
                            {
                                break;
                            }
                        }
                        else
                        {
                            --sec;
                           // sec=60;
                            
                        }
                    }
                    hh.setText(hr+":"+min+":"+sec);
                   
                    Thread.sleep(1000);
                    
                }
                
                
            }
             if(hr<=0&&min==1&&sec==0)
                    {
                       next.setEnabled(false);
                       previous.setEnabled(false);
                       save_answer.setEnabled(false);
                       submit_answer.setEnabled(true);
                    }
        }
        }
        catch(InterruptedException e)
        {}
    }

    String exam_id="",q_no="";
    int q_no1,tot=0;
    String c1,w1;
    int c,w=0,w3;
    String answers,max,min,Student_id;
    int tot_marks=0,ma,mi,percent=0;
    int a;
    String Answer_prev=null;
   int hours1=0, minutes1=0;
    
    public Student_inter(String s1,int s2,String s3,int s4,int s5){
        initComponents();
        exam_id=s1;
        tot=s2;
        Student_id=s3;
        hours1=s4;
        minutes1=s5;
        
        setsub();
        setexam();
        setmax();
        setmin();
        setsession();
        t = new Thread(this,"time");
        t.start();
        //next_prev_disable();
        System.out.println("Before Initialize");
        //initialize_values();
       // no.setText(rs.getString("question_no"));
    }    
    
    public Student_inter() {
        initComponents();
        setsub();
        setexam();
        setmax();
        setmin();
        setsession();
        initialize_values();
        
        
    }
   
    public void hide()
    {
        next.setVisible(false);
        previous.setVisible(false);
    }
    private void initialize_values()
    {
        System.out.print(exam_id);
        System.out.print("After call Initialize value");
        int a =1;
        try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                String sql="select * from question where EXAM_ID=? and question_no=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, exam_id);
                ps.setInt(2, a);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    System.out.println("Inside while\n");
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                }          
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    
    }
    public void Submit_disable()
    {
        submit_answer.setEnabled(false);
    }
    
    public void setsub()
 {
     try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                String sql="select * from testdetails";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                     subject_stu.setText(rs.getString("subject"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
 }
       public void setmax()
 {
     try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                String sql="select * from testdetails";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                     max_marks.setText(rs.getString("max_marks"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
 }
    public void setmin()
 {
     try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                String sql="select * from testdetails";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                     min_marks.setText(rs.getString("min_marks"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
 }
    
    public void setexam()
 {
     try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                String sql="select * from testdetails";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                     test_name.setText(rs.getString("Exam_name"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
 }
    
    public void setsession()
 {
     try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                String sql="select * from testdetails";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                     session.setText(rs.getString("session_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answer_grp = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        ques_stu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        no = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        answer_1 = new javax.swing.JRadioButton();
        answer_2 = new javax.swing.JRadioButton();
        answer_3 = new javax.swing.JRadioButton();
        answer_4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b11 = new javax.swing.JButton();
        b12 = new javax.swing.JButton();
        b13 = new javax.swing.JButton();
        b14 = new javax.swing.JButton();
        b16 = new javax.swing.JButton();
        b17 = new javax.swing.JButton();
        b18 = new javax.swing.JButton();
        b19 = new javax.swing.JButton();
        b21 = new javax.swing.JButton();
        b22 = new javax.swing.JButton();
        b23 = new javax.swing.JButton();
        b24 = new javax.swing.JButton();
        b26 = new javax.swing.JButton();
        b27 = new javax.swing.JButton();
        b28 = new javax.swing.JButton();
        b29 = new javax.swing.JButton();
        b31 = new javax.swing.JButton();
        b32 = new javax.swing.JButton();
        b33 = new javax.swing.JButton();
        b34 = new javax.swing.JButton();
        b36 = new javax.swing.JButton();
        b37 = new javax.swing.JButton();
        b38 = new javax.swing.JButton();
        b39 = new javax.swing.JButton();
        b41 = new javax.swing.JButton();
        b42 = new javax.swing.JButton();
        b43 = new javax.swing.JButton();
        b44 = new javax.swing.JButton();
        b46 = new javax.swing.JButton();
        b47 = new javax.swing.JButton();
        b48 = new javax.swing.JButton();
        b49 = new javax.swing.JButton();
        b51 = new javax.swing.JButton();
        b52 = new javax.swing.JButton();
        b53 = new javax.swing.JButton();
        b54 = new javax.swing.JButton();
        b56 = new javax.swing.JButton();
        b57 = new javax.swing.JButton();
        b58 = new javax.swing.JButton();
        b59 = new javax.swing.JButton();
        b61 = new javax.swing.JButton();
        b62 = new javax.swing.JButton();
        b63 = new javax.swing.JButton();
        b64 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        b15 = new javax.swing.JButton();
        b20 = new javax.swing.JButton();
        b25 = new javax.swing.JButton();
        b30 = new javax.swing.JButton();
        b35 = new javax.swing.JButton();
        b40 = new javax.swing.JButton();
        b45 = new javax.swing.JButton();
        b50 = new javax.swing.JButton();
        b55 = new javax.swing.JButton();
        b60 = new javax.swing.JButton();
        b65 = new javax.swing.JButton();
        b66 = new javax.swing.JButton();
        b71 = new javax.swing.JButton();
        b76 = new javax.swing.JButton();
        b91 = new javax.swing.JButton();
        b81 = new javax.swing.JButton();
        b86 = new javax.swing.JButton();
        b96 = new javax.swing.JButton();
        b67 = new javax.swing.JButton();
        b68 = new javax.swing.JButton();
        b69 = new javax.swing.JButton();
        b70 = new javax.swing.JButton();
        b72 = new javax.swing.JButton();
        b73 = new javax.swing.JButton();
        b74 = new javax.swing.JButton();
        b75 = new javax.swing.JButton();
        b78 = new javax.swing.JButton();
        b83 = new javax.swing.JButton();
        b88 = new javax.swing.JButton();
        b93 = new javax.swing.JButton();
        b100 = new javax.swing.JButton();
        b99 = new javax.swing.JButton();
        b98 = new javax.swing.JButton();
        b97 = new javax.swing.JButton();
        b92 = new javax.swing.JButton();
        b87 = new javax.swing.JButton();
        b82 = new javax.swing.JButton();
        b77 = new javax.swing.JButton();
        b79 = new javax.swing.JButton();
        b80 = new javax.swing.JButton();
        b84 = new javax.swing.JButton();
        b85 = new javax.swing.JButton();
        b89 = new javax.swing.JButton();
        b90 = new javax.swing.JButton();
        b95 = new javax.swing.JButton();
        b94 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        save_answer = new javax.swing.JButton();
        submit_answer = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        session = new javax.swing.JLabel();
        timer = new javax.swing.JPanel();
        hh = new javax.swing.JLabel();
        test_name = new javax.swing.JLabel();
        subject_stu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        max_marks = new javax.swing.JLabel();
        min_marks = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ques_stu.setText("question");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ques_stu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ques_stu)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jLabel1.setText("Question :");

        no.setText("No.");

        answer_1.setText("answer1");
        answer_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answer_1MouseClicked(evt);
            }
        });
        answer_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer_1ActionPerformed(evt);
            }
        });

        answer_2.setText("answer2");
        answer_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer_2ActionPerformed(evt);
            }
        });

        answer_3.setText("answer3");
        answer_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer_3ActionPerformed(evt);
            }
        });

        answer_4.setText("answer4");
        answer_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answer_4)
                    .addComponent(answer_3)
                    .addComponent(answer_2)
                    .addComponent(answer_1))
                .addContainerGap(632, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(answer_1)
                .addGap(18, 18, 18)
                .addComponent(answer_2)
                .addGap(18, 18, 18)
                .addComponent(answer_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(answer_4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(no)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(no))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        b6.setText("6");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b7.setText("7");
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setText("8");
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b9.setText("9");
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b11.setText("11");
        b11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11ActionPerformed(evt);
            }
        });

        b12.setText("12");
        b12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12ActionPerformed(evt);
            }
        });

        b13.setText("13");
        b13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b13ActionPerformed(evt);
            }
        });

        b14.setText("14");
        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14ActionPerformed(evt);
            }
        });

        b16.setText("16");
        b16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b16ActionPerformed(evt);
            }
        });

        b17.setText("17");
        b17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b17ActionPerformed(evt);
            }
        });

        b18.setText("18");
        b18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18ActionPerformed(evt);
            }
        });

        b19.setText("19");
        b19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b19ActionPerformed(evt);
            }
        });

        b21.setText("21");
        b21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b21ActionPerformed(evt);
            }
        });

        b22.setText("22");
        b22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b22ActionPerformed(evt);
            }
        });

        b23.setText("23");
        b23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b23ActionPerformed(evt);
            }
        });

        b24.setText("24");
        b24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b24ActionPerformed(evt);
            }
        });

        b26.setText("26");
        b26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b26ActionPerformed(evt);
            }
        });

        b27.setText("27");
        b27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b27ActionPerformed(evt);
            }
        });

        b28.setText("28");
        b28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b28ActionPerformed(evt);
            }
        });

        b29.setText("29");
        b29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b29ActionPerformed(evt);
            }
        });

        b31.setText("31");
        b31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b31ActionPerformed(evt);
            }
        });

        b32.setText("32");
        b32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b32ActionPerformed(evt);
            }
        });

        b33.setText("33");
        b33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b33ActionPerformed(evt);
            }
        });

        b34.setText("34");
        b34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b34ActionPerformed(evt);
            }
        });

        b36.setText("36");
        b36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b36ActionPerformed(evt);
            }
        });

        b37.setText("37");
        b37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b37ActionPerformed(evt);
            }
        });

        b38.setText("38");
        b38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b38ActionPerformed(evt);
            }
        });

        b39.setText("39");
        b39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b39ActionPerformed(evt);
            }
        });

        b41.setText("41");
        b41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b41ActionPerformed(evt);
            }
        });

        b42.setText("42");
        b42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b42ActionPerformed(evt);
            }
        });

        b43.setText("43");
        b43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b43ActionPerformed(evt);
            }
        });

        b44.setText("44");
        b44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b44ActionPerformed(evt);
            }
        });

        b46.setText("46");
        b46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b46ActionPerformed(evt);
            }
        });

        b47.setText("47");
        b47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b47ActionPerformed(evt);
            }
        });

        b48.setText("48");
        b48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b48ActionPerformed(evt);
            }
        });

        b49.setText("49");
        b49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b49ActionPerformed(evt);
            }
        });

        b51.setText("51");
        b51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b51ActionPerformed(evt);
            }
        });

        b52.setText("52");
        b52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b52ActionPerformed(evt);
            }
        });

        b53.setText("53");
        b53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b53ActionPerformed(evt);
            }
        });

        b54.setText("54");
        b54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b54ActionPerformed(evt);
            }
        });

        b56.setText("56");
        b56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b56ActionPerformed(evt);
            }
        });

        b57.setText("57");
        b57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b57ActionPerformed(evt);
            }
        });

        b58.setText("58");
        b58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b58ActionPerformed(evt);
            }
        });

        b59.setText("59");
        b59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b59ActionPerformed(evt);
            }
        });

        b61.setText("61");
        b61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b61ActionPerformed(evt);
            }
        });

        b62.setText("62");
        b62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b62ActionPerformed(evt);
            }
        });

        b63.setText("63");
        b63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b63ActionPerformed(evt);
            }
        });

        b64.setText("64");
        b64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b64ActionPerformed(evt);
            }
        });

        b1.setText("1");
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setText("2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.setText("3");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setText("4");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setText("5");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b10.setText("10");
        b10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b10ActionPerformed(evt);
            }
        });

        b15.setText("15");
        b15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b15ActionPerformed(evt);
            }
        });

        b20.setText("20");
        b20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b20ActionPerformed(evt);
            }
        });

        b25.setText("25");
        b25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b25ActionPerformed(evt);
            }
        });

        b30.setText("30");
        b30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b30ActionPerformed(evt);
            }
        });

        b35.setText("35");
        b35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b35ActionPerformed(evt);
            }
        });

        b40.setText("40");
        b40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b40ActionPerformed(evt);
            }
        });

        b45.setText("45");
        b45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b45ActionPerformed(evt);
            }
        });

        b50.setText("50");
        b50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b50ActionPerformed(evt);
            }
        });

        b55.setText("55");
        b55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b55ActionPerformed(evt);
            }
        });

        b60.setText("60");
        b60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b60ActionPerformed(evt);
            }
        });

        b65.setText("65");
        b65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b65ActionPerformed(evt);
            }
        });

        b66.setText("66");
        b66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b66ActionPerformed(evt);
            }
        });

        b71.setText("71");
        b71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b71ActionPerformed(evt);
            }
        });

        b76.setText("76");
        b76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b76ActionPerformed(evt);
            }
        });

        b91.setText("91");
        b91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b91ActionPerformed(evt);
            }
        });

        b81.setText("81");
        b81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b81ActionPerformed(evt);
            }
        });

        b86.setText("86");
        b86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b86ActionPerformed(evt);
            }
        });

        b96.setText("96");
        b96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b96ActionPerformed(evt);
            }
        });

        b67.setText("67");
        b67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b67ActionPerformed(evt);
            }
        });

        b68.setText("68");
        b68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b68ActionPerformed(evt);
            }
        });

        b69.setText("69");
        b69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b69ActionPerformed(evt);
            }
        });

        b70.setText("70");
        b70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b70ActionPerformed(evt);
            }
        });

        b72.setText("72");
        b72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b72ActionPerformed(evt);
            }
        });

        b73.setText("73");
        b73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b73ActionPerformed(evt);
            }
        });

        b74.setText("74");
        b74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b74ActionPerformed(evt);
            }
        });

        b75.setText("75");
        b75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b75ActionPerformed(evt);
            }
        });

        b78.setText("78");
        b78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b78ActionPerformed(evt);
            }
        });

        b83.setText("83");
        b83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b83ActionPerformed(evt);
            }
        });

        b88.setText("88");
        b88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b88ActionPerformed(evt);
            }
        });

        b93.setText("93");
        b93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b93ActionPerformed(evt);
            }
        });

        b100.setText("100");
        b100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b100ActionPerformed(evt);
            }
        });

        b99.setText("99");
        b99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b99ActionPerformed(evt);
            }
        });

        b98.setText("98");
        b98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b98ActionPerformed(evt);
            }
        });

        b97.setText("97");
        b97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b97ActionPerformed(evt);
            }
        });

        b92.setText("92");
        b92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b92ActionPerformed(evt);
            }
        });

        b87.setText("87");
        b87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b87ActionPerformed(evt);
            }
        });

        b82.setText("82");
        b82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b82ActionPerformed(evt);
            }
        });

        b77.setText("77");
        b77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b77ActionPerformed(evt);
            }
        });

        b79.setText("79");
        b79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b79ActionPerformed(evt);
            }
        });

        b80.setText("80");
        b80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b80ActionPerformed(evt);
            }
        });

        b84.setText("84");
        b84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b84ActionPerformed(evt);
            }
        });

        b85.setText("85");
        b85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b85ActionPerformed(evt);
            }
        });

        b89.setText("89");
        b89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b89ActionPerformed(evt);
            }
        });

        b90.setText("90");
        b90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b90ActionPerformed(evt);
            }
        });

        b95.setText("95");
        b95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b95ActionPerformed(evt);
            }
        });

        b94.setText("94");
        b94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b94ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(b1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b10, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(b16, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addComponent(b71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b91, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b81, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(b57, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                        .addComponent(b52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b62, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b63, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b64, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b65, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b58, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b59, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b60, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b53, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b54, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b55, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b48, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b49, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b50, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b44, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b45, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b39, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b40, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b34, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b35, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b29, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b30, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b24, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(b25, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(b67, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(b68, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(b69, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(b70, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(b82, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                                .addComponent(b87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(b77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(b72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(b97, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                            .addComponent(b92, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10))
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(b17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(b18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(b99, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b94, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b89, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b84, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b79, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b74, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(b75, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b80, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b85, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b90, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b95, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b100)
                                        .addComponent(b15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(b20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(b11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b86, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b76, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1)
                    .addComponent(b2)
                    .addComponent(b3)
                    .addComponent(b4)
                    .addComponent(b5))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b6)
                    .addComponent(b7)
                    .addComponent(b8)
                    .addComponent(b9)
                    .addComponent(b10))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b11)
                    .addComponent(b12)
                    .addComponent(b13)
                    .addComponent(b14)
                    .addComponent(b15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b16)
                    .addComponent(b17)
                    .addComponent(b18)
                    .addComponent(b19)
                    .addComponent(b20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b21)
                    .addComponent(b22)
                    .addComponent(b23)
                    .addComponent(b24)
                    .addComponent(b25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b26)
                    .addComponent(b27)
                    .addComponent(b28)
                    .addComponent(b29)
                    .addComponent(b30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b31)
                    .addComponent(b32)
                    .addComponent(b33)
                    .addComponent(b34)
                    .addComponent(b35))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b36)
                    .addComponent(b37)
                    .addComponent(b38)
                    .addComponent(b39)
                    .addComponent(b40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b41)
                    .addComponent(b42)
                    .addComponent(b43)
                    .addComponent(b44)
                    .addComponent(b45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b46)
                    .addComponent(b47)
                    .addComponent(b48)
                    .addComponent(b49)
                    .addComponent(b50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b51)
                    .addComponent(b52)
                    .addComponent(b53)
                    .addComponent(b54)
                    .addComponent(b55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b56)
                    .addComponent(b57)
                    .addComponent(b58)
                    .addComponent(b59)
                    .addComponent(b60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b63)
                    .addComponent(b64)
                    .addComponent(b65)
                    .addComponent(b62)
                    .addComponent(b61))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b66)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b70)
                        .addComponent(b69)
                        .addComponent(b68)
                        .addComponent(b67)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b74)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b71)
                        .addComponent(b72)
                        .addComponent(b75)
                        .addComponent(b73)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b76)
                    .addComponent(b78)
                    .addComponent(b77)
                    .addComponent(b79)
                    .addComponent(b80))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b81)
                    .addComponent(b83)
                    .addComponent(b82)
                    .addComponent(b84)
                    .addComponent(b85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b86)
                    .addComponent(b88)
                    .addComponent(b87)
                    .addComponent(b89)
                    .addComponent(b90))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b91, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b93)
                    .addComponent(b92)
                    .addComponent(b95)
                    .addComponent(b94))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b96)
                    .addComponent(b100)
                    .addComponent(b99)
                    .addComponent(b98)
                    .addComponent(b97))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel7);

        previous.setText("Previous");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        save_answer.setText("Save this answer");
        save_answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_answerActionPerformed(evt);
            }
        });

        submit_answer.setText("Submit test");
        submit_answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_answerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(previous)
                .addGap(27, 27, 27)
                .addComponent(next)
                .addGap(18, 18, 18)
                .addComponent(save_answer)
                .addGap(27, 27, 27)
                .addComponent(submit_answer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(373, 373, 373))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previous)
                    .addComponent(next)
                    .addComponent(save_answer)
                    .addComponent(submit_answer))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        session.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        session.setText("Session");

        timer.setBorder(javax.swing.BorderFactory.createTitledBorder("Time left:"));

        hh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hh.setText("hh");

        javax.swing.GroupLayout timerLayout = new javax.swing.GroupLayout(timer);
        timer.setLayout(timerLayout);
        timerLayout.setHorizontalGroup(
            timerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timerLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(hh)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        timerLayout.setVerticalGroup(
            timerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timerLayout.createSequentialGroup()
                .addComponent(hh)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        test_name.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        test_name.setText("Test name");

        subject_stu.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        subject_stu.setText("Subject name");

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel7.setText("Min Marks:");

        jLabel5.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel5.setText("Max Marks:");

        max_marks.setText("marks");

        min_marks.setText("marks");

        jLabel2.setText("EXAM:");

        jLabel3.setText("SUBJECT:");

        jLabel4.setText("SESSION:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(max_marks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(min_marks)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(55, 55, 55)
                                .addComponent(test_name))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subject_stu)
                                    .addComponent(session))
                                .addGap(400, 400, 400)
                                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(test_name)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subject_stu)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(session)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(max_marks)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(min_marks)
                            .addComponent(jLabel7))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(453, 453, 453)
                .addComponent(jLabel8)
                .addContainerGap(842, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 int k=0,j=0;
    private void submit_answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_answerActionPerformed
        // TODO add your handling code here:
       /*if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit??")==0)
       {
           status a=new status();
            a.setVisible(true);
            this.setVisible(false);
       }
       else
       {
           this.setVisible(true);
       }*/
        q_no = no.getText();
                q_no1= Integer.parseInt(q_no);
               String a_ans[]=new String[tot];
                String q_ans[]=new String[tot];
                int k=0,j=0,corr=0,wrong=0;
                String a="";
                
                
        try
        {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                String sql1="select answer from answer where exam_id=? and Student_id=?";
                PreparedStatement ps1=con.prepareStatement(sql1);
                ps1.setString(1,exam_id);
                ps1.setString(2, Student_id);
                ResultSet rs= ps1.executeQuery();
                while(rs.next())
                {   System.out.println("Helloc");
                    a_ans[k]=rs.getString("answer").toString();
                   // a_qno[k]=rs.getString("Question_no").toString();
                    k++;
                }
                System.out.print("xyz");
                 String sql2="select answer from question where exam_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setString(1,exam_id);
                ResultSet rs2= ps2.executeQuery();
                while(rs2.next())
                {   System.out.println("Helloj");
                    q_ans[j]=rs2.getString("answer").toString();
                   // q_qno[k]=rs.getString("Question_no").toString();
                    j++;
                    
                System.out.println("Hellol");
                }
                
                /*String sql3="select q.answer,a.answer from question q, answer a where a.question_no=q.question_no and a.exam_id=q.exam_id";
                
                System.out.println("Hellom");
                PreparedStatement ps3=con.prepareStatement(sql3);
                //ps.setString(1,exam_id);
                ResultSet rs3=ps3.executeQuery();*/
                k=0;
                j=0;
                /*while(rs3.next())
                {  
                    
                    if(q_ans[k].equals(a_ans[j]))
                    {
                        a="C";
                    }
                    else
                    {
                         a="N";
                    }
                    k++;j++;
                }*/
                
                for(int i=0;i<tot;i++)
                {
                    System.out.println(a_ans[i]);
                        System.out.println(q_ans[i]);
                    if(a_ans[i].equals(q_ans[i]))
                    {
                        
                        corr++;
                    }
                    else
                    {
                        wrong++;
                    }
                }  
                
                String sql5="select correct,wrong,max_marks,min_marks from testdetails where exam_id=?";
                PreparedStatement ps5=con.prepareStatement(sql5);
                ps5.setString(1,exam_id);
                ResultSet rs5=ps5.executeQuery();
                while(rs5.next())
                {
                    
                c1=rs5.getString("correct");
                w=rs5.getInt("wrong");
                //System.out.print("here\n\n");
                max=rs5.getString("max_marks");
                min=rs5.getString("min_marks");
                System.out.print("here\n\n");
                }
                System.out.print("Wrong ans:"+w);
                c=Integer.parseInt(c1);
                w3=w;
                ma=Integer.parseInt(max);
                mi=Integer.parseInt(min);
                
                 //tot_marks = (corr*c)-(wrong*w);
                 JOptionPane.showMessageDialog(null,"Correct: "+(corr*c)+"\nwrong:"+(wrong*w3)+"\ntotal_marks: "+((corr*c)+(wrong*w3)));
                 tot_marks =(corr*c)+(wrong*(w3));
                 
                 percent=((tot_marks*100)/ma);
                 System.out.print("answer is:"+tot_marks);
                 System.out.print("reached here");
                 String sql6="insert into result values(?,?,?,?,?)";
                 PreparedStatement ps6=con.prepareStatement(sql6);
                 ps6.setString(1,Student_id);
                 ps6.setString(2, exam_id);
                 ps6.setInt(3, tot_marks);
                 if(tot_marks>=mi)
                 {
                 ps6.setString(4, "Pass");
                 }
                 if(tot_marks<mi)
                 {
                     ps6.setString(4,"Fail");
                 }
                 ps6.setInt(5, percent);
                 int i=ps6.executeUpdate();
                 if(i>0)
                 {
                         status s=new status();
                         s.setVisible(true);
                         System.exit(0);
                 }
        }
       catch(Exception e)
        {   
            System.out.println(e);
        }
    }//GEN-LAST:event_submit_answerActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        //qno();
        System.out.println("Before function call");
        save_answerActionPerformed(evt);
        try
            {
                System.out.println("After function call");
                q_no = no.getText();
                q_no1= Integer.parseInt(q_no);
                //String q_no2 = q_no1.toString();
                q_no1 = q_no1+1;
                answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                //q_no = q_no1.toSring();
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,q_no1);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                            Answer_prev=null;
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,q_no1);
                            ps4.setString(2,exam_id);
                            ps4.setString(3, Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                                
  
                                
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,q_no1);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
        
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        if(q_no1==tot)
        {
            next.setEnabled(false);
        }
        
        if(q_no1>1)
        {
            previous.setEnabled(true);
        }
           
    }//GEN-LAST:event_nextActionPerformed

    
    
    
    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=6;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=7;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            
                ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=8;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            
                ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=9;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            
                ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b9ActionPerformed

    private void b11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b11ActionPerformed
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=11;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            
                ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b11ActionPerformed

    private void b12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b12ActionPerformed
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=12;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            
                ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b12ActionPerformed

    private void b13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b13ActionPerformed
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=13;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(4,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b13ActionPerformed

    private void b14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b14ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=14;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            
                ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b14ActionPerformed

    private void b16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b16ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=16;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b16ActionPerformed

    private void b17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b17ActionPerformed
        // TODO add your handling code hereif(review.isSelected())
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=17;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b17ActionPerformed

    private void b18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b18ActionPerformed
   
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=18;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b18ActionPerformed

    private void b19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b19ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=19;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b19ActionPerformed

    private void b21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b21ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=21;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b21ActionPerformed

    private void b22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b22ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=22;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b22ActionPerformed

    private void b23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b23ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=23;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b23ActionPerformed

    private void b24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b24ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=24;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b24ActionPerformed

    private void b26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b26ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=26;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b26ActionPerformed

    private void b27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b27ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=27;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b27ActionPerformed

    private void b28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b28ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=26;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b28ActionPerformed

    private void b29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b29ActionPerformed
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=29;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b29ActionPerformed

    private void b31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b31ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=31;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        
    }//GEN-LAST:event_b31ActionPerformed

    private void b32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b32ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=32;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b32ActionPerformed

    private void b33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b33ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=33;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b33ActionPerformed

    private void b34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b34ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=34;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b34ActionPerformed

    private void b36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b36ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=36;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b36ActionPerformed

    private void b37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b37ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=37;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b37ActionPerformed

    private void b38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b38ActionPerformed
        // TODO add your handling code here:if(review.isSelected
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=38;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b38ActionPerformed

    private void b39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b39ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=39;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b39ActionPerformed

    private void b41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b41ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=41;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b41ActionPerformed

    private void b42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b42ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=42;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b42ActionPerformed

    private void b43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b43ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=43;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b43ActionPerformed

    private void b44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b44ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=44;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b44ActionPerformed

    private void b46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b46ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=46;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b46ActionPerformed

    private void b47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b47ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=47;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b47ActionPerformed

    private void b48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b48ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=48;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b48ActionPerformed

    private void b49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b49ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=49;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b49ActionPerformed

    private void b51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b51ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=51;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b51ActionPerformed

    private void b52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b52ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=52;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b52ActionPerformed

    private void b53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b53ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=53;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b53ActionPerformed

    private void b54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b54ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=54;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b54ActionPerformed

    private void b56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b56ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=56;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b56ActionPerformed

    private void b57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b57ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=57;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b57ActionPerformed

    private void b58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b58ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=58;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b58ActionPerformed

    private void b59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b59ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=59;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b59ActionPerformed

    private void b61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b61ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=61;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b61ActionPerformed

    private void b62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b62ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=62;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b62ActionPerformed

    private void b63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b63ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=63;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b63ActionPerformed

    private void b64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b64ActionPerformed
        // TODO add your handling code here:if(review.isSelected())
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=64;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_b64ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        
           // b1.setBackground(Color.red);
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=1;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }        
    }//GEN-LAST:event_b1ActionPerformed

    
    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
                //b2.setBackground(Color.red);
                answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=2;
        try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
      
    }//GEN-LAST:event_b2ActionPerformed
    public void b2()
    {
         if(tot>=2)
       {
           b2.setEnabled(true);
       }
         else
         {
             b2.setEnabled(false);
         }
        
    }
    public void b3()
    {
        if(tot>=3)
       {
           b3.setEnabled(true);
       }
         else
         {
             b3.setEnabled(false);
         }
    }
    public void b4()
    {
        if(tot>=4)
       {
           b4.setEnabled(true);
       }
         else
         {
             b4.setEnabled(false);
         }
    }
    public void b5()
    {
        if(tot>=5)
       {
           b5.setEnabled(true);
       }
         else
         {
             b5.setEnabled(false);
         }
    }
    public void b6()
    {
        if(tot>=6)
       {
           b6.setEnabled(true);
       }
         else
         {
             b6.setEnabled(false);
         }
    }
    public void b7()
    {
        if(tot>=7)
       {
           b7.setEnabled(true);
       }
         else
         {
             b7.setEnabled(false);
         }
    }
    public void b8()
    {
        if(tot>=8)
       {
           b8.setEnabled(true);
       }
         else
         {
             b8.setEnabled(false);
         }
    }
    public void b9()
    {
        if(tot>=9)
       {
           b9.setEnabled(true);
       }
         else
         {
             b9.setEnabled(false);
         }
    }
    public void b10()
    {
        if(tot>=10)
       {
           b10.setEnabled(true);
       }
         else
         {
             b10.setEnabled(false);
         }
    }
    public void b11()
    {
       if(tot>=11)
       {
           b11.setEnabled(true);
       }
         else
         {
             b11.setEnabled(false);
         } 
    }
    public void b12()
    {
         if(tot>=12)
       {
           b12.setEnabled(true);
       }
         else
         {
             b12.setEnabled(false);
         }
        
    }
    public void b13()
    {
        if(tot>=13)
       {
           b13.setEnabled(true);
       }
         else
         {
             b13.setEnabled(false);
         }
    }
    public void b14()
    {
        if(tot>=14)
       {
           b14.setEnabled(true);
       }
         else
         {
             b14.setEnabled(false);
         }
    }
    public void b15()
    {
        if(tot>=15)
       {
           b15.setEnabled(true);
       }
         else
         {
             b15.setEnabled(false);
         }
    }
    public void b16()
    {
        if(tot>=16)
       {
           b16.setEnabled(true);
       }
         else
         {
             b16.setEnabled(false);
         }
    }
    public void b17()
    {
        if(tot>=17)
       {
           b17.setEnabled(true);
       }
         else
         {
             b17.setEnabled(false);
         }
    }
    public void b18()
    {
        if(tot>=18)
       {
           b18.setEnabled(true);
       }
         else
         {
             b18.setEnabled(false);
         }
    }
    public void b19()
    {
        if(tot>=19)
       {
           b19.setEnabled(true);
       }
         else
         {
             b19.setEnabled(false);
         }
    }
    public void b20()
    {
        if(tot>=20)
       {
           b20.setEnabled(true);
       }
         else
         {
             b20.setEnabled(false);
         }
    }
    public void b21()
    {
       if(tot>=21)
       {
           b21.setEnabled(true);
       }
         else
         {
             b21.setEnabled(false);
         } 
    }
       public void b22()
    {
         if(tot>=22)
       {
           b22.setEnabled(true);
       }
         else
         {
             b22.setEnabled(false);
         }
        
    }
    public void b23()
    {
        if(tot>=23)
       {
           b23.setEnabled(true);
       }
         else
         {
             b23.setEnabled(false);
         }
    }
    public void b24()
    {
        if(tot>=24)
       {
           b24.setEnabled(true);
       }
         else
         {
             b24.setEnabled(false);
         }
    }
    public void b25()
    {
        if(tot>=25)
       {
           b25.setEnabled(true);
       }
         else
         {
             b25.setEnabled(false);
         }
    }
    public void b26()
    {
        if(tot>=26)
       {
           b26.setEnabled(true);
       }
         else
         {
             b26.setEnabled(false);
         }
    }
    public void b27()
    {
        if(tot>=27)
       {
           b27.setEnabled(true);
       }
         else
         {
             b27.setEnabled(false);
         }
    }
    public void b28()
    {
        if(tot>=28)
       {
           b28.setEnabled(true);
       }
         else
         {
             b28.setEnabled(false);
         }
    }
    public void b29()
    {
        if(tot>=29)
       {
           b29.setEnabled(true);
       }
         else
         {
             b29.setEnabled(false);
         }
    }
    public void b30()
    {
        if(tot>=30)
       {
           b30.setEnabled(true);
       }
         else
         {
             b30.setEnabled(false);
         }
    }
    public void b31()
    {
       if(tot>=31)
       {
           b31.setEnabled(true);
       }
         else
         {
             b31.setEnabled(false);
         } 
    }
       public void b32()
    {
         if(tot>=32)
       {
           b32.setEnabled(true);
       }
         else
         {
             b32.setEnabled(false);
         }
        
    }
    public void b33()
    {
        if(tot>=33)
       {
           b33.setEnabled(true);
       }
         else
         {
             b33.setEnabled(false);
         }
    }
    public void b34()
    {
        if(tot>=34)
       {
           b34.setEnabled(true);
       }
         else
         {
             b34.setEnabled(false);
         }
    }
    public void b35()
    {
        if(tot>=35)
       {
           b35.setEnabled(true);
       }
         else
         {
             b35.setEnabled(false);
         }
    }
    public void b36()
    {
        if(tot>=36)
       {
           b36.setEnabled(true);
       }
         else
         {
             b36.setEnabled(false);
         }
    }
    public void b37()
    {
        if(tot>=37)
       {
           b37.setEnabled(true);
       }
         else
         {
             b37.setEnabled(false);
         }
    }
    public void b38()
    {
        if(tot>=38)
       {
           b38.setEnabled(true);
       }
         else
         {
             b38.setEnabled(false);
         }
    }
    public void b39()
    {
        if(tot>=39)
       {
           b39.setEnabled(true);
       }
         else
         {
             b39.setEnabled(false);
         }
    }
    public void b40()
    {
        if(tot>=40)
       {
           b40.setEnabled(true);
       }
         else
         {
             b40.setEnabled(false);
         }
    }
    public void b41()
    {
       if(tot>=41)
       {
           b41.setEnabled(true);
       }
         else
         {
             b41.setEnabled(false);
         } 
    }
       public void b42()
    {
         if(tot>=42)
       {
           b42.setEnabled(true);
       }
         else
         {
             b42.setEnabled(false);
         }
        
    }
    public void b43()
    {
        if(tot>=43)
       {
           b43.setEnabled(true);
       }
         else
         {
             b43.setEnabled(false);
         }
    }
    public void b44()
    {
        if(tot>=44)
       {
           b44.setEnabled(true);
       }
         else
         {
             b44.setEnabled(false);
         }
    }
    public void b45()
    {
        if(tot>=45)
       {
           b45.setEnabled(true);
       }
         else
         {
             b45.setEnabled(false);
         }
    }
    public void b46()
    {
        if(tot>=46)
       {
           b46.setEnabled(true);
       }
         else
         {
             b46.setEnabled(false);
         }
    }
    public void b47()
    {
        if(tot>=47)
       {
           b47.setEnabled(true);
       }
         else
         {
             b47.setEnabled(false);
         }
    }
    public void b48()
    {
        if(tot>=48)
       {
           b48.setEnabled(true);
       }
         else
         {
             b48.setEnabled(false);
         }
    }
    public void b49()
    {
        if(tot>=49)
       {
           b49.setEnabled(true);
       }
         else
         {
             b49.setEnabled(false);
         }
    }
    public void b50()
    {
        if(tot>=50)
       {
           b50.setEnabled(true);
       }
         else
         {
             b50.setEnabled(false);
         }
    }
    public void b51()
    {
       if(tot>=51)
       {
           b51.setEnabled(true);
       }
         else
         {
             b51.setEnabled(false);
         } 
    }
       public void b52()
    {
         if(tot>=52)
       {
           b52.setEnabled(true);
       }
         else
         {
             b52.setEnabled(false);
         }
        
    }
    public void b53()
    {
        if(tot>=53)
       {
           b53.setEnabled(true);
       }
         else
         {
             b53.setEnabled(false);
         }
    }
    public void b54()
    {
        if(tot>=54)
       {
           b54.setEnabled(true);
       }
         else
         {
             b54.setEnabled(false);
         }
    }
    public void b55()
    {
        if(tot>=55)
       {
           b55.setEnabled(true);
       }
         else
         {
             b55.setEnabled(false);
         }
    }
    public void b56()
    {
        if(tot>=56)
       {
           b56.setEnabled(true);
       }
         else
         {
             b56.setEnabled(false);
         }
    }
    public void b57()
    {
        if(tot>=57)
       {
           b57.setEnabled(true);
       }
         else
         {
             b57.setEnabled(false);
         }
    }
    public void b58()
    {
        if(tot>=58)
       {
           b58.setEnabled(true);
       }
         else
         {
             b58.setEnabled(false);
         }
    }
    public void b59()
    {
        if(tot>=59)
       {
           b59.setEnabled(true);
       }
         else
         {
             b59.setEnabled(false);
         }
    }
    public void b60()
    {
        if(tot>=60)
       {
           b60.setEnabled(true);
       }
         else
         {
             b60.setEnabled(false);
         }
    }
    public void b61()
    {
       if(tot>=61)
       {
           b61.setEnabled(true);
       }
         else
         {
             b61.setEnabled(false);
         } 
    }
       public void b62()
    {
         if(tot>=62)
       {
           b62.setEnabled(true);
       }
         else
         {
             b62.setEnabled(false);
         }
        
    }
    public void b63()
    {
        if(tot>=63)
       {
           b63.setEnabled(true);
       }
         else
         {
             b63.setEnabled(false);
         }
    }
    public void b64()
    {
        if(tot>=64)
       {
           b64.setEnabled(true);
       }
         else
         {
             b64.setEnabled(false);
         }
    }
    public void b65()
    {
        if(tot>=65)
       {
           b65.setEnabled(true);
       }
         else
         {
             b65.setEnabled(false);
         }
    }
    public void b66()
    {
        if(tot>=66)
       {
           b66.setEnabled(true);
       }
         else
         {
             b66.setEnabled(false);
         }
    }
    public void b67()
    {
        if(tot>=67)
       {
           b67.setEnabled(true);
       }
         else
         {
             b67.setEnabled(false);
         }
    }
    public void b68()
    {
        if(tot>=68)
       {
           b68.setEnabled(true);
       }
         else
         {
             b68.setEnabled(false);
         }
    }
    public void b69()
    {
        if(tot>=69)
       {
           b69.setEnabled(true);
       }
         else
         {
             b69.setEnabled(false);
         }
    }
    public void b70()
    {
        if(tot>=70)
       {
           b70.setEnabled(true);
       }
         else
         {
             b70.setEnabled(false);
         }
    }
    public void b71()
    {
       if(tot>=71)
       {
           b71.setEnabled(true);
       }
         else
         {
             b71.setEnabled(false);
         } 
    }
       public void b72()
    {
         if(tot>=72)
       {
           b72.setEnabled(true);
       }
         else
         {
             b72.setEnabled(false);
         }
        
    }
    public void b73()
    {
        if(tot>=73)
       {
           b73.setEnabled(true);
       }
         else
         {
             b73.setEnabled(false);
         }
    }
    public void b74()
    {
        if(tot>=74)
       {
           b74.setEnabled(true);
       }
         else
         {
             b74.setEnabled(false);
         }
    }
    public void b75()
    {
        if(tot>=75)
       {
           b75.setEnabled(true);
       }
         else
         {
             b75.setEnabled(false);
         }
    }
    public void b76()
    {
        if(tot>=76)
       {
           b76.setEnabled(true);
       }
         else
         {
             b76.setEnabled(false);
         }
    }
    public void b77()
    {
        if(tot>=77)
       {
           b77.setEnabled(true);
       }
         else
         {
             b77.setEnabled(false);
         }
    }
    public void b78()
    {
        if(tot>=78)
       {
           b78.setEnabled(true);
       }
         else
         {
             b78.setEnabled(false);
         }
    }
    public void b79()
    {
        if(tot>=79)
       {
           b79.setEnabled(true);
       }
         else
         {
             b79.setEnabled(false);
         }
    }
    public void b80()
    {
        if(tot>=80)
       {
           b80.setEnabled(true);
       }
         else
         {
             b80.setEnabled(false);
         }
    }
    public void b81()
    {
       if(tot>=81)
       {
           b81.setEnabled(true);
       }
         else
         {
             b81.setEnabled(false);
         } 
    }
       public void b82()
    {
         if(tot>=82)
       {
           b82.setEnabled(true);
       }
         else
         {
             b82.setEnabled(false);
         }
        
    }
    public void b83()
    {
        if(tot>=83)
       {
           b83.setEnabled(true);
       }
         else
         {
             b83.setEnabled(false);
         }
    }
    public void b84()
    {
        if(tot>=84)
       {
           b84.setEnabled(true);
       }
         else
         {
             b84.setEnabled(false);
         }
    }
    public void b85()
    {
        if(tot>=85)
       {
           b85.setEnabled(true);
       }
         else
         {
             b85.setEnabled(false);
         }
    }
    public void b86()
    {
        if(tot>=86)
       {
           b86.setEnabled(true);
       }
         else
         {
             b86.setEnabled(false);
         }
    }
    public void b87()
    {
        if(tot>=87)
       {
           b87.setEnabled(true);
       }
         else
         {
             b87.setEnabled(false);
         }
    }
    public void b88()
    {
        if(tot>=88)
       {
           b88.setEnabled(true);
       }
         else
         {
             b88.setEnabled(false);
         }
    }
    public void b89()
    {
        if(tot>=89)
       {
           b89.setEnabled(true);
       }
         else
         {
             b89.setEnabled(false);
         }
    }
    public void b90()
    {
        if(tot>=90)
       {
           b90.setEnabled(true);
       }
         else
         {
             b90.setEnabled(false);
         }
    }
    public void b91()
    {
       if(tot>=91)
       {
           b91.setEnabled(true);
       }
         else
         {
             b91.setEnabled(false);
         } 
    }
       public void b92()
    {
         if(tot>=92)
       {
           b92.setEnabled(true);
       }
         else
         {
             b92.setEnabled(false);
         }
        
    }
    public void b93()
    {
        if(tot>=93)
       {
           b93.setEnabled(true);
       }
         else
         {
             b93.setEnabled(false);
         }
    }
    public void b94()
    {
        if(tot>=94)
       {
           b94.setEnabled(true);
       }
         else
         {
             b94.setEnabled(false);
         }
    }
    public void b95()
    {
        if(tot>=95)
       {
           b95.setEnabled(true);
       }
         else
         {
             b95.setEnabled(false);
         }
    }
    public void b96()
    {
        if(tot>=96)
       {
           b96.setEnabled(true);
       }
         else
         {
             b96.setEnabled(false);
         }
    }
    public void b97()
    {
        if(tot>=97)
       {
           b97.setEnabled(true);
       }
         else
         {
             b97.setEnabled(false);
         }
    }
    public void b98()
    {
        if(tot>=98)
       {
           b98.setEnabled(true);
       }
         else
         {
             b98.setEnabled(false);
         }
    }
    public void b99()
    {
        if(tot>=99)
       {
           b99.setEnabled(true);
       }
         else
         {
             b99.setEnabled(false);
         }
    }
    public void b100()
    {
        if(tot>=100)
       {
           b100.setEnabled(true);
       }
         else
         {
             b100.setEnabled(false);
         }
    }
    
    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=3;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=4;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  

       
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        // TODO add your handling code here:
       
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=5;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b5ActionPerformed

    private void b10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b10ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=10;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b10ActionPerformed

    private void b15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b15ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=15;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b15ActionPerformed

    private void b20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b20ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=20;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b20ActionPerformed

    private void b25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b25ActionPerformed
        // TODO add your handling code here:
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=25;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b25ActionPerformed

    private void b30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b30ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=30;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b30ActionPerformed

    private void b35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b35ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=35;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b35ActionPerformed

    private void b40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b40ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=40;
try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b40ActionPerformed

    private void b45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b45ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=45;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b45ActionPerformed

    private void b50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b50ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=50;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b50ActionPerformed

    private void b55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b55ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=55;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b55ActionPerformed

    private void b60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b60ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=60;
try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b60ActionPerformed

    private void b65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b65ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=65;
try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b65ActionPerformed

    private void b66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b66ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=66;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b66ActionPerformed

    private void b71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b71ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=71;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b71ActionPerformed

    private void b76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b76ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=76;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b76ActionPerformed

    private void b91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b91ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=91;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b91ActionPerformed

    private void b81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b81ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=81;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b81ActionPerformed

    private void b86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b86ActionPerformed
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=86;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b86ActionPerformed

    private void b96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b96ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=96;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b96ActionPerformed

    private void b67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b67ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=67;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b67ActionPerformed

    private void b68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b68ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=68;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b68ActionPerformed

    private void b69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b69ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=69;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b69ActionPerformed

    private void b70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b70ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=70;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b70ActionPerformed

    private void b72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b72ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=72;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b72ActionPerformed

    private void b73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b73ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=73;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b73ActionPerformed

    private void b74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b74ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=74;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b74ActionPerformed

    private void b75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b75ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=75;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b75ActionPerformed

    private void b78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b78ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=78;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b78ActionPerformed

    private void b83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b83ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=83;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b83ActionPerformed

    private void b88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b88ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=88;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b88ActionPerformed

    private void b93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b93ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=93;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b93ActionPerformed

    private void b100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b100ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=100;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b100ActionPerformed

    private void b99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b99ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=99;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b99ActionPerformed

    private void b98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b98ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=98;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b98ActionPerformed

    private void b97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b97ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=97;
      try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b97ActionPerformed

    private void b92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b92ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=92;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b92ActionPerformed

    private void b87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b87ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=87;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b87ActionPerformed

    private void b82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b82ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=82;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b82ActionPerformed

    private void b77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b77ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=77;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b77ActionPerformed

    private void b79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b79ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=79;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b79ActionPerformed

    private void b80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b80ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=80;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b80ActionPerformed

    private void b84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b84ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=84;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b84ActionPerformed

    private void b85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b85ActionPerformed
        // TODO add your handling code herereview.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=85;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b85ActionPerformed

    private void b89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b89ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=89;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b89ActionPerformed

    private void b90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b90ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=90;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b90ActionPerformed

    private void b95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b95ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=95;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b95ActionPerformed

    private void b94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b94ActionPerformed
        // TODO add your handling code here:review.setVisible(true);
        
            answer_1.setSelected(false);
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
                a=94;
       try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no=? and  Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,a);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,a);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                String Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,a);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }  
    }//GEN-LAST:event_b94ActionPerformed

    private void answer_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer_1ActionPerformed
        // TODO add your handling code here:
        Answer_prev="A";
        if(answer_1.isSelected())
            {
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
            }
        else
        {
            answer_1.setSelected(false);
            answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
        }
    }//GEN-LAST:event_answer_1ActionPerformed

    private void answer_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer_2ActionPerformed
        // TODO add your handling code here:
      Answer_prev="B";
      if(answer_2.isSelected())
            {
                answer_1.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
            }
        else
        {
            answer_1.setSelected(false);
            answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
        }
    }//GEN-LAST:event_answer_2ActionPerformed

    private void answer_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer_3ActionPerformed
        // TODO add your handling code here:
      Answer_prev="C";
      if(answer_3.isSelected())
            {
                answer_2.setSelected(false);
                answer_1.setSelected(false);
                answer_4.setSelected(false);
            }
        else
        {
            answer_1.setSelected(false);
            answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
        }
    }//GEN-LAST:event_answer_3ActionPerformed

    private void answer_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer_4ActionPerformed
        // TODO add your handling code here:
      Answer_prev="D";
      if(answer_4.isSelected())
            {
                answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_1.setSelected(false);
            }
        else
        {
            answer_1.setSelected(false);
            answer_2.setSelected(false);
                answer_3.setSelected(false);
                answer_4.setSelected(false);
        }
    }//GEN-LAST:event_answer_4ActionPerformed

    private void save_answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_answerActionPerformed
        // TODO add your handling code here:
                q_no = no.getText();
                q_no1= Integer.parseInt(q_no);
                String ans[]=new String[tot];
               String c;
               int count;
        try
        {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                String sql="Select count(*) from answer where exam_id=? and question_no=? and Student_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,exam_id);
                ps.setInt(2,q_no1);
                ps.setString(3,Student_id);
                //System.out.println("Hello1");
                ResultSet rs=ps.executeQuery();
                //count = rs.getInt(1);
                //System.out.println("Hello2");
                JOptionPane.showMessageDialog(null, q_no1);
                while(rs.next())
                {   
                    count = rs.getInt(1);
                    //c=rs.getString("count(answer)");
                    //count=Integer.parseInt(c);
                    System.out.print(count);
                    if(count==0)
                    {   System.out.print("null");
                        String sql1="insert into answer values(?,?,?,?,?)";
                        PreparedStatement ps1=con.prepareStatement(sql1);
                        ps1.setString(1,exam_id);
                        ps1.setInt(2,q_no1);
                        ps1.setString(3,Answer_prev);
                        ps1.setString(4,"Answered");
                        ps1.setString(5,Student_id);
                        System.out.print("success");
                        
                        int i=ps1.executeUpdate();
                        if(i>0)
                            {
                                answer=null;
                                JOptionPane.showMessageDialog(null,"Saved");
                            }
                     }
                    else
                    {
                        System.out.print("not null");
                        JOptionPane.showMessageDialog(null,Answer_prev);
                        JOptionPane.showMessageDialog(null,Student_id);
                        JOptionPane.showMessageDialog(null,q_no1);
                        JOptionPane.showMessageDialog(null,exam_id);
                        String sql2="Update answer set answer=? where exam_id=? and question_no=? and Student_id=?";
                        PreparedStatement ps2=con.prepareStatement(sql2);
                        ps2.setString(1,Answer_prev);
                        ps2.setString(2,exam_id);
                        ps2.setInt(3,q_no1);
                        ps2.setString(4,Student_id);
                        int j=ps2.executeUpdate();
                         if(j>0)
                            {
                                JOptionPane.showMessageDialog(null,"Saved again");
                            }
                    }
                }
        }
       catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_save_answerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        System.out.print(exam_id);
        System.out.print("After call Initialize value");
        int a =1;
        try
            {
                
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                
                String sql2="select count(answer) from answer where Question_no='1' and Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                //ps2.setInt(1,q_no1);
                ps2.setString(1,exam_id);
                ps2.setString(2,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                            Answer_prev=null;
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no='1' and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            //ps4.setInt(1,q_no1);
                            ps4.setString(1,exam_id);
                            ps4.setString(2, Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                System.out.print("Answer");
                                Answer_prev=rs4.getString("ANSWER");
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                                
  
                                
                            }
                        }
                
                }
                
                
                
                
                
                
                
                String sql="select * from question where EXAM_ID=? and question_no=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, exam_id);
                ps.setInt(2, a);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    System.out.println("Inside while\n");
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                }          
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_formWindowOpened
    String c9;
    int count9;
    
    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        // TODO add your handling code here:
        save_answerActionPerformed(evt);
        try
            {
                
               
                //q_no = q_no1.toSring();
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","qwer1234");
                /*
                
                String sql1="insert into answer values(?,?,?,?,?)";
                        PreparedStatement ps1=con.prepareStatement(sql1);
                        ps1.setString(1,exam_id);
                        ps1.setInt(2,q_no1);
                        ps1.setString(3,answer);
                        ps1.setString(4,"Answered");
                        ps1.setString(5,Student_id);
                        System.out.print("success");
                        
                        int i=ps1.executeUpdate();
                        if(i>0)
                            {
                                JOptionPane.showMessageDialog(null,"Saved");
                            }
                
                
                */
                q_no = no.getText();
                q_no1= Integer.parseInt(q_no);
                //String q_no2 = q_no1.toString();
                q_no1 = q_no1-1;
                String sql2="select count(answer) from answer where Question_no=? and Exam_id=? and Student_id=?";
                PreparedStatement ps2=con.prepareStatement(sql2);
                ps2.setInt(1,q_no1);
                ps2.setString(2,exam_id);
                ps2.setString(3,Student_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next())
                {   
                    c9=rs2.getString("count(answer)");
                    count9=Integer.parseInt(c9);
                    System.out.print(c9);
                    if(count9==0)
                        {
                            answer_1.setSelected(false);
                            answer_2.setSelected(false);
                            answer_3.setSelected(false);
                            answer_4.setSelected(false);
                            Answer_prev=null;
                        }
                    else
                        {
                            String sql4="select * from ANSWER where question_no=? and exam_id=? and Student_id=?";
                            PreparedStatement ps4=con.prepareStatement(sql4);
                            ps4.setInt(1,q_no1);
                            ps4.setString(2,exam_id);
                            ps4.setString(3,Student_id);
                            ResultSet rs4=ps4.executeQuery();
                            
                            while(rs4.next())
                            {
                                
                                Answer_prev=rs4.getString("ANSWER");
                                JOptionPane.showMessageDialog(null, Answer_prev);
                                if(Answer_prev.equals("A"))
                                    {
                                        answer_1.setSelected(true);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("B"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(true);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("C"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(true);
                                        answer_4.setSelected(false);
                                    }
                                else if(Answer_prev.equals("D"))
                                    {
                                        answer_1.setSelected(false);
                                        answer_2.setSelected(false);
                                        answer_3.setSelected(false);
                                        answer_4.setSelected(true);
                                    }
                                
                       
  
                            }
                        }
                
                }
                
                String sql="select * from question where QUESTION_NO=? and Exam_id=?";
                System.out.println("Hello");
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1,q_no1);
                ps.setString(2,exam_id);
                ResultSet rs=ps.executeQuery();
              
                while(rs.next())
                {
                    System.out.println("Next Value"); 
                    ques_stu.setText(rs.getString("question"));
                     answer_1.setText(rs.getString("a"));
                     answer_2.setText(rs.getString("b"));
                     answer_3.setText(rs.getString("c"));
                     answer_4.setText(rs.getString("d"));
                     no.setText(rs.getString("question_no"));
                 }          
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        if(q_no1==1)
        {
            previous.setEnabled(false);
        }
        if(q_no1<tot)
        {
            next.setEnabled(true);
        }
    }//GEN-LAST:event_previousActionPerformed
  
    public void prev_disable()
    {
        previous.setEnabled(false);
    }
    
    
    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_b1MouseClicked

    private void answer_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answer_1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_answer_1MouseClicked
 
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
            java.util.logging.Logger.getLogger(Student_inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_inter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton answer_1;
    private javax.swing.JRadioButton answer_2;
    private javax.swing.JRadioButton answer_3;
    private javax.swing.JRadioButton answer_4;
    private javax.swing.ButtonGroup answer_grp;
    private javax.swing.JButton b1;
    private javax.swing.JButton b10;
    private javax.swing.JButton b100;
    private javax.swing.JButton b11;
    private javax.swing.JButton b12;
    private javax.swing.JButton b13;
    private javax.swing.JButton b14;
    private javax.swing.JButton b15;
    private javax.swing.JButton b16;
    private javax.swing.JButton b17;
    private javax.swing.JButton b18;
    private javax.swing.JButton b19;
    private javax.swing.JButton b2;
    private javax.swing.JButton b20;
    private javax.swing.JButton b21;
    private javax.swing.JButton b22;
    private javax.swing.JButton b23;
    private javax.swing.JButton b24;
    private javax.swing.JButton b25;
    private javax.swing.JButton b26;
    private javax.swing.JButton b27;
    private javax.swing.JButton b28;
    private javax.swing.JButton b29;
    private javax.swing.JButton b3;
    private javax.swing.JButton b30;
    private javax.swing.JButton b31;
    private javax.swing.JButton b32;
    private javax.swing.JButton b33;
    private javax.swing.JButton b34;
    private javax.swing.JButton b35;
    private javax.swing.JButton b36;
    private javax.swing.JButton b37;
    private javax.swing.JButton b38;
    private javax.swing.JButton b39;
    private javax.swing.JButton b4;
    private javax.swing.JButton b40;
    private javax.swing.JButton b41;
    private javax.swing.JButton b42;
    private javax.swing.JButton b43;
    private javax.swing.JButton b44;
    private javax.swing.JButton b45;
    private javax.swing.JButton b46;
    private javax.swing.JButton b47;
    private javax.swing.JButton b48;
    private javax.swing.JButton b49;
    private javax.swing.JButton b5;
    private javax.swing.JButton b50;
    private javax.swing.JButton b51;
    private javax.swing.JButton b52;
    private javax.swing.JButton b53;
    private javax.swing.JButton b54;
    private javax.swing.JButton b55;
    private javax.swing.JButton b56;
    private javax.swing.JButton b57;
    private javax.swing.JButton b58;
    private javax.swing.JButton b59;
    private javax.swing.JButton b6;
    private javax.swing.JButton b60;
    private javax.swing.JButton b61;
    private javax.swing.JButton b62;
    private javax.swing.JButton b63;
    private javax.swing.JButton b64;
    private javax.swing.JButton b65;
    private javax.swing.JButton b66;
    private javax.swing.JButton b67;
    private javax.swing.JButton b68;
    private javax.swing.JButton b69;
    private javax.swing.JButton b7;
    private javax.swing.JButton b70;
    private javax.swing.JButton b71;
    private javax.swing.JButton b72;
    private javax.swing.JButton b73;
    private javax.swing.JButton b74;
    private javax.swing.JButton b75;
    private javax.swing.JButton b76;
    private javax.swing.JButton b77;
    private javax.swing.JButton b78;
    private javax.swing.JButton b79;
    private javax.swing.JButton b8;
    private javax.swing.JButton b80;
    private javax.swing.JButton b81;
    private javax.swing.JButton b82;
    private javax.swing.JButton b83;
    private javax.swing.JButton b84;
    private javax.swing.JButton b85;
    private javax.swing.JButton b86;
    private javax.swing.JButton b87;
    private javax.swing.JButton b88;
    private javax.swing.JButton b89;
    private javax.swing.JButton b9;
    private javax.swing.JButton b90;
    private javax.swing.JButton b91;
    private javax.swing.JButton b92;
    private javax.swing.JButton b93;
    private javax.swing.JButton b94;
    private javax.swing.JButton b95;
    private javax.swing.JButton b96;
    private javax.swing.JButton b97;
    private javax.swing.JButton b98;
    private javax.swing.JButton b99;
    private javax.swing.JLabel hh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel max_marks;
    private javax.swing.JLabel min_marks;
    private javax.swing.JButton next;
    private javax.swing.JLabel no;
    private javax.swing.JButton previous;
    private javax.swing.JLabel ques_stu;
    private javax.swing.JButton save_answer;
    private javax.swing.JLabel session;
    private javax.swing.JLabel subject_stu;
    private javax.swing.JButton submit_answer;
    private javax.swing.JLabel test_name;
    private javax.swing.JPanel timer;
    // End of variables declaration//GEN-END:variables
    private String answer="";
}
