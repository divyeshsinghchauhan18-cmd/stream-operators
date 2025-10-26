// Practical 7: Reactive Streams Operators Demo
import reactor.core.publisher.Flux;

public class ReactiveOperatorsDemo {
    public static void main(String[] args) {
        System.out.println("map operator:");
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
        numbers.map(n -> n * n)
               .subscribe(n -> System.out.print(n + " ")); // 1 4 9 16 25
        System.out.println("\n");

        System.out.println("filter operator:");
        numbers.filter(n -> n % 2 == 0)
               .subscribe(n -> System.out.print(n + " ")); // 2 4
        System.out.println("\n");

        System.out.println("flatMap operator:");
        Flux<String> fruits = Flux.just("apple", "banana");
        fruits.flatMap(fruit -> Flux.fromArray(fruit.split("")))
              .subscribe(ch -> System.out.print(ch + " ")); // a p p l e b a n a n a
        System.out.println("\n");

        System.out.println("reduce operator:");
        numbers.reduce((a, b) -> a + b)
               .subscribe(n -> System.out.println(n)); // 15

        System.out.println("merge operator:");
        Flux<String> letters = Flux.just("A", "B");
        Flux.merge(letters, fruits)
            .subscribe(s -> System.out.print(s + " ")); // A B apple banana
        System.out.println("\n");

        System.out.println("zip operator:");
        Flux<Integer> ids = Flux.just(1, 2);
        Flux<String> names = Flux.just("Jack", "Jill");
        Flux.zip(ids, names, (id, name) -> id + "-" + name)
            .subscribe(s -> System.out.print(s + " ")); // 1-Jack 2-Jill
        System.out.println("\n");

        System.out.println("concat operator:");
        Flux.concat(letters, fruits)
            .subscribe(s -> System.out.print(s + " ")); // A B apple banana
        System.out.println();
    }
}
