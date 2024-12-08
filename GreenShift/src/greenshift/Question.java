/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greenshift;

/**
 *
 * @author aorpr
 */
public class Question {

    private String questionText; // The text of the question.
    private String[] answers; // Array of possible answers.
    private int correctAnswer; // Index of the correct answer in the array.

    // Constructor to initialize a question with text, answers, and the correct answer index.
    public Question(String questionText, String[] answers, int correctAnswer) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    // Returns the question text.
    public String getQuestionText() {
        return questionText;
    }

    // Returns the array of possible answers.
    public String[] getAnswers() {
        return answers;
    }

    // Returns the index of the correct answer.
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    // Sets the question text.
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    // Sets the array of possible answers.
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    // Sets the index of the correct answer.
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    // Returns a string representation of the question.
    @Override
    public String toString() {
        return "Question{" + "questionText=" + questionText + ", answers=" + answers + ", correctAnswer=" + correctAnswer + '}';
    }
    
}
