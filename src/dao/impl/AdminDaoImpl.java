package dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.AdminDao;
import model.course;
import model.admin;
import model.student;
import model.teacher;
import model.teach;
import until.BaseDao;

public class AdminDaoImpl implements AdminDao{

    //管理员登录
    @Override
    public admin login(admin admin) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="select * from admin where adminID=? and adminPassword=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,admin.getAdminID());
            ps.setString(2, admin.getAdminPassword());
            rs=ps.executeQuery();
            admin  admins=null;
            if(rs.next()){
                admins=new admin();
                admins.setAdminID(rs.getString("adminID"));
                admins.setAdminPassword(rs.getString("adminPassword"));
                return admins;

            }
            else
                return null;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    //添加课程
    @Override
    public void addCourse(course course) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="insert into course (courseID,courseName,courseCredit) values(?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getCourseName());
            ps.setFloat(3, course.getCourseCredit());
            int a = ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //删除课程
    @Override
    public void deleteCourse(String courseID) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "delete from course where courseID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, courseID);
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
                String sql2="delete from choice where courseID=?";
                ps=con.prepareStatement(sql2);
                ps.setString(1, courseID);
                int b=ps.executeUpdate();
            }
            else{
                System.out.println("输入ID有误，删除失败");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //修改课程
    @Override
    public void updateCourse(course course) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="update course set courseID=?,courseName=? where courseCredit=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getCourseName());
            ps.setFloat(3, course.getCourseCredit());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("课程修改成功");
            }
            else{
                System.out.println("输入ID有误，课程修改失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //    查看某一课程
    @Override
    public void selectOneCourse(String courseID) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from course where courseID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, courseID);
            rs=ps.executeQuery();
            course course=null;
            if(rs.next()){
                course = new course();
                course.setCourseID(rs.getString("courseID"));
                course.setCourseName(rs.getString("courseName"));
                course.setCourseCredit(rs.getFloat("courseCredit"));
                System.out.println("courseID "+"\t"+" courseName"+"\t"+"courseCredit"+"\t");
                System.out.println(course.getCourseID()+" "+course.getCourseName()+" "+course.getCourseCredit());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //查看全部课程
    @Override
    public void selectAllCourse() {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from course ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            course course=null;
            System.out.println("courseID "+"\t"+" courseName"+"\t"+"courseCredit"+"\t");
            while(rs.next()){
                course = new course();
                course.setCourseID(rs.getString("courseID"));
                course.setCourseName(rs.getString("courseName"));
                course.setCourseCredit(rs.getFloat("courseCredit"));
                System.out.println(course.getCourseID()+" \t "+course.getCourseName()+" \t "+course.getCourseCredit());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //添加学生
    @Override
    public void addStudent(student student) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="insert into student (studentID,studntName,studentPassword,studentSex,studentBirthday,studentSubject,studentTel,studentEmail) values(?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, student.getStudentID());
            ps.setString(2,student.getStudentName());
            ps.setString(3, student.getStudentPassword());
            ps.setString(4,student.getStudentSex());
            ps.setString(5,student.getStudentBirthday());
            ps.setString(6,student.getStudentSubject());
            ps.setString(7,student.getStudentTel());
            ps.setString(8,student.getStudentEmail());

            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("学生添加成功");
            }
            else{
                System.out.println("学生添加失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //删除学生
    @Override
    public void deleteStudent(String studentID) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "delete from student where studentID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,studentID);
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
                String sql2="delete from choice where studentID=?";
                ps=con.prepareStatement(sql2);
                ps.setString(1, studentID);
                int b=ps.executeUpdate();
            }
            else{
                System.out.println("输入用户名有误，删除失败");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //修改用户
    @Override
    public void updateStudent(student student) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="update student set studentPassword=? where studentID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, student.getStudentPassword());
            ps.setString(2, student.getStudentID());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("学生修改成功");
            }
            else{
                System.out.println("输入有误，学生修改失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //查看某一学生
    @Override
    public void selectOneStudent(String studentID) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from student where studentID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, studentID);
            rs=ps.executeQuery();
            student student=null;
            if(rs.next()){
                student = new student();
                student.setStudentID(rs.getString("studentName"));
                student.setStudentPassword(rs.getString("studentPassword"));
                System.out.println(student.getStudentID()+" "+student.getStudentPassword());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //查看全部学生
    @Override
    public void selectAllStudent() {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from student ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            student student=null;
            while(rs.next()){
                student = new student();
                student.setStudentID(rs.getString("studentID"));
                student.setStudentName(rs.getString("studentName"));
                student.setStudentPassword(rs.getString("studentPassword"));
                System.out.println(student.getStudentID()+" "+student.getStudentName()+" "+student.getStudentPassword());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //添加教师
    @Override
    public void addTeacher(teacher teacher) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="insert into teacher (teacherID,teacherName,teacherPassword,teacherSex,teacherBirthday,teacherTitle,teacherTel,teacherEmail) values(?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacher.getTeacherID());
            ps.setString(2,teacher.getTeacherName());
            ps.setString(3, teacher.getTeacherPassword());
            ps.setString(4,teacher.getTeacherSex());
            ps.setString(5,teacher.getTeacherBirthday());
            ps.setString(6,teacher.getTeacherTitle());
            ps.setString(7,teacher.getTeacherTel());
            ps.setString(8,teacher.getTeacherEmail());

            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("教师添加成功");
            }
            else{
                System.out.println("教师添加失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //修改老师
    @Override
    public void updateTeacher(teacher teacher) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql="update teacher set teacherPassword=? where teacherID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacher.getTeacherPassword());
            ps.setString(2, teacher.getTeacherID());
            int a = ps.executeUpdate();
            if(a>0){
                System.out.println("老师修改成功");
            }
            else{
                System.out.println("输入有误，老师修改失败");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //删除老师
    @Override
    public void deleteTeacher(String teacherID) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql = "delete from teacher where teacherID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacherID);
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("删除成功");
                String sql2="delete from teach where teacherID=?";
                ps=con.prepareStatement(sql2);
                ps.setString(1, teacherID);
                int b=ps.executeUpdate();
            }
            else{
                System.out.println("输入用户名有误，删除失败");
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //查看某一老师
    @Override
    public void selectOneTeacher(String teacherID) {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from teacher where teacherID=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, teacherID);
            rs=ps.executeQuery();
            teacher teacher=null;
            if(rs.next()){
                teacher = new teacher();
                teacher.setTeacherID(rs.getString("teacherName"));
                teacher.setTeacherPassword(rs.getString("teacherPassword"));
                System.out.println(teacher.getTeacherID()+" "+teacher.getTeacherPassword());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //查看全部老师
    @Override
    public void selectAllTeacher() {
        // TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();
            String sql ="select * from teacher ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            teacher teacher=null;
            while(rs.next()){
                teacher = new teacher();
                teacher.setTeacherID(rs.getString("teacherID"));
                teacher.setTeacherName(rs.getString("teacherName"));
                teacher.setTeacherPassword(rs.getString("teacherPassword"));
                System.out.println(teacher.getTeacherID()+" \t "+teacher.getTeacherName()+" \t "+teacher.getTeacherPassword()+" \t ");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
