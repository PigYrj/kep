package com.pigyrj.kep.server.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author YRJ
 * @date 2019/4/25
 * 字典项节点
 */
@Getter
@Setter
@NoArgsConstructor
public class DictNodeEntity extends BaseEntity{

    private int id;

    /**
     * 字典项的唯一编码
     */
    private String code;

    /**
     * 字典项的值
     */
    private String value;

    /**
     * 字典项的名称
     */
    private String name;

    /**
     * 字典项分组标识
     */
    private String groupId;

    /**
     * 字典项的标签
     */
    private String lable;

    /**
     * 父项的CODE
     */
    private String parentCode;

    /**
     * 字典项等级标识
     */
    private String level;

    /**
     * 备注
     */
    private String note;

    /**
     * 数据有效性 1-有效 其他-无效
     */
    private String enable;
}
