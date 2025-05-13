//잘못된 예시
// 할인정책이 PaymentService 내부에 강하게 결합되어있음.
// 새로운 할인정책이 추가되면 if문을 직접 수정해야함 -> SOLID원칙중 OCP위반
// 테스트나 유지보수가 어려움.
/*
class PaymenService{
    public void pay(int price, String usertype){
        int finalPrice;

        if ("normal".equals(usertype)){
            finalPrice = price -1000;
        }
        else if ("RATE".equals(usertype)){
            finalPrice = (int)(price * 0.9);
        }
        else if ("VIP".equals(usertype)){
            finalPrice = (int)(price * 0.5);
        }
        else{
            finalPrice = price;
        }
        System.out.println("최종결제금액: " + finalPrice + "원");
    }
}
*/

//잘된 예시
// 알고리즘을 클래스로 분리하여 SOLID원칙의 OCP를 만족시킨다. 테스트하기도 수월하며 전략추가가 유연해진다.
// 어떻게 보면 전략패턴은 OCP + DIP라고 볼 수 있다.

interface DiscountStrategy{
    int applyDiscount(int price);
}

class FixedDiscountStrategy implements DiscountStrategy{
    public int applyDiscount(int price){
        return price - 1000;
    }
}
class VipDiscountStrategy implements DiscountStrategy{

    public int applyDiscount(int price) {
        return (int) (price * 0.5);
    }
}

class PayService {
    private DiscountStrategy discountStrategy;
    public PayService (DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }
    public void pay(int price){
        int finalPrice = this.discountStrategy.applyDiscount(price);
        System.out.println("최종 결제금액 : " + finalPrice + "원");
    }
}

public class Week2_Day4 {

    Week2_Day4(){
        PayService normal = new PayService(new FixedDiscountStrategy());
        PayService vip = new PayService(new VipDiscountStrategy());

        normal.pay(10000);
        vip.pay(10000);
    }
}
