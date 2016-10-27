package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images
		String[] baseParts = { System.getProperty("user.dir"), "images" };
		String dir = String.join(File.separator, baseParts);
		String relPath;
		String[] relPathParts = null;
		Picture picture = null;
		Scanner in = new Scanner(System.in);

		// prompt user for image to filter and validate input
		do {
			String imagePath = "path not set";

			// try to open the file
			try {

				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();

				relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));

				picture = new Picture(imagePath);

			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}

		} while (picture == null);

		// prompts user for filter and validate input

		// pass filter ID int to getFilter, and get an instance of Filter back
		Filter filter = null;

		while (filter == null) {

			int filterID = displayFilter(in);

			try {
				filter = getFilter(filterID);
			} catch (Exception e) {
				System.out.println("Invalid Filter ID");
			}

		}

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();

		System.out.println("Image successfully filtered");

		// save image, if desired

		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		String overwrite = "";

		// if the user enters the same file name as the input file, confirm that
		// they want to overwrite the original

		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			while (fileName.equals(relPathParts[relPathParts.length - 1]) && !overwrite.equals("yes")) {
				if (!fileName.equals(relPathParts[relPathParts.length - 1])) {
					break;
				}
				System.out.println("Are you sure you want to overwrite your file?\n(\"yes\" or \"no\")");
				overwrite = in.next();
				if (overwrite.equals("no")) {
					System.out.println("New File name?");
					fileName = in.next();
				}

			}

			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}

		// close input scanner
		in.close();
	}

	// this method accepts an int parameter, and returns an instance of the
	// Filter interface
	// this method throws an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int fNum) throws Exception {

		Filter filter;
		switch (fNum) {
		case 1:
			filter = new BlueFilter();
			break;
		case 2:
			filter = new GreyscaleFilter();
			break;
		case 3:
			filter = new BlurFilter();
			break;
		case 4:
			filter = new InverseFilter();
			break;
		case 5: 
			filter = new HighContrast();
			break;
		default:
			throw (new Exception("Not a valid filter"));
		}

		return filter;
	}

	private static int displayFilter(Scanner in) {
		int filterID = 0;
		String[] filters = { "Blue Filter : 1", "Greyscale : 2", "5 px Box Blur: 3", 
				"Inverse Filter: 4", "High Contrast: 5" };

		System.out.println("Please Select a filter by the corresponding number:");
		for (String s : filters) {
			System.out.println(s);
		}
		while (filterID == 0) {
			try {
				filterID = Integer.parseInt(in.next());
			} catch (Exception e) {
				System.out.println("Not a Valid filter");
			}
		}

		return filterID;
	}

	public static void filterImage(int filterID, String fileName) {

		// Create the base path for images
		String[] baseParts = { System.getProperty("user.dir"), "images" };
		String dir = String.join(File.separator, baseParts);
		String relPath;
		String[] relPathParts = null;
		Picture picture = null;

		// prompt user for image to filter and validate input
		do {

			String imagePath = "path not set";

			// try to open the file
			try {
				relPath = fileName;

				relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));

				picture = new Picture(imagePath);

			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}

		} while (picture == null);

		// pass filter ID int to getFilter, and get an instance of Filter back
		Filter filter = null;
		try {
			filter = getFilter(filterID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();

		// System.out.println("Image successfully filtered");
	}

}