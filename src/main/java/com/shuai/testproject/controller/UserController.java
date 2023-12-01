package com.shuai.testproject.controller;


import com.shuai.testproject.log.OperaLog;
import com.shuai.testproject.response.BaseResponse;
import com.shuai.testproject.service.UserService;
import com.shuai.testproject.vo.request.GetUserInfoRequestVO;
import com.shuai.testproject.vo.response.GetUserInfoResponseVO;
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
