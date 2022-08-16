package com.cys.boot.typeHandler;

import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.RefundOptionEnum;

public class RefundOptionEnumTypeHandler implements TypeHandler< RefundOptionEnum>{

	@Override
	public void setParameter(PreparedStatement ps, int i, RefundOptionEnum parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getCode());
		/*set code, param is interface, before conv, you need
		get its imp class, then use it to confirm conv which imp.
		Class<? extends RefundOptionEnum> nowClass=
												parameter.getClass();
		System.err.println(nowClass);
		if(nowClass.equals(
					RefundOptionBeforeSendEnum.class)) {
			//set different enum type code
			ps.setInt(i, ((RefundOptionBeforeSendEnum)parameter)
					.getCode());
		}else if(nowClass.equals(
					RefundOptionForOnlyRefundEnum.class)) {
			ps.setInt(i, ((RefundOptionForOnlyRefundEnum)
					parameter).getCode());
		}else {
			ps.setInt(i, ((RefundOptionForGoodAndMoneyEnum)
					parameter).getCode());
		}*/
		
		
	}

	@Override
	public RefundOptionEnum getResult(
			ResultSet rs, String columnName) throws SQLException {
		return RefundOptionEnum.getRefundOptionEnum(
				rs.getInt(columnName)) ;
		//rs has code only, dosen't know code is belong to what enum
	}

	@Override
	public RefundOptionEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return RefundOptionEnum.getRefundOptionEnum(rs.getInt(columnIndex));
	}

	@Override
	public RefundOptionEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return RefundOptionEnum.getRefundOptionEnum(cs.getInt(columnIndex));
	}

}
