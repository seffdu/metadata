package com.du.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author duqifeng
 * 2018/4/28 16:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResp<T> {

    private T data;
    private int code;
    private String message;

    private static BaseRespBuilder builderOk() {
        return BaseResp.builder().code(20000);
    }

    public static BaseResp ok() {
        BaseRespBuilder builder = builderOk();
        return builder.build();
    }

    public static <T> BaseResp<T> ok(T body) {
        BaseResp baseResp = ok();
        baseResp.setData(body);
        return baseResp;
    }
}
