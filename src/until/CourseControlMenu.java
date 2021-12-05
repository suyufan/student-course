package until;

import java.util.Scanner;
/**
 * 课程管理界面
 */
import service.AdminService;
public class CourseControlMenu {
    public static void ShowMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________");
        System.out.println("    1.课程新增");
        System.out.println("    2.课程查看");
        System.out.println("    3.课程删除");
        System.out.println("    4.课程修改");
        System.out.println("_________________________");
        int a =sc.nextInt();
        switch(a){
            case 1:
                AdminService.manAddCourse();
                break;
            case 2:
                CourseLookMenu.ShowMenu();
                break;
            case 3:
                AdminService.manDeleteCourse();
                break;
            case 4:
                AdminService.manUpdateCourse();
                break;
            default:
                System.out.println("输入数字不合法，程序退出");
                System.exit(0);

        }
    }

}
