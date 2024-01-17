public class Light {
    // Вызов конструктора this()

    // Поля
    private int noOfWatts;
    private boolean indicator;
    private String location;

    Light() {                              // Явный конструктор по умолчанию
        this(0, false);
        System.out.println("Returning from default constructor no. 1.");
    }

    Light(int watt, boolean ind) {         // Не по умолчанию
        this(watt, ind, "X");
        System.out.println("Returning from non-default constructor no. 2.");
    }

    Light(int noOfWatts, boolean indicator, String location) {   // (3) Не по умолчанию
        this.noOfWatts = noOfWatts;
        this.indicator = indicator;
        this.location = location;
        System.out.println("Returning from non-default constructor no. 3.");
    }
}
