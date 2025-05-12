
// 싱글턴 패턴을 적용하지 않을 경우 각 서비스에서 Logger 객체를 계속 할당해야함.
// 하나의 Logger 객체를 만들어 여러 서비스에서 호출하게끔 만드는게 싱글턴 패턴.

/*
class Logger {
    public void log(String message){
        System.out.println("[LOG] " + message);
    }
}
class OrderService {
    public void order(){
        Logger logger = new Logger();
        logger.log("주문이 완료되었습니다.");
    }
}
class ProductService {
    public void viewPorducT() {
        Logger logger = new Logger();
        logger.log("상품이 조회되었습니다.");
    }
}
*/

class Logger {
    private static final Logger instance = new Logger();
    private Logger(){}

    public static Logger getInstance(){
        return instance;
    }
    public void log (String message){
        System.out.println("[Log] " + message);
    }
}

class ViewService{
    public void View() {
        Logger.getInstance().log("조회가 완료되었습니다");
    }
}

class BagService{
    public void Put(){
        Logger.getInstance().log("상품이 장바구니에 추가되었습니다.");
    }
}

public class Week2_Day3 {


    Week2_Day3(){
        ViewService viewService = new ViewService();
        BagService bagService = new BagService();
        viewService.View();
        bagService.Put();
    }
}
