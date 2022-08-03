import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierFunctionalnterface {
    public void shouldGetTheTextByUsingSupplierWithoutLambdaExpression() throws Exception {
        Supplier<String> supplier = new Supplier<String>() {

            @Override
            public String get() {
                return "Java 8 - Supplier by Craft Coder";
            }
        };

        String guide = supplier.get();
    }

    public void shouldGetTheTextByUsingSupplierWithLambdaExpression() throws Exception {
        Supplier<String> supplier = () -> "Java 8 - Supplier by Craft Coder";

        String guide = supplier.get();
    }

    public void shouldGetAListOfRandomNumbersByUsingLoops() throws Exception {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer number = RandomNumbers.getNext();
            randomNumbers.add(number);
        }

        System.out.println(randomNumbers);
    }

    public void shouldGetAListOfRandomNumbersGreaterThan5ByUsingLoops() throws Exception {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer number = RandomNumbers.getNext();
            if (number > 5) {
                randomNumbers.add(number);
            }
        }

        System.out.println(randomNumbers);
    }

    public void shouldGetAListOfRandomNumbersByUsingSupplier() throws Exception {
        Supplier<Integer> supplier = () -> RandomNumbers.getNext();

        List<Integer> randomNumbers = Stream
                .generate(supplier)
                .filter(number -> number > 5)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(randomNumbers);
    }

}

class RandomNumbers {
    public static Integer getNext() {
        return new Random().nextInt(10);
    }
}