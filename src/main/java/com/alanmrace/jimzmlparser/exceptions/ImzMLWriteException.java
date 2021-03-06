package com.alanmrace.jimzmlparser.exceptions;

/**
 * Fatal exception occurred when writing ImzML.
 * 
 * @author Alan Race
 */
public class ImzMLWriteException extends Exception {

    /**
     * Serialisation version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construct ImzMLWriteException with a message describing the issue.
     * 
     * @param message Description of the issue
     */
    public ImzMLWriteException(String message) {
        super(message);
    }

    /**
     * Construct ImzMLWriteException with a message describing the issue and a chained
     * exception.
     * 
     * @param message Description of the issue
     * @param exception Exception thrown previously
     */
    public ImzMLWriteException(String message, Exception exception) {
        super(message, exception);
    }
}
