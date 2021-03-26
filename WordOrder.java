package lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WordOrder {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		File file = new File("words.txt");
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String lineWords[] = line.split("[\\s.,]+");
				words.addAll(Arrays.asList(lineWords));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collections.sort(words);
		System.out.println(words);
	}

}