package com.ubs.opsit.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BerlinClockImpl implements TimeConverter {

    private static final int HOURS_MAX_RANGE = 24;
    private static final int HOURS_MIN_RANGE = 0;
    private static final int MINUTE_SECOND_MAX_RANGE = 59;
    private static final int MINUTE_SECOND_MIN_RANGE = 0;
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String OFF_LAMP = "O";
    private static final String RED_LAMP = "R";
    private static final String YELLO_LAMP = "Y";

    @Override
    public String convertTime(final String time) {
        if (time == null || time.trim().isEmpty()) {
            return BerlinMsg.NO_TIME_PROVIDED.getkey();
        }

        final String[] timeSplited = time.split(":");
        if (timeSplited.length < 3) {
            return BerlinMsg.INVALID_TIME_FORMAT.getkey();
        }

        int seconds, minutes, hours = 0;
        try {
            hours = Integer.parseInt(timeSplited[0]);
            minutes = Integer.parseInt(timeSplited[1]);
            seconds = Integer.parseInt(timeSplited[2]);
        } catch (final NumberFormatException nfex) {
            return BerlinMsg.NUMERIC_TIME.getkey() + time;
        }

        final List<String> errorMsg = new ArrayList<String>();
        if (!isTimeinValidRange(hours, minutes, seconds, errorMsg)) {
            final StringJoiner sj = new StringJoiner(NEW_LINE);
            for (final String error : errorMsg) {
                sj.add(error);
            }

            return sj.toString();
        }

        final BerlinTimeBuilder btb = BerlinTimeBuilder.getBerlinTimeBuilder();

        final String berlinTime = btb.withSeconds(getBerlinSeconds(seconds)).withFirstRowHours(getBerlinHourFirstRow(hours))
            .withSecondRowHours(getBerlinHourSecondRow(hours)).withFirstRowMinutes(getBerlineMinuFirstdRow(minutes))
            .withSecondRowMinutes(getBerlineMinuteSecondRow(minutes)).build();

        return berlinTime;
    }

    private String getBerlineMinuFirstdRow(final int minutes) {
        return getOnAndOffLights(minutes / 5, 11, YELLO_LAMP).replaceAll("YYY", "YYR");

    }

    private String getBerlineMinuteSecondRow(final Integer minutes) {
        return getOnAndOffLights(minutes % 5, 4, YELLO_LAMP);
    }

    /**
     * @param hour
     * @return
     */
    private String getBerlinHourFirstRow(final Integer hour) {

        return getOnAndOffLights(hour / 5, 4, RED_LAMP);
    }

    /**
     * @param hour
     * @return
     */
    private String getBerlinHourSecondRow(final Integer hour) {

        return getOnAndOffLights(hour % 5, 4, RED_LAMP);
    }

    private String getBerlinSeconds(final Integer second) {

        return second % 2 == 0 ? YELLO_LAMP : "O";
    }

    private String getOnAndOffLights(final int onLamp, final int totalLampInRow, final String lampType) {

        final StringBuilder lampInRow = new StringBuilder(totalLampInRow);
        for (int i = 0; i < onLamp; i++) {
            lampInRow.append(lampType);
        }
        final int offLamp = totalLampInRow - onLamp;
        for (int i = 0; i < offLamp; i++) {
            lampInRow.append(OFF_LAMP);
        }
        return lampInRow.toString();
    }

    private boolean isTimeinValidRange(final int hours, final int minutes, final int seconds, final List<String> errorMsg) {
        validateTimeRangs(hours, HOURS_MIN_RANGE, HOURS_MAX_RANGE, BerlinMsg.HOUR.getkey(), errorMsg);
        validateTimeRangs(minutes, MINUTE_SECOND_MIN_RANGE, MINUTE_SECOND_MAX_RANGE, BerlinMsg.MINUTE.getkey(), errorMsg);
        validateTimeRangs(seconds, MINUTE_SECOND_MIN_RANGE, MINUTE_SECOND_MAX_RANGE, BerlinMsg.SECOND.getkey(), errorMsg);

        if (errorMsg.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    private boolean validateTimeRangs(final int timePart, final int minRange, final int maxRange, final String timeUnit,
        final List<String> errorMsg) {
        if (timePart < minRange || timePart > maxRange) {
            errorMsg.add(BerlinMsg.TIME_UNIT_OUT_OF_RANGE.getkey() + timeUnit);
            return false;
        }
        return true;
    }

}
