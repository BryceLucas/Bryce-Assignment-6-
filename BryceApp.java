import java.util.Scanner;

public class BryceApp {

    public static void generateAndSaveRandomArray() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the length of the array to generate: ");
            int arrayLength = scanner.nextInt();
            
            int[] array = ArrayUtilities.createRandomArray(arrayLength);
            
            System.out.println("Enter the filename to save the random array: ");
            String filename = scanner.next();
            
            ArrayUtilities.writeArrayToFile(array, filename);
            System.out.println("Random array saved to file: " + filename);
        }
    }

    public static void sortFileAndSaveToNewFile() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the filename to read the array from: ");
            String filename = scanner.next();
            int[] array = ArrayUtilities.readFileToArray(filename);
            
            ArrayUtilities.bubbleSort(array);
            
            System.out.println("Enter the filename to save the sorted array: ");
            String sortedFilename = scanner.next();
            ArrayUtilities.writeArrayToFile(array, sortedFilename);
            System.out.println("Sorted array saved to file: " + sortedFilename);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option:\n1. Generate and save a random array\n2. Read, sort, and save an array from a file");
            int choice = scanner.nextInt();

            if (choice == 1) {
                generateAndSaveRandomArray();
            } else if (choice == 2) {
                sortFileAndSaveToNewFile();
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
