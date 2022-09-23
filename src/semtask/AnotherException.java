/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semtask;

/**
 *
 * @author Admin
 */
public class AnotherException extends Exception {

    public AnotherException() {
    }

    public AnotherException(String message) {
        super(message);
    }

    public AnotherException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnotherException(Throwable cause) {
        super(cause);
    }

    public AnotherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
