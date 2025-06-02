# WEEK3  : Spring Boot
### 본 프로젝트는, Spring Boot에 대한 기본 개념, MVC, REST API설계 등 기본적인 Java Web 설계 공부를 위해 작성하였습니다.

# Day 1
> #### 프로젝트 세팅
> - 프로젝트 세팅
> - Spring Boot 기본 개념 : Spring을 더 쉽고 빠르게 사용할 수 있도록 설정 파일 및 의존성 관리 자동화.
> - Spring Boot 쓰는 이유 : 간결한구조,API구현용이 & 내장서버 재공(Tomcat), Dependency 지원, 운영모니터링 기능 내장
> - 기본구조 : Controller / Service / Repository / Application.java

# Day 2
> - 의존성 주입 (DI) : 객체를 new하지않고 Spring이 대신 만들어 줌. ( @Autowired, @Bean )
> - Bean : Spring IoC 컨테이너가 관리하는 객체 인스턴스 ( @Component, @Service, @Repository, @Controller )
> - IoC 컨테이너 : 제어의 역전 ( 객체 생성, 의존성 주입을 Spring이 담당 ), Spring의 핵심철학, Bean을 등록하고 필요할 때 의존성 주입

# Day 3
> - MVC 아키텍처 : Model-View-Controller의 약자로, 웹 애플리케이션 아키텍처 패턴 중 하나.
> - Controller : 클라이언트 요청을받아 처리를 응답. 비즈니스 로직은 Service가 처리
> - Service : 비즈니스 로직 담당, 필요한 데이터 처리는 Repository에 위임
> - Repository : DB와 직접 연결되는 계층. JPA를 사용하면 인터페이스만 정의해도 사용가능.
> - Entity : DB와 직접 매핑되는 클래스 
> - DTO : Data Transfer Object : 민감한 속성은 숨기고 오로지 클라이언트와 통신을 하기위한 데이터 통신용 객체

# Day 4
> - REST API : Representational State Transfer : 웹에서 자원(Resource)를 이름(URL)로 지정하는 스타일.
> #### ✅핵심원칙
> | REST 원칙              | 설명                                          |
> | -------------------- | ------------------------------------------- |
> | **자원의 식별**           | URL을 통해 고유하게 자원을 식별 (ex: `/users/1`)        |
> | **표현의 형태**           | JSON, XML 등으로 자원을 표현. 클라이언트가 이해 가능한 형태로 변환됨 |
> | **Self-descriptive** | 메시지에 필요한 정보가 스스로 담겨있음 (ex: 상태코드, 응답 body)   |
> | **Stateless**        | 서버가 클라이언트 상태를 저장하지 않음 (요청마다 필요한 정보 포함!)     |
> - HTTP 메서드 : GET, POST, PUT, DELETE
> - 옛날에는 모든 요청을 POST로 보내는경우도 많고, URL에 행위를 담아 요청을 보냄 ( POST /createUser, POST /updateUser )
> - 그러나, REST API는 목적에 따라 HTTP메서드를 구분해서 사용하여 코드를 간결하게 만들어줌 ( POST /User, PUT /User )
> - REST API의 장점 : 유지보수 편리, 코드간결, 확장성 좋음, 클라이언트 해석이 쉬움.
# Day 5
> - DTO, Entity를 구분해서 사용. 
> - DTO의 장점 : 
> - 1. DB설계가 노출되지 않고 어떤 데이터만 넘겨줄지 명확히 정의하여 데이터 전송에만 집중!
> - 2. Entity에 민감한 정보가 있을 수 있는데 빼고 전달 가능.
> - 3. Entity구조가 바뀌어도 DTO만 맞춰주면 되어 유연성 증가
> - Entity 는 DB와 통신 전용, DTO는 계층간/외부 전송 전용.

# Day 6
> ### Spring Framework의 예외처리
> - @ExceptionHandler : 컨트롤러에서 발생한 특정 예외를 처리할 수 있는 메서드를 정의할 때 사용
> - @ControllerAdvice : 전역적으로 모든 컨트롤러의 예외를 한 클래스에서 처리하는 기능
> - @Valid, @Validated : DTO나 폼 데이터의 유효성 검증을 할 때 사용. ( 이메일형식@Email, 빈칸검증@NotBlank 등 )
> - @BindingResult : @Valid로 검증 한 결과를 담아두는 객체. 검증 실패시에도 컨트롤러로 진입 가능하게 함.
> - ResponseEntity : 스프링에서 응답을 쉽게 커스터마이징 하는 클래스 ( ex) ResponseEntity.ok(Entity) )
> - 커스텀 예외 클래스 : Exception 클래스를 상속받아 나만의 예외 클래스를 만들고, 사용할 수 있다.