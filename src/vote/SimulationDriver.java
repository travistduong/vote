package vote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * TRAVIS DUONG
 * CS 356
 * 10/17/17
 */
public class SimulationDriver {
	
	public static void main(String[] args) {
	
		IVoteService test = new IVoteService();
		test.serviceStart();  // begin
		
		ArrayList<String> testAnswers = new ArrayList<String>();  // creating sample answers
		String[] week = {"MON", "TUES", "WED", "THU", "FRI", "SAT", "SUN"};
		testAnswers.addAll(Arrays.asList(week));
		
		test.setAnswers(testAnswers);  // (1) set the answers in IVoteService
		
		Question testQuestion = new Question("What day is it today?", 7, 1);  
		// (2) Creates a test question using the constructor (String qtext, int answerNum, int choiceFlag)
		test.setQuestion(testQuestion);  // set the question in IVoteService
		
		Random randy = new Random();
		// (3) Randomly generate number of students and their answers.
		int numStudents = randy.nextInt(30) + 1;
		System.out.println(numStudents + " random students have been created.");
		ArrayList<Student> randStudents = new ArrayList<Student>();
		for (int id = 0; id < numStudents; id++) {
			int randAnswer = randy.nextInt(7) + 1;
			randStudents.add(new Student(id, Integer.toString(randAnswer)));
		}
		
		for (Student s : randStudents) {
			// (4) Submit all students' answers.
			test.submission(s);
		}
		
		// Uncomment these lines to test multiple choice input.
		// Student stud = new Student(1, "1 2 3 4 5");
		// test.submission(stud);
		
		test.updateValues();
		
		test.output(); // (5) Output the results.

	}

}
