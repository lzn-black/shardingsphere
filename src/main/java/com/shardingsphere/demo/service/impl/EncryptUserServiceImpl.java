package com.shardingsphere.demo.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shardingsphere.demo.entity.EncryptUser;
import com.shardingsphere.demo.repository.EncryptUserRepository;
import com.shardingsphere.demo.service.EncryptUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptUserServiceImpl implements EncryptUserService {

	@Autowired
	private EncryptUserRepository encryptUserRepository;
	
	@Override
	public void processEncryptUsers() throws SQLException {
		insertEncryptUsers();
	}
	
	private List<Long> insertEncryptUsers() throws SQLException {
		List<Long> result = new ArrayList<>(10);
        for (long i = 1L; i <= 10; i++) {
        	EncryptUser encryptUser = new EncryptUser();
        	encryptUser.setUserId(i);
        	encryptUser.setUserName("test_" + i);
        	encryptUser.setPwd("pwd" + i);
            encryptUserRepository.addEntity(encryptUser);
            result.add(encryptUser.getUserId());
        }
        
        return result;
	}

	@Override
	public List<EncryptUser> getEncryptUsers() throws SQLException {
		return encryptUserRepository.findEntities();
	}
}
