package com.du.requ;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duqifeng
 * 2018/4/28 16:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequ {

    private String username;
    private String password;
}
