package com.engineersbox.continuity;

import com.engineersbox.continuity.annotation.Continuable;
import com.engineersbox.continuity.state.Continuation;

public class Main {

    private static class Execution implements Runnable {

        @Override
        @SuppressWarnings("java:S106")
        public @Continuable void run() {
            for (long i = 1; i <= 5; i++) {
                System.out.println("Execution before suspend");
                final Object fromCaller = Continuation.suspend(i);
                System.out.println("Execution after suspend: " + fromCaller);
            }
        }

    }

    @SuppressWarnings("java:S106")
    public static void main(final String[] args) {
        final String[] strings = {"A", "B", "C"};
        for (Continuation cc = Continuation.startWith(new Execution()); null != cc;) {
            final int valueFromContinuation = ((Number) cc.value()).intValue();
            System.out.println("Interrupted " + valueFromContinuation);
            cc = cc.resume(strings[valueFromContinuation % strings.length]);
        }

        System.out.println("ALL DONE");
    }

}
