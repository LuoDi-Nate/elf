package com.fooluodi.elf.framework;

import com.fooluodi.elf.common.exception.ElfServiceException;
import com.fooluodi.elf.common.exception.ElfSystemException;
import com.fooluodi.elf.common.util.ElfBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public abstract class WebAPIBaseController {

    private static final Logger baseLogger = LoggerFactory.getLogger(WebAPIBaseController.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public
    @ResponseBody
    ResponseEntity<String> handleMethodArgumentNotValidException(HttpServletRequest req,
                                                                 MethodArgumentNotValidException e) {
        baseLogger.error("Request:{},error_message: {},parameter name: {} ", req.getRequestURL(), e.getMessage(),
                e.getParameter());
        return ResponseEntity.fail(e.getBindingResult().getFieldError().getDefaultMessage(), "");
    }


    @ExceptionHandler(ElfServiceException.class)
    public
    @ResponseBody
    ResponseEntity<Map<String, Object>> handleServiceException(HttpServletRequest req,
                                                               ElfServiceException e) {
        baseLogger.error("Request:{},error_message: {}, message:{},error_code: {} ", req.getRequestURL(),
                e.getErrorMessage(), e.getMessage(), e.getErrorCode());
        if (e.getErrorCode().equals("") || e.getErrorCode() == null)
            return new ResponseEntity<Map<String, Object>>("SERVICE_EXCEPTION", "用户行为异常", new HashMap<String, Object>());
        else
            return new ResponseEntity<Map<String, Object>>(ElfBeanUtils.killNull(e.getErrorCode()), e.getErrorMessage(), new HashMap<String, Object>());
    }

    @ExceptionHandler(ElfSystemException.class)
    public
    @ResponseBody
    ResponseEntity<Map<String, Object>> handleSystemException(HttpServletRequest req,
                                                              ElfSystemException e) {
        baseLogger.error("Request:{},error_message: {},message:{},error_code :{},cause:{} ", req.getRequestURL(),
                e.getErrorMessage(), e.getMessage(), e.getErrorCode(), e);

        if (e.getErrorCode().equals("") || e.getErrorCode() == null)
            return new ResponseEntity<Map<String, Object>>("SERVICE_EXCEPTION", "系统异常", new HashMap<String, Object>());
        else
            return new ResponseEntity<Map<String, Object>>(ElfBeanUtils.killNull(e.getErrorCode()), e.getErrorMessage(), new HashMap<String, Object>());
    }


    public static class ValidationErrorSimple {
        private String objectName;
        private String field;
        private String code;
        private String message;

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ValidationErrorSimple(String objectName, String field, String code, String message) {
            super();
            this.objectName = objectName;
            this.field = field;
            this.code = code;
            this.message = message;
        }

        public ValidationErrorSimple(ObjectError e) {
            this.objectName = e.getObjectName();
            this.message = MessageFormat.format(ElfBeanUtils.killNull(e.getDefaultMessage()), e.getArguments());
            this.code = e.getCode();
            if (e instanceof FieldError) {
                this.field = ((FieldError) e).getField();
            }
        }
    }

    @ExceptionHandler(BindException.class)
    public
    @ResponseBody
    ResponseEntity<List<ValidationErrorSimple>> handleBindException(HttpServletRequest req,
                                                                    BindException exception) {
        baseLogger.error("Request:{},error_message: {} ", req.getRequestURL(), exception.getMessage());

        List<ValidationErrorSimple> errors = new ArrayList<ValidationErrorSimple>();

        for (ObjectError e : exception.getAllErrors()) {
            errors.add(new ValidationErrorSimple(e));
        }
        ElfSystemException sysEx = new ElfSystemException(WebAPIExceptions.ERR_WEBAPI_VALIDATION);
        return new ResponseEntity<List<ValidationErrorSimple>>(sysEx.getErrorCode(), sysEx.getErrorMessage(), errors);
    }

    @ExceptionHandler(Throwable.class)
    public
    @ResponseBody
    ResponseEntity<String> handleThrowable(HttpServletRequest req, Throwable exception) {
        baseLogger.error("Request: {} raised: {}", req.getRequestURL(), exception);
        if(exception.getCause() instanceof ElfServiceException){
            ElfServiceException midasServiceException = (ElfServiceException)exception.getCause();
        	return new ResponseEntity<String>(midasServiceException.getErrorCode(), midasServiceException.getMessage(), null);
        }else{
        	ElfSystemException se = new ElfSystemException(WebAPIExceptions.ERR_UNKNOWN);
        	return new ResponseEntity<String>(se.getErrorCode(), se.getErrorMessage(), "未知异常");
        }
    }

}
