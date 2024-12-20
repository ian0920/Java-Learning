import java.time.LocalDate;
import java.util.*;

public class Main {


    private static Map<String, Purchase> purchases = new LinkedHashMap<>();

    private static NavigableMap<String, Student> students = new TreeMap<>();


    public static void main(String[] args) {

        Course jmc = new Course("jmc101", "Java Master Class", "Java");
        Course python = new Course("pyt101", "Python Master Class", "Python");

        addPurchase("Mary Martin", jmc, 129.99);
        addPurchase("Andy Martin", jmc, 139.99);
        addPurchase("Mary Martin", python, 149.99);
        addPurchase("Joe Jones", jmc, 149.99);
        addPurchase("Bill Brown", python, 119.99);
        addPurchase("Chuck Cheese", python, 119.99);
        addPurchase("Davey Jones", jmc, 139.99);
        addPurchase("Eva East", python, 139.99);
        addPurchase("Fred Forker", jmc, 139.99);
        addPurchase("Greg Brady", python, 129.99);

        purchases.forEach((k, v) -> System.out.println(k+": " +v));
        System.out.println("---------------------------------------");
        students.forEach((k, v) -> System.out.println(k+": " +v));
        System.out.println("---------------------------------------");

        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();

        for (Purchase p : purchases.values() ) {
            datedPurchases.compute(p.purchaseDate(),
                    (oldKey, oldValue) -> {
                        List<Purchase> list =
                                (oldValue == null) ? new ArrayList<>() : oldValue;
                        list.add(p);
                        return list;
                    });
        }

        datedPurchases.forEach((k, v) -> System.out.println(k+": " +v));
        System.out.println("--------------------------------------------");

        int  currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear,1);
        LocalDate week1 = firstDay.plusDays(7);

        Map<LocalDate,List<Purchase>> week1Purchase = datedPurchases.headMap(week1);
        Map<LocalDate,List<Purchase>> week2Purchase = datedPurchases.tailMap(week1);
//        week1Purchase.forEach((k, v) -> System.out.println(k+": " +v));
//        System.out.println("--------------------------------------------");
//        week2Purchase.forEach((k, v) -> System.out.println(k+": " +v));

        displayStates(1, week1Purchase);
        displayStates(2, week2Purchase);

        LocalDate lastDate = datedPurchases.lastKey();
        var previousEntry = datedPurchases.lastEntry();

        while(previousEntry != null){

            List<Purchase> lastDaysDate = previousEntry.getValue();
            System.out.println(lastDate + " purchase : " + lastDaysDate.size());

            LocalDate prevDate = datedPurchases.lowerKey(lastDate);
            previousEntry = datedPurchases.lowerEntry(lastDate);
            lastDate = prevDate;
        }







    }


    public static void addPurchase (String name, Course course, double price){

        Student exisitingStudent = students.get(name);
        if (exisitingStudent == null){
            exisitingStudent =new Student(name, course);
            students.put(name, exisitingStudent);
        }
        else {
            exisitingStudent.addCourse(course);
        }

        int day = new Random().nextInt(1,15);
        String key = course.courseId() + "_" + exisitingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(),exisitingStudent.getId(), price, year, day);
        purchases.put(key,purchase);

    }

    public static void displayStates (int period, Map<LocalDate, List<Purchase>> periodData){

        System.out.println("------------------------------");
        Map<String, Integer> weeklyCount = new TreeMap<>();

        periodData.forEach((k,v)->{
            System.out.println( k + ":" +v );
            for(Purchase p : v){
                weeklyCount.merge(p.courseId(), 1, (prev, current)-> {
                    return prev + current;
                });
            }
        });

        System.out.printf("Week %d Purchase = %s %n", period, weeklyCount);

    }
}
