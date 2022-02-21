package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper//数据库接口
public interface UserMapper {
    //查询
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);//更新状态

    int updateHeader(int id, String headerUrl);//更新头像

    int updatePassword(int id, String password);//更新密码
}
