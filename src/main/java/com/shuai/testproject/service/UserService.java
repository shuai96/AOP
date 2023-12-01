package com.shuai.testproject.service;

import com.shuai.testproject.response.BaseResponse;
import com.shuai.testproject.vo.request.GetUserInfoRequestVO;
import com.shuai.testproject.vo.response.GetUserInfoResponseVO;

/**
 * @author shuai
 */
public interface UserService {

    /**
     * 查询用户信息
     *
     * @param userInfoRequestVO GetUserInfoRequestVO
     * @return BaseResponse<GetUserInfoResponseVO>
     */
    BaseResponse<GetUserInfoResponseVO> getUserInfo(GetUserInfoRequestVO userInfoRequestVO);
}
