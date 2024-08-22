package com.baize.model.result;



import java.io.Serializable;
import java.util.concurrent.FutureTask;

/**
 * JSON返回类(异步包装类)
 * <p>
 * 通过自定义FutureTask实现该类的可序列化,防止出现序列化失败问题
 * </ul>
 * 内部包装了{@link JsonRequest}对象,可以在异步环境中获得资源并返回
 *
 * @author by 春风能解释
 * <p>
 * 2023/6/30
 * @deprecated 2024-3-24,缓存部分与异步成功兼容,将不再使用此类,核心配置来自{@link }
 */
@Deprecated
public class JsonRequestAsync<T> extends FutureTask<JsonRequest<T>> implements Serializable {
    /**
     * 序列化字段
     */
    private static final long serialVersionUID = -8875407950170076576L;

    /**
     * 实现传入JSON对象的构造器
     *
     * @param result JSON对象
     */
    public JsonRequestAsync(JsonRequest<T> result) {
        super(() -> result);
    }
}
