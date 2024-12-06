/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenshift;
import java.util.*;
/**
 *
 * @author aorpr
 */
public class QuizApp {
    private List<Question> questions; // List of Question objects
    private int[] userAnswers;
    private int currentQuestion; //int for index of current question 

    public QuizApp(List<Question> questions) {
        this.questions = questions;
        this.userAnswers = new int[questions.size()];
        Arrays.fill(userAnswers, -1); // Initialize unanswered
        this.currentQuestion = 0;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestion);
    }

    
    public void setUserAnswer(int answerIndex) {
        userAnswers[currentQuestion] = answerIndex;
    }

    public int getUserAnswer() {
        return userAnswers[currentQuestion];
    }

    public boolean hasNextQuestion() {
        return currentQuestion < questions.size() - 1;
    }

    public boolean hasPreviousQuestion() {
        return currentQuestion > 0;
    }

    //Next q if there even is a next q 
    public void nextQuestion() {
        if (hasNextQuestion()) {
            currentQuestion++;
        }
    }

    //If has prev q, then -- to go prev
    public void previousQuestion() {
        if (hasPreviousQuestion()) {
            currentQuestion--;
        }
    }

    //For each question user gets correct out of i questions, score up. 
    public int calculateScore() {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (userAnswers[i] == questions.get(i).getCorrectAnswer()) {
                score++;
            }
        }
        return score;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}
