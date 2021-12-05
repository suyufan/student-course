package service;
import java.util.Scanner;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import dao.*;
import until.*;
import model.teacher;
import model.teach;
import model.choice;
import model.course;
import model.student;
import until.TeacherMenu;

public class TeacherService {
    static Scanner sc = new Scanner(System.in);
    public void teacherLogin(String teacherID,String teacherPassword){
        TeacherDao dao = new TeacherDaoImpl();
        teacher teacher =new teacher();
        /*teacher.setteacherName(teacherName);*/
        teacher.setTeacherID(teacherID);
        teacher.setTeacherPassword(teacherPassword);
        dao.login(teacher);
        if(dao.login(teacher)!=null){
            System.out.println("登录成功");
            TeacherMenu.ShowMenu(teacherID);
        }
        else{
            System.out.println("用户名或密码错误");
        }

    }
    public static void teacherChangePassWord(String teacherID){
        TeacherDao dao = new TeacherDaoImpl();
        teacher teacher =new teacher();
        System.out.println("请输入新密码");
        String teacherPassword = sc.nextLine();
        if(teacherPassword==""||teacherPassword.length()>10){
            System.exit(0);
        }
        else{
            teacher.setTeacherID(teacherID);
            teacher.setTeacherPassword(teacherPassword);
            dao.changePass(teacher);
            System.out.println("修改密码成功，新密码为："+teacherPassword);
            TeacherMenu.ShowMenu(teacherID);
        }

    }

    /**
     * 录入失败
     * @param teacherID,choiceScore
     */
    public static void teacherStuScore(String teacherID){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("_________________________");
        System.out.println("请依次输入学生成绩：");
        String choiceScore = sc.nextLine();
        dao.getTeaScore(teacherID);
        TeacherMenu.ShowMenu(teacherID);
    }

    public static void teacherAvaScore(String teacherID){
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println("_________________________");
        System.out.println("打印学生成绩单为：");
        dao.getAvaScore(teacherID);
        TeacherMenu.ShowMenu(teacherID);
    }

}

