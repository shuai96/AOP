package com.shuai.testproject.service;

import com.shuai.testproject.response.BaseResponse;
import com.shuai.testproject.vo.request.GetUserInfoRequestVO;
import com.shuai.testproject.vo.response.GetUserInfoResponseVO;

public interface UserService {

    /**
     * 查询用户信息
     *
     * @param userInfoRequestVO
     * @return
     */
    BaseResponse<GetUserInfoResponseVO> getUserInfo(GetUserInfoRequestVO userInfoRequestVO);
}
