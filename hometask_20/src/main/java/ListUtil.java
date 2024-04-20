import java.util.Comparator;
import java.util.List;


public class ListUtil extends Thread {

    private List<?> list;
    private Marker marker;

    public ListUtil(List<?> list, Marker marker) {
        this.list = list;
        this.marker = marker;
    }

    @Override
    public void run() {
        ListUtil listUtil = new ListUtil( list, marker);
    }

    public void countMin(List<Integer> integerList) {
        synchronized (marker) {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Integer min = integerList.stream()
                    .min((i, i1) -> i - i1)
                    .get();
            System.out.println(min);
        }
    }

    public void countMax(List<Integer> integerList){
        synchronized (marker) {
            Integer max = integerList.stream()
                    .max(Comparator.comparingInt(Integer::intValue))
                    .get();
            System.out.println(max);
        }
    }
}


