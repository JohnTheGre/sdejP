public class StrategyPattern {
    // Strategy Interface
    interface PaymentStrategy {
        void pay(int amount);
    }

    // Concrete Strategies
    static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " via Credit Card.");
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " via PayPal.");
        }
    }

    // Context Class
    static class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout(int amount) {
            paymentStrategy.pay(amount);
        }
    }
}