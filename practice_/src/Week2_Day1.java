// 2주차는 객체지향의 특성에 대하여 배우도록 한다.
// 오늘은 객체지향의 4요소 > 추상화, 캡슐화, 상속, 다형성에 대해 배우도록 한다.


// 추상화 + 상속 실습 ( 동물 )

abstract class Animal {
    private String name; // 캡슐화
    public Animal (String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    // 추상 메서드 ( 다형성 유도 )
    public abstract void makeSound(); // 울음소리
}

class Dog extends Animal {

    public Dog(String name){
        super(name); // 상속하는 부모의 생성자를 따라한다는 뜻
    }
    @Override
    public void makeSound() {
        System.out.println(getName()+ "이 짖습니다. ^멍!^");
    }
}

class Cat extends Animal {

    public Cat (String name){
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println(getName()+" 가 외칩니다 ^야옹!^");
    }
}

public class Week2_Day1 {

    Week2_Day1(){
        Animal dog = new Dog("연탄");
        Animal cat = new Cat("마리");

        dog.makeSound();
        cat.makeSound();
    }
}
