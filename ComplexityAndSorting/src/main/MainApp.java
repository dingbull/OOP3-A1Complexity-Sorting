package main;

import utils.SortUtils;
import shapes.Shape;
import shapes.Cylinder;
import shapes.Cone;
import shapes.Pyramid;
import shapes.Prism;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MainApp {

    public static void main(String[] args) {
        String fileName = ""; // File name
        String sortType = ""; // Sorting criteria
        String algorithm = ""; // Sorting algorithm

        // Parse command-line arguments
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-f":
                case "-F":
                    fileName = args[++i];
                    break;
                case "-t":
                case "-T":
                    sortType = args[++i];
                    break;
                case "-s":
                case "-S":
                    algorithm = args[++i];
                    break;
            }
        }

        // Create path for the file
        String fullPath = "./res/" + fileName;

        // Result shows "File not found: .\res (Access is denied)" This is to check path to debug file access issues
        System.out.println("Attempting to read file from: " + fullPath);

        try {
            // Read shapes from the file
            BufferedReader reader = new BufferedReader(new FileReader(fullPath));
            int numShapes = Integer.parseInt(reader.readLine().trim());
            Shape[] shapes = new Shape[numShapes];

            for (int i = 0; i < numShapes; i++) {
                String[] data = reader.readLine().split(" ");
            }

            // Start timing
            long startTime = System.currentTimeMillis();

            // Perform the sorting
            if ("b".equals(algorithm)) {
                SortUtils.bubbleSort(shapes, sortType);
            } else if ("q".equals(algorithm)) {
                SortUtils.quickSort(shapes, sortType, 0, shapes.length - 1);
            }
            else if ("i".equals(algorithm)) 
            {
                SortUtils.insertionSort(shapes, sortType);
            }
            else if ("h".equals(algorithm)) 
            {
                SortUtils.heapSort(shapes, sortType);
            }

            // Stop timing
            long endTime = System.currentTimeMillis();

            // Output the time taken
            System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

            // Output the sorted shapes
            System.out.println("First sorted value: " + shapes[0]);
            System.out.println("Last sorted value: " + shapes[shapes.length - 1]);
            // ... every thousandth value in between, if needed

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
