package Q11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileQueuer implements Runnable {
    public FileQueuer(BlockingQueue<Path> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    private BlockingQueue<Path> blockingQueue;

    @Override
    public void run() {

        Path path = getPath();
        queue(path);


//        ArrayList<Path> lst = new ArrayList<>();
//        try {
//            lst = Files.walk(path).Stream<Path>().
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public Path getPath() {
        Scanner sc = new Scanner(System.in);
        boolean correct = false;
        Path path = Paths.get("/Users");

        while (!correct) {
            System.out.println("Please enter your directory: ");
            String pathString = sc.nextLine();
            try {
                path = Paths.get(pathString);
                correct = true;
            } catch (Exception e) {
                System.out.println("Incorrect format.");
            }
        }
        return path;
    }

    public void queue(Path path) {
        try {
            try (Stream<Path> entries = Files.walk(path)) {
                entries.forEach(entity -> blockingQueue.add(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Path p : blockingQueue
             ) {
            System.out.println(p.toString());

        }
    }
}
