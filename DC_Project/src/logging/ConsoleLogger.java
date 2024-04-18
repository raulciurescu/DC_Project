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
    public void close() {
        // No resources to close in this simple implementation
    }

    @Override
    public void writeTime(long value, TimeUnit unit) {
        // Convert time value to the specified unit and print
        long convertedValue = convertTime(value, unit);
        System.out.println(convertedValue + " " + unit);
    }

    @Override
    public void writeTime(String string, long value, TimeUnit unit) {
        // Convert time value to the specified unit and print with message
        long convertedValue = convertTime(value, unit);
        System.out.println(string + " " + convertedValue + " " + unit);
    }

    // Convert time value to the specified unit
    private long convertTime(long value, TimeUnit unit) {
        switch (unit) {
            case Nano:
                return value;
            case Micro:
                return value / 1_000;
            case Milli:
                return value / 1_000_000;
            case Sec:
                return value / 1_000_000_000;
            default:
                throw new IllegalArgumentException("Invalid TimeUnit: " + unit);
        }
    }
}
