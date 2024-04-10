import java.util.ArrayList;
import java.util.List;

public class Problem2_16 {
    // 純粋
    static int increment(int x) {
        return x + 1;
    }

    // 非純粋 引数以外も使われるから
    static double randomPart(double x) {
        return x * Math.random();
    }

    // 純粋
    static int add(int a, int b) {
        return a + b;
    }

    class ShoppingCart {
        private List<String> items = new ArrayList<>();

        // 非純粋 既存の値が変わる
        public int addItem(String item) {
            items.add(item);
            return items.size() + 5;
        }

    }

    // 非純粋 返される戻り値複数ある。例外とか
    static char getFirstCharacter(String s) {
        return s.charAt(0);
    }
}
