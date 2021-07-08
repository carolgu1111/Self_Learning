package com.ruoyi.project.ums.employed.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author CAROL GU
 * @create 2021-07-07 2:56 PM
 * @desc
 */
public class UMSEmployed extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long employedId;
    private String employedName;
    private String employedSort;
    private String employedState;
    private String status;

    public Long getEmployedId() {
        return employedId;
    }

    public void setEmployedId(Long employedId) {
        this.employedId = employedId;
    }

    @NotBlank(message = "员工姓名不能为空")
    @Size(min = 0, max = 50, message = "员工姓名长度不能超过50个字符")
    public String getEmployedName() {
        return employedName;
    }

    public void setEmployedName(String employedName) {
        this.employedName = employedName;
    }

    @NotBlank(message = "显示排序不能为空")
    public String getEmployedSort() {
        return employedSort;
    }

    public void setEmployedSort(String employedSort) {
        this.employedSort = employedSort;
    }

    public String getEmployedState() {
        return employedState;
    }

    public void setEmployedState(String employedState) {
        this.employedState = employedState;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
