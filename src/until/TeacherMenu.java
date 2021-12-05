package until;

import java.util.Scanner;
import service.*;
/**
 * 老师界面
 *
 */
public class TeacherMenu {
    public static void ShowMenu(String teacherID){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________");
        System.out.println("      欢迎"+teacherID+"使用选课系统         ");
        System.out.println("    1.修改登录密码");
        System.out.println("    2.录入学生成绩");
        System.out.println("    3.打印成绩单");
        System.out.println("    4.退出选课系统");
        System.out.println("_________________________");
        int a = sc.nextInt();
        switch(a){
            case 1:  TeacherService.teacherChangePassWord(teacherID);
                break;
            case 2:  TeacherService.teacherStuScore(teacherID);
                break;
            case 3:     TeacherService.teacherAvaScore(teacherID);
                break;
            case 4:  System.out.println("用户成功退出！");
                System.exit(0);
                break;
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
        }


    }
}

