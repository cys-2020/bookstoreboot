package com.cys.boot.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.GoodSendTimeEnum;

public class GoodSendTimeEnumTypeHandler implements TypeHandler<GoodSendTimeEnum>{

	@Override
	public void setParameter(PreparedStatement ps, int i, GoodSendTimeEnum parameter, JdbcType jdbcType) throws SQLException {
		//set code(flag)
		ps.setInt(i, parameter.getC());
	}

	@Override
	public GoodSendTimeEnum getResult(ResultSet rs, String columnName) throws SQLException {
		//
		return GoodSendTimeEnum.getGoodSendTimeEnum(rs.getInt(columnName));
	}

	@Override
	public GoodSendTimeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return GoodSendTimeEnum.getGoodSendTimeEnum(rs.getInt(columnIndex));
	}

	@Override
	public GoodSendTimeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return GoodSendTimeEnum.getGoodSendTimeEnum(cs.getInt(columnIndex));
	}
	
}
