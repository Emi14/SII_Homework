package org.siit.projects.metricDistanceCalculator;

public enum MetricConvertor {
    m(1000),
    cm(10),
    mm(1),
    km(1000000),
    dm(100);

    private final int scale;

    MetricConvertor(int scale) {
        this.scale = scale;
    }
    public int getScale() {
        return scale;
    }
}
