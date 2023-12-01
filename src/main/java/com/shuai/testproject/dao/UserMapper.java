package com.shuai.testproject.dao;

import com.shuai.testproject.vo.response.GetUserInfoResponseVO;


public interface UserMapper {
    GetUserInfoResponseVO selectById(Long id);
}
