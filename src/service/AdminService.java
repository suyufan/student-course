package service;

import java.sql.Date;
import java.util.Scanner;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import model.course;
import model.admin;
import model.student;
import model.teach;
import model.teacher;
import until.AdminMenu;
import until.StuMenu;

public class AdminService {
    static Scanner sc = new Scanner(System.in);
    //管理员登录
    public void manLogin(String adminID,String adminPassword){
        AdminDao dao= new AdminDaoImpl();
        admin admin = new admin();
        admin.setAdminID(adminID);
        admin.setAdminPassword(adminPassword);
        dao.login(admin);
        if(dao.login(admin)!=null){
            System.out.println("登录成功");
            AdminMenu.ShowMenu();

        }
        else{
            System.out.println("用户名或密码错误");
        }
    }
    //添加课程
    public static void manAddCourse(){
        AdminDao dao = new AdminDaoImpl();
        course course=new course();
        System.out.println("请输入要填加的课程ID：");
        course.setCourseID(sc.nextLine());
        System.out.println("请输入要填加的课程名：");
        course.setCourseName(sc.next());
        System.out.println("请输入要添加的课程学分：");
        course.setCourseCredit(sc.nextFloat());
        dao.addCourse(course);
        AdminMenu.ShowMenu();
    }
    //删除课程
    public static void manDeleteCourse(){
        AdminDao dao = new AdminDaoImpl();
        System.out.println("请输入要删除的课程ID：");
        String courseID=sc.next();
        dao.deleteCourse(courseID);
        AdminMenu.ShowMenu();
    }
    //修改课程
    public static void manUpdateCourse(){
        AdminDao dao = new AdminDaoImpl();
        course course=new course();
        System.out.println("请输入要修改的课程ID：");
        course.setCourseID(sc.nextLine());
        System.out.println("请输入修改后的课程名：");
        course.setCourseName(sc.nextLine());
        System.out.println("请输入要修改的课程学分：");
        course.setCourseCredit(sc.nextFloat());
        dao.updateCourse(course);
        AdminMenu.ShowMenu();
    }
    //查看某一课程
    public static void manOneCourse(){
        AdminDao dao = new AdminDaoImpl();
        System.out.println("请输入要查看的课程ID：");
        String courseID=sc.next();
        dao.selectOneCourse(courseID);
        AdminMenu.ShowMenu();
    }
    //查看全部课程
    public static void manAllCourse(){
        AdminDao dao = new AdminDaoImpl();
        System.out.println("已有课程如下：");
        dao.selectAllCourse();
        AdminMenu.ShowMenu();
    }
    //添加学生
    public static void manAddStudent(){
        AdminDao dao = new AdminDaoImpl();
        student student = new student();
        System.out.println("请输入要填加的学生学号：");
        student.setStudentID(sc.nextLine());
        System.out.println("请输入学生姓名");
        student.setStudentName(sc.nextLine());
        System.out.println("请输入密码：");
        student.setStudentPassword(sc.nextLine());
        System.out.println("请输入学生性别：");
        student.setStudentSex(sc.nextLine());
        System.out.println("请输入学生生日：");
        student.setStudentBirthday(sc.nextLine());
        System.out.println("请输入学生专业");
        student.setStudentSubject(sc.nextLine());
        System.out.println("请输入学生联系方式");
        student.setStudentTel(sc.nextLine());
        System.out.println("请输入学生Email");
        student.setStudentEmail(sc.nextLine());
        dao.addStudent(student);
        AdminMenu.ShowMenu();
    }
    //添加教师
    public static void manAddTeacher(){
        AdminDao dao = new AdminDaoImpl();
        teacher teacher = new teacher();
        System.out.println("请输入要填加的教师学号：");
        teacher.setTeacherID(sc.nextLine());
        System.out.println("请输入教师姓名");
        teacher.setTeacherName(sc.nextLine());
        System.out.println("请输入密码：");
        teacher.setTeacherPassword(sc.nextLine());
        System.out.println("请输入教师性别：");
        teacher.setTeacherSex(sc.nextLine());
        System.out.println("请输入教师生日：");
        teacher.setTeacherBirthday(sc.nextLine());
        System.out.println("请输入教师职称");
        teacher.setTeacherTitle(sc.nextLine());
        System.out.println("请输入教师联系方式");
        teacher.setTeacherTel(sc.nextLine());
        System.out.println("请输入教师Email");
        teacher.setTeacherEmail(sc.nextLine());
        dao.addTeacher(teacher);
        AdminMenu.ShowMenu();
    }
    //删除学生
    public static void manDeleteUser(){
        AdminDao dao = new AdminDaoImpl();
        System.out.println("请输入要删除的学生学号：");
        String studentID = sc.next();
        dao.deleteStudent(studentID);
        AdminMenu.ShowMenu();
    }
    //修改学生
    public static void manUpdateUser(){
        AdminDao dao = new AdminDaoImpl();
        student student= new student();
        System.out.println("请输入要修改的学生学号：");
        student.setStudentID(sc.next());
        System.out.println("请输入修改后的密码：");
        student.setStudentPassword(sc.nextLine());
        dao.updateStudent(student);
        AdminMenu.ShowMenu();
    }
    //查看某一学生
    public static void manOneUser(){
        AdminDao dao = new AdminDaoImpl();
        System.out.println("请输入要查看的学生学号：");
        String studentID = sc.next();
        dao.selectOneStudent(studentID);
        AdminMenu.ShowMenu();
    }
    //查看全部学生
    public static void manAllUser(){
        AdminDao dao = new AdminDaoImpl();
        System.out.println("已有学生信息如下：");
        System.out.println("学生ID \t 学生姓名 \t 学生密码 \t ");
        dao.selectAllStudent();
        AdminMenu.ShowMenu();
    }
    //查看某一老师
    public static void manOneTeacher(){
        AdminDao dao = new AdminDaoImpl();
        System.out.println("请输入要查看的老师学号：");
        String teacherID = sc.next();
        dao.selectOneTeacher(teacherID);
        AdminMenu.ShowMenu();
    }
    //查看全部老师
    public static void manAllTeacher(){
        AdminDao dao = new AdminDaoImpl();
        System.out.println("已有老师信息如下：");
        System.out.println("教师ID \t 教师姓名 \t 教师密码 \t ");
        dao.selectAllTeacher();
        AdminMenu.ShowMenu();
    }

}