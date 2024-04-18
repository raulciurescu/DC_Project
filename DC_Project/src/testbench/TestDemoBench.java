package testbench;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import bench.DemoBenchmark;
import timing.Timer;
import java.lang.InterruptedException;

public class TestDemoBench {
    public static void main(String[] args) throws InterruptedException{
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new DemoBenchmark();

        final int workload = 100;
        for(int i=0; i<10; i++) {
            bench.initialize(workload);
            timer.start(); // Start the timer before the benchmark run
            bench.run();
            if(i==2) bench.cancel();
            // Set the time unit to Milli
            TimeUnit timeUnit = TimeUnit.Sec;
            log.writeTime("Finished in", timer.stop(), timeUnit); // Stop the timer here
        }

        log.close();
        bench.clean();
    }
}
