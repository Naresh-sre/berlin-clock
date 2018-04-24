package com.ubs.opsit.interviews;

import java.util.StringJoiner;

public class BerlinTimeBuilder {

    private static final String NEW_LINE = System.getProperty("line.separator");

    public static BerlinTimeBuilder getBerlinTimeBuilder() {
        return new BerlinTimeBuilder();
    }

    private String firstRowHours;
    private String firstRowMinutes;
    private String secondRowHours;
    private String secondRowMinutes;

    private String seconds;

    private BerlinTimeBuilder() {

    }

    public String build() {
        final StringJoiner sj = new StringJoiner(NEW_LINE);
        sj.add(this.seconds).add(this.firstRowHours).add(this.secondRowHours).add(this.firstRowMinutes)
            .add(this.secondRowMinutes);
        return sj.toString();
    }

    public BerlinTimeBuilder withFirstRowHours(final String firstRowHours) {
        this.firstRowHours = firstRowHours;
        return this;
    }

    public BerlinTimeBuilder withFirstRowMinutes(final String firstRowMinutes) {
        this.firstRowMinutes = firstRowMinutes;
        return this;
    }

    public BerlinTimeBuilder withSecondRowHours(final String secondRowHours) {
        this.secondRowHours = secondRowHours;
        return this;
    }

    public BerlinTimeBuilder withSecondRowMinutes(final String secondRowMinutes) {
        this.secondRowMinutes = secondRowMinutes;
        return this;
    }

    public BerlinTimeBuilder withSeconds(final String seconds) {
        this.seconds = seconds;
        return this;
    }

}
