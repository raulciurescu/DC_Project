package logging;

public enum TimeUnit {
    Nano(1),
    Micro(1_000),
    Milli(1_000_000),
    Sec(1_000_000_000);

    private final long multiplier;

    TimeUnit(long multiplier) {
        this.multiplier = multiplier;
    }

    // Convert time value from one unit to another
    public static long convert(long value, TimeUnit fromUnit, TimeUnit toUnit) {
        return (value * fromUnit.multiplier) / toUnit.multiplier;
    }
}
