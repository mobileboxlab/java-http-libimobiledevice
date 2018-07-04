package com.mobilebox.exception;

/**
 * An exception mapped to INTERNAL_ERROR (HTTP 500). This exception that may be
 * thrown when an action cannot be completed.
 */
public class InternalException extends Exception {

	private static final long serialVersionUID = -1822993753274157084L;

	/**
	 * Construct a new InternalException with the specified message.
	 * 
	 * @param message
	 *            A human-readable String message describing the problem that
	 *            occurred.
	 */
	public InternalException(final String message) {
		super(message.replace("\n", ""));
	}

}
