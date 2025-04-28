import java.util.Arrays;
import java.util.List;

public class Day1 {

    Day1(){
        List<Integer> number = Arrays.asList(1 , 2 , 3 , 4 , 5, 6, 7, 8, 9);
        number.stream()
                .filter( n -> n % 3 == 0 )
                .forEach( n -> System.out.println("숫자 : " + n)); // 짬뽕출력
        System.out.println("------------------------------");
        number.stream()
                .filter( n -> n%2 == 0)
                .forEach( System.out::println); //단순 출력 ( 메소드참조 문법 )
        System.out.println("------------------------------");
        // 예제2. 소문자 변환
        List<String> names = Arrays.asList("ALICE","BOB","JASON","STRANGE");
        names.stream()
                .map( name -> name.toLowerCase()) //소문자 변환
                .forEach( System.out::println );
        System.out.println("------------------------------");
        names.stream()
                .map(String::toLowerCase) //메소드참조 사용
                .forEach( System.out::println); //메소드 참조 사용
        System.out.println("------------------------------");
        // 예제3. 문자열 길이순으로 정렬
        names.stream()
                .sorted( (a,b) -> Integer.compare(a.length(), b.length()))
                .forEach(System.out::println);
    }
}
