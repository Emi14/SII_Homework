package org.siit.projects.phoneApp;

import java.awt.*;

public class SamsungGalaxyS6 extends Samsung{
    public SamsungGalaxyS6(String imei) {
        super(Color.black, Material.METAL, imei);
    }

    @Override
    public String toString() {
        return "SamsungGalaxyS6{" +
                "color=" + color +
                ", material=" + material +
                ", imei='" + imei + '\'' +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
