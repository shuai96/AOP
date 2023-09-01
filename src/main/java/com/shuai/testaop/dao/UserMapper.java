package com.shuai.testaop.dao;

import com.shuai.testaop.vo.request.GetUserInfoRequestVO;
import com.shuai.testaop.vo.response.GetUserInfoResponseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    GetUserInfoResponseVO selectById(Long id);
}
