package com.shuai.testproject.service.impl;

import com.shuai.testproject.dao.UserMapper;
import com.shuai.testproject.response.BaseResponse;
import com.shuai.testproject.response.exception.SysException;
import com.shuai.testproject.service.UserService;
import com.shuai.testproject.vo.request.GetUserInfoRequestVO;
import com.shuai.testproject.vo.response.GetUserInfoResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户信息
     *
     * @param userInfoRequestVO
     * @return
     */
    @Override
    public BaseResponse<GetUserInfoResponseVO> getUserInfo(GetUserInfoRequestVO userInfoRequestVO) {
        if(userInfoRequestVO.getId() == 1){
            throw new SysException("666", "777");
        }
        GetUserInfoResponseVO getUserInfoResponseVO = userMapper.selectById(userInfoRequestVO.getId());
        BaseResponse<GetUserInfoResponseVO> baseResponse = new BaseResponse<>();
        baseResponse.setRespInfo(getUserInfoResponseVO);
        logger.info("查询成功");
        return baseResponse;
    }
}
