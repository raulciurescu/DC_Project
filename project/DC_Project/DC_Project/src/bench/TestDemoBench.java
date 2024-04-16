package testbench;

import bench.DemoBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

public class TestDemoBench {
    public static void main(String[] args) {
        // Initialize timer, logger, and benchmark
        ITimer timer = new Timer();
        ILogger logger = new ConsoleLogger();
        DemoBenchmark benchmark = new DemoBenchmark();

        // Custom initialization for the benchmark (if needed)
        int sleepTime = 1000; // 1 second sleep time for demo
        benchmark.initializeTime(sleepTime);

        // Test pause and resume using a loop
        for (int i = 0; i < 3; i++) {
            // Start timing
            timer.start();

            // Run the benchmark
            benchmark.runn();

            // Pause timing
            long pauseTime = timer.pause();
            logger.write("Pause Time", pauseTime, "nanoseconds");

            // Resume timing
            timer.resume();
        }

        // Stop timing
        long elapsedTime = timer.stop();

        // Print the total elapsed time
        logger.write("Total Elapsed Time:", elapsedTime, "nanoseconds");

        // Close the logger
        logger.close();
    }
}
