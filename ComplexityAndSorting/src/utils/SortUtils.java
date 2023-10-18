package utils;

import shapes.Shape;

public class SortUtils {

    // Bubble Sort 
    public static void bubbleSort(Shape[] shapes, String sortType) {
        int n = shapes.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (shouldSwap(shapes[j], shapes[j + 1], sortType)) {
                    // Swap shapes[j+1] and shapes[j]
                    Shape temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                    
                    swapped = true;
                }
            }

            // If no two adjacent elements were swapped, the array is sorted
            if (!swapped) break;
        }
    }

    // Quick Sort 
    public static void quickSort(Shape[] shapes, String sortType, int low, int high) {
        if (low < high) {
            int pi = partition(shapes, sortType, low, high);
            
            quickSort(shapes, sortType, low, pi - 1);
            quickSort(shapes, sortType, pi + 1, high);
        }
    }

    private static int partition(Shape[] shapes, String sortType, int low, int high) {
        Shape pivot = shapes[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (shouldSwap(pivot, shapes[j], sortType)) {
                // Swap shapes[i] and shapes[j]
                Shape temp = shapes[i];
                shapes[i] = shapes[j];
                shapes[j] = temp;
                
                i++;
            }
        }

        // Swap shapes[i] and shapes[high]
        Shape temp = shapes[i];
        shapes[i] = shapes[high];
        shapes[high] = temp;

        return i;
    }

    private static boolean shouldSwap(Shape a, Shape b, String sortType) {
        switch (sortType) {
            case "v":
                return a.getVolume() < b.getVolume();
            case "h":
                return a.getHeight() < b.getHeight();
            case "a":
                return a.getBaseArea() < b.getBaseArea();
            default:
                return false;
        }
    }
}
