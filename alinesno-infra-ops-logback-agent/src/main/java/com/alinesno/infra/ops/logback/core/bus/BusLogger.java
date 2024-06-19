package com.alinesno.infra.ops.logback.core.bus;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.common.core.context.SpringContext;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.util.Asserts;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.util.HashMap;
import java.util.Map;

/**
 * BusLogger类用于监视某些事件或状态的变化。
 * 它可以被设计为在特定事件发生时执行相应的动作，例如文件系统的变化、网络状态的更改等。
 */
public class BusLogger {

    private static LoggerProperties config = null ;

    public static LoggerProperties config(){
        if(config == null){
            config = SpringContext.getBean(LoggerProperties.class);
        }
        return config;
    }

    /**
     * 处理消息的方法。
     * 本方法接收一个消息对象，通过HTTP POST请求将消息发送到指定的服务器URL。
     * 使用Unirest库进行HTTP请求，请求体为消息对象的JSON格式。
     *
     * @param msg 消息对象，不能为空。
     * @throws IllegalArgumentException 如果msg为null，则抛出此异常。
     */
    public static void message(MsgDto msg) {

        // 确保消息对象不为空
        Asserts.notNull(msg , "消息传递对象为空.") ;

        // 异常环境信息
        Map<String , Object> envMap = new HashMap<>() ;

        msg.setTimestamp(System.currentTimeMillis());
        msg.setProjectCode(config().getProjectCode());

        // 从配置中获取服务器URL
        String serverUrl = config().getRestHost() ;
        long connectTimeout = config().getConnectTimeout() ;

        // 设置Unirest的超时时间为0，表示无限等待
        Unirest.setTimeouts(connectTimeout , 0);
        // 发送POST请求到服务器的指定路径，路径为服务器URL加上版本号和操作路径

        HttpResponse<String> response = null; // 将响应结果转换为字符串

        try {
            response = Unirest.post(serverUrl + (serverUrl.endsWith("/")?"":"/")  + "v1/api/collector/businessLog")
                    .header("Content-Type", "application/json") // 设置请求头，指定内容类型为JSON
                    .header("Accept", "*/*") // 接受所有类型的响应
                    .header("Connection", "keep-alive") // 保持连接 alive
                    .body(JSONObject.toJSONString(msg)) // 将消息对象转换为JSON格式作为请求体
                    .asString();

            // 打印响应结果
            System.out.println("response = " + response.getBody());
        } catch (UnirestException e) {
            System.out.println("预警服务网络连接异常:" + e.getMessage());

            // TODO 网络异常则先将消息放到队列中
        }

    }

    /**
     * 记录一条低级别消息。
     * 此方法用于记录一个简单的低级别消息，不包含任何参数。
     *
     * @param msgStr 消息字符串。
     */
    public static void low(String msgStr) {
        message(new MsgDto(msgStr , AlertLevelEnum.LOW.getCode())) ;
    }

