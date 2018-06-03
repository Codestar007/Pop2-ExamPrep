package Q11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class Runner {
    BlockingQueue<Path> sharedQueue = new ArrayBlockingQueue<Path>(10);

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.go();
    }

    public void go() {
        Thread thread = new Thread(new FileQueuer(sharedQueue));
        thread.start();
    }
}

