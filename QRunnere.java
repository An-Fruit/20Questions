
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class QRunnere {
	public static void main(String[] args) throws Exception {
		QRunnere a = new QRunnere();
		a.run();
	}

	public void run() throws Exception {
		QuestionsGame bob = new QuestionsGame();
		Scanner scan = new Scanner(new File("spec-questions.txt"));
		bob.read("spec-questions.txt");
		bob.askQuestions();
		bob.preOrder();
	}
} 
