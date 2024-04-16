package bench;

import timing.ITimer;
import timing.Timer;

import java.util.Random;

public class DemoBenchmark implements IBenchmark {
    private int[] array;
    private int sleepTime; // Represents the sleep time in milliseconds
    private volatile boolean running; // Indicates whether the benchmark is running

    @Override
    public void initialize(int size) {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }

        this.sleepTime = sleepTime;
        running = true;
    }

    @Override
    public void run() {
        // Implement your algorithm here using the initialized array
        // For demo purposes, let's just do a simple iteration over the array
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        // You can print the result or perform any other operation here

        while (running ) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initializeTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void cancel() {
        running = false;
    }

}
