package com.kr.formdang.mapper;

import com.kr.formdang.entity.AdminTbEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    AdminTbEntity findAdmin(Long id);
}
