package logging;

public class ConsoleLogger implements ILogger {

    @Override
    public void write(long value) {
        System.out.println(value);
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public void write(Object... values) {
        for (Object value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    @Override
    public void writeTime(String message, long time, TimeUnit unit) {
        double convertedTime;
        String unitString;
        switch (unit) {
            case Nano:
                convertedTime = time;
                unitString = "Nano";
                break;
            case Micro:
                convertedTime = time / 1000.0;
                unitString = "Micro";
                break;
            case Milli:
                convertedTime = time / 1000000.0;
                unitString = "Milli";
                break;
            case Sec:
                convertedTime = time / 1000000000.0;
                unitString = "Sec";
                break;
            default:
                throw new IllegalArgumentException("Unknown TimeUnit");
        }
        write(message + " " + String.format("%.2f", convertedTime) + " " + unitString);
        logger.writeTime("Finished in", elapsedTime, TimeUnit.Milli);
    }

    @Override
    public void close() {
        // No action needed for closing console output
    }
}
