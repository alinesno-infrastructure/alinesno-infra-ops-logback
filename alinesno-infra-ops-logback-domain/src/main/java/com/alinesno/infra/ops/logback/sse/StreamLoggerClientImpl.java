package com.alinesno.infra.ops.logback.sse;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.ops.logback.entity.LogEntryEntity;
import com.alinesno.infra.ops.logback.sse.EventSourceListener;
import com.alinesno.infra.ops.logback.sse.IStreamLoggerClient;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * StreamLoggerClientImpl 类是 IStreamLoggerClient 接口的实现类。
 */
public class StreamLoggerClientImpl implements IStreamLoggerClient {

    private final SqlSession sqlSession;

    /**
     * 构造函数，用于初始化 StreamLoggerClientImpl 对象。
     *
     * @param sqlSession SqlSession 对象
     */
    public StreamLoggerClientImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 实现了 IStreamLoggerClient 接口的 streamChatCompletion() 方法。
     * 用于流式记录日志并发送给事件源监听器。
     *
     * @param eventSourceListener 事件源监听器
     */
    @Override
    public void streamChatCompletion(EventSourceListener eventSourceListener) {
        try {
            // 从 SqlSession 中获取连接
            Connection connection = sqlSession.getConnection();

            // 创建查询语句
            String query = "SELECT * FROM log_record";
            PreparedStatement statement = connection.prepareStatement(query);

            // 设置流式结果集
            statement.setFetchSize(Integer.MIN_VALUE);

            // 执行查询
            ResultSet resultSet = statement.executeQuery();

            // 处理查询结果
            while (resultSet.next()) {

                // 获取日志数据
                LogEntryEntity logEntry = new LogEntryEntity();

                logEntry.setTimestamp(resultSet.getLong("timestamp"));
                logEntry.setLogLevel(resultSet.getString("log_level"));
                logEntry.setLoggerName(resultSet.getString("logger_name"));
                logEntry.setThreadName(resultSet.getString("thread_name"));
                logEntry.setLogMessage(resultSet.getString("log_message"));
                logEntry.setException(resultSet.getString("exception"));
                logEntry.setUsername(resultSet.getString("username"));
                logEntry.setIpAddress(resultSet.getString("ip_address"));
                logEntry.setRequestUrl(resultSet.getString("request_url"));
                logEntry.setRequestMethod(resultSet.getString("request_method"));
                logEntry.setRequestParameters(resultSet.getString("request_parameters"));
                logEntry.setResponseCode(resultSet.getInt("response_code"));
                logEntry.setResponseTime(resultSet.getLong("response_time"));
                logEntry.setServerName(resultSet.getString("server_name"));
                logEntry.setLogId(resultSet.getString("log_id"));
                logEntry.setLogTags(resultSet.getString("log_tags"));
                logEntry.setSourceApplication(resultSet.getString("source_application"));
                logEntry.setLogCategory(resultSet.getString("log_category"));
                logEntry.setLogLocation(resultSet.getString("log_location"));
                logEntry.setLogContext(resultSet.getString("log_context"));
                logEntry.setLogMarkers(resultSet.getString("log_markers"));
                logEntry.setLogExtraData(resultSet.getString("log_extra_data"));
                logEntry.setLogDuration(resultSet.getLong("log_duration"));
                logEntry.setLogEnvironment(resultSet.getString("log_environment"));
                logEntry.setStandardizedFields(resultSet.getString("standardized_fields"));

                // 发送日志数据给事件源监听器
                eventSourceListener.onEvent(null, null, null, JSONObject.toJSONString(logEntry));
            }

            // 关闭语句和结果集
            resultSet.close();
            statement.close();

            // 发送完所有日志数据后关闭事件源
            eventSourceListener.onClosed(null);
        } catch (SQLException e) {
            String errorMessage = "Error streaming log data: " + e.getMessage();
            eventSourceListener.onEvent(null, null, "error", errorMessage);
            eventSourceListener.onClosed(null);
        }
    }
}
