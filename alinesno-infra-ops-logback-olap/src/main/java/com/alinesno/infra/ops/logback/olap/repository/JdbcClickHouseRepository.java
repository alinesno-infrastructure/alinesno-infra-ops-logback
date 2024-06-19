package com.alinesno.infra.ops.logback.olap.repository;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.alinesno.infra.ops.logback.olap.constants.ClickHouseSqlConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
 

/**
 * ClickHouse持久层基于JDBC驱动的实现
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@Service
public class JdbcClickHouseRepository {

	@Autowired
	@Qualifier(value = "clickHouseTemplate")
	private JdbcTemplate clickHouseTemplate;
 
	public boolean exists(final String tableName) {
		String sql = MessageFormat.format(ClickHouseSqlConstant.SQL_EXISTS_TABLE, tableName);
		Map<String, Object> exists = queryObject(sql);
		return "1".equals(exists.get("result").toString());
	}
 
	public int update(final String sql) {
		return clickHouseTemplate.update(sql);
	}
 
	public Map<String, Object> queryObject(final String sql) {
		return queryObject(sql, Function.identity());
	}
 
	public Map<String, Object> queryObject(final String sql, final Function<Object, Object> resultConvert) {
		log.info("query sql : {} ", sql);
		return clickHouseTemplate.queryForObject(sql, new ColumnMapRowMapper() {
 
			@Override
			protected Object getColumnValue(final ResultSet rs, final int index) throws SQLException {
				Object value = super.getColumnValue(rs, index);
				return resultConvert.apply(value);
			}
		});
	}
 
	public List<Map<String, Object>> queryList(final String sql) {
		return queryList(sql, Function.identity());
	}
 
	public List<Map<String, Object>> queryList(final String sql, final Function<Object, Object> resultConvert) {
		log.info("query sql : \r\n{} ", sql);
		return clickHouseTemplate.query(sql, new ColumnMapRowMapper() {
 
			@Override
			protected Object getColumnValue(final ResultSet rs, final int index) throws SQLException {
				Object value = super.getColumnValue(rs, index);
				return resultConvert.apply(value);
			}
		});
	}
 
	public <T> T executeQuery(final String sql, final ResultSetExtractor<T> rse) {
		try {
			return clickHouseTemplate.query(sql, rse);
		} catch (Exception e) {
			String message = e.getMessage();
			if (message.contains("Client should retry")) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					log.error("query error:{}" , e1.getMessage());
				}
				return clickHouseTemplate.query(sql, rse);
			} else {
				throw e;
			}
		}
 
	}
 
	public SqlRowSet queryRowSet(final String sql) {
		return clickHouseTemplate.queryForRowSet(sql);
	}
 
}