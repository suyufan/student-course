package dao;

import model.course;
import model.admin;
import model.student;
import model.teacher;

public interface AdminDao {
    public admin login(admin admin);

    public void addCourse(course course);//增加课程
    public void deleteCourse(String courseID);//删除课程
    public void updateCourse(course course);//更新课程
    public void selectOneCourse(String courseID);//查询一个课程
    public void selectAllCourse();//查询所有课程

    public void addStudent(student student);//增加学生信息
    public void deleteStudent(String studentID);//删除学生信息
    public void updateStudent(student student);//更新学生信息
    public void selectOneStudent(String studentID);//查询一个学生信息
    public void selectAllStudent();//查询所有学生信息

    public void addTeacher(teacher teacher);//增加教师信息
    public void deleteTeacher(String teacherID);//删除教师信息
    public void updateTeacher(teacher teacher);//更新教师信息
    public void selectOneTeacher(String teacherID);//查询一个教师信息
    public void selectAllTeacher();//查询所有教师信息

}
