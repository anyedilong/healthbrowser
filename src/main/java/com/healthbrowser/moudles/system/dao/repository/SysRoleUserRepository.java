package com.healthbrowser.moudles.system.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.healthbrowser.moudles.system.domain.SysRoleUser;


public interface SysRoleUserRepository extends JpaRepository<SysRoleUser, String> {

	@Query(value = "delete from sys_role_user where user_id = :userId", nativeQuery = true)
	@Modifying
	@Transactional
	void deleteByUserId(@Param("userId") String userId);
	
	@Query(value = "delete from sys_role_user where role_id = :roleId", nativeQuery = true)
	@Modifying
	@Transactional
	void batchDelUserByRole(@Param("roleId") String roleId);

}
