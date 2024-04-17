package com.kr.formdang.service.admin;


import com.kr.formdang.entity.AdminTbEntity;
import com.kr.formdang.exception.FormException;
import com.kr.formdang.utils.file.dto.S3File;
import org.springframework.web.multipart.MultipartFile;

public interface AdminService {

    AdminTbEntity saveSnsAdmin(AdminTbEntity adminTbEntity) throws FormException;
    String successLogin(String accessToken, String refreshToken) ;
    String successPaperLogin(String accessToken, String refreshToken);
    String failLogin(Exception e) ;
    boolean updateProfile(Long aid, S3File profile, MultipartFile file);

}
