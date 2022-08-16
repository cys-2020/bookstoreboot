package com.cys.boot.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.UserLvEnum;

public class UserLvEnumTypeHandler implements TypeHandler<UserLvEnum>{

	@Override
	public void setParameter(PreparedStatement ps, int i, UserLvEnum parameter, JdbcType jdbcType) throws SQLException {
		//set code(flag)
		ps.setInt(i, parameter.getCode());
	}

	@Override
	public UserLvEnum getResult(ResultSet rs, String columnName) throws SQLException {
		//
		return UserLvEnum.getUserLvEnum(rs.getInt(columnName));
	}

	@Override
	public UserLvEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return UserLvEnum.getUserLvEnum(rs.getInt(columnIndex));
	}

	@Override
	public UserLvEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return UserLvEnum.getUserLvEnum(cs.getInt(columnIndex));
	}
	
}
