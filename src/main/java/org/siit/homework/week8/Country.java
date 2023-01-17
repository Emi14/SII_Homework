package org.siit.homework.week8;

public enum Country {
    USA("UnitedStates"),
    NOR("Norway"),
    FIN("Finland"),
    SWE("Sweden"),
    GER("Germany"),
    UK("UnitedKingdom"),
    FRA("France"),
    DEN("Denmark"),
    BEL("Belgium"),
    SK("Slovakia"),
    CZ("CzechRepublic");
    String countryName;
    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
    public static Country getCountryEnum(String country) {

        Country[] countries = Country.values();

        for(Country c : countries) {
            if (country.equals(c.name())) {
                return c;
            }
        }
        return null;

    }
}
