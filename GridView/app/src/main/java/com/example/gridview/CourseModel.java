package com.example.gridview;

public class CourseModel {
    private String course_name;
    public CourseModel(String course_name)
    {
        this.course_name=course_name;
    }
    public String getCourse_name()
    {
        return course_name;
    }
    public void setCourse_name(String course_name)
    {
        this.course_name=course_name;
    }
}
