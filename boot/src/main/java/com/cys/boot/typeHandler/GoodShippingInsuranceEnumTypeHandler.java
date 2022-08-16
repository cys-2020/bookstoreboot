package com.cys.boot.typeHandler;

import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.GoodShippingInsuranceEnum;

public class GoodShippingInsuranceEnumTypeHandler 
		implements TypeHandler<GoodShippingInsuranceEnum>{

	@Override
	public void setParameter(PreparedStatement ps, int i, GoodShippingInsuranceEnum parameter, JdbcType jdbcType) throws SQLException {
		//set code(flag)
		ps.setInt(i, parameter.getCode());
	}

	@Override
	public GoodShippingInsuranceEnum getResult(ResultSet rs, String columnName) throws SQLException {
		//
		return GoodShippingInsuranceEnum
				.getGoodShippingInsuranceEnum(
						rs.getInt(columnName));
	}

	@Override
	public GoodShippingInsuranceEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return GoodShippingInsuranceEnum.getGoodShippingInsuranceEnum(rs.getInt(columnIndex));
	}

	@Override
	public GoodShippingInsuranceEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return GoodShippingInsuranceEnum.getGoodShippingInsuranceEnum(cs.getInt(columnIndex));
	}
	
}
