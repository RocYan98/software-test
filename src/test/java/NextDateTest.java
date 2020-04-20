import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextDateTest {
    static class MyDate {
        private int id;
        private int yy;
        private int mm;
        private int dd;
        private String nextDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getYy() {
            return yy;
        }

        public void setYy(int yy) {
            this.yy = yy;
        }

        public int getMm() {
            return mm;
        }

        public void setMm(int mm) {
            this.mm = mm;
        }

        public int getDd() {
            return dd;
        }

        public void setDd(int dd) {
            this.dd = dd;
        }

        public String getNextDate() {
            return nextDate;
        }

        public void setNextDate(String nextDate) {
            this.nextDate = nextDate;
        }
    }

    static List<MyDate> readTestCase(String filename) {
        String result = "";

        InputStream is = TriangularTest.class.getResourceAsStream(filename);

        try {
            InputStreamReader isr = new InputStreamReader(is);//构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(isr);

            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result += s;
            }

            br.close();
            isr.close();
            is.close();

            List<MyDate> cases = JSON.parseArray(result, MyDate.class);

            return cases;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void boundary_test() {
        List<MyDate> s = readTestCase("/cases/boundary-nextDate.json");

        for (MyDate c : s) {
            String nextDate = null;
            try {
                nextDate = NextDate.getNextDate(c.yy, c.mm, c.dd);
            } catch (IllegalArgumentException e) {
            }

            System.out.print("case id:" + c.id);
            assertEquals(c.nextDate, nextDate);
            System.out.println(" 通过");
        }
    }
}