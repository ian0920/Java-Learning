import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(List.of("George", "Gray", "Grace"));
        System.out.println(list);
        System.out.println("Gray is in the list? " + list.contains("Gray"));

        list.removeIf(s-> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gray is in the list? " + list.contains("Gray"));

    }
}
