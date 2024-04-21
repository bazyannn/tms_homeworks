import java.util.Comparator;
import java.util.List;


public class ListUtil extends Thread {

    private List<?> list;

    public ListUtil(List<?> list) {
        this.list = list;
    }

    @Override
    public void run() {
        ListUtil listUtil = new ListUtil(list);
    }

    public void countMin(List<Integer> integerList) {

        Integer min = integerList.stream()
                .min((i, i1) -> i - i1)
                .get();
        System.out.println(min);

    }

    public void countMax(List<Integer> integerList) {

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Integer max = integerList.stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .get();
        System.out.println(max);

    }
}


