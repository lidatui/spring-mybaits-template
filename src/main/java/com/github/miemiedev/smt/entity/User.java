package com.github.miemiedev.smt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * FP_USER_BASIC_INFO
 * User: miemiebw
 */
public class User implements Serializable {
    private Long id;
    private String name;
    private String realName;
    private String email;
    private String type;
    private String state;
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append('}');
        return sb.toString();
    }
}
