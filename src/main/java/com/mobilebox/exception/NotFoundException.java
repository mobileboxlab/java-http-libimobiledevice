package com.mobilebox.exception;

/**
 * An exception mapped to NOT_FOUND (HTTP 404). An exception that thrown when
 * the resource requested was not found.
 */
public class NotFoundException extends Exception {

	private static final long serialVersionUID = -1822993753274157084L;

	/**
	 * Construct a new NotFoundException with the specified message.
	 * 
	 * @param message
	 *            A human-readable String message describing the problem that
	 *            occurred.
	 */
	public NotFoundException(final String message) {
		super(message.replace("\n", ""));
	}

}
