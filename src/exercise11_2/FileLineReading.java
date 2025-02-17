package exercise11_2;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.Scanner;

public class FileLineReading {

	public static final String BASE_PATH = "src/exercise11_2/";

	public static void main(String[] args) {

		if (args.length > 0) {
			for (String arg : args) {

				getLineNum(arg);
			}
		} else {
			System.out.println("No arguments provided.");
		}
	}

	/**
	 * Counts the number of lines in a file specified in the command line It prints
	 * out the name of the file and the number of lines in the file.
	 * @param arg file path passed in from the command line
	 */
	private static void getLineNum(String arg) {
		int lineNum = 0;
		Scanner scanner;
		try {
			scanner = new Scanner(new File(BASE_PATH + arg));
			while (scanner.hasNext()) {
				scanner.nextLine();
				lineNum++;
			}
			System.out.println("File Name: " + arg + " has " + lineNum + " lines.");
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file.");
			return;  // End the program by returning from main().
		}
		scanner.close();
	}

}