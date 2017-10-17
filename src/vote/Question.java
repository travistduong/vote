package vote;

/**
 * TRAVIS DUONG
 * CS 356
 * 10/17/17
 */

public class Question {
	String qtext;
	int answerNum;
	int choiceFlag = 0; // "0" for single choice; "1" for multiple choice
	
	public Question(String qtext, int answerNum, int choiceFlag) {
		this.qtext = qtext;
		System.out.println("Your question text has been set as '" + qtext + "'");
		this.answerNum = answerNum;
		System.out.println("Your number of answers has been set as " + answerNum + ".");
		this.choiceFlag = choiceFlag;
		if (choiceFlag == 0) {
			System.out.println("The question type has been set to single choice.");
		} else {
			System.out.println("The question type has been set to multiple choice.");
			System.out.println("Select multiple answers by submitting your answers delimited by a space character (ex: 1 2 3).");
		}
	}
	
	public Question() {
		qtext = "default";
		answerNum = 0;
		choiceFlag = 0;
	}

	public void setQText(String text) {
		qtext = text;
		System.out.println("Your question text has been set.");
	}
	
	public String getQText() {
		return qtext;
	}
	
	public void setAnswerNum(int num) {
		answerNum = num;
		System.out.println(answerNum + " possible answers have been created.");
	}
	
	public int getAnswerNum() {
		return answerNum; 
	}
	
	public void setChoiceFlag(int flag) {
		choiceFlag = flag;
		if (choiceFlag == 0) {
			System.out.println("A single choice question has been created.");
		} else {
			System.out.println("A multiple choice question has been created.");
		}
	}
	
	public int getChoiceFlag() {
		return choiceFlag;
	}
}
