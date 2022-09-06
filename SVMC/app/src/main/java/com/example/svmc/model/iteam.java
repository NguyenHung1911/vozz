package com.example.svmc.model;

import java.io.Serializable;

public class iteam implements Serializable {
    private int id;
    private String name, date, timeStart, timeEnd, content;
    private int trangThai;

    public iteam() {
    }

    public iteam(int id, String name, String date, String timeStart, String timeEnd, String content, int trangThai) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.content = content;
        this.trangThai = trangThai;
    }

    public iteam(String name, String date, String timeStart, String timeEnd, String content, int trangThai) {
        this.name = name;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.content = content;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTrangThai() {
        return 0;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
