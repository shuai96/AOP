package com.shuai.testaop.service;

import com.shuai.testaop.response.BaseResponse;
import com.shuai.testaop.vo.request.GetUserInfoRequestVO;
import com.shuai.testaop.vo.response.GetUserInfoResponseVO;

public interface UserService {

    /**
     * 查询用户信息
     *
     * @param userInfoRequestVO
     * @return
     */
    BaseResponse<GetUserInfoResponseVO> getUserInfo(GetUserInfoRequestVO userInfoRequestVO);
}
