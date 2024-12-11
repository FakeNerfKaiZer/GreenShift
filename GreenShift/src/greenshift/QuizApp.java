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
    private List<Question> questions; // List of Question objects in the quiz.
    private int[] userAnswers; // Stores user's answers; -1 indicates unanswered questions.
    private int currentQuestion; // Index of the currently displayed question.

    // Constructor to initialize the quiz with a list of questions.
    public QuizApp(List<Question> questions) {
        this.questions = questions;
        this.userAnswers = new int[questions.size()];
        Arrays.fill(userAnswers, -1); // Initialize all questions as unanswered.
        this.currentQuestion = 0; // Start with the first question.
    }

    // Returns the currently displayed question.
    public Question getCurrentQuestion() {
        return questions.get(currentQuestion);
    }

    // Records the user's answer for the current question.
    public void setUserAnswer(int answerIndex) {
        userAnswers[currentQuestion] = answerIndex;
    }

    // Retrieves the user's answer for the current question.
    public int getUserAnswer() {
        return userAnswers[currentQuestion];
    }

    // Checks if there is a next question to navigate to.
    public boolean hasNextQuestion() {
        return currentQuestion < questions.size() - 1;
    }

    // Checks if there is a previous question to navigate to.
    public boolean hasPreviousQuestion() {
        return currentQuestion > 0;
    }

    // Moves to the next question if available.
    public void nextQuestion() {
        if (hasNextQuestion()) {
            currentQuestion++;
        }
    }

    // Moves to the previous question if available.
    public void previousQuestion() {
        if (hasPreviousQuestion()) {
            currentQuestion--;
        }
    }

    // Calculates the user's score by counting correctly answered questions.
    public int calculateScore() {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (userAnswers[i] == questions.get(i).getCorrectAnswer()) {
                score++; // Increment score for each correct answer.
            }
        }
        return score;
    }

    // Returns the total number of questions in the quiz.
    public int getTotalQuestions() {
        return questions.size();
    }
}
