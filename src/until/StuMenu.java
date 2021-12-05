package until;

import java.util.Scanner;
import service.*;
/**
 * 学生界面
 *
 */
public class StuMenu {
    public static void showMenu(String studentID){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________");
        System.out.println("      欢迎"+studentID+"使用选课系统         ");
        System.out.println("    1.修改学生密码");
        System.out.println("    2.查看已选课程信息");
        System.out.println("    3.查询获得总学分");
        System.out.println("    4.选择课程");
        System.out.println("    5.查看可选课程信息");
        System.out.println("    6.删除已选课程");
        System.out.println("    7.打印个人成绩单");
        System.out.println("    8.退出选课系统");
        System.out.println("_________________________");
        int a = sc.nextInt();
        switch(a){
            case 1:  StudentService.studentChangePassWord(studentID);
                break;
            case 2:  StudentService.studentStuCourse(studentID);
                break;
            case 3: StudentService.studentStuCourseCredit(studentID);
                break;
            case 4:     StudentService.studentChooserCourse(studentID);
                break;
            case 5:     StudentService.studentAvaCourse(studentID);
                break;
            case 6:     StudentService.studentDeleteCourse(studentID);
                break;
            case 7: StudentService.studentStuCourseScore(studentID);
                break;
            case 8:  System.out.println("用户成功退出！");
                System.exit(0);
                break;
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
        }


    }

}
