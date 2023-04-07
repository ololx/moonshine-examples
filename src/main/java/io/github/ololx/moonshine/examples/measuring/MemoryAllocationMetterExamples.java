package io.github.ololx.moonshine.examples.measuring;

import io.github.ololx.moonshine.measuring.memory.ThreadMemoryAllocationMeter;
import io.github.ololx.moonshine.measuring.memory.WholeMemoryAllocationMeter;
import io.github.ololx.moonshine.stopwatch.SimpleStopwatch;
import io.github.ololx.moonshine.stopwatch.Stopwatch;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

/**
 * project moonshine-examples
 * created 2023-04-07 22:56
 *
 * @author Alexander A. Kropotin
 */
public final class MemoryAllocationMetterExamples {

    private static final Logger log = Logger.getLogger(MemoryAllocationMetterExamples.class.getName());

    public static void main(String[] args) {
        WholeMemoryAllocationMeter totalMemUsaMet = new WholeMemoryAllocationMeter().start();
        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> {
                    ThreadMemoryAllocationMeter threadMemoryUsage = new ThreadMemoryAllocationMeter();
                    threadMemoryUsage.start();

                    int[] ints = new int[100000000];
                    for (int i = 0; i < ints.length; i++) {
                        ints[i] = i;
                    }

                    threadMemoryUsage.stop();
                    log.info("1 - RAM usage by tread: " + threadMemoryUsage.result());
                }),
                CompletableFuture.runAsync(() -> {
                    ThreadMemoryAllocationMeter threadMemoryUsage = new ThreadMemoryAllocationMeter();
                    threadMemoryUsage.start();

                    int[] ints = new int[100000000];
                    for (int i = 0; i < ints.length; i++) {
                        ints[i] = i;
                    }

                    threadMemoryUsage.stop();
                    log.info("2 - RAM usage by tread: " + threadMemoryUsage.result());
                }),
                CompletableFuture.runAsync(() -> {
                    ThreadMemoryAllocationMeter threadMemoryUsage = new ThreadMemoryAllocationMeter();
                    threadMemoryUsage.start();

                    int[] ints = new int[100000000];
                    for (int i = 0; i < ints.length; i++) {
                        ints[i] = i;
                    }

                    threadMemoryUsage.stop();
                    log.info("3 - RAM usage by tread: " + threadMemoryUsage.result());
                }),
                CompletableFuture.runAsync(() -> {
                    ThreadMemoryAllocationMeter threadMemoryUsage = new ThreadMemoryAllocationMeter();
                    threadMemoryUsage.start();

                    int[] ints = new int[100000000];

                    threadMemoryUsage.stop();
                    log.info("4 - RAM usage by tread: " + threadMemoryUsage.result());
                })
        ).join();

        totalMemUsaMet.stop();
        log.info("TOTAL - RAM usage heap + non head: " + totalMemUsaMet.result());
    }
}
