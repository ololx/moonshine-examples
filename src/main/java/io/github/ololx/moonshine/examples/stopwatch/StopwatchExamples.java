package io.github.ololx.moonshine.examples.stopwatch;

import io.github.ololx.moonshine.stopwatch.SimpleStopwatch;
import io.github.ololx.moonshine.stopwatch.Stopwatch;

import java.util.logging.Logger;
import java.util.stream.LongStream;

/**
 * project moonshine-examples
 * created 2023-01-11 16:56
 *
 * @author Alexander A. Kropotin
 */
public final class StopwatchExamples {

    private static final Logger log = Logger.getLogger(StopwatchExamples.class.getName());

    void doSomething() throws InterruptedException {
        Thread.sleep(100);
    }

    void exampleOfMeasuringWholeMethodExecutionTime() throws InterruptedException {
        // create and start new stopwatch
        Stopwatch stopwatch = new SimpleStopwatch().start();

        // do something
        doSomething();

        // get elapsed time of whole method execution and log it
        log.info("Finished the numbers multiplication. Spent time = " + stopwatch.elapsed());
    }

    void exampleOfMeasuringSummaryTimeExecutionOfMethodParts() throws InterruptedException {
        // create new stopwatch
        Stopwatch stopwatch = new SimpleStopwatch().start();

        // start stopwatch
        stopwatch.start();

        // do something
        doSomething();

        // stop stopwatch
        stopwatch.stop();

        // do something
        doSomething();

        // start stopwatch again
        stopwatch.start();

        // do something
        doSomething();

        // stop stopwatch and get elapsed time of the nums multiplication and dividing, and log it
        log.info(
                "Finished the numbers multiplication and dividing. Spent time = "
                        + stopwatch.stop().elapsed()
        );
    }

    public static void main(String[] args) throws InterruptedException {
        var stopwatchExamples = new StopwatchExamples();
        stopwatchExamples.exampleOfMeasuringWholeMethodExecutionTime();
        stopwatchExamples.exampleOfMeasuringSummaryTimeExecutionOfMethodParts();
    }
}
