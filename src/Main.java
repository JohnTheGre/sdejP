public class Main {
    public static void main(String[] args) {
        System.out.println("=== Design Patterns Demonstration ===\n");

        // Singleton Pattern Example
        System.out.println("--- Singleton Pattern Example ---");
        SingletonPattern.Singleton singleton1 = SingletonPattern.Singleton.getInstance();
        SingletonPattern.Singleton singleton2 = SingletonPattern.Singleton.getInstance();
        
        singleton1.showMessage();
        
        // Verify both references point to the same instance
        System.out.println("Are both instances the same? " + (singleton1 == singleton2));
        System.out.println();

        // Adapter Pattern Example
        System.out.println("--- Adapter Pattern Example ---");
        AdapterPatter.AudioPlayer audioPlayer = new AdapterPatter.AudioPlayer();
        
        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("avi", "clip.avi");  // Unsupported format
        System.out.println();

        // Strategy Pattern Example
        System.out.println("--- Strategy Pattern Example ---");
        StrategyPattern.ShoppingCart cart = new StrategyPattern.ShoppingCart();

        // Pay with Credit Card
        System.out.println("Payment 1:");
        cart.setPaymentStrategy(new StrategyPattern.CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart.checkout(100);
        System.out.println();

        // Pay with PayPal
        System.out.println("Payment 2:");
        cart.setPaymentStrategy(new StrategyPattern.PayPalPayment("john.doe@example.com"));
        cart.checkout(50);
        System.out.println();

        // Pay with Bitcoin
        System.out.println("Payment 3:");
        cart.setPaymentStrategy(new StrategyPattern.BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        cart.checkout(200);
        System.out.println();

        // Try checkout without payment method
        System.out.println("Payment 4 (no strategy set):");
        StrategyPattern.ShoppingCart cart2 = new StrategyPattern.ShoppingCart();
        cart2.checkout(75);
    }
}