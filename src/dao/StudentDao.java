package dao;

import model.student;
import model.choice;

public interface StudentDao {
    public student login(student student);//查询自己的基本信息
    public void changePass(student student);//更换学号以及密码
    public void getStuCourse(String studentID);//查询已选课程
    public void getStuCourseCredit(String studentID);//查询获得学分
    public void getAvaCourse(String studentID);//查询可选课程
    public void chooseCourse(String studentID,String courseID,float choiceScore);//选课
    public void deleteCourse(String studentID,String courseID);//删除选课
    public void getStuCourseScore(String studentID);//打印个人成绩单
}
