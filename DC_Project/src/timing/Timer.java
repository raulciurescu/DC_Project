// Timer.java
package timing;

public class Timer implements ITimer {
    private long startTime;
    private long totalTime;

    public Timer() {
        this.startTime = 0;
        this.totalTime = 0;
    }

    @Override
    public void start() {
        startTime = System.nanoTime();
        totalTime = 0; // Reset total time
    }

    @Override
    public long stop() {
        if (startTime == 0) {
            throw new IllegalStateException("Timer has not been started.");
        }
        long endTime = System.nanoTime();
        totalTime += (endTime - startTime);
        startTime = 0; // Reset start time
        return totalTime;
    }

    @Override
    public void resume() {
        startTime = System.nanoTime();
    }

    @Override
    public long pause() {
        if (startTime == 0) {
            throw new IllegalStateException("Timer has not been started.");
        }
        long currentTime = System.nanoTime();
        long elapsedTime = currentTime - startTime;
        startTime = currentTime; // Update start time for resume
        totalTime += elapsedTime;
        return elapsedTime;
    }
}