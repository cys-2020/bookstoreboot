package com.cys.boot.typeHandler;

import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.CouponEnum;

public class CouponEnumTypeHandler implements TypeHandler<CouponEnum>{

	@Override
	public void setParameter(PreparedStatement ps, int i, CouponEnum parameter, JdbcType jdbcType) throws SQLException {
		//set code(flag)
		ps.setInt(i, parameter.getFlag());
	}

	@Override
	public CouponEnum getResult(ResultSet rs, String columnName) throws SQLException {
		//
		return CouponEnum.getCouponEnum(rs.getInt(columnName));
	}

	@Override
	public CouponEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return CouponEnum.getCouponEnum(rs.getInt(columnIndex));
	}

	@Override
	public CouponEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return CouponEnum.getCouponEnum(cs.getInt(columnIndex));
	}
	
}
