package experiment7;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
public class twoMonthCalendar {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year1 = scanner.nextInt();
        System.out.print("请输入月份:");
        int month1 = scanner.nextInt();
        getCalendar(year1,month1);
    }
    public static void getCalendar(int year,int month){
        LocalDate firstDayOfMonth = LocalDate.of(year,month,1);
        int daysInMonth = firstDayOfMonth.lengthOfMonth();
        int firstDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();
        int month1 = month+1;
        int year1 = year;
        if (month==12){
            month1 = 1;
            year1++;
        }
        LocalDate firstDayOfMonth2 = LocalDate.of(year1,month1,1);
        int daysInMonth1 = firstDayOfMonth2.lengthOfMonth();
        int firstDayOfWeek2 = firstDayOfMonth2.getDayOfWeek().getValue();
        System.out.println("       " + Month.of(month) + " " + year+"                          " + Month.of(month1) + " " + year1);
        System.out.println("Mon Tue Wed Thu Fri Sat Sun          Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }
        for (int i = 1;i<=7-firstDayOfWeek+1; i++){
            System.out.print(i+" \t");
            if ((firstDayOfWeek+i-1)%7==0){
                System.out.print("\t\t ");
                for (int b = 1; b < firstDayOfWeek2; b++) {
                    System.out.print("\t ");
                }
                for (int a = 1;a<=7-firstDayOfWeek2+1;a++){
                    System.out.print(a+"\t ");
                }
                System.out.println();
            }
        }
        for (int p=2;p<36;p=p+7){
            for (int i = 7-firstDayOfWeek+p;i<=7-firstDayOfWeek+p+6&&i<=daysInMonth;i++){
                System.out.print(i+" \t");
                if ((firstDayOfWeek+i-1)%7==0||i==daysInMonth){
                    System.out.print("\t\t ");
                    if (i==daysInMonth){
                        for (int k = 0;k<7-firstDayOfWeek+23+6-daysInMonth;k++){
                            System.out.print("\t ");
                        }
                    }
                    for (int a =7-firstDayOfWeek2+p;a<=daysInMonth1;a++){
                        System.out.print(a+"\t ");
                        if ((firstDayOfWeek2+a-1)%7==0||a==daysInMonth1){
                            System.out.println();
                            if (a<daysInMonth1&&i==daysInMonth){
                                System.out.print("\t\t ");
                                for (int k = 0;k<7;k++){
                                    System.out.print("\t ");
                                }
                                for (int f =a+1;f<=daysInMonth1;f++){
                                    System.out.print(f+"\t ");

                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
