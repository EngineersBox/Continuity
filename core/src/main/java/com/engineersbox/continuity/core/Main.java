package com.engineersbox.continuity.core;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.coroutine.Coroutine;
import com.engineersbox.continuity.core.coroutine.CoroutineExecutor;
import com.engineersbox.continuity.logger.LogFormatter;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    private static final Logger LOGGER = LogFormatter.getLogger(Main.class, Level.ALL);

    public static final class TestCoroutine implements Coroutine {
        @Override
        public void run(final Continuation c) {
            LOGGER.info("Started");
            for (int i = 0; i < 10; i++) {
                echo(c, i);
            }
        }

        private void echo(final Continuation c,
                          final int x) {
            LOGGER.info(String.format("Value: %d", x));
            c.suspend();
        }
    }

    public static void main(final String[] args) {
        final CoroutineExecutor coroutineExecutor = new CoroutineExecutor(new TestCoroutine());
        coroutineExecutor.execute();
        coroutineExecutor.execute();
    }

}
