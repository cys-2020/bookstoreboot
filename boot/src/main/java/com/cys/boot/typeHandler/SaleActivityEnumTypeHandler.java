package com.cys.boot.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.SaleActivityEnum;

public class SaleActivityEnumTypeHandler implements TypeHandler<SaleActivityEnum>{

	@Override
	public void setParameter(PreparedStatement ps, int i, SaleActivityEnum parameter, JdbcType jdbcType) throws SQLException {
		//set code(flag)
		ps.setInt(i, parameter.getCode());
	}

	@Override
	public SaleActivityEnum getResult(ResultSet rs, String columnName) throws SQLException {
		//
		return SaleActivityEnum.getActivityEnum(rs.getInt(columnName));
	}

	@Override
	public SaleActivityEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return SaleActivityEnum.getActivityEnum(rs.getInt(columnIndex));
	}

	@Override
	public SaleActivityEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return SaleActivityEnum.getActivityEnum(cs.getInt(columnIndex));
	}
	
}
