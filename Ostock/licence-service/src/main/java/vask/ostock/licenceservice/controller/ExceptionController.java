package vask.ostock.licenceservice.controller;

import static java.util.Collections.singletonMap;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vask.ostock.licenceservice.util.ErrorMessage;
import vask.ostock.licenceservice.util.ResponseWrapper;
import vask.ostock.licenceservice.util.RestErrorList;

import java.util.Map;


/**
 *
 * @author vask
 * @version
 * @since Jun 28
 */


@ControllerAdvice
@EnableWebMvc
public class ExceptionController extends ResponseEntityExceptionHandler {


    /**
     * handleException - Handles all the Exception recieving a request, responseWrapper.
     *@param request
     *@param responseWrapper
     *@return ResponseEntity<ResponseWrapper>
     * @user vask
     * @since 20
     */
    @ExceptionHandler(value = { Exception.class })
    public @ResponseBody ResponseEntity<AddDefaultCharsetFilter.ResponseWrapper> handleException(HttpServletRequest request,
                                                                                                 AddDefaultCharsetFilter.ResponseWrapper responseWrapper){

        return ResponseEntity.ok(responseWrapper);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseWrapper> handleIOException(HttpServletRequest request, RuntimeException e){

        RestErrorList errorList = new RestErrorList(HttpStatus.NOT_ACCEPTABLE, new ErrorMessage(e.getMessage(), e.getMessage()));
        ResponseWrapper responseWrapper = new ResponseWrapper(null, singletonMap("status", HttpStatus.NOT_ACCEPTABLE), errorList);
        return ResponseEntity.ok(responseWrapper);
    }

}
