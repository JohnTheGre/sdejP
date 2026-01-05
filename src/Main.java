public class Main {
    public static void main(String[] args) {
        System.out.println("E-Commerce System with Design Patterns");

        // SINGLETON PATTERN
        // Get store configuration (only one instance exists)
        StoreConfig config = StoreConfig.getInstance();
        config.displayConfig();

        // Verify singleton - getting instance again returns the same object
        StoreConfig config2 = StoreConfig.getInstance();
        System.out.println("→ Singleton verification: config == config2? " + (config == config2));
        System.out.println("  (Both variables point to the same instance)\n");

        System.out.println("--------\n");

        // ORDER 1: Credit Card Payment (Strategy Pattern)
        System.out.println(">>> CUSTOMER 1: Shopping with Credit Card\n");

        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItem("Laptop", 1000);
        cart1.addItem("Wireless Mouse", 50);
        cart1.addItem("USB-C Cable", 15);

        cart1.viewCart();

        // Set payment strategy: Credit Card
        System.out.println("--- Selected Payment: Credit Card ---");
        cart1.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart1.checkout();

        System.out.println("--------\n");

        // ORDER 2: PayPal Payment (Strategy Pattern)
        System.out.println(">>> CUSTOMER 2: Shopping with PayPal\n");

        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem("Mechanical Keyboard", 120);
        cart2.addItem("Monitor", 250);

        cart2.viewCart();

        // Set payment strategy: PayPal
        System.out.println("--- Selected Payment: PayPal ---");
        cart2.setPaymentStrategy(new PayPalPayment("customer@email.com"));
        cart2.checkout();

        System.out.println("---------\n");

        // ORDER 3: External Payment Gateway (Adapter Pattern)
        System.out.println(">>> CUSTOMER 3: Using External Payment Gateway\n");

        ShoppingCart cart3 = new ShoppingCart();
        cart3.addItem("Smartphone", 800);
        cart3.addItem("Phone Case", 25);
        cart3.addItem("Screen Protector", 10);

        cart3.viewCart();

        // Use external payment service through adapter
        System.out.println("--- Selected Payment: External Gateway (via Adapter) ---");
        ExternalPaymentService externalService = new ExternalPaymentService();
        cart3.setPaymentStrategy(new ExternalPaymentAdapter(externalService, "MERCH_12345"));
        cart3.checkout();

        System.out.println("-------\n");

        // ORDER 4: Bank Transfer (Adapter Pattern)
        System.out.println(">>> CUSTOMER 4: Using Bank Transfer\n");

        ShoppingCart cart4 = new ShoppingCart();
        cart4.addItem("Gaming Console", 500);
        cart4.addItem("Controller", 60);

        cart4.viewCart();

        // Use bank transfer through adapter
        System.out.println("--- Selected Payment: Bank Transfer (via Adapter) ---");
        BankTransferAPI bankAPI = new BankTransferAPI();
        cart4.setPaymentStrategy(new BankTransferAdapter(bankAPI, "NL91ABNA0417164300"));
        cart4.checkout();

        System.out.println("--------\n");

        // PATTERN INTEGRATION
        System.out.println(">>> PATTERN SUMMARY:\n");
        System.out.println(" THE SINGLETON: StoreConfig used by all carts for tax, currency, etc.");
        System.out.println(" THE STRATEGY: Different payment methods (CreditCard, PayPal) interchangeable");
        System.out.println(" THE ADAPTER: External services (Payment Gateway, Bank) adapted to our interface");
        System.out.println("\nAll patterns work together in one cohesive E-Commerce system!");

        System.out.println(" Bedankt voor winkelen met onze winkel  ");
    }
}