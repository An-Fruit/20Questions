import java.util.*;
import java.io.*;

// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

public class QuestionsGame {
   //global variables
	private QuestionNode root;
	
	
	public QuestionsGame() {
		
	}
	public void read(String filename) throws Exception{
		Scanner file = new Scanner(new File(filename));
		//checks for question/asnwer
		
		while(file.hasNext()) {
			String status = file.nextLine().trim();
			String words = file.nextLine().trim();
			if(status.equals("Q:")) root.data = words;
		}
		
		file.close();
	}
	
	public boolean yesTo(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.println("y/n ? ");
		if(input.next().equals("y")) return true;
		else return false;
		
	}
	
	public void play() {
		return;
	}
	public static void main(String[] args) throws Exception{
		new QuestionsGame().read("spec-questions.txt");
	}

//private node class
	private static class QuestionNode {
			String data;
			QuestionNode left;
			QuestionNode right;
			
			public QuestionNode( String s, QuestionNode l, QuestionNode r)
			{
			      data = s;
			      left = l;
			      right = r;
			      
			}
			
			public String toString()
			{
				return "" + data + " " + left + " " + right;
				
			}
		}


}
