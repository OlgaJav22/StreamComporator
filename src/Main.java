import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = new LinkedList<>
                (List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16));

        System.out.println(integerList);

        long integerStream = integerList.stream()
                .filter(integer -> integer % 2 == 0).count();

        System.out.println(integerStream);

        findMinMax(integerList.stream(), Comparator.naturalOrder(), (v1, v2) -> System.out.println(v1 + v2));

    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(order).toList();
        minMaxConsumer.accept(list.isEmpty()?null: list.stream().min(order).get(), list.isEmpty()?null:list.stream().max(order).get());
         }

}


