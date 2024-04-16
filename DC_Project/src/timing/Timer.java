package timing;

public class Timer implements ITimer {
    private long startTime; // Stores the start time in nanoseconds
    private long elapsedTime; // Stores the total elapsed time in nanoseconds
    private boolean isRunning; // Indicates whether the timer is running or paused

    public Timer() {
        this.elapsedTime = 0;
        this.isRunning = false;
    }

    @Override
    public void start() {
        if (!isRunning) {
            startTime = System.nanoTime();
            isRunning = true;
        }
    }

    @Override
    public long stop() {
        if (isRunning) {
            long endTime = System.nanoTime();
            elapsedTime += endTime - startTime;
            isRunning = false;
        }
        return elapsedTime;
    }

    @Override
    public void resume() {
        if (!isRunning) {
            startTime = System.nanoTime();
            isRunning = true;
        }
    }

    @Override
    public long pause() {
        if (isRunning) {
            long pauseTime = System.nanoTime();
            elapsedTime += pauseTime - startTime;
            isRunning = false;
            startTime = pauseTime;
            return pauseTime - startTime;
        }
        return 0; // Timer is already paused
    }
}
