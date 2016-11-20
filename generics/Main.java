
public class Main {
    public static void main(String[] args) {
        Q<BImpl1, BImpl2, DImpl> q = new Q<BImpl1, BImpl2, DImpl>(new BImpl1(), new BImpl2(), new DImpl());
        System.out.println(q.allCalc());

        // java7
        Q<BImpl1, BImpl2, DImpl> q2 = new Q<>(new BImpl1(), new BImpl2(), new DImpl());
        System.out.println(q2.allCalc());
    }
}
