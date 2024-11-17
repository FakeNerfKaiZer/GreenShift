/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package greenshift;

import java.awt.CardLayout;
import java.awt.Color;

/**
 *
 * @author bloxd
 */
public class MainGUI extends javax.swing.JFrame {
    
    public void showWelcomePanel() {
    CardLayout cardLayout = (CardLayout) Background.getLayout();
    cardLayout.show(Background, "WelcomePanel"); // Use the name assigned to WelcomePanel
}
    /**
     * Creates new form GreenShiftGUI
     */
    public MainGUI() {        
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

        Navbar = new javax.swing.JPanel();
        navExitBtn = new javax.swing.JButton();
        navQuizBtn = new javax.swing.JButton();
        navTipBtn = new javax.swing.JButton();
        navTrackerBtn = new javax.swing.JButton();
        label3 = new java.awt.Label();
        Background = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        TipPanel = new javax.swing.JPanel();
        QuizPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTa = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        answerOne = new javax.swing.JRadioButton();
        answerTwo = new javax.swing.JRadioButton();
        answerThree = new javax.swing.JRadioButton();
        answerFour = new javax.swing.JRadioButton();
        prevQuestionBtn = new javax.swing.JButton();
        nextQuestionBtn = new javax.swing.JButton();
        TrackerPanel = new javax.swing.JPanel();
        deleteBTN = new javax.swing.JToggleButton();
        addBTN1 = new javax.swing.JToggleButton();
        nextBTN = new javax.swing.JButton();
        textArea2 = new java.awt.TextArea();
        jTextField1 = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(1, 148, 141));

        Navbar.setBackground(new java.awt.Color(2, 61, 84));

