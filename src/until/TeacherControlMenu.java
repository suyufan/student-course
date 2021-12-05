package until;

import java.util.Scanner;

import service.AdminService;
/**
 * 教师管理界面
 *
 */
public class TeacherControlMenu {
    public static void ShowMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________");
        System.out.println("    1.教师新增");
        System.out.println("    2.教师查看");
        System.out.println("    3.教师删除");
        System.out.println("    4.教师修改");
        System.out.println("_________________________");
        int a =sc.nextInt();
        switch(a){
            case 1:
                AdminService.manAddTeacher();
                break;
            case 2:
                TeacherLookMenu.ShowMenu();
                break;
            case 3:
                AdminService.manDeleteUser();
                break;
            case 4:
                AdminService.manUpdateUser();
                break;
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);
        }
    }

}
