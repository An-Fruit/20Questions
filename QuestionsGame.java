package Tree2;

import java.io.File;
import java.util.Scanner;

// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

public class QuestionsGame {
    // Your code here
	QuestionNode root;

   
    
    
    public QuestionsGame() {
    	root = null;
    }
    
    public void read(String filename) throws Exception{
    	Scanner scan = new Scanner(new File(filename));
    	if (scan.hasNext()) {
    		String status = scan.nextLine().trim();
    		String txt = scan.nextLine().trim();
    		root  = new QuestionNode(null, null, txt, "Q");	
    	}
    	while(scan.hasNext()) {
    		String status = scan.nextLine().trim();
    		String txt = scan.nextLine().trim();
    		read(root, txt, status);
    	}
    	
    	
    	
    }
    
    private QuestionNode read(QuestionNode n, String dat, String stat) {
    	if (n == null) {
    		n = new QuestionNode(null, null, dat, stat);
    	}
    	else if (n.left != null && n.left.type.equals("A")) {
    		n.right = read(n.right,dat, stat);
    	}
    	else {
    		n.left = read(n.left, dat, stat);
    	}
    	return n;
    }
    
    private void preOrder(QuestionNode n) {
    	if (n != null) {
    		System.out.println(n.data + " ");
    		preOrder(n.left);
    		preOrder(n.right);
    	}
    }
    
    public void preOrder() {
    	preOrder(root);
    }
    
    public void write(String filename) {
    	
    }
    
    public void askQuestions() {
    	
    }
    
    
    private static class QuestionNode {
        // Your code here
    	QuestionNode left;
    	QuestionNode right;
    	String type;
    	String data;
    	
    	public QuestionNode(QuestionNode y, QuestionNode n, String txt, String t) {
    		left = y;
    		right = n;
    		data = txt;
    		type = t;
    	}
    }
    
}
