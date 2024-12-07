/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package greenshift;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bloxd
 */
public class MainGUI extends javax.swing.JFrame {
    ArrayList <EnergyTips> energytips; 
    ArrayList <TransportTips> transporttips;
    ArrayList <RecycleTips> recycletips;
    int currentIndex;
    
    private QuizApp quizApp;
    
    ArrayList <ClimateAction> trackerList;// Creating the tracker ArrayList
    int listIndex; //Creating the list Index
   
    //Displays the welcome page on launch
    public void showWelcomePanel() {
        CardLayout cardLayout = (CardLayout) Background.getLayout();
        cardLayout.show(Background, "WelcomePanel");
        System.out.println("Welcome to GreenShift");
    }
    /**
     * Creates new form GreenShiftGUI
     */
    public MainGUI() {        
        initComponents();
        
        energytips = new ArrayList<>(); //create the arraylists for the Tip Generator
        transporttips = new ArrayList<>();
        recycletips = new ArrayList<>();
        
        currentIndex = 0; 
        
        loadEnergyList();
        loadTransportList();
        loadRecycleList();
       
        quizResetBtn.setVisible(false);
        
        //Button group for quiz answers, helps with bug fixes
        answerBtnGroup.add(answerOne);
        answerBtnGroup.add(answerTwo);
        answerBtnGroup.add(answerThree);
        answerBtnGroup.add(answerFour);
        
        trackerList = new ArrayList<>(); //Create the arraylist for the Tracker
        listIndex = 0;
        
        List<Question> questions = loadQuestionsFromFile("questions.txt"); //Loads questions from txt file for the Quiz
        quizApp = new QuizApp(questions);
        loadQuestion(); 
        
        loadTracker();
        displayAllTracker();
        
        
        Background.setLayout(new CardLayout());
        Background.add(WelcomePanel, "WelcomePanel");

        // Set initial visibility state
        WelcomePanel.setVisible(true);
        
        welcomeLabel.setText("Welcome to GreenShift \n" +
                     "Your Personal Climate Impact Tracker\n\n" +
                     "Thank you for joining us on this journey toward a healthier planet!\n" +
                     "GreenShift is designed to help you make small, everyday changes\n" +
                     "that add up to a big difference in tackling climate change.\n\n" +
                     "What You Can Do Here:\n" +
                     "• Track Your Actions: Log eco-friendly activities you have done.\n" +
                     "• Get Inspired: Discover simple tips to reduce your carbon footprint.\n" +
                     "• Learn About Yourself: Take a fun quiz to evaluate your lifestyle.\n\n" +
                     "Together, we can make the shift toward a greener future.\n\n" +
                     "Let’s get started! Pick a function from the navbar to begin");
    }

