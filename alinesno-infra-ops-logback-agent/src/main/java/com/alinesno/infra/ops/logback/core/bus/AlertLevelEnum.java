package com.alinesno.infra.ops.logback.core.bus;

import lombok.Getter;

/**
 * 报警等级枚举类，定义了系统的报警等级及其对应的代码和标签。
 */
@Getter
public enum AlertLevelEnum {

    CRITICAL("0", "严重"),
    EMERGENCY("1", "紧急"),
    IMPORTANT("2", "重要"),
    NORMAL("3", "一般"),
    LOW("4", "低");

    // 报警等级代码
    private final String code;
    // 报警等级标签，用于显示
    private final String label;

    /**
     * 构造方法，初始化报警等级的代码和标签。
     * @param code 报警等级的代码
     * @param label 报警等级的标签
     */
    AlertLevelEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    /**
     * 根据代码获取报警等级枚举值。
     * @param code 报警等级的代码
     * @return 对应代码的报警等级枚举值，如果不存在则返回null
     */
    public static AlertLevelEnum getByCode(String code) {
        for (AlertLevelEnum value : AlertLevelEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    /**
     * 根据标签获取报警等级枚举值。
     * @param label 报警等级的标签
     * @return 对应标签的报警等级枚举值，如果不存在则返回null
     */
    public static AlertLevelEnum getByLabel(String label) {
        for (AlertLevelEnum value : AlertLevelEnum.values()) {
            if (value.getLabel().equals(label)) {
                return value;
            }
        }
        return null;
    }

    /**
     * 根据代码获取报警等级的标签。
     * @param code 报警等级的代码
     * @return 对应代码的报警等级标签，如果不存在则返回null
     */
    public static String getLabelByCode(String code) {
        for (AlertLevelEnum value : AlertLevelEnum.values()) {
            if (value.getCode().equals(code)) {
                return value.getLabel();
            }
        }
        return null;
    }
}
