package bench;

import java.util.Random;
import java.lang.InterruptedException;


public class DemoBenchmark implements IBenchmark {
    private int[] array;
    private boolean running = true; // Add running flag

    @Override
    public void run() throws InterruptedException{
        for (int i = 0; i < array.length && running; i++) {
            Thread.sleep(array.length); // Simulate some work (bubble sort)
            bubbleSort(array);
        }
    }

    @Override
    public void run(Object... params) {
        // This method is not used in this implementation
    }

    @Override
    public void initialize(Object... params) {
        // Initialize the array with random values of specified size
        int size = (int) params[0];
        array = generateRandomArray(size);
    }

    @Override
    public void clean() {
        // Clear the array
        array = null;
    }

    @Override
    public void cancel() {
        running = false; // Set running to false when cancel is called
    }

    // Method to generate an array of specified size with random values
    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    // Bubble sort implementation
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
