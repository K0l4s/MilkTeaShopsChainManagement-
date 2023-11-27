package alotra.milktea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import alotra.milktea.entity.UserEntity;

@Repository
public interface IUserRepo extends JpaRepository<UserEntity, String>{

	UserEntity findUserByUsername(String username);
	
//	@Query("SELECT u FROM User u WHERE (u.username = :username AND u.code = :code)")
	List<UserEntity> findUserByUsernameAndCode(@Param("username") String username,@Param("code") String code);
	
//	@Query("SELECT u FROM User u WHERE u.username = :email AND u.password = :password")
	List<UserEntity> findUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
