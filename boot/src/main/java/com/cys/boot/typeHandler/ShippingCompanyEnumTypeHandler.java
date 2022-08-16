package com.cys.boot.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.ShippingCompanyEnum;

public class ShippingCompanyEnumTypeHandler implements TypeHandler<ShippingCompanyEnum>{

	@Override
	public void setParameter(PreparedStatement ps, int i, ShippingCompanyEnum parameter, JdbcType jdbcType) throws SQLException {
		//set code(flag)
		ps.setInt(i, parameter.getCode());
	}

	@Override
	public ShippingCompanyEnum getResult(ResultSet rs, String columnName) throws SQLException {
		//
		return ShippingCompanyEnum.getShippingCompanyEnum(rs.getInt(columnName));
	}

	@Override
	public ShippingCompanyEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return ShippingCompanyEnum.getShippingCompanyEnum(rs.getInt(columnIndex));
	}

	@Override
	public ShippingCompanyEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return ShippingCompanyEnum.getShippingCompanyEnum(cs.getInt(columnIndex));
	}
	
}
