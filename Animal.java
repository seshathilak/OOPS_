// Access Modifiers: 
// class cant be private or protected except nested classes 
// Over ridden method must not be more restrictive 
public class Animal {

    // encapsulation or data hiding: wrapping var and methods.

    // Achieved by :
    // 1.private
    // 2.setters and getters .

    private int weight;

    public void setWeight(int newWeight) {
        if (newWeight > 0) {
            weight = newWeight;
        } else {
            System.out.println("Weight must be bigger than 0");
        }
    }

    public double getWeight() {
        return weight;
    }

    // default access : package private
    String name;

    // Object class
    Object o = new Object();

    // jdk = jre + dev tools
    // jre = jvm + libraries

    // obj based = oops without Inheritance

    // adv of oops : resusability , redundancy , security

    // obj has id ,state and behaviour

    // Anonymous object : print(new Calculation().fact(5))

    // CONSTRUCTOR :
    // default and paramaterized
    // cannot be abstract(no sense), static(belongs to obj), final(not inherited ),
    // and synchronized
    // can hv access specifiers
    // returns current cls instance
    // there is constructor class in java.lang.reflect

    // STATIC
    // memory effiecient
    // STATIC BLOCK :
    // initilize stat var
    // excecuted bfr main
    static int count;
    static {
        count = 0;
    }

    // THIS
    Animal(String name) {
        this.name = name;
    }

    Animal(String name, int w) {
        // Should be called first
        this(name);
        this.setWeight(w);
    }

    // return the obj
    Animal f() {
        return this;
    }

    public static void main(String[] args) {
        // There is no default constructor as we defined atleast one constructor
        // Animal dog = new Animal();

        Animal dogObj = new Dog();// Upcasting: can access only parent var and overridden methods !!
        ((Dog) dogObj).bark();// to access other methods u shd typecase

        // OVERRIDING
        // static method belongs to cls area hence cant over ride
        // Covariant return type :
        // stay away from the confusing type casts

        A2 a2 = new A2();
        ((A2) a2.foo()).print();// can be prevented if foo in A2 return value is changed to A2

        // dynamic binding(late binding : type of obj is decided at runtime )
        // or runtime poly
        a2.print();
        // data are not overridden ,hence runtime poly not possible

        // DOWNCASTING
        // Dog d = new Animal() ; complite time errror
        // Dog d = (Dog) new Animal("hii"); // RTE : class cast exception .
        Animal a = new Dog();
        // Real world example :
        // https://www.javatpoint.com/downcasting-with-instanceof-operator
        // this is how to do
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.bark();
        }
        // same done using a static method
        Dog.method(a);

    }
}

// Inheritance
class Dog extends Animal {

    // Must provide a constructor for super class doest exist
    Dog() {
        super("hello");
    }

    void bark() {
        System.out.printf("barking");
    }

    // Example of how to downcasting
    static void method(Animal a) {
        if (a instanceof Dog) {
            Dog d = (Dog) a;// downcasting
            d.bark();
            System.out.println("ok downcasting performed");
        }
    }

    // Aggregation :
    // If a class have an entity reference
    // Eg : class Employee { Address a ; (ref to address class instance )}

    // METHOD OVERLOADING
    // cant by changing return type : as comiler doesnt know wt method to call
    // (compile time error )
    // can overload main bt jvm calls main nly with string[]

    // TYPE PROMOTION :
    // byte to short to int
    // char to int
    // int to long to float to double

}

class A1 {
    // blank
    final int maxspeed;
    // static blank
    final static int stafivar;
    static {
        // psble only in static block
        stafivar = 100;
    }

    A1() {
        // final var can be initialized only in constructor
        maxspeed = 100;
    }

    // cant extend final class , over ride final method
    A1 foo() {
        return this;

    }

    void print() {
        System.out.println("Inside the class A1");
    }
}

class A2 extends A1 {
    // super() is added in each class constructor automatically by compiler if there
    // is no super() or this().
    A2() {
        super();
        // The java compiler copies the code of instance initializer block in every
        // constructor.
        // After SUPER()
        {
            System.out.print("BLOCK");
        }
    }

    // no chaning return type to A2
    A1 foo() {
        return this;
    }

    void print() {
        System.out.println("Inside the class A2");
    }
}

// Abstraction : hiding implementation n showing functionality
// While extending abs cls : make it abs or provie implementation
abstract class Abscls {
    Abscls() {
        System.out.println("Abscls is created");
    }

    // if abs method present class must b abstract
    abstract void absmethod();// no body
}

// multiple inheritance psble with interface as implementation is provided by
// cls which inherits
interface interface_name {

    // Since java 8
    // shd have a body
    default void defvar() {
        System.out.printf("default method inside interface ");
    };

    // Since java 9
    static void statmethod() {
        System.out.printf("Static method inside interface ");

    }

    int min = 5;// public static final int min = 5

    void print(); // public abstract void print()
}

interface NoMembers {
    // called marker or tagged interface
}

// When to use Abstract Classes :
// ->providing functionality to unrelated clsses
// ->Whenever one requires common methods among classes and the access
// specifiers of those methods are non- public
// (as in interface everything is public )

// when interface :
// -> multiple inheritance
// -> providing functionality to unrel clsses