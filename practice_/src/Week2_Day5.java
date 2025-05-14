// 팩토리 패턴 실습
// 팩토리 패턴은 객체 생성을 다른 클래스에 맡기는게 핵심!
// 객체 생성을 직접하면 클래스 의존도가 높아져 좋지 않음.




interface PayService2{
    void pay(int amount);
}

class CardPayService implements PayService2{
    public void pay(int amount){
        System.out.println("카드로 " + amount + "원 결제합니다!");
    }
}

class BankPayService implements PayService2{
    public void pay(int amount) {
        System.out.println("계좌이체로 " + amount + "원 결제합니다!");
    }
}

// 잘못된 예제
// Service 객체를 직접 생성.
/*
class OrderService2 {
    public void processPayment(String type, int amount){
        if ( type.equals("card") ){
            CardPayService payService = new CardPayService();
            payService.pay(amount);
        }else if (type.equals("bank")){
            BankPayService payService = new BankPayService();
            payService.pay(amount);
        }else {
            throw new IllegalArgumentException("지원하지 않는 결제방식입니다.");
        }
    }
}
*/

class PayServiceFactory{
    public static PayService2 getPayService(String type){
        if ( type.equals("card")){
            return new CardPayService();
        } else if (type.equals("bank")){
            return new BankPayService();
        }
        throw new IllegalArgumentException("지원하지 않는 결제방식입니다.");
    }
}
// 객체 생성을 Factory에 맡기고 서비스에서는 실행만 할 수 있게 만든 패턴이 바로 팩토리 패턴!
class OrderService2 {
    public void processPayment(String type, int amount){
        PayService2 payservice2 =  PayServiceFactory.getPayService(type);
        payservice2.pay(amount);
    }
}

public class Week2_Day5 {

    Week2_Day5(){ //여기선 Service를 new해서 사용했지만, 나중에 스프링에서는 @Service 같은 Annotation으로 처리할 것으로 예상됨.
        OrderService2 orderService = new OrderService2();
        orderService.processPayment("card",5000);
    }
}
