import java.util.*;

public class Main {

    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,SATURDAY}

    public static void main(String[] args) {

        List<WeekDay> annsWorkDay = new ArrayList<>(List.of(WeekDay.MONDAY, WeekDay.TUESDAY
                ,WeekDay.THURSDAY, WeekDay.FRIDAY));

        var annsDaySet = EnumSet.copyOf(annsWorkDay);
        // EnumSet is an abstract class so cannot directly create a new EnumSet using the new keyword

        System.out.println(annsDaySet.getClass().getName());

        annsDaySet.forEach(System.out::println);

        var allDays = EnumSet.allOf(WeekDay.class);
        System.out.println("-------------------------------");
        allDays.forEach(System.out::println);

        Set<WeekDay> newPersonDay = EnumSet.complementOf(annsDaySet);
        System.out.println(newPersonDay);

        Set<WeekDay> weekDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        weekDays.forEach(System.out::println);

        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ann", "Mary", "Bob"});
        employeeMap.put(WeekDay.MONDAY, new String[] {"Mary", "Bob"});

        employeeMap.forEach((k,v) -> System.out.println(k + ":" + Arrays.toString(v)));

    }
}
