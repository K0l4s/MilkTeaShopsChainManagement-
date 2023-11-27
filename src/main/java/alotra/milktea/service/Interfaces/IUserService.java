package alotra.milktea.service.Interfaces;

import java.util.List;


import alotra.milktea.entity.UserEntity;

public interface IUserService {
	boolean register(UserEntity user);
	List<UserEntity> findAll();
	UserEntity findOne(String username);
	boolean vetifyUserCode(UserEntity user);
	boolean login(String username, String password);
}
