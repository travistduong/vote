package vote;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * TRAVIS DUONG
 * CS 356
 * 10/17/17
 */

public class IVoteService {
	private Question question;  // stores question text
	private ArrayList<String> answers = new ArrayList<String>();  // stores answer text
	private String[] submissions = new String[100];  // stores student submissions
	private int[] answerCount;  // stores answer totals

	public void serviceStart() {
		System.out.println("Hello!  Welcome to Travis Duong's iVote Program.");
		Arrays.fill(submissions, "0");  // fills the array with '0's to begin
		// configure();  // Uncomment the beginning of this line to take user input.
	}

	private void configure() {
		// This method takes user input to configure the question.
		System.out.println("What type of question would you like?");
		System.out.println("For single choice, type in 0");
		System.out.println("For multiple choice, type in 1");
		
		question = new Question();
		
		Scanner sc = new Scanner(System.in);
		int input1 = sc.nextInt();
		if (input1 == 0) {
			question.setChoiceFlag(0);
		} else if (input1 == 1) {
			question.setChoiceFlag(1);
		} else {
			System.out.println("Error: Invalid entry!");
		}
		
		System.out.println("How many possible answers should there be?");
		int input2 = sc.nextInt();
		question.setAnswerNum(input2);
		sc.nextLine();
		
		for (int i = 1; i <= input2; i++) {
			System.out.println("Please enter text for answer " + i + ": ");
			answers.add(sc.nextLine());
		}
		
		System.out.println("Please enter text for the question: ");
		String input3 = sc.nextLine();
		question.setQText(input3);
		
		System.out.println("Your question has been configured!");
		
		sc.close();
	}
	
	public void submission(Student student) {
		submissions[student.getID()] = student.getAnswer();  // saves the student's answer into an array location equivalent to their ID
	}

	public void updateValues() {
		// Once all submissions have been received, this function is designed to store and record the results of the vote.
		answerCount = new int[question.getAnswerNum() + 1];  // Integer array that stores the vote totals.
		for (int i = 0; i < 100; i++) {
			if (question.getChoiceFlag() == 0) {
				// places each student's vote into its corresponding locations in answerCount; incrementing the value
				answerCount[Integer.parseInt(submissions[i])] = answerCount[Integer.parseInt(submissions[i])] + 1; 
			} else {
				// scans the submission text to grab all votes by the student, and increments the vote value
				Scanner scanner = new Scanner(submissions[i]);
				scanner.useDelimiter(" ");  // Multiple choice submissions are sent in the following format: "1 2 3"
				while (scanner.hasNext()) {
					String scan = scanner.next();
					answerCount[Integer.parseInt(scan)] += 1;
				}
				scanner.close();
			}
		}
	}

	public void output() {
		// Prints the Question.
		System.out.println("Question: " + getQuestion().getQText());
		// Prints the results.
		System.out.println("The results are as follows: ");
		for (int i = 1; i <= question.getAnswerNum(); i++) {
			System.out.println(getAnswers().get(i - 1) + ": " + answerCount[i]);
		}
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	
	public ArrayList<String> getAnswers() {
		return answers;
	}
}
