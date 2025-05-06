import java.util.concurrent.*;

public class Day6 {

    //데이식스?ㅋ
    Day6() {

        // ExecutorService 생성
        ExecutorService executor = Executors.newSingleThreadExecutor(); // 스레드 1개짜리 풀

        // Callable 정의 이번 실습에선 배송비 계산으로 진행
        Callable<Integer> shoppingTask = () -> {
            System.out.println("배송비 계산중 ...");
            Thread.sleep(2000);
            return 3000; // 계산 된 배송비. 정확한로직은 생략
        };

        // 작업 제출하고 Future로 결과값 받기.
        Future<Integer> future = executor.submit(shoppingTask);

        System.out.println("메인 쓰레드에서는 다른 작업을 실행합니다.");
        // 결과 받아오기
        try {
            Integer shoppingFee = future.get();
            System.out.println("배송비 계산 완료... " + shoppingFee + "원");

        }catch(InterruptedException | ExecutionException e ) {
            e.printStackTrace();
        }
        executor.shutdown();// 쓰레드 종료

    }
}
