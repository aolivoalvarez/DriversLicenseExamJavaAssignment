import java.util.ArrayList;
import java.util.Scanner;

public class DriverExam {
	
	static boolean passed(int correct) { //method to check if student passed
		if (correct >= 15) { //if number of correct answers is 15 or more, the student passes
			return true;
		}
		else {
			return false;
		}
	}
	
	static int totalCorrect(char[] answers, char[] student) { //method to determine how many correct answers the student had
		
		int correct = 0; //number of correct answers
		
		for (int i = 0; i < student.length; i++) { //iterates through all student answers
			
			if (student[i] == answers[i]) { //compares each element of the arrays
				correct++; //adds one to correct if the student has the correct answer
			}
		}
		return correct;
	}
	
static int totalIncorrect(char[] answers, char[] student, ArrayList<Integer> wrong) { //method to determine how many incorrect answers the student had
		
		int incorrect = 0; //number of incorrect answers
		
		for (int i = 0; i < student.length; i++) { //iterates through all student answers
			
			if (student[i] != answers[i]) { //compares each element of the arrays
				incorrect++; //adds one to incorrect if the student has the incorrect answer
				wrong.add(i + 1); //adds the question number to an arraylist of wrong answers
				
			}
		}
		return incorrect;
	}

	public static void main(String[] args) {
		//initialize
		Scanner input = new Scanner(System.in);
		
		boolean passed = false;
		int correct = 0;
		int incorrect = 0;
		char currentAnswer = ' ';
		
		char[] correctAnswers = { 'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D', 'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'};
		char[] studentAnswers = new char[20];
		
		ArrayList<Integer> missedQuestions = new ArrayList<Integer>();
		
		for (int i = 0; i < studentAnswers.length; i++) { //loop to get student answers
			System.out.print("Please enter your answer for question " + (i + 1) + ": ");
			currentAnswer = input.next().charAt(0);
			
			while ((currentAnswer != 'A') && (currentAnswer != 'B') && (currentAnswer != 'C') && (currentAnswer != 'D')) { //loop to catch invalid answers
				System.out.println("Invalid answer. Please enter again: ");
				currentAnswer = input.next().charAt(0);
			}
			
			studentAnswers[i] = currentAnswer;
			
		}
		
		correct = totalCorrect(correctAnswers, studentAnswers);
		incorrect = totalIncorrect(correctAnswers, studentAnswers, missedQuestions);
		passed = passed(correct);
		
		if (passed) {
			System.out.println("You have passed your exam with a score of " + correct + " out of 20." );
		}
		else {
			System.out.println("You have failed your exam with " + incorrect + " questions missed out of 20." );
		}
		
		if (missedQuestions.size() != 0) {
			System.out.println("Here are the questions that you missed: ");
			
			for (int question : missedQuestions) {
				System.out.println(question);
			}
		}

	}

}
