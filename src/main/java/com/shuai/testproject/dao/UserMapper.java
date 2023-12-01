package com.shuai.testproject.dao;

import com.shuai.testproject.vo.response.GetUserInfoResponseVO;


/**
 * @author shuai
 */
public interface UserMapper {
    GetUserInfoResponseVO selectById(Long id);
}
