/**
 * Singleton Pattern - Store Configuration
 * Ensures only one configuration instance exists across the application
 * Used by all parts of the system to get consistent store settings
 */
class StoreConfig {
    private static StoreConfig instance;

    // Store configuration data
    private double taxRate = 0.21; // 21% VAT
    private String storeName = "Java E-Commerce Store";
    private String currency = "€";
    private double freeShippingThreshold = 100.0;
    private int pointsPerEuro = 1; // Loyalty points

    // Private constructor prevents direct instantiation
    private StoreConfig() {
        System.out.println("→ StoreConfig initialized (Singleton created)");
    }

    /**
     * Global access point to the single instance
     */
    public static StoreConfig getInstance() {
        if (instance == null) {
            instance = new StoreConfig();
        }
        return instance;
    }

    // Getters for configuration values
    public double getTaxRate() {
        return taxRate;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getCurrency() {
        return currency;
    }

    public double getFreeShippingThreshold() {
        return freeShippingThreshold;
    }

    public int getPointsPerEuro() {
        return pointsPerEuro;
    }

    public void displayConfig() {
        System.out.println(" Store Configuration ");
        System.out.println("Store Name: " + storeName);
        System.out.println("Currency: " + currency);
        System.out.println("Tax Rate: " + (taxRate * 100) + "%");
        System.out.println("Free Shipping Threshold: " + currency + freeShippingThreshold);
        System.out.println("Loyalty Points: " + pointsPerEuro + " point per " + currency + "1");
        System.out.println();
    }
}