package com.alanmrace.jimzmlparser.exceptions;

/**
 * Fatal parse exception occurred. It is not possible to continue parsing.
 * 
 * @author Alan Race
 */
public class FatalParseException extends Exception {

    private final FatalParseIssue issue;

    /**
     * Construct FatalParseException with a message describing the issue and the
     * original exception.
     * 
     * @param issue FatalParseIssue that caused the exception
     */
    public FatalParseException(FatalParseIssue issue) {
        super(issue.getIssueMessage());
        
        this.issue = issue;
    }
    
    /**
     * Construct FatalParseException with a message describing the issue and the
     * original exception.
     * 
     * @param issue FatalParseIssue that caused the exception
     * @param exception Exception that caused the issue
     */
    public FatalParseException(FatalParseIssue issue, Exception exception) {
        super(issue.getIssueMessage(), exception);
        
        this.issue = issue;
    }
    
    public FatalParseIssue getIssue() {
        return issue;
    }
}
