import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        var result = IntStream
                .iterate(0, i -> i<= 1000, i -> i + 10)
                .summaryStatistics();

        System.out.println(result);

        var leapYear = IntStream
                .iterate(2000, i -> i<=2025, i -> i + 1)
                .filter(i -> i % 4 == 0)
                .peek(System.out::println)
                .summaryStatistics();

        System.out.println(leapYear);

        Seat [] seats = new Seat[100];

        Arrays.setAll(seats, i -> new Seat((char)('A' + (i / 10)), i % 10 + 1));
//        Arrays.asList(seats).forEach(System.out::println);

        var reservationCount = Arrays.stream(seats)
                .filter(Seat::isReserved)
                .count();

        System.out.println("reservationCount = " + reservationCount);

        var hasBookings = Arrays.stream(seats).anyMatch(Seat::isReserved);
        System.out.println("has booked = " + hasBookings);

        var allBookings = Arrays.stream(seats).allMatch(Seat::isReserved);
        System.out.println("All booked = " + allBookings);

        var eventWashOut = Arrays.stream(seats).noneMatch(Seat::isReserved);
        System.out.println("Event Wash Out = " + eventWashOut);
    }
}
