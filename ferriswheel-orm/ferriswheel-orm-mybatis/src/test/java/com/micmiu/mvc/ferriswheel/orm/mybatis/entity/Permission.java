package com.micmiu.mvc.ferriswheel.orm.mybatis.entity;

public class Permission {
    private Long id;

    private Long roleId;

    private Long menuId;

    private String resName;

    private String resCnName;

    private String operation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResCnName() {
        return resCnName;
    }

    public void setResCnName(String resCnName) {
        this.resCnName = resCnName == null ? null : resCnName.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }
}