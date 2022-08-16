package com.cys.boot.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.StoreLvEnum;

public class StoreLvEnumTypeHandler implements TypeHandler<StoreLvEnum>{

	@Override
	public void setParameter(PreparedStatement ps, int i, StoreLvEnum parameter, JdbcType jdbcType) throws SQLException {
		//set code(flag) as mysql value
		ps.setInt(i, parameter.getLv());
	}

	@Override
	public StoreLvEnum getResult(ResultSet rs, String columnName) throws SQLException {
		//get code(value in mysql)
		return StoreLvEnum.getStoreLvEnum(rs.getInt(columnName));
	}

	@Override
	public StoreLvEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return StoreLvEnum.getStoreLvEnum(rs.getInt(columnIndex));
	}

	@Override
	public StoreLvEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return StoreLvEnum.getStoreLvEnum(cs.getInt(columnIndex));
	}
	
}

