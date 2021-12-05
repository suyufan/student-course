package until;

import dao.TeacherDao;
import service.StudentService;

import java.util.Scanner;
/**
 * 管理员界面
 *
 */
public class AdminMenu {
    public static void ShowMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________");
        System.out.println("      欢迎使用选课系统         ");
        System.out.println("    1.课程管理");
        System.out.println("    2.学生管理");
        System.out.println("    3.教师管理");
        System.out.println("    4.退出系统");
        System.out.println("_________________________");
        int a =sc.nextInt();
        switch(a){
            case 1:
                CourseControlMenu.ShowMenu();
                break;
            case 2:
                StudentControlMenu.ShowMenu();
                break;
            case 3:
                TeacherControlMenu.ShowMenu();
                break;
            case 4:
                System.out.println("用户成功退出！");
                System.exit(0);
                break;
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
        }
    }


}
