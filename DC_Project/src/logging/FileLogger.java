package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger {
    private BufferedWriter writer;

    public FileLogger(String filePath) {
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            System.err.println("Error creating/opening the file: " + e.getMessage());
        }
    }

    @Override
    public void write(long value) {
        try {
            writer.write(String.valueOf(value));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    @Override
    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    @Override
    public void write(Object... values) {
        for (Object value : values) {
            try {
                writer.write(String.valueOf(value) + " ");
            } catch (IOException e) {
                System.err.println("Error writing to the file: " + e.getMessage());
            }
        }
        try {
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Error closing the file: " + e.getMessage());
            }
        }
    }

    @Override
    public void writeTime(long value, TimeUnit unit) {

    }

    @Override
    public void writeTime(String string, long value, TimeUnit unit) {

    }
}
