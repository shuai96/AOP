package com.shuai.testaop.controller;


import com.shuai.testaop.log.OperaLog;
import com.shuai.testaop.response.BaseResponse;
import com.shuai.testaop.service.UserService;
import com.shuai.testaop.vo.request.GetUserInfoRequestVO;
import com.shuai.testaop.vo.response.GetUserInfoResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/get")
    @ResponseBody
    @OperaLog(operate = "用户查询", module = "用户管理")
    public BaseResponse<GetUserInfoResponseVO> getUserInfo(@RequestBody GetUserInfoRequestVO userInfoRequestVO) {
        return userService.getUserInfo(userInfoRequestVO);
    }
}
