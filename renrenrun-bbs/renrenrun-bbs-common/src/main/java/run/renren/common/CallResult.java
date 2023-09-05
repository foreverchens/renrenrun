package run.renren.common;

/**
 * @author yyy
 * @wx ychen5325
 * @email yangyouyuhd@163.com
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import lombok.Data;

@Data
public class CallResult<T> {
	private static final long serialVersionUID = -7704551131927143131L;
	private static final int CODE_FAILURE = 400;
	private static final int CODE_SUCCESS = 200;
	private static final String SUC_MSG = "success";
	private static final String FAIL_MSG = "fail";
	private Boolean success;
	private Integer code;
	public String message;
	private T data;

	private CallResult() {
	}

	private CallResult(boolean isSuccess, int code, String message, T resultObject) {
		this.success = isSuccess;
		this.code = code;
		this.message = message;
		this.data = resultObject;
	}

	public static <T> CallResult<T> success() {
		return new CallResult(true, CODE_SUCCESS, SUC_MSG, (Object) null);
	}

	public static <T> CallResult<T> success(T resultObject) {
		return new CallResult<>(true, CODE_SUCCESS, SUC_MSG, resultObject);
	}


	public static <T> CallResult<T> failure() {
		return new CallResult(false, CODE_FAILURE, FAIL_MSG, (Object) null);
	}

	public static <T> CallResult<T> failure(String msg) {
		return new CallResult(false, CODE_FAILURE, msg, (Object) null);
	}

	public static <T> CallResult<T> failure(int code) {
		return new CallResult(false, code, FAIL_MSG, (Object) null);
	}

	public static <T> CallResult failure(int code, String msg) {
		return new CallResult(false, code, msg, (Object) null);
	}

    @Override
    public String toString() {
        return "CallResult{" + "success=" + success + ", code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
