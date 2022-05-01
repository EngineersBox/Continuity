package com.engineersbox.continuity.core;

import com.engineersbox.continuity.core.continuation.Continuation;
import com.engineersbox.continuity.core.coroutine.Coroutine;
import com.engineersbox.continuity.core.coroutine.CoroutineExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static final class TestCoroutine implements Coroutine {
        @Override
        public void run(final Continuation c) {
            LOGGER.info("Started");
            for (int i = 0; i < 10; i++) {
                echo(c, i);
                c.suspend();
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
