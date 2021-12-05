package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.String;

import javax.swing.plaf.synth.SynthScrollBarUI;

import model.*;
import until.*;
import dao.TeacherDao;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    //查询教师的工号以及密码
    public teacher login(teacher teacher) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = BaseDao.getCon();
            String sql = "select * from teacher where teacherID=? and teacherPassword=?";
            ps = con.prepareStatement(sql);
            /*ps.setString(1,student.getStudentName());*/
            ps.setString(1, teacher.getTeacherID());
            ps.setString(2, teacher.getTeacherPassword());
            rs = ps.executeQuery();
            teacher teachers = null;
            if (rs.next()) {
                teachers = new teacher();
                //从数据库中获取值设置到实体类的setter方法中
                /*teachers.setteacherName(rs.getString("teacherName"));*/
                teachers.setTeacherID(rs.getString("teacherID"));
                teachers.setTeacherPassword(rs.getString("teacherPassword"));
                return teachers;
            } else {
                return null;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    //更新用户名以及密码
    public void changePass(teacher teacher) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = BaseDao.getCon();
            String sql = "update teacher set teacherPassword=? where teacherID=?";
            ps = con.prepareStatement(sql);

            ps.setString(1, teacher.getTeacherPassword());
            ps.setString(2, teacher.getTeacherID());
            int a = ps.executeUpdate();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    //录入自己所教课程的学生成绩
    public void getTeaScore(String teacherID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = BaseDao.getCon();
            String sql1 = "SELECT choice.studentID,choice.choiceScore from choice,teach where teach.courseID = choice.courseID and teacherID=?";
            ps = con.prepareStatement(sql1);
            ps.setString(1, teacherID);
            rs = ps.executeQuery();
            System.out.println("studentID \t choiceScore \t ");
            while (rs.next()) {
                choice choice = new choice();
                choice.setStudentID(rs.getString("studentID"));
                choice.setChoiceScore(rs.getFloat("choiceScore"));

                System.out.println(choice.getStudentID()+" \t "+ choice.getChoiceScore());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
            /*String sql2 = "Insert into SELECT choice.studentID,choice.choiceScore from choice,teach where teach.courseID = choice.courseID and teacherID=? (studentID,choiceScore) values(?,?)";
            int a = ps.executeUpdate();
            if (a > 0) {
                System.out.println("成绩录入成功");
            } else {
                System.out.println("成绩录入失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

    @Override
    //输出所教课程的成绩单
    public void getAvaScore(String teacherID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = BaseDao.getCon();
            String sql = "select choice.courseID,student.studentName,choice.choiceScore from student,choice,teach where choice.studentID in (select choice.studentID from choice,teach where choice.courseID=teach.courseID and teach.teacherID =?);";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacherID);
           /* ps.setString(1, studentID);*/
            rs = ps.executeQuery();
            System.out.println("courseID \t studentName \t choiceScore \t");
            while (rs.next()) {
                //System.out.println(6);
                course course = new course();
                course.setCourseID(rs.getString("courseID"));
                course.setCourseName(rs.getString("studentName"));
                course.setCourseCredit(rs.getFloat("choiceScore"));

                System.out.println(course.getCourseID() + " " + course.getCourseName() + " " + course.getCourseCredit());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