        navExitBtn.setBackground(new java.awt.Color(2, 61, 84));
        navExitBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        navExitBtn.setForeground(new java.awt.Color(255, 255, 255));
        navExitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross (white).png"))); // NOI18N
        navExitBtn.setText("Exit");
        navExitBtn.setBorder(null);
        navExitBtn.setBorderPainted(false);
        navExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navExitBtnActionPerformed(evt);
            }
        });

        navQuizBtn.setBackground(new java.awt.Color(2, 61, 84));
        navQuizBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        navQuizBtn.setForeground(new java.awt.Color(255, 255, 255));
        navQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quiz (white).png"))); // NOI18N
        navQuizBtn.setText("Quiz");
        navQuizBtn.setBorder(null);
        navQuizBtn.setBorderPainted(false);
        navQuizBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        navQuizBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navQuizBtnActionPerformed(evt);
            }
        });

        navTipBtn.setBackground(new java.awt.Color(2, 61, 84));
        navTipBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        navTipBtn.setForeground(new java.awt.Color(255, 255, 255));
        navTipBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/idea (white).png"))); // NOI18N
        navTipBtn.setText("Tips");
        navTipBtn.setBorder(null);
        navTipBtn.setBorderPainted(false);
        navTipBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navTipBtnActionPerformed(evt);
            }
        });

        navTrackerBtn.setBackground(new java.awt.Color(2, 61, 84));
        navTrackerBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        navTrackerBtn.setForeground(new java.awt.Color(255, 255, 255));
        navTrackerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard (white).png"))); // NOI18N
        navTrackerBtn.setText("Action Tracker");
        navTrackerBtn.setBorder(null);
        navTrackerBtn.setBorderPainted(false);
        navTrackerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navTrackerBtnActionPerformed(evt);
            }
        });

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("GreenShift");

        javax.swing.GroupLayout NavbarLayout = new javax.swing.GroupLayout(Navbar);
        Navbar.setLayout(NavbarLayout);
        NavbarLayout.setHorizontalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navTrackerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
            .addComponent(navTipBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navQuizBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        NavbarLayout.setVerticalGroup(
            NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navQuizBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navTipBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navTrackerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(335, 335, 335)
                .addComponent(navExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Background.setBackground(new java.awt.Color(1, 148, 141));
        Background.setLayout(new java.awt.CardLayout());

        WelcomePanel.setBackground(new java.awt.Color(1, 148, 141));

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout WelcomePanelLayout = new javax.swing.GroupLayout(WelcomePanel);
        WelcomePanel.setLayout(WelcomePanelLayout);
        WelcomePanelLayout.setHorizontalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomePanelLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        WelcomePanelLayout.setVerticalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanelLayout.createSequentialGroup()
                .addContainerGap(439, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );

        Background.add(WelcomePanel, "card5");

        TipPanel.setBackground(new java.awt.Color(1, 148, 141));

        javax.swing.GroupLayout TipPanelLayout = new javax.swing.GroupLayout(TipPanel);
        TipPanel.setLayout(TipPanelLayout);
        TipPanelLayout.setHorizontalGroup(
            TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        TipPanelLayout.setVerticalGroup(
            TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );

        Background.add(TipPanel, "card2");

        QuizPanel.setBackground(new java.awt.Color(1, 148, 141));

        questionTa.setEditable(false);
        questionTa.setBackground(new java.awt.Color(255, 255, 255));
        questionTa.setColumns(20);
        questionTa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        questionTa.setRows(5);
        questionTa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(questionTa);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Climate Quiz");

        answerOne.setText("Answer 1");
        answerOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerOneActionPerformed(evt);
            }
        });

        answerTwo.setText("Answer 2");

        answerThree.setText("Answer 3");

        answerFour.setText("Answer 4");

        prevQuestionBtn.setText("Previous");
        prevQuestionBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nextQuestionBtn.setText("Next");
        nextQuestionBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout QuizPanelLayout = new javax.swing.GroupLayout(QuizPanel);
        QuizPanel.setLayout(QuizPanelLayout);
        QuizPanelLayout.setHorizontalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QuizPanelLayout.createSequentialGroup()
                        .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(answerOne, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addComponent(answerThree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(QuizPanelLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(prevQuestionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuizPanelLayout.createSequentialGroup()
                                .addComponent(nextQuestionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuizPanelLayout.createSequentialGroup()
                                .addComponent(answerFour, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addComponent(answerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QuizPanelLayout.setVerticalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(answerOne, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(answerTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerThree, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerFour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextQuestionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevQuestionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        Background.add(QuizPanel, "card4");

        TrackerPanel.setBackground(new java.awt.Color(1, 148, 141));

        deleteBTN.setText("Delete");
        deleteBTN.setBorder(null);
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        addBTN1.setText("Add");
        addBTN1.setBorder(null);
        addBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTN1ActionPerformed(evt);
            }
        });

        nextBTN.setText("Next");
        nextBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTNActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(242, 242, 242));
        label1.setName(""); // NOI18N
        label1.setText("Action Taken");

        label2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setName(""); // NOI18N
        label2.setText("Action Tracker");

        javax.swing.GroupLayout TrackerPanelLayout = new javax.swing.GroupLayout(TrackerPanel);
        TrackerPanel.setLayout(TrackerPanelLayout);
        TrackerPanelLayout.setHorizontalGroup(
            TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrackerPanelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(addBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(TrackerPanelLayout.createSequentialGroup()
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TrackerPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TrackerPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrackerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        TrackerPanelLayout.setVerticalGroup(
            TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrackerPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(textArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        Background.add(TrackerPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(Navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void addBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addBTN1ActionPerformed

    private void nextBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextBTNActionPerformed

    private void answerOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerOneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerOneActionPerformed

    private void navExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navExitBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new StartPageGUI().setVisible(true);

    }//GEN-LAST:event_navExitBtnActionPerformed

    private void navQuizBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navQuizBtnActionPerformed
        // TODO add your handling code here:
        Background.removeAll();
        Background.add(QuizPanel);
        Background.repaint();
        Background.revalidate();
        
        //changing the colour of the icon
        navTrackerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard (white).png")));
        navQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quiz.png")));
        navTipBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/idea (white).png")));
        
        //changig the colour of the background
        navTipBtn.setBackground(new Color(2, 61, 84));
        navTrackerBtn.setBackground(new Color(2, 61, 84));
        navQuizBtn.setBackground(new Color(1,148,141));
        
        // changing the colour of the text        
        navQuizBtn.setForeground(new Color(0, 0, 0));
        navTipBtn.setForeground(new Color(255, 255, 255));
        navTrackerBtn.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_navQuizBtnActionPerformed

    private void navTipBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navTipBtnActionPerformed
        // TODO add your handling code here:
        Background.removeAll();
        Background.add(TipPanel);
        Background.repaint();
        Background.revalidate();
        
        //changing the colour of the icon
        navTrackerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard (white).png")));
        navQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quiz (white).png")));
        navTipBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/idea.png")));
        
        //changig the colour of the background
        navTipBtn.setBackground(new Color(1,148,141));
        navTrackerBtn.setBackground(new Color(2, 61, 84));
        navQuizBtn.setBackground(new Color(2, 61, 84));
        
        // changing the colour of the text
        navTipBtn.setForeground(new Color(0,0,0));
        navTrackerBtn.setForeground(new Color(255, 255, 255));
        navQuizBtn.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_navTipBtnActionPerformed

    private void navTrackerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navTrackerBtnActionPerformed
        // TODO add your handling code here:
        Background.removeAll();
        Background.add(TrackerPanel);
        Background.repaint();
        Background.revalidate();
               
        //changing the colour of the icon
        navTrackerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard.png")));
        navQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/quiz (white).png")));
        navTipBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/idea (white).png")));
        
        //changig the colour of the background
        navTipBtn.setBackground(new Color(2, 61, 84));
        navTrackerBtn.setBackground(new Color(1,148,141));
        navQuizBtn.setBackground(new Color(2, 61, 84));
        
        // changing the colour of the text        
        navTrackerBtn.setForeground(new Color(0,0,0));
        navTipBtn.setForeground(new Color(255, 255, 255));
        navQuizBtn.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_navTrackerBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel QuizPanel;
    private javax.swing.JPanel TipPanel;
    private javax.swing.JPanel TrackerPanel;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JToggleButton addBTN1;
    private javax.swing.JRadioButton answerFour;
    private javax.swing.JRadioButton answerOne;
    private javax.swing.JRadioButton answerThree;
    private javax.swing.JRadioButton answerTwo;
    private javax.swing.JToggleButton deleteBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JButton navExitBtn;
    private javax.swing.JButton navQuizBtn;
    private javax.swing.JButton navTipBtn;
    private javax.swing.JButton navTrackerBtn;
    private javax.swing.JButton nextBTN;
    private javax.swing.JButton nextQuestionBtn;
    private javax.swing.JButton prevQuestionBtn;
    private javax.swing.JTextArea questionTa;
    private java.awt.TextArea textArea2;
    // End of variables declaration//GEN-END:variables
}
