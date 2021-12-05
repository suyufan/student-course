package service;
import java.util.Scanner;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import model.student;
import until.StuMenu;
import model.course;

public class StudentService {
    static Scanner sc = new Scanner(System.in);
    public void studentLogin(String studentID,String studentPassword){
        StudentDao dao = new StudentDaoImpl();
        student student =new student();
        /*student.setStudentName(studentName);*/
        student.setStudentID(studentID);
        student.setStudentPassword(studentPassword);
        dao.login(student);
        if(dao.login(student)!=null){
            System.out.println("登录成功");
            StuMenu.showMenu(studentID);
        }
        else{
            System.out.println("用户名或密码错误");
        }

    }
    public static void studentChangePassWord(String studentID){
        StudentDao dao = new StudentDaoImpl();
        student student =new student();
        System.out.println("请输入新密码");
        String studentPassword = sc.nextLine();
        if(studentPassword==""||studentPassword.length()>10){
            System.exit(0);
        }
        else{
            student.setStudentID(studentID);
            student.setStudentPassword(studentPassword);
            dao.changePass(student);
            System.out.println("修改密码成功，新密码为："+studentPassword);
            StuMenu.showMenu(studentID);
        }

    }
    public static void studentStuCourse(String studentID){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("已选课程信息为：");
        dao.getStuCourse(studentID);
        StuMenu.showMenu(studentID);
    }
    public static void studentStuCourseCredit(String studentID) {
        StudentDao dao = new StudentDaoImpl();
        System.out.println("---------------------");
        System.out.println("获得总学分为 ");
        dao.getStuCourseCredit(studentID);
        StuMenu.showMenu(studentID);
    }
    public static void studentDeleteCourse(String studentID){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("想要删除的课程ID为：");
        String courseID=sc.nextLine();
        dao.deleteCourse(studentID,courseID);
        StuMenu.showMenu(studentID);

    }
    public static void studentAvaCourse(String studentID){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("可选课程为：");
        dao.getAvaCourse(studentID);
        StuMenu.showMenu(studentID);
    }
    public static void studentChooserCourse(String studentID){
        StudentDao dao = new StudentDaoImpl();
        System.out.println("_________________________");
        System.out.println("想要选择的课程ID为：");
        String courseID=sc.nextLine();
        System.out.println("默认输入成绩为0");
        float choiceScore = sc.nextFloat();
        dao.chooseCourse(studentID,courseID,choiceScore);
        StuMenu.showMenu(studentID);
    }
    public static void studentStuCourseScore(String studentID) {
        StudentDao dao = new StudentDaoImpl();
        System.out.println("---------------------");
        System.out.println("个人成绩单为 ");
        dao.getStuCourseScore(studentID);
        StuMenu.showMenu(studentID);
    }
}
