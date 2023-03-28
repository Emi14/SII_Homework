package org.siit.homework.week6;

public class Distance {
    private double value;
    private String unit;

    public Distance() {}

    public Distance(double value) {
        this.value = value;
    }

    public Distance(String unit) {
        this.unit = unit;
    }

    public Distance(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValueInMillimeters() {
        switch (unit) {
            case "mm":
                return value;
            case "cm":
                return value * 10;
            case "dm":
                return value * 100;
            case "m":
                return value * 1000;
            case "km":
                return value * 1000000;
            default:
                throw new IllegalArgumentException("Invalid unit: " + unit + ". Please use metric system.");
        }
    }

//    public double getValueInLowestUnit() {
//        double valueInMillimeters = getValueInMillimeters();
//        switch (unit) {
//            case "km":
//                return valueInMillimeters / 1000000;
//            case "m":
//                return valueInMillimeters / 1000;
//            case "dm":
//                return valueInMillimeters / 100;
//            case "cm":
//                return valueInMillimeters / 10;
//            case "mm":
//            default:
//                return valueInMillimeters;
//        }
//    }

    public Distance add(Distance distance) {
        double sum = getValueInMillimeters() + distance.getValueInMillimeters();
        return new Distance(sum, "mm");
    }

    public Distance subtract(Distance distance) {
        double difference = getValueInMillimeters() - distance.getValueInMillimeters();
        return new Distance(difference, "mm");
    }

    @Override
    public String toString() {
        return "Distance{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}

