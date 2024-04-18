package bench;
import java.lang.InterruptedException;

public interface IBenchmark {

        void run() throws InterruptedException;
        void run(Object... params);
        void initialize(Object... params);
        void clean();
        void cancel();
}
