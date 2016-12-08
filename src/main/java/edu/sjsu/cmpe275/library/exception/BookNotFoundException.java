package edu.sjsu.cmpe275.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by aa001 on 12/7/16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such book exists.")
public class BookNotFoundException extends RuntimeException {
}
