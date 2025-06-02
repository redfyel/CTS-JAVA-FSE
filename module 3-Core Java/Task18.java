class Animal {
    public void makeSound() {
        System.out.println("i can make sound!");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("i can bark! woof , woof!");
    }
}
public class Task18 {
    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();
        Animal ad = new Dog();

        a.makeSound();
        d.makeSound();
        ad.makeSound();
    }
}
