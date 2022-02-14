package Tree2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class QRunner {
	public static void main(String[] args) throws Exception {
		QRunner a = new QRunner();
		a.run();
	}

	public void run() throws Exception {
		QuestionsGame bob = new QuestionsGame();
		Scanner scan = new Scanner(new File("spec-questions.txt"));
		bob.read("spec-questions.txt");
		bob.preOrder();
	}
} 
