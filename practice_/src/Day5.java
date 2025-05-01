
class Delivery implements Runnable{ // Runnalbe 신규 생성 ( 배송 상태 업데이트 )
    public void run (){
        for ( int i = 1 ; i < 4 ; i++){
            System.out.println("배송 상테 업데이트 중... step : " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            }catch ( InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Notification implements Runnable { // 알림전송 Runnable
    public void run (){
        for (int i = 1 ; i < 4 ; i++){
            System.out.println("사용자에게 알림 전송... step : " + i);
            try {
                Thread.sleep(1000); //1초 대기
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }
}


public class Day5 {
    // Runnable을 사용해 두 개의 스레드를 만들어 실행
    // 한 스레드는 배송 상태 업데이트, 다른 스레드는 알림 전송
    // 각 작업은 1초 간격으로 3번 출력되도록 구현
    Day5(){
        Thread thread_Delivery = new Thread(new Delivery());
        Thread thread_Notification = new Thread(new Notification());

        thread_Delivery.start();
        thread_Notification.start();

        System.out.println("쓰레드를 시작했습니다.");
    }
}
