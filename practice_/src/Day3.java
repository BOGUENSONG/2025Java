import java.util.*;

class Member {
    private String email;

    public Member(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}


class Order {
    private String id;
    private String productName;

    public Order(String id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public String getId() { return id; }
    public String getProductName() { return productName; }
}


class CartItem {
    private String name;

    public CartItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


public class Day3 {
    Day3() {
        //실습1. 이메일 가져오기
        Member member = new Member("krbbogle95@gmail.com");
        Member member_null = new Member(null);
        String email = Optional.ofNullable(member)
                .map(Member::getEmail)
                .orElse("이메일 없음");

        String email_null = Optional.ofNullable(member_null)
                .map(Member::getEmail)
                .orElse("이메일 없음");

        System.out.println(email);
        System.out.println(email_null);
        //실습2. 주문의 상품명 가져오기

        Map<String,Order> orderDB = new HashMap<>();
        orderDB.put("1001",new Order("1001","맥북"));
        orderDB.put("1002",new Order("1002", "아이패드"));

        String nonOrder = "1003"; //없는 주문번호

        Order order = Optional.ofNullable(orderDB.get("1001"))
                .orElseThrow( () -> new NoSuchElementException("[주문을 찾을 수 없어용]  주문번호 : " + nonOrder) );

        System.out.println("상품명 출력 " + order.getProductName());
        //실습3. 장바구니에 특정 상품이 있는지 확인 ( Filter 활용 )
        // 맥북이 들어있으면 출력, 없으면 해당상품없음 출력

        List<CartItem> cart = Arrays.asList(
                new CartItem("맥북"),
                new CartItem("아이패드"),
                new CartItem("갤럭시")
        );

        Optional<CartItem> macbook = cart.stream().filter( a -> a.getName().equals("맥북") ).findFirst();

        String result = macbook
                .map(CartItem::getName)
                .orElse("해당상품 없음");
        System.out.println(result);


    }
}
