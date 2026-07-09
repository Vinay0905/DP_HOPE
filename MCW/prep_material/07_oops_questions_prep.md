# 🧬 Object-Oriented Programming (OOPs) Interview Guide

This guide compiles the top OOPs questions from the reference PDF and includes advanced C++ concepts critical for **MulticoreWare** (who write high-performance C++ compiler and GPU code).

---

## 1. Core Pillars of OOPs (Explained Simply)

### Q1. What is the difference between Abstraction and Encapsulation?
*   **Abstraction (Hiding complexity):** Focuses on *what* the object does, not *how* it does it. It shows only essential features to the outside world.
    *   *Analogy*: When you drive a car, you press the gas pedal (abstraction). You don't need to know how fuel injection works.
*   **Encapsulation (Hiding data):** Focuses on binding data (variables) and code (methods) together into a single unit (class) and restricting direct access to guard it.
    *   *Analogy*: A capsule pill. the medicine is inside, protected from the external environment, and you can only consume it as a whole.
*   **Key Difference:** Abstraction is a design-level concept (interfaces, abstract classes), while Encapsulation is an implementation-level concept (using `private`, `protected`, `public` access modifiers).

### Q2. Polymorphism: Overloading vs. Overriding
*   **Method Overloading (Compile-time Polymorphism):** Multiple methods in the *same class* have the *same name* but *different parameters* (number, type, or order of arguments). The compiler decides which method to call at compile-time.
    ```cpp
    int add(int a, int b);
    double add(double a, double b);
    ```
*   **Method Overriding (Runtime Polymorphism):** A subclass provides a *specific implementation* for a method that is *already defined in its parent class*. The exact method to call is determined at runtime based on the actual object type.
    ```cpp
    class Animal { virtual void speak() { cout << "Sound"; } };
    class Dog : public Animal { void speak() override { cout << "Woof"; } };
    ```

### Q3. Inheritance: What is the Diamond Problem and how is it solved?
*   **The Diamond Problem:** In multiple inheritance, if Class B and Class C both inherit from Class A, and Class D inherits from both B and C, Class D gets *two copies* of Class A's variables. If Class A has a method `show()`, and Class D calls it, the compiler doesn't know which path to take (A -> B -> D or A -> C -> D), resulting in a compiler error.
*   **The Solution (Virtual Inheritance):** In C++, you use the `virtual` keyword when inheriting to ensure Class D only receives *one copy* of Class A's members.
    ```cpp
    class B : virtual public A { ... };
    class C : virtual public A { ... };
    class D : public B, public C { ... }; // D has only one copy of A
    ```

---

## 2. Advanced C++ OOPs (Highly Likely at MulticoreWare)

### Q4. What is a Virtual Function, and how do `vptr` and `vtable` work under the hood?
*   **Virtual Function:** A member function in a base class that you expect to redefine in derived classes. It tells the compiler to perform **late binding** (decide which function to run at runtime based on the object, not the pointer type).
*   **How it works (vtable and vptr):**
    1.  **vtable (Virtual Table):** For every class that has at least one virtual function, the compiler creates a static table of function pointers pointing to the virtual functions of that class.
    2.  **vptr (Virtual Pointer):** Every instance of a class containing virtual functions is given a hidden pointer (usually at the start of the object's memory) pointing to its class's `vtable`.
    3.  When a virtual function is called through a base pointer, the program looks at the object's `vptr`, follows it to the `vtable`, and runs the function at that address. This adds a tiny runtime overhead (one extra pointer dereference).

### Q5. Why do we need a Virtual Destructor?
*   **The Problem:** If you delete a derived class object through a base class pointer, and the base class destructor is *not* virtual, only the base class destructor runs. The derived class's destructor is skipped, causing a **memory leak** for any memory allocated in the derived class.
*   **The Solution:** Declare the base class destructor as `virtual`. This ensures the derived class destructor runs first, followed by the base class destructor.
    ```cpp
    class Base {
        virtual ~Base() { } // Crucial!
    };
    ```

### Q6. Struct vs. Class in C++
*   **The only differences:**
    1.  *Default Access Modifier*: In a `struct`, members are `public` by default. In a `class`, they are `private` by default.
    2.  *Default Inheritance*: A `struct` inherits publicly by default. A `class` inherits privately by default.
*   *Note*: In C++, structs can have constructors, destructors, methods, and support polymorphism, just like classes.

---

## 3. Reference PDF Highlights

*   **Inline Functions (Q11):** Instructs the compiler to replace the function call directly with the function code to save the overhead of a function call stack push/pop. Use for small, frequently called functions.
*   **Friend Functions (Q13):** A non-member function that is granted access to the `private` and `protected` members of a class. Use sparingly as it bypasses encapsulation.
*   **Abstract Class (Q16):** A class that contains at least one **pure virtual function** (e.g., `virtual void draw() = 0;`). It cannot be instantiated; it only serves as an interface.
*   **Constructor Overloading (Q9):** Defining multiple constructors with different argument lists within the same class. Destructors *cannot* be overloaded because they take no arguments.
*   **Call by Value vs. Call by Reference (Q19):** Call by value copies the variable (safe but slow for large objects). Call by reference passes the memory address (fast, changes affect the original variable).
