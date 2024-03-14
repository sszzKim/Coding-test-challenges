package baekjoon;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class JustTest {
    public static void main(String[] args) {
        Stream<String> fruits = Stream.of("apple","mango","kiwi","peach","cherry","lemon");
        //String rs = fruits.map(s -> s.toString()).collect(Collectors.joining(","));
        //String rs = fruits.map(String::toString).collect(Collectors.joining(","));
        String rs = fruits.map(s -> s.toString()).collect(Collectors.joining(","));
        System.out.println(rs);
    }
}
