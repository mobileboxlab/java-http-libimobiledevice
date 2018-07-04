package com.mobilebox.exception;

/**
 * An exception mapped to INVALID_PARAMETER (HTTP 400). Thrown to indicate that
 * a method has been passed an illegal or inappropriate parameter.
 */
public class ParameterException extends Exception {

	private static final long serialVersionUID = 2897638738838747222L;

	/**
	 * Construct a new ParameterException with the specified message.
	 * 
	 * @param message
	 *            A human-readable String message describing the problem that
	 *            occurred.
	 */
	public ParameterException(final String message) {
		super(message.replace("\n", ""));
	}

}