    /**
     * 记录一条带有参数的低级别消息。
     * 此方法用于记录一个带有单个参数的低级别消息。
     *
     * @param msgStr 消息字符串模板。
     * @param params 消息中的参数。
     */
    public static void low(String msgStr, Object params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.LOW.getCode())) ;
    }

    /**
     * 记录一条带有可变参数列表的低级别消息。
     * 此方法用于记录一个带有多个参数的低级别消息。
     *
     * @param msgStr 消息字符串模板。
     * @param params 消息中的参数列表。
     */
    public static void low(String msgStr, Object... params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.LOW.getCode())) ;
    }

    /**
     * 记录一条带有异常的低级别消息。
     * 此方法用于记录一个带有异常信息的低级别消息。
     *
     * @param msgStr 消息字符串。
     * @param params 异常信息。
     */
    public static void low(String msgStr, Throwable params) {
        message(new MsgDto(msgStr , params.getMessage(), AlertLevelEnum.LOW.getCode())) ;
    }

    /**
     * 发送一条普通级别的消息。
     * 此方法用于传达一般性的信息，这些信息对正常操作没有直接影响。
     *
     * @param msgStr 消息文本
     */
    public static void normal(String msgStr) {
        message(new MsgDto(msgStr , AlertLevelEnum.NORMAL.getCode())) ;
    }

    /**
     * 发送一条带有参数的普通级别消息。
     * 此方法用于传达带有特定参数的一般性信息，这些信息对正常操作没有直接影响。
     *
     * @param msgStr 消息模板，包含占位符
     * @param params 占位符的参数
     */
    public static void normal(String msgStr, Object params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.LOW.getCode())) ;
    }

    /**
     * 发送一条带有可变参数列表的普通级别消息。
     * 此方法用于传达带有多个参数的一般性信息，这些信息对正常操作没有直接影响。
     *
     * @param msgStr 消息模板，包含占位符
     * @param params 占位符的参数列表
     */
    public static void normal(String msgStr, Object... params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.LOW.getCode())) ;
    }

    /**
     * 发送一条带有异常信息的普通级别消息。
     * 此方法用于当发生异常时，传达相关的错误信息。
     *
     * @param msgStr 消息文本
     * @param params 异常对象，用于提取错误信息
     */
    public static void normal(String msgStr, Throwable params) {
        message(new MsgDto(msgStr , params.getMessage(), AlertLevelEnum.LOW.getCode())) ;
    }

    /**
     * 发送一条重要级别的消息。
     * 此方法用于传达对正常操作有潜在影响的信息，需要相关人员重视。
     *
     * @param msgStr 消息文本
     */
    public static void important(String msgStr) {
        message(new MsgDto(msgStr , AlertLevelEnum.IMPORTANT.getCode())) ;
    }

    /**
     * 发送一条重要级别的消息。
     * 使用格式化字符串和参数来构建消息，然后通过message方法发送。
     *
     * @param msgStr 格式化字符串，用于构建最终的消息。
     * @param params 参数，用于填充格式化字符串。
     */
    public static void important(String msgStr, Object params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.IMPORTANT.getCode())) ;
    }

    /**
     * 发送一条重要级别的消息。
     * 使用格式化字符串和可变参数来构建消息，然后通过message方法发送。
     *
     * @param msgStr 格式化字符串，用于构建最终的消息。
     * @param params 参数，用于填充格式化字符串，可以是任意数量的参数。
     */
    public static void important(String msgStr, Object... params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.IMPORTANT.getCode())) ;
    }

    /**
     * 发送一条重要级别的消息，与异常相关联。
     * 消息内容为传入的字符串和异常信息的组合。
     *
     * @param msgStr 消息字符串。
     * @param params 异常对象，其消息将被包含在最终消息中。
     */
    public static void important(String msgStr, Throwable params) {
        message(new MsgDto(msgStr , params.getMessage(), AlertLevelEnum.IMPORTANT.getCode())) ;
    }

    /**
     * 发送一条紧急级别的消息。
     * 直接使用传入的字符串作为消息内容，并指定紧急级别。
     *
     * @param msgStr 消息字符串。
     */
    public static void emergency(String msgStr) {
        message(new MsgDto(msgStr , AlertLevelEnum.EMERGENCY.getCode())) ;
    }

    /**
     * 发送一条紧急级别的消息。
     * 使用格式化字符串和参数来构建消息，然后通过message方法发送。
     *
     * @param msgStr 格式化字符串，用于构建最终的消息。
     * @param params 参数，用于填充格式化字符串。
     */
    public static void emergency(String msgStr, Object params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.EMERGENCY.getCode())) ;
    }

    /**
     * 发送一条紧急级别的消息。
     * 使用格式化字符串和可变参数来构建消息，然后通过message方法发送。
     *
     * @param msgStr 格式化字符串，用于构建最终的消息。
     * @param params 参数，用于填充格式化字符串，可以是任意数量的参数。
     */
    public static void emergency(String msgStr, Object... params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.EMERGENCY.getCode())) ;
    }


    /**
     * 记录紧急程度为EMERGENCY的日志消息。
     * 此方法用于记录包含详细异常信息的紧急日志消息。
     *
     * @param msgStr 日志消息字符串。
     * @param params 异常对象，提供额外的错误详细信息。
     */
    public static void emergency(String msgStr, Throwable params) {
        message(new MsgDto(msgStr , params.getMessage(), AlertLevelEnum.EMERGENCY.getCode())) ;
    }

    /**
     * 记录紧急程度为CRITICAL的日志消息。
     * 此方法用于记录不包含异常信息的严重级别日志消息。
     *
     * @param msgStr 日志消息字符串。
     */
    public static void critical(String msgStr) {
        message(new MsgDto(msgStr , AlertLevelEnum.CRITICAL.getCode())) ;
    }

    /**
     * 记录紧急程度为CRITICAL的日志消息。
     * 此方法用于记录包含一个参数的严重级别日志消息。
     *
     * @param msgStr 格式化的日志消息字符串。
     * @param params 日志消息的参数。
     */
    public static void critical(String msgStr, Object params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.EMERGENCY.getCode())) ;
    }

    /**
     * 记录紧急程度为CRITICAL的日志消息。
     * 此方法用于记录包含多个参数的严重级别日志消息。
     *
     * @param msgStr 格式化的日志消息字符串。
     * @param params 日志消息的参数数组。
     */
    public static void critical(String msgStr, Object... params) {
        FormattingTuple format =  MessageFormatter.format(msgStr , params);
        message(new MsgDto(format.getMessage(), AlertLevelEnum.EMERGENCY.getCode())) ;
    }

    /**
     * 记录紧急程度为CRITICAL的日志消息。
     * 此方法用于记录包含详细异常信息的严重级别日志消息。
     *
     * @param msgStr 日志消息字符串。
     * @param params 异常对象，提供额外的错误详细信息。
     */
    public static void critical(String msgStr, Throwable params) {
        message(new MsgDto(msgStr , params.getMessage(), AlertLevelEnum.CRITICAL.getCode())) ;
    }
}
