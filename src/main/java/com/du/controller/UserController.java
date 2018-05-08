package com.du.controller;

import com.du.dto.TokenDto;
import com.du.dto.UserDto;
import com.du.requ.UserRequ;
import com.du.resp.BaseResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author duqifeng
 * 2018/4/28 16:06
 */
@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("login")
    public BaseResp login(UserRequ userRequ) {
        TokenDto token = TokenDto.builder().token("admin").build();
        return BaseResp.ok(token);
    }

    @GetMapping("info")
    public BaseResp info(String token) {
        UserDto userDto = null;
        if ("admin".equals(token))
            userDto = UserDto.builder()
                    .avatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
                    .name("admin")
                    .roles(new String[]{"admin"})
                    .build();
        return BaseResp.ok(userDto);
    }

    @PostMapping("logout")
    public BaseResp logout() {
        return BaseResp.ok();
    }
}
