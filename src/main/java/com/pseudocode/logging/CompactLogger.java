package com.pseudocode.logging;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

public class CompactLogger extends MarkerIgnoringBase {
	private static final long serialVersionUID = 1L;
	private static final String TRACE = "[TRACE ";
	private static final String DEBUG = "[DEBUG ";
	private static final String INFO = "[INFO ";
	private static final String WARN = "[WARNING ";
	private static final String ERROR = "[ERROR ";
	private static final String END = "] ";
	private static final String SPACE = " ";

	public CompactLogger(String logName) {
		name = (logName == null) ? "" : logName.substring(logName.lastIndexOf('.')+1);
	}

	@Override
	public boolean isTraceEnabled() {
		return CompactLoggerFactory.isTraceEnabled;
	}

	@Override
	public boolean isDebugEnabled() {
		return CompactLoggerFactory.isDebugEnabled;
	}

	@Override
	public boolean isInfoEnabled() {
		return CompactLoggerFactory.isInfoEnabled;
	}

	@Override
	public boolean isWarnEnabled() {
		return CompactLoggerFactory.isWarnEnabled;
	}

	@Override
	public boolean isErrorEnabled() {
		return CompactLoggerFactory.isErrorEnabled;
	}

	protected void write(String label, String msg) {
		write(label, msg, (Throwable)null);
	}

	protected void write(String label, String format, Object arg1) {
		FormattingTuple tuple = MessageFormatter.format(format, arg1);
		write(label, tuple.getMessage(), tuple.getThrowable());
	}

	protected void write(String label, String format, Object arg1, Object arg2) {
		FormattingTuple tuple = MessageFormatter.format(format, arg1, arg2);
		write(label, tuple.getMessage(), tuple.getThrowable());
	}

	protected void write(String label, String format, Object[] args) {
		FormattingTuple tuple = MessageFormatter.arrayFormat(format, args);
		write(label, tuple.getMessage(), tuple.getThrowable());
	}

	protected void write(String label, String msg, Throwable t) {
		if (label == null) {
			label = "";
		}
		if (msg == null) {
			msg = "";
		}

		String line = new StringBuilder(label.length() + name.length() + msg.length() + 20)
			.append(label)
			.append(System.currentTimeMillis())
			.append(SPACE)
			.append(name)
			.append(END)
			.append(msg).toString();

		CompactLoggerFactory.writer.println(line);
		if (t != null) {
			t.printStackTrace(CompactLoggerFactory.writer);
		}

		if (CompactLoggerFactory.needsFlush) {
			CompactLoggerFactory.writer.flush();
		}
	}

	@Override
	public void trace(String msg) {
		if (isTraceEnabled()) {
			write(TRACE, msg);
		}
	}

	@Override
	public void trace(String msg, Object arg1) {
		if (isTraceEnabled()) {
			write(TRACE, msg, arg1);
		}
	}

	@Override
	public void trace(String msg, Object arg1, Object arg2) {
		if (isTraceEnabled()) {
			write(TRACE, msg, arg1, arg2);
		}
	}

	@Override
	public void trace(String msg, Object... args) {
		if (isTraceEnabled()) {
			write(TRACE, msg, args);
		}
	}

	@Override
	public void trace(String msg, Throwable t) {
		if (isTraceEnabled()) {
			write(TRACE, msg, t);
		}
	}

	@Override
	public void debug(String msg) {
		if (isDebugEnabled()) {
			write(DEBUG, msg);
		}
	}

	@Override
	public void debug(String format, Object arg1) {
		if (isDebugEnabled()) {
			write(DEBUG, format, arg1);
		}
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		if (isDebugEnabled()) {
			write(DEBUG, format, arg1, arg2);
		}
	}

	@Override
	public void debug(String format, Object... args) {
		if (isDebugEnabled()) {
			write(DEBUG, format, args);
		}
	}

	@Override
	public void debug(String msg, Throwable t) {
		if (isDebugEnabled()) {
			write(DEBUG, msg, t);
		}
	}

	@Override
	public void info(String msg) {
		if (isInfoEnabled()) {
			write(INFO, msg);
		}
	}

	@Override
	public void info(String format, Object arg1) {
		if (isInfoEnabled()) {
			write(INFO, format, arg1);
		}
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		if (isInfoEnabled()) {
			write(INFO, format, arg1, arg2);
		}
	}

	@Override
	public void info(String format, Object... args) {
		if (isInfoEnabled()) {
			write(INFO, format, args);
		}
	}

	@Override
	public void info(String msg, Throwable t) {
		if (isInfoEnabled()) {
			write(INFO, msg, t);
		}
	}

	@Override
	public void warn(String msg) {
		if (isWarnEnabled()) {
			write(WARN, msg);
		}
	}

	@Override
	public void warn(String format, Object arg1) {
		if (isWarnEnabled()) {
			write(WARN, format, arg1);
		}
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		if (isWarnEnabled()) {
			write(WARN, format, arg1, arg2);
		}
	}

	@Override
	public void warn(String format, Object... args) {
		if (isWarnEnabled()) {
			write(WARN, format, args);
		}
	}

	@Override
	public void warn(String msg, Throwable t) {
		if (isWarnEnabled()) {
			write(WARN, msg, t);
		}
	}

	@Override
	public void error(String msg) {
		if (isErrorEnabled()) {
			write(ERROR, msg);
		}
	}

	@Override
	public void error(String format, Object arg1) {
		if (isErrorEnabled()) {
			write(ERROR, format, arg1);
		}
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		if (isErrorEnabled()) {
			write(ERROR, format, arg1, arg2);
		}
	}

	@Override
	public void error(String format, Object... args) {
		if (isErrorEnabled()) {
			write(ERROR, format, args);
		}
	}

	@Override
	public void error(String msg, Throwable t) {
		if (isErrorEnabled()) {
			write(ERROR, msg, t);
		}
	}
}
