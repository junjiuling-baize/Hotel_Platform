package com.baize.model.result;

import com.alibaba.fastjson2.JSON;

import com.baize.model.result.exception.ServiceException;
import com.baize.model.result.exenum.RequestException;
import com.baize.model.result.exenum.TypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * JSON返回类
 * <p>
 * 此类用于向前端返回统一的JSON格式，具体分以下几个部分:
 * <ul>
 *      <li>status(Integer):状态码，错误的唯一标识，可以是自定义的，也可以是WEB规定的，可参阅{@link HttpStatus}</li>
 *      <li>message(String):消息，向客户端或服务端描述错误的原因</li>
 *      <li>success(Boolean):是否成功，描述一个请求是否成功，也用于客户端或服务端判断</li>
 *      <li>data(T-泛型):具体的数据，整个请求的核心，可存放任意类型的数据，需要配合泛型</li>
 *      <li>type(String/Integer):异常类型，可自定义，便于开发者寻错，只有在发生异常时才具有参考价值，可参阅{@link TypeEnum}</li>
 *      <li>date(Long):当前的时间戳</li>
 * </ul>
 *
 * @author by 春风能解释
 * <p>
 * 2023/6/30
 */
@Data
@NoArgsConstructor
@ApiModel(value = "统一响应类", description = "用于传给前端的统一JSON格式")
@Slf4j
public class JsonRequest<T> implements Serializable {
    /**
     * 序列化字段
     */
    @Serial
    @ApiModelProperty(value = "序列化字段", hidden = true)
    private static final long serialVersionUID = -7878717752339104014L;
    /**
     * 错误代码
     */
    @ApiModelProperty(value = "错误代码", allowableValues = "range[100,511]")
    private Integer status = 200;
    /**
     * 消息
     */
    @ApiModelProperty(value = "消息")
    private String message = "请求已成功!";
    /**
     * 是否成功
     */
    @ApiModelProperty(value = "是否成功")
    private Boolean success = true;
    /**
     * 错误类型
     */
    @ApiModelProperty(value = "错误类型")
    private String type = TypeEnum.SUCCESS.getDescription();
    /**
     * 数据
     */
    @ApiModelProperty(value = "数据", allowEmptyValue = true)
    private T data = null;
    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private Long date = System.currentTimeMillis();
    /**
     * 动态资源
     */
    @ApiModelProperty(value = "动态资源")
    private Map<String, Object> other = null;

    /**
     * 构造方法1
     *
     * @param data 数据
     */
    public JsonRequest(T data) {
        this.data = data;
    }

    /**
     * 构造方法2
     *
     * @param status  状态
     * @param message 消息
     * @param success 是否成功
     * @param type    异常类型
     */
    public JsonRequest(Integer status, String message, Boolean success, String type) {
        this.status = status;
        this.message = message;
        this.success = success;
        this.type = type;
    }

    /**
     * 构造方法3
     *
     * @param data  数据
     * @param other 动态数据
     */
    public JsonRequest(T data, Map<String, Object> other) {
        this.data = data;
        this.other = other;
    }

    /**
     * 成功请求
     *
     * @param data 数据
     * @param <T>  类型
     * @return JSON
     */
    public static <T> JsonRequest<T> success(T data) {
        return new JsonRequest<>(data);
    }

    /**
     * 成功请求
     *
     * @param data  数据
     * @param other 动态数据
     * @param <T>   类型
     * @return JSON
     */
    public static <T> JsonRequest<T> success(T data, Map<String, Object> other) {
        return new JsonRequest<>(data, other);
    }


    /**
     * 错误请求
     *
     * @param e   异常
     * @param <T> 类型
     * @return JSON
     */
    public static <T> JsonRequest<T> error(RequestException e) {
        return new JsonRequest<>(
                e.getStatus(),
                e.getMessage(),
                false,
                e.getType());
    }

    /**
     * 成功请求(异步)
     *
     * @param data  数据
     * @param other 动态数据
     * @param <T>   类型
     * @return JSON
     */
    // public static <T> JsonRequestAsync<T> successAsync(T data, Map<String, Object> other) {
    public static <T> CompletableFuture<JsonRequest<T>> successAsync(T data, Map<String, Object> other) {
        // return new JsonRequestAsync<>(new JsonRequest<>(data, other));
        return CompletableFuture.completedFuture((new JsonRequest<>(data, other)));
    }

    /**
     * 成功请求(异步)
     *
     * @param data 数据
     * @param <T>  类型
     * @return JSON
     */
    // public static <T> JsonRequestAsync<T> successAsync(T data) {
    public static <T> CompletableFuture<JsonRequest<T>> successAsync(T data) {
        // return new JsonRequestAsync<>(new JsonRequest<>(data));
        return CompletableFuture.completedFuture((new JsonRequest<>(data)));
    }

    /**
     * 错误请求(异步)
     *
     * @param e   异常
     * @param <T> 类型
     * @return JSON
     */
    // public static <T> JsonRequestAsync<T> errorAsync(RequestException e) {
    public static <T> CompletableFuture<JsonRequest<T>> errorAsync(RequestException e) {
        // return JsonRequestAsync<>(new JsonRequest<>(
        //         e.getStatus(),
        //         e.getMessage(),
        //         false,
        //         e.getType()));
        return CompletableFuture.completedFuture(new JsonRequest<>(
                e.getStatus(),
                e.getMessage(),
                false,
                e.getType()));
    }

    /**
     * 错误请求
     *
     * @param message 异常信息
     * @param <T>     类型
     * @return JSON
     */
    public static <T> JsonRequest<T> error(String message) {
        return new JsonRequest<>(
                500,
                message == null ? RequestException.NULL_POINTER_ERROR.getMessage() : message,
                false,
                TypeEnum.SERVER.getDescription());
    }

    /**
     * 自定义异常返回
     *
     * @param <T> 类型
     * @param e   异常
     * @return JSON
     */
    public static <T> JsonRequest<T> error(Exception e) {
        //如果是已定义的异常
        if (e instanceof ServiceException) {
            ServiceException exception = (ServiceException) e;
            return new JsonRequest<>(
                    exception.getStatus(),//状态码
                    e.getMessage() == null ? RequestException.NULL_POINTER_ERROR.getMessage() : e.getLocalizedMessage(), //消息
                    false,//是否成功
                    exception.getType()//异常类型
            );
        }//特殊异常处理
        // else if (e instanceof BadCredentialsException) {
        //     return error(RequestException.LOGIN_ERROR);
        // }
        //其他的未知异常
        return new JsonRequest<>(
                RequestException.UNKNOWN_EXCEPTION.getStatus(),//状态码
                e.getMessage() == null ? RequestException.NULL_POINTER_ERROR.getMessage() : e.getLocalizedMessage(), //消息
                false, //是否成功
                RequestException.UNKNOWN_EXCEPTION.getType());//异常类型
    }

    /**
     * 重写ToString方法以序列化
     *
     * @return 序列化之后的字符串
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
