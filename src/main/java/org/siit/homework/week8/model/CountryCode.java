package org.siit.homework.week8.model;

public enum CountryCode {
    AT("AT"), BE("BE"), BR("BR"), HR("HR"), CY("CY"), CZ("CZ"), DK("DK"), EE("EE"), FI("FI"), FR("FR"), DE("DE"),
    GR("GR"), HU("HU"), IE("IE"), IT("IT"), LV("LV"), LU("LU"), NL("NL"), PL("PL"), PT("PT"), RO("RO"), SK("SK"),
    UK("UK"), US("US");

    final String countryCode;

    CountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


}
