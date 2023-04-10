package org.siit.projects.phoneApp;

import java.awt.*;

public class SamsungGalaxyNote extends Samsung{
    public SamsungGalaxyNote(String imei) {
        super(Color.gray, Material.PLASTIC, imei);
    }

    @Override
    public String toString() {
        return "SamsungGalaxyNote{" +
                "color=" + color +
                ", material=" + material +
                ", imei='" + imei + '\'' +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
