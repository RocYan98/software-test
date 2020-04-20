
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TriangularTest {
    static class TestCase {
        public int id;
        public int x;
        public int y;
        public int z;
        public Triangular.TriangularType type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }

        public Triangular.TriangularType getType() {
            return type;
        }

        public void setType(Triangular.TriangularType type) {
            this.type = type;
        }
    }


    static List<TestCase> readTestCase(String filename) {
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

            List<TestCase> cases = JSON.parseArray(result, TestCase.class);

            return cases;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void boundary_test() {
        List<TestCase> s = readTestCase("/cases/boundary-triangular.json");

        for (TestCase c : s) {
            Triangular.TriangularType type = null;
            try {
                type = Triangular.deduce(c.x, c.y, c.z);
            } catch (IllegalArgumentException e) {
            }

            System.out.print("case id:" + c.id);
            assertEquals(c.type, type);
            System.out.println(" 通过");
        }
    }

    @Test
    public void equivalence_test() {
        List<TestCase> s = readTestCase("/cases/equivalence-triangular.json");

        for (TestCase c : s) {
            Triangular.TriangularType type = null;
            try {
                type = Triangular.deduce(c.x, c.y, c.z);
            } catch (IllegalArgumentException e) {
            }

            System.out.print("case id:" + c.id);
            assertEquals(c.type, type);
            System.out.println(" 通过");
        }
    }

}
