# OOP Course Curriculum & Implementation Plan

This copy of the course plan is saved in your project folder for easy access and reference.

---

## 📋 Course Syllabus & Progress Tracking

| Status | Lesson & File Name | Type | Word Count Target | Key Concepts Covered |
| :--- | :--- | :--- | :--- | :--- |
| ⏳ **Pending** | `lessons/01_introduction_to_oop.md` | Normal | 1800 - 3000 | Class vs Object, state vs behavior, memory allocation intuition |
| ⏳ **Pending** | `lessons/02_references_and_memory.md` | Normal | 1800 - 3000 | Stack vs Heap, reference variables, pass-by-value, the swap problem, `null` |
| ⏳ **Pending** | `lessons/03_constructors_and_initialization.md`| Normal | 1800 - 3000 | Default/parameterized/copy constructors, `this()`, chaining, initialization order |
| ⏳ **Pending** | `lessons/04_encapsulation.md` | Major | 2500 - 4000 | Access modifiers, data hiding, getter/setter validation, read-only classes |
| ⏳ **Pending** | `lessons/05_packages_and_static.md` | Normal | 1800 - 3000 | Package management, import, `static` variables/methods/blocks, nested static classes |
| ⏳ **Pending** | `lessons/06_inheritance.md` | Major | 2500 - 4000 | subclassing, `super()`, inheritance hierarchy, why no multiple inheritance |
| ⏳ **Pending** | `lessons/07_polymorphism.md` | Major | 2500 - 4000 | Method Overloading vs Overriding, Dynamic Method Dispatch, covariant returns |
| ⏳ **Pending** | `lessons/08_abstraction.md` | Major | 2500 - 4000 | Abstract classes, interfaces, default/private interface methods, complete comparison |
| ⏳ **Pending** | `lessons/09_composition_vs_inheritance.md` | Major | 2500 - 4000 | Fragile base class problem, Has-A vs Is-A, refactoring inheritance to composition |
| ⏳ **Pending** | `lessons/10_solid_principles.md` | Major | 2500 - 4000 | Single Responsibility, Open-Closed, Liskov, Interface Segregation, Dependency Inversion |
| ⏳ **Pending** | `lessons/11_design_patterns.md` | Major | 2500 - 4000 | Singleton, Factory, Builder, Adapter, Decorator, Observer, Strategy |
| ⏳ **Pending** | `lessons/12_object_class_and_interview_modeling.md` | Major | 2500 - 4000 | `equals`, `hashCode`, `toString`, `clone`, OOAD interview modeling (e.g., Parking Lot) |

---

## 🛠️ Code Example Progression Structure

For every lesson, code examples will follow this structured pipeline:

1. **Smallest Possible Example**: Focused entirely on syntax and the core concept in isolation.
2. **Realistic Example**: Demonstrates the concept in a practical, real-world context (e.g., banking, e-commerce, sensor readings).
3. **Design-Oriented Example**: Shows how the concept is applied to build robust, modular systems.
4. **Bad vs. Corrected Example**: Directly contrasts code exhibiting common pitfalls/anti-patterns with its refactored, high-quality counterpart.

Each example will detail the **file placement**, **compilation and run commands**, and **expected console output** so the student can replicate the execution.

---

## 🎯 Target Audience & Technical Scope

- **Prerequisites**: Student is assumed to understand variables, loops, conditional statements (`if`/`else`), and basic methods, but has **zero** OOP knowledge.
- **Java Version**: Targeted at Java 17/21 features (e.g., record types, modern interface syntax, sealed classes) while explicitly maintaining backward-compatibility notes for Java 8 (highly relevant for legacy code and corporate interviews).
- **Format**: Self-contained markdown files placed in the `lessons/` folder.
