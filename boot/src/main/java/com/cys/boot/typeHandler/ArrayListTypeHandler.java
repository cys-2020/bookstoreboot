package com.cys.boot.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cys.boot.utils.Convert;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
public class ArrayListTypeHandler implements TypeHandler<ArrayList<String>> {
	private Convert conv=new Convert();
	@Override
	//when you set param in sql, and you need handle(convert) ArrayList or other (any)types needed convert to sql type 
	public void setParameter(PreparedStatement ps, int i, ArrayList<String> parameter, JdbcType jdbcType) throws SQLException {
		//set param after handling
		ps.setString(i, conv.toStringFromArrayList(parameter));
	}

	@Override
	//when you get data from sql field, and you need handle(convert) sql field's type to  ArrayList or (any) other types (because your sepcial bean's type which can't set directly)
	public ArrayList<String> getResult(ResultSet rs, String columnName) throws SQLException {
		//get sql field value into bean after handling to bean's special typ 
		return conv.toArrayListFromString(rs.getString(columnName) );
	}

	@Override
	public ArrayList<String> getResult(ResultSet rs, int columnIndex) throws SQLException {
		return conv.toArrayListFromString((rs.getString(columnIndex))) ;
	}

	@Override
	public ArrayList<String> getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return conv.toArrayListFromString((cs.getString(columnIndex))) ;
	}
}
