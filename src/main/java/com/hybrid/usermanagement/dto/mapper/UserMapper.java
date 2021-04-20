package com.hybrid.usermanagement.dto.mapper;

import com.hybrid.usermanagement.dto.UserDto;
import com.hybrid.usermanagement.entity.User;

import java.util.List;

//@Mapper
public interface UserMapper extends EntityMapper<UserDto, User>{
    @Override
    UserDto toDataObject(User entity);

    @Override
    List<UserDto> toDataObject(List<User> entities);

    @Override
    User toEntity(UserDto data);

    @Override
    List<User> toEntity(List<UserDto> datas);
}
