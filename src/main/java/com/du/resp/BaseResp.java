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
public class BaseResp<T extends Serializable> implements Serializable{

    private T data;
    private int code;
    private String desc;
}
