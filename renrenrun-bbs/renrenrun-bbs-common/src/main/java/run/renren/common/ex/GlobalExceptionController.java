/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package run.renren.common.ex;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;
import run.renren.common.CallResult;

/**
 * 异常处理器
 *
 * @author Mark sunlightcs@gmail.com
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CallResult<String> handlerMethodArgumentNotValidException(Exception e) {
		log.error(e.getMessage(), e);
		return CallResult.failure("非法参数");
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public CallResult<String> handlerNoFoundException(Exception e) {
		log.error(e.getMessage(), e);
		return CallResult.failure(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public CallResult<String> handleDuplicateKeyException(DuplicateKeyException e) {
		log.error(e.getMessage(), e);
		return CallResult.failure("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public CallResult<String> handleException(Exception e) {
		log.error(e.getMessage(), e);
		return CallResult.failure("未知异常");
	}
}
