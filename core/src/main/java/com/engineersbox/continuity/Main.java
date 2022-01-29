package com.engineersbox.continuity;

import com.engineersbox.continuity.continuation.Continuation;
import com.engineersbox.continuity.coroutine.Coroutine;
import com.engineersbox.continuity.coroutine.CoroutineExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

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
            LOGGER.info("Value: {}", x);
            c.suspend();
        }
    }

    public static void main(final String[] args) {
        final CoroutineExecutor coroutineExecutor = new CoroutineExecutor(new TestCoroutine());
        coroutineExecutor.execute();
        coroutineExecutor.execute();
    }

}
