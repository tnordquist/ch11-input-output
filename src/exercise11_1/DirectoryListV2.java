package exercise11_1;

import java.io.File;
import java.util.Scanner;

/**
 * This program lists the files in a directory specified by
 * the user.  The user is asked to type in a directory name.
 * If the name entered by the user is not a directory, a
 * message is printed and the program ends.
 */
public class DirectoryListV2 {


	public static void main(String[] args) {

		String directoryName;  // Directory name entered by the user.
		File directory;        // File object referring to the directory.
		String[] files;        // Array of file names in the directory.
		Scanner scanner;       // For reading a line of input from the user.

		scanner = new Scanner(System.in);  // scanner reads from standard input.

		System.out.print("Enter a directory name: ");
		directoryName = scanner.nextLine().trim();
		directory = new File(directoryName);

		if (!directory.isDirectory()) {
			if (!directory.exists())
				System.out.println("There is no such directory!");
			else
				System.out.println("That file is not a directory.");
		} else {
//            files = directory.list();
			drillFile(directory);
//            System.out.println("Files in directory \"" + directory + "\":");
//	        if (files != null) {
//		        for (String file : files)
//					drillFile(directory,file);
//                   System.out.println("   " + file);
//	        }
		}

	} // end main()

	private static void drillFile(File directory) {
		String[] files = directory.list();
		for (String file : files) {
			File tempDir = new File(directory, file);
			if (tempDir.isFile())
				System.out.println("  " + file);
			else if (tempDir.isDirectory()) {
				System.out.println("Files in directory \"" + directory + "\":");
				drillFile(tempDir);
			}
		}


	}

} // end class DirectoryListV2
