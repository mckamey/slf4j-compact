package com.pseudocode.logging;

import java.io.OutputStream;
import java.io.PrintStream;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * This class enables quick & dirty programmatic access to
 * enabling/disabling logging levels and setting output.
 */
public class CompactLoggerFactory implements ILoggerFactory {

	// set up logging defaults
	static volatile boolean isTraceEnabled = false;
	static volatile boolean isDebugEnabled = false;
	static volatile boolean isInfoEnabled = true;
	static volatile boolean isWarnEnabled = true;
	static volatile boolean isErrorEnabled = true;

	static volatile PrintStream writer = System.out;
	static volatile boolean needsFlush = true;

	@Override
	public Logger getLogger(String name) {
		return new CompactLogger(name);
	}

	public static synchronized void setLoggerOutput(OutputStream output) {
		if (output == null) {
			writer = System.out;
			needsFlush = true;

		} else if (output instanceof PrintStream) {
			writer = (PrintStream)output;
			needsFlush = (output != System.err);

		} else {
			writer = new PrintStream(output, true);
			needsFlush = false;
		}
	}

	public static boolean isTraceEnabled() {
		return isTraceEnabled;
	}

	public static void setTraceEnabled(boolean value) {
		isTraceEnabled = value;
	}

	public static boolean isDebugEnabled() {
		return isDebugEnabled;
	}

	public static void setDebugEnabled(boolean value) {
		isDebugEnabled = value;
	}

	public static boolean isInfoEnabled() {
		return isInfoEnabled;
	}

	public static void setInfoEnabled(boolean value) {
		isInfoEnabled = value;
	}

	public static boolean isWarnEnabled() {
		return isWarnEnabled;
	}

	public static void setWarnEnabled(boolean value) {
		isWarnEnabled = value;
	}

	public static boolean isErrorEnabled() {
		return isErrorEnabled;
	}

	public static void setErrorEnabled(boolean value) {
		isErrorEnabled = value;
	}
}
