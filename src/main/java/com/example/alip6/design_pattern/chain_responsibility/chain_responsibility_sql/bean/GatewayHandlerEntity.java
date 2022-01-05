package com.example.alip6.design_pattern.chain_responsibility.chain_responsibility_sql.bean;

/**
 * 责任链模式数据库实体类
 */
public class GatewayHandlerEntity {

    private Integer id;

    private String handlerName;

    private String handlerId;

    private String nextHandlerId;

    private String prevHandlerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getNextHandlerId() {
        return nextHandlerId;
    }

    public void setNextHandlerId(String nextHandlerId) {
        this.nextHandlerId = nextHandlerId;
    }
}
