package com.du.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author duqifeng
 * 2018/4/28 16:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto implements Serializable {

    private String token;
}
