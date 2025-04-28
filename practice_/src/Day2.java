import java.util.*;
import java.util.stream.Collectors;

public class Day2 {

    Day2() {
        // 장바구니 상품 가격 총합 구하기 (reduce 사용)
        List<Integer> prices = Arrays.asList(15000, 23000, 12000, 7000, 5000);
        int price = prices.stream()
                        .reduce(1, (a,b) ->  a + b ) ; //초기값, 람다식 순서
        int price_methodsymbol = prices.stream()
                .reduce(0, Integer::sum) ; // 초기값, 메소드참조 사용
        System.out.println(price);
        System.out.println(price_methodsymbol);


        // 만원 이상 제품만 모아서 다시 리스트로 만들기
        List<Integer> prices2 = Arrays.asList(15000, 23000, 12000, 7000, 5000);

        List<Integer> result = prices2.stream()
                .filter( (a) -> a >= 10000 )
                .collect(Collectors.toList());
        System.out.println(result);

        // 여러 리스트를 하나로 합치기
        List<List<String>> cartItems = Arrays.asList(
                Arrays.asList("노트북", "마우스"),
                Arrays.asList("키보드", "모니터"),
                Arrays.asList("이어폰")
        );
        List<String> result2 = cartItems.stream()
                .flatMap(a -> a.stream())
                .collect(Collectors.toList());
        System.out.println(result2);

        List<String> result2_symbol = cartItems.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(result2_symbol); //메서드 참조 사용
    }
}
