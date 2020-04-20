import com.fasterxml.jackson.annotation.JsonValue;

public class Triangular {
    //三角形类别
    public enum TriangularType {
        NORMAL(0),         //普通三角形
        NON_TRIANGLAR(1),  //非三角形
        EQUILATERAL(2),    //等边三角形
        ISOSCELS(3);       //等腰三角形

        private int value;

        TriangularType(int v) {
            this.value = v;
        }
    }

    //要求 0 < x,y,z <= 200
    public static TriangularType deduce(int x, int y, int z) {
        TriangularType type;

        if (!(x > 0) || !(x <= 200) || !(y > 0) || !(y <= 200) || !(z > 0) || !(z <= 200)) {
            throw new IllegalArgumentException("输入x, y, z不在指定范围，(0, 200]");
        } else {
            //如果能构成三角形
            if (x + y > z && y + z > x && x + z > y) {
                if (x == y && y == z) {
                    type = TriangularType.EQUILATERAL;
                } else if (x == y || y == z || x == z) {
                    type = TriangularType.ISOSCELS;
                } else {
                    type = TriangularType.NORMAL;
                }
            } else {
                type = TriangularType.NON_TRIANGLAR;
            }
        }

        return type;
    }
}
