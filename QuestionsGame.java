import java.io.*;
import java.util.Scanner;

// Andre Zhang & Thanh Duong
//

public class QuestionsGame {
    // Your code here
	QuestionNode root;

   
    Scanner file;
    
    public QuestionsGame() {
    	root = null;
    	file = new Scanner(System.in);
    }
    
    public void read(String filename) throws Exception{
    	Scanner scan = new Scanner(new File(filename));
    	root = read(scan);
    } 
    
    private QuestionNode read(Scanner scan) {
    	String type = scan.nextLine().trim();
        String data = scan.nextLine().trim();
        QuestionNode cur = new QuestionNode(data, type);  
    
        if (type.contains("Q:")) {
           cur.left = read(scan);
           cur.right = read(scan);   
        }
        
        return cur; 
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
    
    public void write(String filename) throws Exception {
    	File file = new File(filename);
    	PrintWriter writer = new PrintWriter(file);
    	write(root, writer);
    	writer.close();
    }
    private void write(QuestionNode n, PrintWriter writer) {
    	 if (n.type.equals("A:")) {
             writer.println("A:"); 
             writer.println(n.data);
          } else {
             writer.println("Q:");
             writer.println(n.data);
             write(n.left, writer);
             write(n.right, writer); 
          }   
    }
    
    public void askQuestions() {
    	System.out.println("Welcome to 20 Questions! \n");
    	askQuestions(root);
    	
    }
    
    private void askQuestions(QuestionNode n) {
    	//if it reaches an answer
    	if(n.left == null &&  n.right == null) {
    		System.out.println("would your object happen to be " + n.data + " (y/n)?");
    		//if the tree wins
    		String s = file.next().trim().toLowerCase();
    		if(s.equals("y")) {
    			System.out.println("Great, I got it right!");
    			return;
    		}
    		//if the tree doesn't guess what it is
    		else if (s.equals("n")){
    			System.out.println("What is the name of your object?"); 
    			QuestionNode ans = new QuestionNode(file.next().trim(), "A:");
    			System.out.println("Please give me a yes/no question that distinguishes between your object and mine -->");
    			file.nextLine();
    			String q = file.nextLine().trim();
    			System.out.println("And what is the answer for your object (y/n)?");
    			String a = file.next().trim();
    			if(a.equals("y")) {
    				n.right = new QuestionNode(ans, null, q, "Q:");
    			}
    			else if(a.equals("n")) {
    				n.right = new QuestionNode(null, ans, q, "Q:");
    			}
    			else {
    				System.out.println("Sorry, that wasn't a valid answer.");
    				askQuestions(n);
    			}
    			return;
    		}
    		//if the user answers with anything besides a yes or no
    		else {
    			System.out.println("Please answer with a \"y\" or a \"n\"");
    			askQuestions(n);
    		}
    	}
    	//if its still traversing
    	else {
    		System.out.println(n.data + " (y/n)?");
    		//go left if they say yes
    		String s = file.next().trim().toLowerCase();
    		if(s.equals("y")) {
    			askQuestions(n.left);
    			
    		}
    		//go right if they say no
    		else if (s.equals("n")){
    			askQuestions(n.right);
    		
    		}
    		//if they answer with anything else
    		else {
    			System.out.println("Please answer with a \"y\" or a \"n\"");
    			askQuestions(n);
    		}
    	}
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
    	public QuestionNode(String txt, String t) {
    		left = null;
    		right = null;
    		data = txt;
    		type = t;
    		
    	}
    }
    
    
    
}