/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

/**
 * Created by lugman on 28/05/17.
 */

class Task {
    String id;
    String task;
    String importance;
    String year;
    String month;
    String day;
    String hour;
    String minute;
    String check;



    public Task() {
        this.task = task;
        importance="";
        year="";
        month="";
        day="";
        hour="";
        minute="";
        check="no";
    }

    public Task(String task, String importance, String year,String month,String day,String hour,String minute) {
        this.task = task;
        this.importance = importance;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour=hour;
        this.minute=minute;
        check="no";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
