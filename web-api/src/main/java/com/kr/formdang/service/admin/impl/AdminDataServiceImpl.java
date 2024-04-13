package com.kr.formdang.service.admin.impl;

import com.kr.formdang.crypto.HashNMacUtil;
import com.kr.formdang.entity.AdminTbEntity;
import com.kr.formdang.layer.AdminDataDto;
import com.kr.formdang.service.admin.AdminDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminDataServiceImpl implements AdminDataService {


    @Override
    public AdminTbEntity getAdminData(AdminDataDto adminDataDto) throws NoSuchAlgorithmException {
        return AdminTbEntity.builder()
                .id(adminDataDto.getId())
                .subId(adminDataDto.getSub_id())
                .pw(HashNMacUtil.getHashSHA256(adminDataDto.getPw()))
                .name(adminDataDto.getName())
                .type(adminDataDto.getType())
                .build();
    }

}
