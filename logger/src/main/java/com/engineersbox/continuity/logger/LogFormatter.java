package com.engineersbox.continuity.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.logging.*;

public class LogFormatter {

    private LogFormatter() {}

    private static Optional<Thread> getThread(final long threadId) {
        return Thread.getAllStackTraces().keySet().stream()
                .filter(t -> t.getId() == threadId)
                .findFirst();
    }

    public static Logger getLogger(final Class<?> clazz,
                                   final Level level) {
        final Logger mainLogger = Logger.getLogger(clazz.getName());
        mainLogger.setUseParentHandlers(false);
        final ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(LogFormatter.createFormatter());
        handler.setLevel(level);
        mainLogger.addHandler(handler);
        mainLogger.setLevel(level);
        return Logger.getLogger(clazz.getName());
    }

    private static SimpleFormatter createFormatter() {
        return new SimpleFormatter() {
            private static final String FORMAT = "[%1$tF %1$tT] [%2$s] [%3$s] %4$s.%5$s: %6$s %n%7$s";

            @Override
            public synchronized String format(final LogRecord logRecord) {
                final ZonedDateTime dateTime = ZonedDateTime.ofInstant(logRecord.getInstant(), ZoneId.systemDefault());

                final long threadId = logRecord.getLongThreadID();
                final String threadName = getThread(threadId)
                        .map(Thread::getName)
                        .orElse("Thread with ID " + threadId);

                return String.format(
                        FORMAT,
                        dateTime,
                        threadName,
                        logRecord.getLevel().getName(),
                        logRecord.getSourceClassName(),
                        logRecord.getSourceMethodName(),
                        logRecord.getMessage(),
                        stackTraceToString(logRecord)
                );
            }
        };
    }

    private static String stackTraceToString(final LogRecord logRecord) {
        if (logRecord.getThrown() == null) {
            return "";
        }
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println();
        logRecord.getThrown().printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

}
