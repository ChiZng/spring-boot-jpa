package com.zchi.qhdfldemo.web.handler;

import com.zchi.qhdfldemo.entity.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 处理controller层抛出的异常
 */
@ControllerAdvice
public class ControllerExceptionHandler {

//    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Map<String, Object> handleUserNotExistException(UserNotExistException ex) {
//        Map<String, Object> result = new HashMap<>();
//        result.put("id", ex.getId());
//        result.put("message", ex.getMessage());
//        return result;
//    }

    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> validationRequestBodyErrorHandler(MethodArgumentNotValidException ex) {
        // 同样是获取BindingResult对象，然后获取其中的错误信息
        // 如果前面开启了fail_fast，事实上这里只会有一个信息
        //如果没有，则可能又多个
        List<String> errorInformation = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return new Result<>("400", errorInformation.toString(), null);
    }

    /**
     * 用于接收用于校验@PathVariable以及@RequestParam校验抛出的异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<?> validationErrorHandler(ConstraintViolationException ex) {
        List<String> errorInformation = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return new Result<>("400", errorInformation.toString(), null);
    }
}
