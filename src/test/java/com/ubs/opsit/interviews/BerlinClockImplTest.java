package com.ubs.opsit.interviews;

import static  org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockImplTest {
    BerlinClockImpl berlinClock ;

    @Before
    public void setUp(){
        berlinClock = new BerlinClockImpl();
    }

    @After
    public void cleanUp(){
        berlinClock = null;
    }

    @Test
    public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
        assertEquals("Y", berlinClock.getBerlinSeconds(0));
        assertEquals("O", berlinClock.getBerlinSeconds(1));
        assertEquals("Y", berlinClock.getBerlinSeconds(2));
    }

    @Test
    public void hourFirstRowhas4lamp(){
        assertEquals(4, berlinClock.getBerlinHourFirstRow(10).length());
    }

    /**
     * Test for Top row Hour lamp
     */
    @Test
    public void topHourLampShouldLitRed(){

        assertEquals("OOOO", berlinClock.getBerlinHourFirstRow(2));
        assertEquals("ROOO", berlinClock.getBerlinHourFirstRow(5));
        assertEquals("RROO", berlinClock.getBerlinHourFirstRow(10));
        assertEquals("RRRO", berlinClock.getBerlinHourFirstRow(15));
        assertEquals("RRRR", berlinClock.getBerlinHourFirstRow(20));
        assertEquals(BerlinMsg.WRONG_INPUT.getkey(), berlinClock.getBerlinHourFirstRow(25));
    }

    @Test
    public void lowRowHourLampShouldLitRed(){
        assertEquals("RROO", berlinClock.getBerlinHourSecondRow(2));
        assertEquals("RRRR", berlinClock.getBerlinHourSecondRow(4));
        assertEquals("OOOO", berlinClock.getBerlinHourSecondRow(5));

    }


    @Test
    public void topRowMinuteLampShouldLitYelloAndRed(){
        assertEquals("YOOOOOOOOOO", berlinClock.getBerlineMinuFirstdRow(5));
        assertEquals("YYOOOOOOOOO", berlinClock.getBerlineMinuFirstdRow(10));
        assertEquals("YYROOOOOOOO", berlinClock.getBerlineMinuFirstdRow(15));
        assertEquals("YYRYYROOOOO", berlinClock.getBerlineMinuFirstdRow(30));
        assertEquals("YYRYYRYYROO", berlinClock.getBerlineMinuFirstdRow(45));
        assertEquals("YYRYYRYYRYY", berlinClock.getBerlineMinuFirstdRow(55));
        assertEquals("YYRYYRYYRYY", berlinClock.getBerlineMinuFirstdRow(59));
        assertEquals(BerlinMsg.WRONG_INPUT.getkey(), berlinClock.getBerlineMinuFirstdRow(61));
    }

    @Test
    public void bottomRowMinuteLampShouldLitYello(){
        assertEquals("YYYY", berlinClock.getBerlineMinuteSecondRow(59));
        assertEquals("YOOO", berlinClock.getBerlineMinuteSecondRow(61));

    }

    @Test
    public void InvalidTime(){
       assertEquals(BerlinMsg.TIME_UNIT_OUT_OF_RANGE.getkey()+BerlinMsg.SECOND.getkey(), berlinClock.convertTime("23:45:60"));
       assertEquals(BerlinMsg.TIME_UNIT_OUT_OF_RANGE.getkey()+BerlinMsg.MINUTE.getkey(), berlinClock.convertTime("23:62:59"));
       assertEquals(BerlinMsg.WRONG_INPUT.getkey(), berlinClock.convertTime("24:23:45"));
    }

}
