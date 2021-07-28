#include <bits/stdc++.h>
#include <iostream>

// Classes have default private fields and methods
// while structs have public
// Structs are used to model new data types, while
// classes model more complex real world objects
// Private members of a class are not accessable
// to outside code unless a class is marked as
// a friend

class containFrndcls
{
private:
    friend class frndCls;
    std::string name;

public:
    containFrndcls(std::string name)
    {
        this->name = name;
    }
};

class frndCls
{
public:
    static std::string GetName(containFrndcls &c)
    {
        return c.name;
    }
};

// The default child constructor calls parents default parnnt constructor
// Chld(): Parent(){};

// Shape here has no purpose except for
// being able to to group similar objects
// so it should be instead an Abstract
// Class

class Shape
{
public:
    virtual double Area() = 0;
};

class Circle : public Shape
{
protected:
    double width;

public:
    Circle(double w)
    {
        width = w;
    }

    // You should use override to force the
    // compiler to check if the base class
    // virtual fucntion is the same as
    // the subclass (AVOIDS SILLY MISTAKES )
    double Area() override
    {
        return 3.14159 * std::pow((width / 2), 2);
    }
};

class Rectangle : public Shape
{
protected:
    double height, width;

public:
    Rectangle(double h, double w)
    {
        height = h;
        width = w;
    }
    // Marking a method as final means
    // that subclasses that inherit from
    // Rectangle can't override Area()
    double Area() override final
    {
        return height * width;
    }
};

class Square : public Rectangle
{
public:
    Square(double h, double w) : Rectangle(h, w)
    {
    }

    /* This would cause an error as area is final in rectangle cls
    double Area() override{
        return height * 2;
    }
    */
};

// This function receives Shapes but uses the
// correct Area()
void ShowArea(Shape &shape)
{
    std::cout << "Area : " << shape.Area() << "\n";
}

int main()
{
    containFrndcls tom("Seshathilak");
    frndCls getName;
    std::cout << "Name : " << getName.GetName(tom) << "\n";

    Rectangle rectangle(10, 5);
    Circle circle(10);
    ShowArea(rectangle);
    ShowArea(circle);

    Square square(10, 10);
    ShowArea(square);

    return 0;
}