package models;

public class Bus {
    private final Integer number;
    private final String model;
    private final Integer mileage;

    private Bus(Integer number, String model, Integer mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public Integer getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public Integer getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    public static class BusBuilder {
        private Integer number;
        private String model;
        private Integer mileage;

        public BusBuilder setNumber(Integer number) {
            this.number = number;
            return this;
        }

        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(Integer mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(number, model, mileage);
        }
    }
}