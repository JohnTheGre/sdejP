# Design Patterns Project

This project demonstrates the implementation of various design patterns in Java.

## Team Members
- *JohnTheGre*: Implemented Singleton Pattern and Adapter Pattern.
- *Ifechukwu26*: Implemented Stratergy Pattern.

## Design Patterns

### Creational Patterns
**Singleton Pattern**: Ensures only one instance of a class is created.
   - **Implementation**: The Singleton class has a private constructor to prevent direct instantiation and a static `getInstance()` method that controls object creation. The single instance is stored as a private static variable that's created only when first requested (lazy initialization).
   - **Usage**: Guarantees that only one instance of the Singleton class exists throughout the application's lifetime. All calls to `getInstance()` return the same object reference, ensuring shared state and preventing duplicate instances.
   - **Example**: When `Singleton.getInstance()` is called multiple times, it returns the same instance each time. The first call creates the instance, and subsequent calls return the existing one. This is verified by comparing references: `singleton1 == singleton2` returns true.
   - **Benefits**:
     - Controlled access to a single instance
     - Reduces memory footprint (only one object created)
     - Useful for managing shared resources (database connections, configuration managers, logging)
     - Provides a global point of access
   - **Real-world analogy**: Like a country having only one president at a time - no matter how many times you ask "who's the president?", you get the same person.

### Structural Patterns
 **Adapter Pattern**: Allows incompatible interfaces to work together.
   - **Implementation**: The MediaAdapter converts the AdvancedMediaPlayer's interface (with separate `playMp4()` and `playVlc()` methods) into the MediaPlayer interface that the client expects (single `play()` method).
   - **Usage**: Enables the AudioPlayer to play advanced media formats (MP4, VLC) without modifying its existing code. The adapter acts as a bridge between the incompatible interfaces.
   - **Example**: When `audioPlayer.play("mp4", "video.mp4")` is called, the MediaAdapter translates this into `advancedPlayer.playMp4("video.mp4")`, making the two incompatible systems work together seamlessly.
   - **Real-world analogy**: Like a power adapter that converts one plug type to another, the MediaAdapter converts one method signature to another.

### Behavioral Patterns
  **Strategy Pattern**: Encapsulates interchangeable algorithms.
   - **Implementation**: Different payment methods (CreditCardPayment, PayPalPayment, BitcoinPayment) implement the PaymentStrategy interface. Each strategy encapsulates a specific payment algorithm. The ShoppingCart class uses composition to hold a reference to a PaymentStrategy that can be changed at runtime.
   - **Usage**: Allows the client (ShoppingCart) to switch between different payment algorithms dynamically without modifying the cart's code. This follows the Open/Closed Principle - the code is open for extension (add new payment methods) but closed for modification.
   - **Example**: The shopping cart can process payments using different methods by simply calling `setPaymentStrategy()` with the desired payment type, then calling `checkout()`. For instance, switching from `CreditCardPayment` to `PayPalPayment` requires no changes to the ShoppingCart class.
   - **Benefits**: 
     - Eliminates conditional statements (no need for if/else chains to handle different payment types)
     - Easy to add new payment methods without modifying existing code
     - Each payment algorithm is encapsulated in its own class, making them easier to test and maintain
   - **Real-world analogy**: Like choosing different transportation methods (car, bus, bike) to reach your destination - the goal is the same, but the strategy changes.


## How to Run(sftw-master)
1. Compile the Java files:
   javac src/*.java -d out
2. Run main java file:
   java -cp out Main

