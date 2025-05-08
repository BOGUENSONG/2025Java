// SOLID

// 1. Single Responsibility Principal ( 단일 책임 원칙 )
// 하나의 클래스는 하나의 책임만 가진다.

/* 잘못된 예 ( 책임이 2개 )
class OrderService {
    public void createOrder(){  } //주문생성
    public void sendEmail(){  } // 이메일 전송
}
*/

// 잘된 예 (분리)
class OrderService{
    public void createOrder(){} // 주문 생성
}
class EmailService{
    public void sendEamil(){} //이메일 전송
}

// 2. Open / Closed Principal ( 개방 - 폐쇄 원칙 )
// 기존 코드를 수정하지 않고 확장할 수 있어야 한다.

/* 잘못된 예 ( 새로운 할인 정책 추가 시 기존 코드 수정필요 )

class DiscountService {

    public int calculateDiscount(String userType) {
        if (userType.equals("VIP")) return 20;
        else return 0;
    }
}

 */

//잘된 예 ( 새로운 할인 정책 추가 시 기존코드 수정없이 확장 가능 )

interface DiscountPolicy{
    int discount();
}

class VipDiscount implements DiscountPolicy{
    public int discount() { return 20;}
}
class FamilyDiscount implements  DiscountPolicy {
    public int discount() { return 50; }
}

class DiscountService {
    private DiscountPolicy policy;
    public DiscountService (DiscountPolicy discountPolicy) {
        this.policy = discountPolicy;
    }
    public int getDiscount(){
        return policy.discount();
    }
}


// 3. Liskov Substitution Principle (리스코프 치환 원칙)
/* 부모 타입 객체는 자식 객체로 대체하여도 동작에 문제가 없어야한다.
// ShoppingCart는 Product 타입을 받아 처리하지만, FreeProduct는 getPrice()를 지원하지 않아 예외가 발생함 → 리스코프 원칙 위반
class Product {
    public int getPrice() {
        return 100;
    }
}

class FreeProduct extends Product {
    @Override
    public int getPrice() {
        throw new UnsupportedOperationException("무료 상품은 가격이 없습니다."); // ❌
    }
}

class ShoppingCart {
    public int calculateTotal(Product product) {
        return product.getPrice(); // 런타임 에러 발생 가능
    }
}


*/

//잘된 예 ( 부모를 사용하는 코드가 자식으로 바뀌어도 예외없이 동작 )
abstract class Product {
    public abstract int getPrice();
}

class PaidProduct extends Product {
    @Override
    public int getPrice() {
        return 100;
    }
}

class FreeProduct extends Product {
    @Override
    public int getPrice() {
        return 0; // ✅ 정상적인 리턴
    }
}

class ShoppingCart {
    public int calculateTotal(Product product) {
        return product.getPrice(); // 어떤 자식 클래스든 안전하게 호출 가능
    }
}

// 4. Interface Segregation Principal ( 인터페이스 분리 원칙 )
// 하나의 큰 인터페이스보다, 작은 인터페이스 여러개가 낫다

/* 위반 예
interface AdminPanel{
    void manageProducts();
    void refundOrder();
    void banUser();
}
* */

//잘된 예 : 역할별로 필요한 기능만 구현할 수 있도록 분리
interface ProductManager {
    void manageProducts();
}
interface OrderManager {
    void refundOrder();
}
interface UserManager {
    void banUser();
}

// 5. Dependency Inversion Principal ( 의존 역전 원칙 )
// 고수준 모듈은 저수준 모듈에 의존하면 안된다 -> 추상화에 의존하자.
/*
 잘못된 예제 ) PaymentService가 KakaoPay에 의존하고있다. 만약 결제수단이 NaverPay가 추가되면 PaymentService도 바꿔야한다.
 테스트도 불편하고, 변경에 취약한 설계

class KakaoPay {
    public void pay (int amount) {
        System.out.println("카카오페이로 + " + amount + "원 결제합니다.");
    }
}

class PaymentService {
    private KakaoPay kakaoPay = new KakaoPay(); //직접 구현체에 의존
    public void processPayment ( int amount ) {
        this.kakaoPay.pay(amount);
    }
}


 */

//올바른 설계

// 5-1. 추상화 계층 (inteface)
interface PayMethod {
    void pay(int amount);
}

// 5-2. 구체 클래스는 추상화에 의존
class KakaoPay implements  PayMethod{

    @Override
    public void pay(int amount) {
        System.out.println("카카오페이로 + " + amount + "원 결제합니다.");
    }
}
class NaverPay implements PayMethod{

    @Override
    public void pay(int amount) {
        System.out.println("네이버페이로 + " + amount + "원 결제합니다.");
    }
}

// 5-3. 고수준 모듈도 추상화에 의존
// PaymentService는 추상화된 PayMethod인터페이스에 의존합니다.
// 실제 어떤 결제수단을 이용할지는 외부에서 주입합니다.
// 덕분에 테스트가 쉽고, 다형성을이용한 유연한 설계가 가능합니다.
class PaymentService {
    private PayMethod payMethod;
    public PaymentService ( PayMethod payMethod){
        this.payMethod = payMethod;
    }
    public void processPayment(int amount){
        payMethod.pay(amount);
    }
}


public class Week2_Day2 {



    Week2_Day2(){

    }
}
