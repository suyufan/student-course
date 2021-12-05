package dao;

import model.teacher;

public interface TeacherDao {
    public teacher login(teacher teacher);//查询自己的基本信息
    public void changePass(teacher teacher);//更换学号以及密码
    public void getTeaScore(String teacherID);//录入所教课程学生成绩
    public void getAvaScore(String teacherID);//输出所教课程成绩单

}
