/**
 * Adaptee - External Third-Party Payment Service
 * This represents an external API
 */
class ExternalPaymentService {
    public void processTransaction(double amount, String merchantId) {
        System.out.println("External Payment Gateway Processing...");
        System.out.println("Merchant ID: " + merchantId);
        System.out.println("Amount: €" + String.format("%.2f", amount));
        System.out.println("Transaction approved by external gateway");
    }
}

/**
 * Another External Service - Bank Transfer API
 */
class BankTransferAPI {
    public boolean initiateTransfer(String iban, double euros) {
        System.out.println("Bank Transfer System:");
        System.out.println("Transferring €" + String.format("%.2f", euros) + " to IBAN: " + iban);
        System.out.println("Transfer queued for processing (1-2 business days)");
        return true;
    }
}

/**
 * Adapter - Makes ExternalPaymentService compatible with PaymentStrategy
 */
class ExternalPaymentAdapter implements PaymentStrategy {
    private ExternalPaymentService externalService;
    private String merchantId;

    public ExternalPaymentAdapter(ExternalPaymentService service, String merchantId) {
        this.externalService = service;
        this.merchantId = merchantId;
    }

    @Override
    public void pay(int amount) {
        // Adapt our integer amount to the external service's double format
        double amountInEuros = (double) amount;
        System.out.println("Using External Payment Service (via Adapter)...");
        externalService.processTransaction(amountInEuros, merchantId);
        System.out.println(" External payment completed!\n");
    }
}

/**
 * Adapter - Makes BankTransferAPI compatible with PaymentStrategy
 */
class BankTransferAdapter implements PaymentStrategy {
    private BankTransferAPI bankAPI;
    private String iban;

    public BankTransferAdapter(BankTransferAPI api, String iban) {
        this.bankAPI = api;
        this.iban = iban;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Using Bank Transfer (via Adapter)...");
        double euros = (double) amount;
        bankAPI.initiateTransfer(iban, euros);
        System.out.println("✓ Bank transfer initiated!\n");
    }
}

// SHOPPING CART

/**
 * Context class that uses the Strategy Pattern
 * The cart uses StoreConfig (Singleton) and accepts PaymentStrategy
 */
class ShoppingCart {
    private java.util.ArrayList<CartItem> items;
    private PaymentStrategy paymentStrategy;
    private StoreConfig config;

    public ShoppingCart() {
        this.items = new java.util.ArrayList<>();
        this.config = StoreConfig.getInstance(); // Using Singleton
    }

    public void addItem(String name, int price) {
        items.add(new CartItem(name, price));
        System.out.println("✓ " + name + " added to cart (" + config.getCurrency() + price + ")");
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void viewCart() {
        System.out.println("\n--- Shopping Cart ---");
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        int subtotal = 0;
        for (CartItem item : items) {
            System.out.println("- " + item.name + ": " + config.getCurrency() + item.price);
            subtotal += item.price;
        }

        double tax = subtotal * config.getTaxRate();
        int totalWithTax = (int) Math.round(subtotal + tax);
        int loyaltyPoints = subtotal * config.getPointsPerEuro();

        System.out.println("\nSubtotal: " + config.getCurrency() + subtotal);
        System.out.println("Tax (" + (config.getTaxRate() * 100) + "%): " + config.getCurrency() + String.format("%.2f", tax));
        System.out.println("Total: " + config.getCurrency() + totalWithTax);
        System.out.println("Loyalty Points Earned: " + loyaltyPoints + " points");

        if (subtotal >= config.getFreeShippingThreshold()) {
            System.out.println(" FREE SHIPPING UNLOCKED!");
        }
        System.out.println();
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println(" Cannot checkout - cart is empty!\n");
            return;
        }

        if (paymentStrategy == null) {
            System.out.println(" Please select a payment method!\n");
            return;
        }

        System.out.println("\n---------- CHECKOUT ---------- ");

        // Calculate total using Singleton config
        int subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.price;
        }

        double tax = subtotal * config.getTaxRate();
        int finalAmount = (int) Math.round(subtotal + tax);

        System.out.println("Subtotal: " + config.getCurrency() + subtotal);
        System.out.println("Tax: " + config.getCurrency() + String.format("%.2f", tax));
        System.out.println("Total Amount: " + config.getCurrency() + finalAmount);
        System.out.println();

        // Use the selected payment strategy
        paymentStrategy.pay(finalAmount);

        // Clear cart after successful checkout
        items.clear();
        System.out.println(" Order completed! Cart cleared.");
        System.out.println("--------------------------------\n");
    }

    // Inner class for cart items
    private static class CartItem {
        String name;
        int price;

        CartItem(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}