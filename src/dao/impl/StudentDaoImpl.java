package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.String;

import javax.swing.plaf.synth.SynthScrollBarUI;

import model.student;
import model.choice;
import model.course;
import until.*;
import dao.StudentDao;

public class StudentDaoImpl implements StudentDao{

    @Override
    //查询学生的学号以及密码
    public student login(student student) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con= BaseDao.getCon();
            String sql="select * from student where studentID=? and studentPassword=?";
            ps=con.prepareStatement(sql);
            /*ps.setString(1,student.getStudentName());*/
            ps.setString(1, student.getStudentID());
            ps.setString(2, student.getStudentPassword());
            rs=ps.executeQuery();
            student students= null;
            if(rs.next()){
                students =new student();
                //从数据库中获取值设置到实体类的setter方法中
                /*students.setStudentName(rs.getString("studentName"));*/
                students.setStudentID(rs.getString("studentID"));
                students.setStudentPassword(rs.getString("studentPassword"));
                return students;
            }else{
                return null;
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    //更新用户名以及密码
    public void changePass(student student) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "update student set studentPassword=? where studentID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, student.getStudentPassword());
            ps.setString(2, student.getStudentID());
            int a =ps.executeUpdate();

        }    catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    //选课
    public void chooseCourse(String studentID,String courseID,float choiceScore) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="insert into choice (studentID,courseID,choiceScore) values(?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,studentID);
            ps.setString(2, courseID);
            ps.setFloat(3,choiceScore);
            int a =ps.executeUpdate();
            if(a>0){
                System.out.println("选课成功");
            }
            else{
                System.out.println("输入ID有误，选课失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //删除选课
    @Override
    public void deleteCourse(String studentID,String courseID) {
        // TODO Auto-generated method stub

        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="delete from choice where studentID=? and courseID=? ";
            ps=con.prepareStatement(sql);
            ps.setString(1, studentID);
            ps.setString(2, courseID);
            int a =ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("输入ID有误，删除失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //查询已选课程
    @Override
    public void getStuCourse(String studentID) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();

            String sql ="select * from course where courseID in (select courseID from choice where studentID=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, studentID);
            rs=ps.executeQuery();
            System.out.println("courseID \t courseName \t courseCredit \t");
            while (rs.next()) {
                //System.out.println(6);
                course course = new course();
                course.setCourseID(rs.getString("courseID"));
                course.setCourseName(rs.getString("courseName"));
                course.setCourseCredit(rs.getFloat("courseCredit"));

                System.out.println(course.getCourseID()+" "+course.getCourseName()+" "+course.getCourseCredit());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    //查询获得学分
    @Override
    public void getStuCourseCredit(String studentID) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "Select sum(courseCredit) From course,choice Where course.courseID=choice.courseID and choice.choiceScore>60 and choice.studentID=?;";
            ps=con.prepareStatement(sql);
            ps.setString(1, studentID);
            rs=ps.executeQuery();
            while (rs.next()) {
                course course = new course();
                course.setCourseCredit(rs.getFloat("sum(courseCredit)"));

                System.out.println(course.getCourseCredit());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //查询可选课程
    @Override
    public void getAvaCourse(String studentID) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "select * from course where courseID not in (select courseID from choice where studentID=?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,studentID);
            rs=ps.executeQuery();
            System.out.println("courseID \t courseName \t courseCredit \t");
            while (rs.next()) {
                course course = new course();
                course.setCourseID(rs.getString("courseID"));
                course.setCourseName(rs.getString("courseName"));
                course.setCourseCredit(rs.getFloat("courseCredit"));

                System.out.println(course.getCourseID()+" "+course.getCourseName()+" "+course.getCourseCredit());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //打印成绩单
    @Override
    public void getStuCourseScore(String studentID) {
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "select courseName,choiceScore from course,choice where choice.studentID in (SELECT choice.studentID from choice,student where choice.studentID = student.studentID and student.studentID = ?);";
            ps=con.prepareStatement(sql);
            ps.setString(1,studentID);
            rs=ps.executeQuery();
            System.out.println("courseName \t choiceScore \t ");
            while (rs.next()) {
                course course = new course();
                choice choice = new choice();
                course.setCourseName(rs.getString("courseName"));
                choice.setChoiceScore(rs.getFloat("choiceScore"));

                System.out.println(course.getCourseName()+"    \t  "+choice.getChoiceScore());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}