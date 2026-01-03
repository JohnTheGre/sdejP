public class StrategyPattern {
    // Strategy Interface
    interface PaymentStrategy {
        void pay(int amount);
    }

    // Concrete Strategy 1: Credit Card Payment
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String name;

        public CreditCardPayment(String cardNumber, String name) {
            this.cardNumber = cardNumber;
            this.name = name;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " using Credit Card.");
            System.out.println("Card Number: " + cardNumber + " | Cardholder: " + name);
        }
    }

    // Concrete Strategy 2: PayPal Payment
    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " using PayPal.");
            System.out.println("PayPal Email: " + email);
        }
    }

    // Concrete Strategy 3: Bitcoin Payment
    static class BitcoinPayment implements PaymentStrategy {
        private String walletAddress;

        public BitcoinPayment(String walletAddress) {
            this.walletAddress = walletAddress;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " using Bitcoin.");
            System.out.println("Wallet Address: " + walletAddress);
        }
    }

    // Context Class: Shopping Cart
    static class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        // Set payment strategy at runtime
        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout(int amount) {
            if (paymentStrategy == null) {
                System.out.println("Please select a payment method!");
                return;
            }
            paymentStrategy.pay(amount);
        }
    }
}