import java.util.*;

import BinarySearchTreeLab.Node;

import java.io.*;

// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

public class QuestionsGame {
   //global variables
	private QuestionNode root;
	
	String curr;
	
	public QuestionsGame() {
		
	}
	
	private void preOrder(QuestionNode n) { 
		if(n != null) {
			
			preOrder(n.left);
			preOrder(n.right);
		}
		return;
	}
	
	public void read(String filename) throws Exception{
		Scanner file = new Scanner(new File(filename));
		
		//first 2 lines are always root node
		file.nextLine().trim();
		root.data = file.nextLine().trim();
		
		//checks for question/answer
		
		QuestionNode temp = root;
		while(temp.left != null)
		while(file.hasNext()) {
			String status = file.nextLine().trim();
			String words = file.nextLine().trim();
			add(status + " " + words);
			
		}
		
		file.close();
	}
	
	private void add(String o)
	{
		root = add( o, root );		
	}
	private QuestionNode add( String o, QuestionNode n )
	{
		if(n == null) {
			n = new QuestionNode(o, null, null);
		}
		if(n.left != null && n.left.data.substring(0,2).equals("A:")) {
			n.right = add(o, n.right);
		}
		else {
			n.left = add(o, n.left);
		}
		
		return n;
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
