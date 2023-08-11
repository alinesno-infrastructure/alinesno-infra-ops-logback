package com.alinesno.infra.ops.logback.core.dto;

/**
 * RunLogCompressMessage类是一个运行日志压缩消息类，用于存储压缩后的日志消息。
 */
public class RunLogCompressMessage {

    private Integer length; // 压缩后的消息长度
    private byte[] body; // 压缩后的消息内容

    /**
     * 获取压缩后的消息内容。
     *
     * @return 压缩后的消息内容
     */
    public byte[] getBody() {
        return body;
    }

    /**
     * 设置压缩后的消息内容。
     *
     * @param body 压缩后的消息内容
     */
    public void setBody(byte[] body) {
        this.body = body;
    }

    /**
     * 获取压缩后的消息长度。
     *
     * @return 压缩后的消息长度
     */
    public Integer getLength() {
        return length;
    }

    /**
     * 设置压缩后的消息长度。
     *
     * @param length 压缩后的消息长度
     */
    public void setLength(Integer length) {
        this.length = length;
    }

}
