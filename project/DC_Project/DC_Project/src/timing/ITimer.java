package timing;
public interface ITimer {
    void start(); // Start the timer
    long stop(); // Stop the timer and return the total elapsed time since start in nanoseconds
    void resume(); // Resume the timer without resetting the previous elapsed time
    long pause(); // Pause the timer and return the elapsed time since the last start or resume in nanoseconds
}

