package alotra.milktea.service.Implements;

import java.util.List;

import alotra.milktea.entity.UserEntity;
import alotra.milktea.service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alotra.milktea.repository.IUserRepo;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserRepo userRepo;
	
	@Override
	@Transactional
	public boolean register(UserEntity user) {
		try {
//			Kiểm tra trùng lặp username
			List<UserEntity> listUser = findAll();
			for(UserEntity item:listUser)
				if(item.getUsername().equals(user.getUsername()))
						return false;
//			Nếu không lặp username thì lưu user mới
			userRepo.save(user);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean login(String username, String password) {
//		String username = user.getUsername();
//		String password = user.getPassword();
//		return userRepo.login(username, password);
		List<UserEntity> listUser = userRepo.findUserByUsernameAndPassword(username,password);
		if(listUser.isEmpty())
			return false;
		return true;
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepo.findAll();
	}

	@Override
	public UserEntity findOne(String username) {
		return userRepo.findUserByUsername(username);
	}

	@Override
	public boolean vetifyUserCode(UserEntity user) {
		String code = user.getCode();
		String username = user.getUsername();
//		boolean flag = userRepo.findUserByUsernameAndCode(username, code);
		List<UserEntity> listUser = userRepo.findUserByUsernameAndCode(username, code);
		if(listUser.isEmpty())
			return false;
		UserEntity updateUser = findOne(username);
		updateUser.setCode("Vetify");
		userRepo.save(updateUser);
		return true;
	}
}
