package logging;
import logging.TimeUnit;

public interface ILogger{
    void write(long value);
    void write(String message);
    void write(Object... values);
    void close();
    void writeTime(long value, TimeUnit unit);
    void writeTime(String string, long value, TimeUnit unit);
}
