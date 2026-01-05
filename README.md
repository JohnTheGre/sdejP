# E-Commerce Shopping System – Design Patterns Project

## Project Overview

This project implements a **basic e-commerce shopping system in Java** that demonstrates how multiple design patterns can be used together within an in all **single, coherent application**.

The system allows a user to:
- Add products to a shopping cart
- View cart contents, totals, and taxes
- Checkout using different payment methods
- Integrate external and legacy payment systems through adapters

Rather than presenting isolated pattern demos, this project applies design patterns to **solve real problems within the same application**, following object-oriented design principles.

---

## Team Members

- **JohnTheGre**  
  Implemented the **Singleton Pattern** and **Strategy Pattern**

- **Ifechukwu26**  
  Implemented the **Adapter Pattern**

---

## Design Pattern Usage in the Application

### Singleton Pattern (Creational)

- **Class**: `StoreConfig`
- **Role**: Singleton
- **Purpose**:  
  Ensures that only one instance of the store configuration exists across the entire application.  
  This configuration provides shared data such as tax rate, currency, store name, loyalty points, and free shipping threshold.

- **Usage in Application**:
    - Accessed by `ShoppingCart` and other components
    - Guarantees consistent configuration values throughout the checkout process

---

### Strategy Pattern (Behavioral)

- **Strategy Interface**: `PaymentStrategy`
- **Concrete Strategies**:
    - `CreditCardPayment`
    - `PayPalPayment`
- **Context Class**: `ShoppingCart`

- **Purpose**:  
  Encapsulates different payment algorithms and allows the shopping cart to switch payment methods dynamically at runtime without modifying its code.

- **Usage in Application**:
    - The user selects a payment method at checkout
    - The `ShoppingCart` gives the payment process to the selected strategy
    - New payment methods can be added without changing the cart logic

---

### Adapter Pattern (Structural)

- **Adapters**:
    - `ExternalPaymentAdapter`
    - `BankTransferAdapter`
- **Adaptees**:
    - `ExternalPaymentService`
    - `BankTransferAPI`
- **Target Interface**: `PaymentStrategy`

- **Purpose**:  
  Allows incompatible external payment APIs to be used within the application by adapting them to the `PaymentStrategy` interface.

- **Usage in Application**:
    - External payment systems are integrated without modifying existing application code
    - Demonstrates how third-party services can be reused safely and cleanly

---

## Application Flow

1. The application initializes shared store configuration using the **Singleton Pattern**
2. The user adds products to the shopping cart
3. The cart calculates subtotal, tax, loyalty points, and shipping eligibility
4. A payment method is selected using the **Strategy Pattern**
5. If the payment method is external, the **Adapter Pattern** is used to process the payment
6. The checkout completes and the cart is cleared

---

## How to Run

1. Compile the project
2. Run the main class:

```bash
java -cp out Main
