import java.util.Scanner;

public class NextDate {
    static int month[][] = {{31, 31}, {28, 29}, {31, 31}, {30, 30}, {31, 31}, {30, 30}, {31, 31}, {31, 31}, {30, 30}, {31, 31}, {30, 30}, {31, 31}};

    public static String getNextDate(int yy, int mm, int dd) {
        boolean is_leap = (yy % 4 == 0 && yy % 100 != 0) || yy % 400 == 0;

        if (yy < 1820 || yy > 2020 || mm <= 0 || dd <= 0) {
            throw new IllegalArgumentException("输入的日期不合法");
        } else if (mm > 12 || dd > 31) {
            throw new IllegalArgumentException("输入的日期不合法");
        } else if (is_leap) {
            if (dd > month[mm - 1][1]) {
                throw new IllegalArgumentException("输入的日期不合法");
            }
        } else if (dd > month[mm - 1][0]) {
            throw new IllegalArgumentException("输入的日期不合法");
        }

        dd++;
        if (is_leap) {
            if (dd > month[mm - 1][1]) {
                dd = 1;
                mm++;
            }
            if (mm > 12) {
                mm = 1;
                yy++;
            }
        } else {
            if (dd > month[mm - 1][0]) {
                dd = 1;
                mm++;
            }
            if (mm > 12) {
                mm = 1;
                yy++;
            }
        }
        return yy + "-" + mm + "-" + dd;
    }
}
