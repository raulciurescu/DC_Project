package bench;
import timing.*;
import logging.*;

interface IBenchmark {
    void run();
}

class MyBenchmarkTestbench {
    public static void main(String[] args) {
        // Initialize timer, logger, and benchmark
        ITimer timer = new Timer();
        ILogger logger = new ConsoleLogger(); // or FileLogger(filePath)

        // Custom initialization for the benchmark (if needed)
        // e.g., benchmark.initialize(args);

        // Start timing
        timer.start();

        // Run the benchmark

        // Stop timing
        long elapsedTime = timer.stop();

        // Print the result
        logger.write("Elapsed Time:", elapsedTime, "nanoseconds");

        // Close the logger
        logger.close();
    }
}
