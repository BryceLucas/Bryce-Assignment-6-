import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrayUtilities {

    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(101); // 0 to 100 inclusive
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i : array) {
                writer.write(i + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFileToArray(String filename) {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers.stream().mapToInt(i -> i).toArray();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}