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
    // cannot be abstract, static, final, and synchronized
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

    public static void hello(String[] args) {
        // There is no default constructor as we defined atleast one constructor
        // Animal dog = new Animal();

        Animal dog = new Dog();
        ((Dog) dog).bark();

        // OVERRIDING
        // static method belongs to cls area hence cant over ride
        // Covariant return type :
        // stay away from the confusing type casts

        A2 a2 = new A2();
        ((A2) a2.foo()).print();

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