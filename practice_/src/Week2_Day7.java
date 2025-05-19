interface Payment{
    void pay(double amount);
}

class CardPayment implements Payment{
    public void pay(double amount){
        System.out.println("카드로 " + amount + "원을 결제합니다!");
    }
}
class BankPayment implements  Payment{
    public void pay(double amount) {
        System.out.println("계좌이체로 " + amount + "원을 결제합니다!");
    }
}

class PaymentServiceFactory{
    public static Payment getPayService(String type){
        switch (type) {
            case "bank":
                return new BankPayment();
            case "card":
                return new CardPayment();
            default :
                throw new IllegalArgumentException("사용할 수 없는 결제방식입니다.");
        }
    }
}

class OrderService3 {
    public void processOrder(String type, double amount){
        Payment payment = PaymentServiceFactory.getPayService(type);
        payment.pay(amount);
    }
}

public class Week2_Day7 {
    Week2_Day7(){
        OrderService3 order1 = new OrderService3();
        order1.processOrder("card",50000);
        order1.processOrder("bank",30000);
        order1.processOrder("unknown",1000);
    }


}
