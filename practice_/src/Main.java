
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.

public class Main {

    private static void test() {
        System.out.println("테스트");
    }
    public static void main(String[] args) {


        // 예제 1. 숫자 필터링
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