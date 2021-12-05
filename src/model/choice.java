package model;

public class choice {
    private  float choiceScore;
    private String studentID;
    private String courseID;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourserID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public  float getChoiceScore() {
        return choiceScore;
    }

    public void setChoiceScore(float choiceScore) {
        this.choiceScore = choiceScore;
    }
}
