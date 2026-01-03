public class Main {
    public static void main(String[] args) {
        // Singleton Pattern Example
        System.out.println("\nSingleton Pattern Example:");
        SingletonPattern.Singleton singleton = SingletonPattern.Singleton.getInstance();
        singleton.showMessage();

        // Factory Pattern Example
        System.out.println("\nFactory Pattern Example:");
        FactoryPattern.Shape circle = FactoryPattern.ShapeFactory.getShape("circle");
        assert circle != null;
        circle.draw();

        FactoryPattern.Shape rectangle = FactoryPattern.ShapeFactory.getShape("rectangle");
        assert rectangle != null;
        rectangle.draw();

        // Decorator Pattern Example
        System.out.println("\nDecorator Pattern Example:");
        DecoratorPattern.Pizza pizza = new DecoratorPattern.PlainPizza();
        pizza = new DecoratorPattern.CheeseDecorator(pizza);
        pizza = new DecoratorPattern.PepperoniDecorator(pizza);

        System.out.println("Order: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());

        // Observer Pattern
        System.out.println("\nObserver Pattern Example:");
        ObserverPattern.WeatherStation weatherStation = new ObserverPattern.WeatherStation();
        ObserverPattern.PhoneDisplay phoneDisplay = new ObserverPattern.PhoneDisplay();

        weatherStation.addObserver(phoneDisplay);
        weatherStation.setTemperature(25.0);
        weatherStation.setTemperature(30.0);

        // Strategy Pattern Example
        System.out.println("\nStrategy Pattern Example:");
        StrategyPattern.ShoppingCart cart = new StrategyPattern.ShoppingCart();
        cart.setPaymentStrategy(new StrategyPattern.CreditCardPayment());
        cart.checkout(100);

        cart.setPaymentStrategy(new StrategyPattern.PayPalPayment());
        cart.checkout(50);
    }
}