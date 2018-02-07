package com.gaofei.dto;

import java.io.Serializable;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
public class SCDTO implements Serializable {
    private String studentId;
    private String courseId;
    private Integer score;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