    ////////////////////Sean's section - Tracker things/////////////////////////////////////////////
    private void loadTracker(){  //a method to just read in and load list into the ArrayList

        File f;
        FileInputStream fStream;
        ObjectInputStream oStream;
        try{
            f = new File("output.dat");
            fStream = new FileInputStream(f); 
            oStream = new ObjectInputStream(fStream);

            trackerList = (ArrayList<ClimateAction>)oStream.readObject();

            oStream.close();
        }
        catch(IOException |ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    private void saveTracker(){//a method to just save the ArrayList to file
            File f;
            FileOutputStream fStream;
            ObjectOutputStream oStream;

            try{
                f = new File("output.dat");
                fStream = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fStream);

                oStream.writeObject(trackerList);
                oStream.close();
                 trackerDisplay.append("\nAction Tracker Saved");
            }
            catch(IOException e){
                System.out.println(e);
            }
    }
    
    private void displayAllTracker(){
        trackerDisplay.setText(""); //clear the display
        if(trackerList.isEmpty()){
            trackerDisplay.setText("Nothing in yout tracker yet!");
        }else{
            ClimateAction temp; //temp to store objects into the list
            for(int i = 0; i < trackerList.size(); i++){
                temp = trackerList.get(i);
                trackerDisplay.append(temp.toString()+"\n");
            } 
        }        
    }
    
    ////////////////////Andrei section - quiz things/////////////////////////////////////////////
    private void loadQuestion() {
        Question currentQuestion = quizApp.getCurrentQuestion();
        questionTa.setText(currentQuestion.getQuestionText());
        String[] options = currentQuestion.getAnswers();
        answerOne.setText(options[0]);
        answerTwo.setText(options[1]);
        answerThree.setText(options[2]);
        answerFour.setText(options[3]);

        // Clears previous answer seleciton when loading a new question
        answerBtnGroup.clearSelection();    

        // Restore previous selection
        int selectedAnswer = quizApp.getUserAnswer();
        if (selectedAnswer != -1) {
            switch (selectedAnswer) {
                case 0 -> answerOne.setSelected(true);
                case 1 -> answerTwo.setSelected(true);
                case 2 -> answerThree.setSelected(true);
                case 3 -> answerFour.setSelected(true);
            }
        }
    }

    //simple save answer method
    private void saveAnswer() {
        if (answerOne.isSelected()) {
            quizApp.setUserAnswer(0);
        } else if (answerTwo.isSelected()) {
            quizApp.setUserAnswer(1);
        } else if (answerThree.isSelected()) {
            quizApp.setUserAnswer(2);
        } else if (answerFour.isSelected()) {
            quizApp.setUserAnswer(3);
        }
    }


    //load questions from Questions.txt 
    private List<Question> loadQuestionsFromFile(String filename) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Read the question text
                String questionText = line;

                // Read the 4 answer options
                String[] answers = new String[4];
                for (int i = 0; i < 4; i++) {
                    answers[i] = reader.readLine();
                }

                // Read the correct answer index
                int correctAnswer = Integer.parseInt(reader.readLine());

                // Create and add the question object
                questions.add(new Question(questionText, answers, correctAnswer));

                // Skip blank line (if present)
                reader.readLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading questions: " + e.getMessage());
        }
        return questions;
    }

    private void resetQuiz() {
        // Clear user answers
        for (int i = 0; i < quizApp.getTotalQuestions(); i++) {
            quizApp.setUserAnswer(-1);
        }

        // Reset to the first question
        quizApp.previousQuestion(); // Ensure it navigates to the start
        while (quizApp.hasPreviousQuestion()) {
            quizApp.previousQuestion();
        }

        // Reload the first question
        loadQuestion();

        // Reset UI components
        answerBtnGroup.clearSelection();
        quizResetBtn.setVisible(false); // Hide reset button
        nextQuestionBtn.setVisible(true); // Show navigation buttons
        prevQuestionBtn.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipButtonGroup1 = new javax.swing.ButtonGroup();
        answerBtnGroup = new javax.swing.ButtonGroup();
        Navbar = new javax.swing.JPanel();
        navExitBtn = new javax.swing.JButton();
        navQuizBtn = new javax.swing.JButton();
        navTipBtn = new javax.swing.JButton();
        navTrackerBtn = new javax.swing.JButton();
        label3 = new java.awt.Label();
        Background = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        welcomeLabel = new java.awt.TextArea();
        QuizPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        questionTa = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        answerOne = new javax.swing.JRadioButton();
        answerTwo = new javax.swing.JRadioButton();
        answerThree = new javax.swing.JRadioButton();
        answerFour = new javax.swing.JRadioButton();
        prevQuestionBtn = new javax.swing.JButton();
        nextQuestionBtn = new javax.swing.JButton();
        quizResetBtn = new javax.swing.JButton();
        selectAnswerlbl = new javax.swing.JLabel();
        TipPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tipTa1 = new javax.swing.JTextArea();
        addBtn1 = new javax.swing.JButton();
        nextTipBtn1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        energyButton = new javax.swing.JRadioButton();
        transportButton = new javax.swing.JRadioButton();
        recycleButton = new javax.swing.JRadioButton();
        AddTipTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        prevTipBtn2 = new javax.swing.JButton();
        TrackerPanel = new javax.swing.JPanel();
        deleteBTNtracker = new javax.swing.JToggleButton();
        addBTNtracker = new javax.swing.JToggleButton();
        nextBTNtracker = new javax.swing.JButton();
        trackerDisplay = new java.awt.TextArea();
        actionInput = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        displayAllBTNtracker = new javax.swing.JButton();
        updateStatusBTNtracker1 = new javax.swing.JButton();

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

        welcomeLabel.setBackground(new java.awt.Color(28, 88, 115));
        welcomeLabel.setEditable(false);
        welcomeLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout WelcomePanelLayout = new javax.swing.GroupLayout(WelcomePanel);
        WelcomePanel.setLayout(WelcomePanelLayout);
        WelcomePanelLayout.setHorizontalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        WelcomePanelLayout.setVerticalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        Background.add(WelcomePanel, "card5");

        QuizPanel.setBackground(new java.awt.Color(1, 148, 141));

        questionTa.setEditable(false);
        questionTa.setBackground(new java.awt.Color(28, 88, 115));
        questionTa.setColumns(20);
        questionTa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        questionTa.setForeground(new java.awt.Color(255, 255, 255));
        questionTa.setRows(5);
        questionTa.setBorder(null);
        jScrollPane3.setViewportView(questionTa);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Climate Quiz");

        answerOne.setBackground(new java.awt.Color(1, 148, 141));
        answerOne.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerOne.setForeground(new java.awt.Color(255, 255, 255));
        answerOne.setText("Answer 1");
        answerOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerOneActionPerformed(evt);
            }
        });

        answerTwo.setBackground(new java.awt.Color(1, 148, 141));
        answerTwo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerTwo.setForeground(new java.awt.Color(255, 255, 255));
        answerTwo.setText("Answer 2");

        answerThree.setBackground(new java.awt.Color(1, 148, 141));
        answerThree.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerThree.setForeground(new java.awt.Color(255, 255, 255));
        answerThree.setText("Answer 3");

        answerFour.setBackground(new java.awt.Color(1, 148, 141));
        answerFour.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        answerFour.setForeground(new java.awt.Color(255, 255, 255));
        answerFour.setText("Answer 4");

        prevQuestionBtn.setBackground(new java.awt.Color(2, 61, 84));
        prevQuestionBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prevQuestionBtn.setForeground(new java.awt.Color(255, 255, 255));
        prevQuestionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backward.png"))); // NOI18N
        prevQuestionBtn.setText("Previous");
        prevQuestionBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prevQuestionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevQuestionBtnActionPerformed(evt);
            }
        });

        nextQuestionBtn.setBackground(new java.awt.Color(2, 61, 84));
        nextQuestionBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nextQuestionBtn.setForeground(new java.awt.Color(255, 255, 255));
        nextQuestionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forward.png"))); // NOI18N
        nextQuestionBtn.setText("Next");
        nextQuestionBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nextQuestionBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        nextQuestionBtn.setIconTextGap(7);
        nextQuestionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionBtnActionPerformed(evt);
            }
        });

        quizResetBtn.setBackground(new java.awt.Color(2, 61, 84));
        quizResetBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quizResetBtn.setForeground(new java.awt.Color(255, 255, 255));
        quizResetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        quizResetBtn.setText("Retry?");
        quizResetBtn.setBorder(null);
        quizResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizResetBtnActionPerformed(evt);
            }
        });

        selectAnswerlbl.setBackground(new java.awt.Color(1, 148, 141));
        selectAnswerlbl.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        selectAnswerlbl.setForeground(new java.awt.Color(255, 255, 255));
        selectAnswerlbl.setText("Select an answer:");

        javax.swing.GroupLayout QuizPanelLayout = new javax.swing.GroupLayout(QuizPanel);
        QuizPanel.setLayout(QuizPanelLayout);
        QuizPanelLayout.setHorizontalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuizPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(QuizPanelLayout.createSequentialGroup()
                        .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(QuizPanelLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(prevQuestionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(answerOne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(answerThree, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                        .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QuizPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addComponent(nextQuestionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(111, Short.MAX_VALUE))
                            .addGroup(QuizPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(answerTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                    .addComponent(answerFour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGroup(QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuizPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuizPanelLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(selectAnswerlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(quizResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        QuizPanelLayout.setVerticalGroup(
            QuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectAnswerlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(quizResetBtn)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        Background.add(QuizPanel, "card4");

        TipPanel.setBackground(new java.awt.Color(1, 148, 141));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Climate Tips");

        tipTa1.setBackground(new java.awt.Color(28, 88, 115));
        tipTa1.setColumns(20);
        tipTa1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tipTa1.setForeground(new java.awt.Color(255, 255, 255));
        tipTa1.setLineWrap(true);
        tipTa1.setRows(5);
        tipTa1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(tipTa1);

        addBtn1.setBackground(new java.awt.Color(2, 61, 84));
        addBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn1.setForeground(new java.awt.Color(255, 255, 255));
        addBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        addBtn1.setText("Add");
        addBtn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn1ActionPerformed(evt);
            }
        });

        nextTipBtn1.setBackground(new java.awt.Color(2, 61, 84));
        nextTipBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nextTipBtn1.setForeground(new java.awt.Color(255, 255, 255));
        nextTipBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forward.png"))); // NOI18N
        nextTipBtn1.setText("Next");
        nextTipBtn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nextTipBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        nextTipBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTipBtn1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Please select which category of tips you would like to receive: ");

        energyButton.setBackground(new java.awt.Color(1, 148, 141));
        tipButtonGroup1.add(energyButton);
        energyButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        energyButton.setForeground(new java.awt.Color(255, 255, 255));
        energyButton.setText("Energy");
        energyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                energyButtonActionPerformed(evt);
            }
        });

        transportButton.setBackground(new java.awt.Color(1, 148, 141));
        tipButtonGroup1.add(transportButton);
        transportButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        transportButton.setForeground(new java.awt.Color(255, 255, 255));
        transportButton.setText("Transportation");
        transportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transportButtonActionPerformed(evt);
            }
        });

        recycleButton.setBackground(new java.awt.Color(1, 148, 141));
        tipButtonGroup1.add(recycleButton);
        recycleButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        recycleButton.setForeground(new java.awt.Color(255, 255, 255));
        recycleButton.setText("Recycling");
        recycleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recycleButtonActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("You may enter any other suitable tips:");

        prevTipBtn2.setBackground(new java.awt.Color(2, 61, 84));
        prevTipBtn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prevTipBtn2.setForeground(new java.awt.Color(255, 255, 255));
        prevTipBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backward.png"))); // NOI18N
        prevTipBtn2.setText("Previous");
        prevTipBtn2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        prevTipBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevTipBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TipPanelLayout = new javax.swing.GroupLayout(TipPanel);
        TipPanel.setLayout(TipPanelLayout);
        TipPanelLayout.setHorizontalGroup(
            TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TipPanelLayout.createSequentialGroup()
                .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TipPanelLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TipPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(TipPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AddTipTF)
                                        .addGroup(TipPanelLayout.createSequentialGroup()
                                            .addComponent(addBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))))))
                    .addGroup(TipPanelLayout.createSequentialGroup()
                        .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TipPanelLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(energyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(transportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TipPanelLayout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(prevTipBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nextTipBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recycleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        TipPanelLayout.setVerticalGroup(
            TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TipPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(energyButton)
                    .addComponent(transportButton)
                    .addComponent(recycleButton))
                .addGap(49, 49, 49)
                .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevTipBtn2)
                    .addComponent(nextTipBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(TipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTipTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        Background.add(TipPanel, "card2");

        TrackerPanel.setBackground(new java.awt.Color(1, 148, 141));

        deleteBTNtracker.setBackground(new java.awt.Color(2, 61, 84));
        deleteBTNtracker.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteBTNtracker.setForeground(new java.awt.Color(255, 255, 255));
        deleteBTNtracker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png"))); // NOI18N
        deleteBTNtracker.setText("Delete");
        deleteBTNtracker.setBorder(null);
        deleteBTNtracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNtrackerActionPerformed(evt);
            }
        });

        addBTNtracker.setBackground(new java.awt.Color(2, 61, 84));
        addBTNtracker.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBTNtracker.setForeground(new java.awt.Color(255, 255, 255));
        addBTNtracker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        addBTNtracker.setText("Add");
        addBTNtracker.setBorder(null);
        addBTNtracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNtrackerActionPerformed(evt);
            }
        });

        nextBTNtracker.setBackground(new java.awt.Color(2, 61, 84));
        nextBTNtracker.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nextBTNtracker.setForeground(new java.awt.Color(255, 255, 255));
        nextBTNtracker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forward.png"))); // NOI18N
        nextBTNtracker.setText("Next");
        nextBTNtracker.setBorder(null);
        nextBTNtracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTNtrackerActionPerformed(evt);
            }
        });

        trackerDisplay.setBackground(new java.awt.Color(28, 88, 115));
        trackerDisplay.setForeground(new java.awt.Color(255, 255, 255));

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(242, 242, 242));
        label1.setName(""); // NOI18N
        label1.setText("Action Taken");

        label2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setName(""); // NOI18N
        label2.setText("Action Tracker");

        displayAllBTNtracker.setBackground(new java.awt.Color(2, 61, 84));
        displayAllBTNtracker.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        displayAllBTNtracker.setForeground(new java.awt.Color(255, 255, 255));
        displayAllBTNtracker.setText("Display All");
        displayAllBTNtracker.setBorder(null);
        displayAllBTNtracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAllBTNtrackerActionPerformed(evt);
            }
        });

        updateStatusBTNtracker1.setBackground(new java.awt.Color(2, 61, 84));
        updateStatusBTNtracker1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateStatusBTNtracker1.setForeground(new java.awt.Color(255, 255, 255));
        updateStatusBTNtracker1.setText("Update Status");
        updateStatusBTNtracker1.setBorder(null);
        updateStatusBTNtracker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStatusBTNtracker1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TrackerPanelLayout = new javax.swing.GroupLayout(TrackerPanel);
        TrackerPanel.setLayout(TrackerPanelLayout);
        TrackerPanelLayout.setHorizontalGroup(
            TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrackerPanelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(addBTNtracker, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteBTNtracker, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(TrackerPanelLayout.createSequentialGroup()
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TrackerPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(trackerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TrackerPanelLayout.createSequentialGroup()
                                .addComponent(updateStatusBTNtracker1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(displayAllBTNtracker, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(nextBTNtracker, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TrackerPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(trackerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBTNtracker, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayAllBTNtracker, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateStatusBTNtracker1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBTNtracker, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBTNtracker, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void loadEnergyList(){  //Methods to just read in and load list into the ArrayLists
       
        File f;
        FileInputStream fStream;
        ObjectInputStream oStream;
        try{
            f = new File("EnergyOutput.dat");
            fStream = new FileInputStream(f); 
            oStream = new ObjectInputStream(fStream);
            
            energytips = (ArrayList<EnergyTips>)oStream.readObject();
            
            oStream.close();
        }
        catch(IOException |ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    private void loadTransportList(){
       
        File f;
        FileInputStream fStream;
        ObjectInputStream oStream;
        try{
            f = new File("TransportOutput.dat");
            fStream = new FileInputStream(f); 
            oStream = new ObjectInputStream(fStream);
            
            transporttips = (ArrayList<TransportTips>)oStream.readObject();
            
            oStream.close();
        }
        catch(IOException |ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    private void loadRecycleList(){
       
        File f;
        FileInputStream fStream;
        ObjectInputStream oStream;
        try{
            f = new File("RecycleOutput.dat");
            fStream = new FileInputStream(f); 
            oStream = new ObjectInputStream(fStream);
            
            recycletips = (ArrayList<RecycleTips>)oStream.readObject();
            
            oStream.close();
        }
        catch(IOException |ClassNotFoundException e){
            System.out.println(e);
        }
    }
    private void saveEnergyList(){
        File f;
        FileOutputStream fStream;
        ObjectOutputStream oStream;
        
        try{
            f = new File("EnergyOutput.dat");
            fStream = new FileOutputStream(f);
            oStream = new ObjectOutputStream(fStream);
            
            oStream.writeObject(energytips);
            oStream.close();
             tipTa1.append("\nTip Added");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    private void saveTransportList(){
        File f;
        FileOutputStream fStream;
        ObjectOutputStream oStream;
        
        try{
            f = new File("TransportOutput.dat");
            fStream = new FileOutputStream(f);
            oStream = new ObjectOutputStream(fStream);
            
            oStream.writeObject(transporttips);
            oStream.close();
             tipTa1.append("\nTip Added");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    private void saveRecycleList(){//Methods to just save the ArrayList to files
        File f;
        FileOutputStream fStream;
        ObjectOutputStream oStream;
        
        try{
            f = new File("RecycleOutput.dat");
            fStream = new FileOutputStream(f);
            oStream = new ObjectOutputStream(fStream);
            
            oStream.writeObject(recycletips);
            oStream.close();
             tipTa1.append("\nTip Added");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    private void deleteBTNtrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNtrackerActionPerformed
        // Tracker's Delete Button

        String searchTerm = JOptionPane.showInputDialog(null, "Enter name of action to delete");
        if (searchTerm != null && !searchTerm.isEmpty()) {
            for (int i = 0; i < trackerList.size(); i++) {
                ClimateAction temp = trackerList.get(i);
                if (searchTerm.equalsIgnoreCase(temp.getName())) {
                    trackerList.remove(i); // Delete the action
                    saveTracker(); // Save the updated list
                    trackerDisplay.append("\nDeleted: " + temp.getName());
                    return;
                }
            }
            trackerDisplay.append("\nNo matching action found.");
        } else {
            trackerDisplay.append("\nPlease enter a valid name.");
        }
    }//GEN-LAST:event_deleteBTNtrackerActionPerformed

    private void addBTNtrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTNtrackerActionPerformed
        // Tracker's Add Button

        ClimateAction temp;  // Temporary object for neatness
        String name = actionInput.getText();  // Get action name from user input
        
        // Optionally, prompt the user for action type and initial status
        String actionType = JOptionPane.showInputDialog("Enter action type (e.g., Recycling, Energy Saving):");
        String status = "Pending";  // Default status
        
        // Create action based on type
        if (actionType.equalsIgnoreCase("Recycling")) {
            temp = new RecyclingAction(name);  // Create a RecyclingAction object
        } else if (actionType.equalsIgnoreCase("Energy Saving")) {
            temp = new EnergySavingAction(name);  // Create an EnergySavingAction object
        } else {
            temp = new ClimateAction(name, status);  // Default ClimateAction if unknown type
        }
        
        trackerList.add(temp);  // Add to the tracker list
        saveTracker();  // Save list to the file
        
        trackerDisplay.append("\n" + name + " added with status: " + status);
    }//GEN-LAST:event_addBTNtrackerActionPerformed

    private void nextBTNtrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTNtrackerActionPerformed
        // Tracker's Next Button
        
        if (!trackerList.isEmpty()) {
            ClimateAction temp = trackerList.get(listIndex);  // Get current action
            trackerDisplay.setText(temp.getActionType() + ": " + temp.getName() + " - Status: " + temp.getStatus());  // Display action info with status
            listIndex++;  // Move to the next action
            
            // Ensure we don't go past the end of the list
            if (listIndex >= trackerList.size()) {
                listIndex = 0;  // Start over when reaching the end
            }
        } else {
            trackerDisplay.setText("Nothing in your tracker yet!");
        }
    }//GEN-LAST:event_nextBTNtrackerActionPerformed

    private void navExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navExitBtnActionPerformed
         // Show a confirmation dialog with a message
        int option = JOptionPane.showConfirmDialog(
                this,  // Parent component
                "Thank you for using GreenShift. Are you sure you want to exit?", // Message
                "Exit Confirmation",  // Dialog title
                JOptionPane.YES_NO_OPTION,  // Option buttons (Yes and No)
                JOptionPane.INFORMATION_MESSAGE); // Icon type

        // Check user's choice
        if (option == JOptionPane.YES_OPTION) {
            // If the user selects "Yes", dispose of the current window
            this.dispose();
        }
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

    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn1ActionPerformed

        if(energyButton.isSelected()){
            EnergyTips temp;
            String tipEnergy = AddTipTF.getText();
            temp = new EnergyTips(tipEnergy);

            energytips.add(temp);
            saveEnergyList();
        }else if(transportButton.isSelected()){
            TransportTips temp;  //temp obj
            String tipTransport = AddTipTF.getText();
            temp = new TransportTips(tipTransport);

            transporttips.add(temp);
            saveTransportList();
        }else if(recycleButton.isSelected()){
            RecycleTips temp; 
            String tipRecycle = AddTipTF.getText();
            temp = new RecycleTips(tipRecycle);

            recycletips.add(temp);
            saveRecycleList();
        }
    }//GEN-LAST:event_addBtn1ActionPerformed

    private void nextTipBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTipBtn1ActionPerformed
  
        if(energyButton.isSelected()){
            if(!energytips.isEmpty()){
                EnergyTips temp = energytips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex++;
                
                if(currentIndex >= energytips.size()){ 
                    currentIndex = 0; 
                }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
        } else if(transportButton.isSelected()){
            if(!transporttips.isEmpty()){
                TransportTips temp = transporttips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex++;
              
                if(currentIndex >= transporttips.size()){ 
                    currentIndex = 0; 
                }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
        }else if(recycleButton.isSelected()){
            if(!recycletips.isEmpty()){
                RecycleTips temp = recycletips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex++;
              
                if(currentIndex >= recycletips.size()){ 
                    currentIndex = 0; 
                }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
        }
    }//GEN-LAST:event_nextTipBtn1ActionPerformed

    private void energyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_energyButtonActionPerformed
    
        tipTa1.setText("");
            if(!energytips.isEmpty()){
                EnergyTips temp = energytips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex++;
                
                if(currentIndex >= energytips.size()){ 
                    currentIndex = 0; 
                }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
    }//GEN-LAST:event_energyButtonActionPerformed

    private void prevTipBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevTipBtn2ActionPerformed
       
        if(energyButton.isSelected()){
            if(!energytips.isEmpty()){
                EnergyTips temp = energytips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex--; 
              
                if(currentIndex >= energytips.size()){ 
                    currentIndex = 0; 
                }else if(currentIndex <= energytips.size()){
                currentIndex = 0;
            }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
        } else if(transportButton.isSelected()){
            if(!transporttips.isEmpty()){
                TransportTips temp = transporttips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex--;
              
                if(currentIndex >= energytips.size()){ 
                    currentIndex = 0; 
                }else if(currentIndex <= energytips.size()){
                currentIndex = 0;
            }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
        } else if(recycleButton.isSelected()){
            if(!recycletips.isEmpty()){
                RecycleTips temp = recycletips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex--; 
              
                if(currentIndex >= energytips.size()){ 
                    currentIndex = 0; 
                }else if(currentIndex <= energytips.size()){
                currentIndex = 0;
            }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
        }
    }//GEN-LAST:event_prevTipBtn2ActionPerformed

    private void recycleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recycleButtonActionPerformed
    
            if(!recycletips.isEmpty()){
                RecycleTips temp = recycletips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex++;
             
                if(currentIndex >= energytips.size()){ 
                    currentIndex = 0; 
                }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
            
    }//GEN-LAST:event_recycleButtonActionPerformed

    private void transportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transportButtonActionPerformed
     
            if(!transporttips.isEmpty()){
                TransportTips temp = transporttips.get(currentIndex);
                tipTa1.setText(temp.toString());            
                currentIndex++; 
             
                if(currentIndex >= energytips.size()){ 
                    currentIndex = 0; 
                }
            }else{
                 tipTa1.setText("There are no tips to display");
            }
    }//GEN-LAST:event_transportButtonActionPerformed

    private void answerOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerOneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerOneActionPerformed

    private void prevQuestionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevQuestionBtnActionPerformed
        // TODO add your handling code here:
        saveAnswer();
        if (quizApp.hasPreviousQuestion()) {
            quizApp.previousQuestion();
            loadQuestion();
        }
    }//GEN-LAST:event_prevQuestionBtnActionPerformed

    private void nextQuestionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionBtnActionPerformed

        saveAnswer();

        // Clear all radio button selections before moving to next question
        answerBtnGroup.clearSelection();

        // Check if it's the final question
        if (quizApp.hasNextQuestion()) {
            quizApp.nextQuestion();
            loadQuestion();
        }
        else {
            // End of the quiz: display the score
            int score = quizApp.calculateScore();
            questionTa.setText("Quiz Completed!\nYour score: " + score + "/" + quizApp.getTotalQuestions());

            // Show the reset button
            quizResetBtn.setVisible(true);

            // Hide next/prev buttons and answers
            selectAnswerlbl.setVisible(false);
            answerFour.setVisible(false);
            answerThree.setVisible(false);
            answerTwo.setVisible(false);
            answerOne.setVisible(false);
            nextQuestionBtn.setVisible(false);
            prevQuestionBtn.setVisible(false);
        }
    }//GEN-LAST:event_nextQuestionBtnActionPerformed

    private void quizResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizResetBtnActionPerformed
        // TODO add your handling code here:
        resetQuiz();

        selectAnswerlbl.setVisible(true);
        answerFour.setVisible(true);
        answerThree.setVisible(true);
        answerTwo.setVisible(true);
        answerOne.setVisible(true);
    }//GEN-LAST:event_quizResetBtnActionPerformed

    private void displayAllBTNtrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAllBTNtrackerActionPerformed
        displayAllTracker();
    }//GEN-LAST:event_displayAllBTNtrackerActionPerformed

    private void updateStatusBTNtracker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStatusBTNtracker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateStatusBTNtracker1ActionPerformed

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
    private javax.swing.JTextField AddTipTF;
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Navbar;
    private javax.swing.JPanel QuizPanel;
    private javax.swing.JPanel TipPanel;
    private javax.swing.JPanel TrackerPanel;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JTextField actionInput;
    private javax.swing.JToggleButton addBTNtracker;
    private javax.swing.JButton addBtn1;
    private javax.swing.ButtonGroup answerBtnGroup;
    private javax.swing.JRadioButton answerFour;
    private javax.swing.JRadioButton answerOne;
    private javax.swing.JRadioButton answerThree;
    private javax.swing.JRadioButton answerTwo;
    private javax.swing.JToggleButton deleteBTNtracker;
    private javax.swing.JButton displayAllBTNtracker;
    private javax.swing.JRadioButton energyButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JButton navExitBtn;
    private javax.swing.JButton navQuizBtn;
    private javax.swing.JButton navTipBtn;
    private javax.swing.JButton navTrackerBtn;
    private javax.swing.JButton nextBTNtracker;
    private javax.swing.JButton nextQuestionBtn;
    private javax.swing.JButton nextTipBtn1;
    private javax.swing.JButton prevQuestionBtn;
    private javax.swing.JButton prevTipBtn2;
    private javax.swing.JTextArea questionTa;
    private javax.swing.JButton quizResetBtn;
    private javax.swing.JRadioButton recycleButton;
    private javax.swing.JLabel selectAnswerlbl;
    private javax.swing.ButtonGroup tipButtonGroup1;
    private javax.swing.JTextArea tipTa1;
    private java.awt.TextArea trackerDisplay;
    private javax.swing.JRadioButton transportButton;
    private javax.swing.JButton updateStatusBTNtracker1;
    private java.awt.TextArea welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
