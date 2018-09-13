package com.imking.imking_admin.vo;

import java.util.List;

public class PageVo<T> {
    private int code;
    private String msg;
    private int count;
    private List<T> list;

    public PageVo(int count, List<T> list) {
        this.code = 0;
        this.msg = "ok";
        this.count = count;
        this.list = list;
    }

    public PageVo() {
    }

    public PageVo(int code, String msg, int count, List<T> list) {

        this.code = code;
        this.msg = msg;
        this.count = count;
        this.list = list;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
