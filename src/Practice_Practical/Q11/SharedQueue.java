package Q11;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SharedQueue {
    public SharedQueue(BlockingQueue<Path> blockingQueue) {
        this.blockingQueue = new ArrayBlockingQueue<Path>(10);
    }

    BlockingQueue<Path> blockingQueue;
}
