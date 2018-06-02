package main;

import game.GameState;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * Runs the program via the text (console) interface.
 */
public class TXTmain {
    public static void main(String[] args) throws IOException {
        Instant startTimeAVG = Instant.now();
        List<String> argList = new ArrayList<>(Arrays.asList(args));
        int repeatNumberIndex = argList.indexOf("-n");
        int numTimesToRun = 1;
        if (repeatNumberIndex >= 0) {
            try {
                numTimesToRun = Math.max(Integer.parseInt(argList.get(repeatNumberIndex + 1)), 1);
            } catch (Exception e) {
                System.err.println("Couldn't parse argument for -n option");
            }
        }
        //long seed = Utilities.parseSeedArgs(args);
        long seed;

        int totalScore = 0;
        int max = 999999999;
        int min = 100000000;
        numTimesToRun = 10000;
        Random rand = new Random();
        List<Long> mySeed = new ArrayList<>();

        //for (int i = 0; i < numTimesToRun; i++) {
        for (int i = 0; i < numTimesToRun; i++) {
            //get a random seed that has not yet been used
            do {
                seed = Long.valueOf(rand.nextInt((max - min) + 1) + min);
            }while (mySeed.contains(seed));
            mySeed.add(seed); // Save seed to set to avoid reuse

            Instant startTime = Instant.now();
            //totalScore += GameState.runNewGame((seed.isPresent() ? seed.get() : 0), false);
            totalScore += GameState.runNewGame(seed, false);
            System.out.println();
            Instant endTime =  Instant.now();
            Duration f = Duration.between( startTime , endTime);
            double milliS = f.toMillis();
            System.out.println("Time taken       :  " + milliS + " Milliseconds");
        }

        if (totalScore != 0) {
            System.out.println("Average score    : " + totalScore / numTimesToRun);
        }
        Instant endTimeAVG =  Instant.now();
        Duration d = Duration.between( startTimeAVG , endTimeAVG );
        double secondsPart = d.toSeconds();
        System.out.println("\nAverage time Taken :  " + (secondsPart / numTimesToRun) + " Seconds");
        System.out.println("TOTAL time Taken :  " + (d.toMinutes()) + " Minutes");

        System.out.print("Seed list: {");
        for (Long s: mySeed){
            System.out.print(s + ", ");
        }
        System.out.print("}");
    }


}
