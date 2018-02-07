package com.gaofei.persist.domain;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
public class SCDomain {
    private String studentId;
    private String courseId;
    private Integer score;
    //这个地方可以加个scoreName 练习一个关联查询

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
