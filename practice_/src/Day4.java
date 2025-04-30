// 1. 사용자 정의 예외 클래스 생성
class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String msg) {
        super(msg);
    }
}

// 2. throw 발생시키기
class UserService {
    public void register(String username, String password) {
         if (password.length() < 10){
             throw new InvalidPasswordException("비밀번호는 10자 이상이여야 합니다.");
         }
         System.out.println("가입이 완료되었습니다!");
    }
}



public class Day4 {

    Day4() {
        // 3. try-catch 적용하기
        try {
            UserService userService = new UserService();
            //userService.register("KIA","1234");
            userService.register("KIA","1234567890");
        } catch (Exception e ){
            System.out.println("회원가입에 실패하였습니다! 사유: " + e.getMessage());
        }
        System.out.println("프로그램 정상 종료");


    }
}
