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
    private List<Question> questions;
    private int[] userAnswers;
    private int currentQuestion;

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

    public void nextQuestion() {
        if (hasNextQuestion()) {
            currentQuestion++;
        }
    }

    public void previousQuestion() {
        if (hasPreviousQuestion()) {
            currentQuestion--;
        }
    }

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
