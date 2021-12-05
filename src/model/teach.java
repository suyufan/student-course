package model;

import java.util.Date;

public class teach {
    private String teacherID;
    private int courseID;
    private String teachDate;

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getTeachDate() {
        return teachDate;
    }

    public void setTeachDate(String teachDate) {
        this.teachDate = teachDate;
    }
}
