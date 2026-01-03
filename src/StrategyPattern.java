/**
 * Strategy Pattern - Strategy Interface
 * Defines the contract for all payment methods
 */
interface PaymentStrategy {
    void pay(int amount);
}

/**
 * Concrete Strategy - Credit Card Payment
 */
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardholderName;

    public CreditCardPayment(String cardNumber, String cardholderName) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Processing Credit Card payment...");
        System.out.println("Amount: €" + amount);
        System.out.println("Card: " + maskCardNumber(cardNumber));
        System.out.println("Cardholder: " + cardholderName);
        System.out.println("✓ Credit Card payment successful!\n");
    }

    private String maskCardNumber(String card) {
        if (card.length() > 4) {
            return "****-" + card.substring(card.length() - 4);
        }
        return card;
    }
}

/**
 * Concrete Strategy - PayPal Payment
 */
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Processing PayPal payment...");
        System.out.println("Amount: €" + amount);
        System.out.println("PayPal Email: " + email);
        System.out.println("✓ PayPal payment successful!\n");
    }
}