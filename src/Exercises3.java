import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Exercises3 {
    public static void IntStreamExercises() {
        System.out.println("Exercise 1: ");
        IntStream.of(1,2,3,4,5).forEach(System.out::println);

        System.out.println("\nExericse 2: ");
        IntStream.range(1, 6).forEach(System.out::println);

        System.out.println("\nExercise 3: ");
        IntStream.iterate(1, n -> n + 2).limit(5).forEach(System.out::println);

        System.out.println("\nExercise 4: ");
        new Random().doubles(5).forEach(System.out::println);

        System.out.println("\nExercises 5: ");
        IntStream.iterate(2, n -> n + 1)
                .filter(Exercises3::isPrime)
                .limit(10)
                .forEach(System.out::println);
    }
    private static boolean isPrime(int number) {
        if (number < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .allMatch(n -> number % n != 0);
    }
    public static int sumNatural(int n) {
        return IntStream.rangeClosed(0, n).sum();
    }

    public static long factorial(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    public static double power(int base, int exp) {
        return Math.pow(base, exp);
    }

    public static int sumList(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static double arithmeticMean(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static double standardDeviation(List<Integer> numbers) {
        double mean = arithmeticMean(numbers);
        return Math.sqrt(numbers.stream().mapToDouble(n -> Math.pow(n - mean, 2)).average().orElse(0));
    }

    public static int sumEven(int n) {
        return IntStream.iterate(n % 2 == 0 ? n : n - 1, i -> i > 0, i -> i - 2).sum();
    }

    public static int sumEvenElements(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> getEvenList(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    public static List<Integer> evenList(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
    }

    public static int computeDotProduct(List<Integer> list1, List<Integer> list2) {
        return IntStream.range(0, list1.size()).map(i -> list1.get(i) * list2.get(i)).sum();
    }
    public static void main(String[] args) {
        System.out.println("Exercises 3.1: ");
        IntStreamExercises();

        System.out.println("\nExercises 3.2: ");
        System.out.println("Sum of first n natural numbers: " + sumNatural(10));

        System.out.println("Factorial: " + factorial(5));

        System.out.println("Power: " + power(2, 3));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("Sum of list: " + sumList(numbers));

        System.out.println("Arithmetic mean: " + arithmeticMean(numbers));

        System.out.println("Standard deviation: " + standardDeviation(numbers));

        System.out.println("Sum of first even numbers up to n: " + sumEven(9));

        System.out.println("Sum of even elements: " + sumEvenElements(numbers));

        System.out.println("Even numbers from list: " + getEvenList(numbers));

        System.out.println("First even numbers up to n: " + evenList(9));

        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(2, 4, 6);
        System.out.println("Dot product: " + computeDotProduct(list1, list2));
    }
}
