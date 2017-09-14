package com.zeek.mapper;

import com.zeek.po.Role;
import org.apache.ibatis.annotations.Select;


public interface RoleMapper {

	public int insertRole(Role role);

	public Role getRole(Long id);

	public int deleteRole(Long id);

	@Select(value = "select id, role_name as roleName, note from t_role where id = #{id}")
	public Role getRole2(Long id);
}
