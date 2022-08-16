package com.cys.boot.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.cys.boot.typeNeedHandle.ChatRecord;
import com.cys.boot.utils.Convert;

public class ChatRecordTypeHandler  implements TypeHandler<ChatRecord>{

	@Override
	public void setParameter(PreparedStatement ps, int i, ChatRecord parameter, JdbcType jdbcType) throws SQLException {
		
		ps.setString(i, new Convert().toStringFromChatRecord(parameter));
	}

	@Override
	public ChatRecord getResult(ResultSet rs, String columnName) throws SQLException {
		//
		return new Convert().toChatRecordFromString(rs.getLong(1), rs.getString(columnName));
	}

	@Override
	public ChatRecord getResult(ResultSet rs, int columnIndex) throws SQLException {
		//
		return new Convert().toChatRecordFromString(rs.getLong(1), rs.getString(columnIndex));
	}

	@Override
	public ChatRecord getResult(CallableStatement cs, int columnIndex) throws SQLException {
		//
		return new Convert().toChatRecordFromString(cs.getLong(1), cs.getString(columnIndex));
	}
	
}
