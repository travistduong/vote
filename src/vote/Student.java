package vote;

/**
 * TRAVIS DUONG
 * CS 356
 * 10/17/17
 */
public class Student {
	
	String ID;
	String answer;
	
	public Student(int ID) {
		this.ID = Integer.toString(ID);
	}
	
	public Student(int ID, String answer) {
		this.ID = Integer.toString(ID);
		this.answer = answer;
	}
	
	public void setID(int ID) {
		this.ID = Integer.toString(ID);
	}
	
	public int getID() {
		return Integer.parseInt(ID);
	}
	
	public void setAnswer(String ans) {
		answer = ans;
	}
	
	public String getAnswer() {
		return answer;
	}
}
