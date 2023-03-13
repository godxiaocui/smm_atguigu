package com.czh.mybatis.pojo;

import java.util.List;

public class Dept {
    private Integer deptId;
    private String deptName;
    private List<Emp> emp;

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", emp=" + emp +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmp() {
        return emp;
    }

    public void setEmp(List<Emp> emp) {
        this.emp = emp;
    }

    public Dept(Integer deptId, String deptName, List<Emp> emp) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.emp = emp;
    }
}

