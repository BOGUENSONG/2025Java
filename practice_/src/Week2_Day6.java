
//        [PaymentService]
//        └─ void process(String paymentType)
//      └─ PaymentStrategyFactory로 전략 주입 후 execute()

// 유지보수, 기존코드 수정없이 코드 추가가 용이한 전략패턴 사용 및 팩토리패턴을 이용해 객체를 팩토리클래스에서 생성하여 서비스에서 사용한다.
interface PaymentStrategy {
    void pay(int amount);
}

class CardPaymentStrategy implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("카드를 사용하여 " + amount + "를 결제합니다.");
    }
}
class PaypalPaymentStrategy implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("페이팔을 사용하여 " + amount + "를 결제합니다.");
    }
}
class PointPaymentStrategy implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("포인트를 사용하여 " + amount + "를 결제합니다.");
    }
}
class PaymentStrategyFactory{
    public static PaymentStrategy getInstance(String type){
        if ( type.equals("card")){
            return new CardPaymentStrategy();
        }else if (type.equals("paypal")){
            return new PaypalPaymentStrategy();
        }else if (type.equals("point")){
            return new PointPaymentStrategy();
        }else {
            throw new IllegalArgumentException("등록되지 않은 결제방식입니다.");
        }
    }
}

class PaymentService3 {
    public void process (String paymentType, int amount){
        PaymentStrategy strategy = PaymentStrategyFactory.getInstance(paymentType);
        strategy.pay(amount); //결제
    }
}

public class Week2_Day6 {

    Week2_Day6(){
        PaymentService3 paymentService = new PaymentService3();
        paymentService.process("card",5000); //카드로결제
        paymentService.process("paypal",10000);//페이팔로결제
        paymentService.process("point",2000);//포인트로결제
    }
}
