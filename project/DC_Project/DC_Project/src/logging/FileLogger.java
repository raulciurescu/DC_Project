package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements ILogger {
    private PrintWriter writer;

    public FileLogger(String filePath) {
        try {
            writer = new PrintWriter(new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(long value) {
        writer.println(value);
    }

    @Override
    public void write(String message) {
        writer.println(message);
    }

    @Override
    public void write(Object... values) {
        for (Object value : values) {
            writer.print(value + " ");
        }
        writer.println();
    }

    @Override
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
