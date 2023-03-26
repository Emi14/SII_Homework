package org.siit.homework.hw7Tema8;

public enum Country {
    UK("UnitedKingdom"),
    SK("Slovakia"),
    DK("Denmark"),
    CZ("Czech Republic"),
    GER("Germany"),
    TR("Turkey"),
    RM("RepublicOfMoldova"),
    RO("Romania"),
    JPN("Japan"),
    IT("Italy"),
    GR ("Greece");
    final String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public static Country getCountryEnum(String country) {

        Country[] countries = Country.values();

        for (Country country1 : countries) {
            if (country.equals(country1.name())) {
                return country1;
            }
        }
        return null;
    }
}
