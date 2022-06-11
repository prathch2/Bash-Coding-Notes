/****************************************************************************
 * Customer.java
 ****************************************************************************
 * This program tests the CustomDate class for any logic errors. It tests
 * every method to make sure it executes the methods properly.
 *_____________________________________________________
 * Pratham Choksi
 * 03/05/2021
 * CMSC 256-004
 ****************************************************************************/

package cmsc256;

import static org.junit.Assert.*;
import org.junit.Test;

public class CustomDateTest {

    //tests the default constructor
    @Test
    public void testCustomDateDefaultConstructor() {
        CustomDate date = new CustomDate();
        if(date.getDay() == 1 && date.getMonth() == 1 && date.getYear() == 1900) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    //tests incorrect day in parameter constructor
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateParameterizedConstructor1() {
        CustomDate date = new CustomDate(5, 33, 1988);
    }

    //tests leap day in parameterized constructor
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateParameterizedConstructor2() {
        CustomDate date = new CustomDate(2, 29, 2021);
    }

    //tests leap day in parameterized constructor
    @Test
    public void testCustomDateParameterizedConstructor3() {
        CustomDate date = new CustomDate(2, 29, 2020);
        if(date.getDay() == 29 && date.getMonth() == 2 && date.getYear() == 2020) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    //tests string parameter in parameterized constructor
    @Test
    public void testCustomDateParameterizedConstructor4() {
        CustomDate date = new CustomDate("March", 4, 2003);
        if(date.getDay() == 4 && date.getMonth() == 3 && date.getYear() == 2003) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    //tests parameterized constructor
    @Test
    public void testCustomDateParameterizedConstructor5() {
        CustomDate date = new CustomDate(3, 4, 2003);
        if(date.getDay() == 4 && date.getMonth() == 3 && date.getYear() == 2003) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    //tests when year is invalid
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateSetYear1() {
        CustomDate date = new CustomDate();
        date.setYear(0);
    }

    //tests when year is invalid
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateSetYear2() {
        CustomDate date = new CustomDate();
        date.setYear(23334);
    }

    //tests a normal year
    @Test
    public void testCustomDateSetYear3() {
        CustomDate date = new CustomDate();
        date.setYear(2019);
        assertEquals(2019, date.getYear());
    }

    //tests getter method
    @Test
    public void testCustomDateGetYear() {
        CustomDate date = new CustomDate();
        date.setYear(2019);
        if (date.getYear() == 2019) {
            assertTrue(true);
        } else
            assertTrue(false);
    }

    //tests invalid month method
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateSetMonth1() {
        CustomDate date = new CustomDate();
        date.setMonth(0);
    }

    //tests invalid month method
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateSetMonth2() {
        CustomDate date = new CustomDate();
        date.setMonth(13);
    }

    //tests a normal month
    @Test
    public void testCustomDateSetMonth3() {
        CustomDate date = new CustomDate();
        date.setMonth(3);
        assertEquals(3, date.getMonth());
    }

    //tests a month as a capital first letter string
    @Test
    public void testCustomDateSetMonth4() {
        CustomDate date = new CustomDate();
        date.setMonth("January");
        assertEquals(1, date.getMonth());
    }

    //tests a month as a lowercase first letter string
    @Test
    public void testCustomDateSetMonth5() {
        CustomDate date = new CustomDate();
        date.setMonth("january");
        assertEquals(1, date.getMonth());
    }

    //tests the getter method
    @Test
    public void testCustomDateGetMonth() {
        CustomDate date = new CustomDate();
        date.setMonth(5);
        if (date.getMonth() == 5) {
            assertTrue(true);
        } else
            assertTrue(false);
    }

    //tests an invalid day
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateSetDay1() {
        CustomDate date = new CustomDate();
        date.setDay(0);
    }

    //tests an invalid day for a specific month
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateSetDay2() {
        CustomDate date = new CustomDate();
        date.setMonth(4);
        date.setDay(31);
    }

    //tests a day for a specific month
    @Test
    public void testCustomDateSetDay3() {
        CustomDate date = new CustomDate();
        date.setMonth(10);
        date.setDay(28);
        assertEquals(28, date.getDay());
    }

    //test leap year day
    @Test
    public void testCustomDateSetDay4() {
        CustomDate date = new CustomDate();
        date.setMonth(2);
        date.setYear(2020);
        date.isLeapYear();
        date.setDay(29);
        assertEquals(29, date.getDay());
    }

    //tests day on a non-leap year
    @Test (expected = IllegalArgumentException.class)
    public void testCustomDateSetDay5() {
        CustomDate date = new CustomDate();
        date.setMonth(2);
        date.setYear(2021);
        date.isLeapYear();
        date.setDay(29);
    }

    //tests getter method
    @Test
    public void testCustomDateGetDay() {
        CustomDate date = new CustomDate();
        date.setMonth(5);
        date.setDay(30);
        if (date.getDay() == 30) {
            assertTrue(true);
        } else
            assertTrue(false);
    }

    //tests if string returns in correct format
    @Test
    public void testCustomDateToString1() {
        CustomDate date = new CustomDate();
        date.setMonth(5);
        date.setDay(2);
        date.setYear(2021);
        assertEquals("05/02/2021", date.toString());
    }

    //tests if string returns in correct format
    @Test
    public void testCustomDateToString2() {
        CustomDate date = new CustomDate();
        date.setMonth(10);
        date.setDay(2);
        date.setYear(2021);
        assertEquals("10/02/2021", date.toString());
    }

    //tests if string returns in correct format
    @Test
    public void testCustomDateToString3() {
        CustomDate date = new CustomDate();
        date.setMonth(4);
        date.setDay(20);
        date.setYear(245);
        assertEquals("04/20/0245", date.toString());
    }

    //tests if string returns in correct format
    @Test
    public void testCustomDateToString4() {
        CustomDate date = new CustomDate();
        date.setMonth(10);
        date.setDay(20);
        date.setYear(1980);
        assertEquals("10/20/1980", date.toString());
    }


    //tests a leap year
    @Test
    public void testCustomDateIsLeapYear1() {
        CustomDate date = new CustomDate();
        date.setYear(2020);
        assertEquals(true, date.isLeapYear());
    }

    //tests a non-leap year
    @Test
    public void testCustomDateIsLeapYear2() {
        CustomDate date = new CustomDate();
        date.setYear(2018);
        date.isLeapYear();
        assertEquals(false, date.isLeapYear());
    }

    //tests last day in the year.
    @Test
    public void testCustomDateAdvanceOneDay1() {
        CustomDate date = new CustomDate();
        date.setYear(2018);
        date.setMonth(12);
        date.setDay(31);
        date.advanceOneDay();
        assertEquals("01/01/2019", date.toString());
    }

    //tests the last day in a month
    @Test
    public void testCustomDateAdvanceOneDay2() {
        CustomDate date = new CustomDate();
        date.setYear(2018);
        date.setMonth(11);
        date.setDay(30);
        date.advanceOneDay();
        assertEquals("12/01/2018", date.toString());
    }

    //tests a random day
    @Test
    public void testCustomDateAdvanceOneDay3() {
        CustomDate date = new CustomDate();
        date.setYear(2018);
        date.setMonth(5);
        date.setDay(8);
        date.advanceOneDay();
        assertEquals("05/09/2018", date.toString());
    }

    //tests with leap month
    @Test
    public void testCustomDateAdvanceOneDay4() {
        CustomDate date = new CustomDate();
        date.setYear(2020);
        date.setMonth(2);
        date.setDay(28);
        date.advanceOneDay();
        assertEquals("02/29/2020", date.toString());
    }

    //tests last day in the year.
    @Test
    public void testCustomDateAdvanceOneWeek1() {
        CustomDate date = new CustomDate();
        date.setYear(2018);
        date.setMonth(12);
        date.setDay(31);
        date.advanceOneWeek();
        assertEquals("01/07/2019", date.toString());
    }

    //tests the last day in a month
    @Test
    public void testCustomDateAdvanceOneWeek2() {
        CustomDate date = new CustomDate();
        date.setYear(2018);
        date.setMonth(11);
        date.setDay(30);
        date.advanceOneWeek();
        assertEquals("12/07/2018", date.toString());
    }

    //tests a random day
    @Test
    public void testCustomDateAdvanceOneWeek3() {
        CustomDate date = new CustomDate();
        date.setYear(2018);
        date.setMonth(5);
        date.setDay(8);
        date.advanceOneWeek();
        assertEquals("05/15/2018", date.toString());
    }

    //tests with leap month
    @Test
    public void testCustomDateAdvanceOneWeek4() {
        CustomDate date = new CustomDate();
        date.setYear(2020);
        date.setMonth(2);
        date.setDay(22);
        date.advanceOneWeek();
        assertEquals("02/29/2020", date.toString());
    }

    //passing a object with same date
    @Test
    public void testCustomDateEquals1() {
        CustomDate date = new CustomDate();
        Object obj = new CustomDate();
        assertEquals(true, date.equals(obj));
    }

    //pass a null statement
    @Test
    public void testCustomDateEquals2() {
        CustomDate date = new CustomDate();
        Object obj = null;
        assertEquals(false, date.equals(obj));
    }

    //pass a string statement
    @Test
    public void testCustomDateEquals3() {
        CustomDate date = new CustomDate();
        Object obj = "hello";
        assertEquals(false, date.equals(obj));
    }

    //passes a reference to different object
    @Test
    public void testCustomDateEquals4() {
        CustomDate date = new CustomDate();
        Object obj = new Object();
        assertEquals(false, date.equals(obj));
    }

    //passes a reference to same object
    @Test
    public void testCustomDateEquals5() {
        CustomDate date = new CustomDate();
        Object obj = new CustomDate();
        date.setYear(2002);
        date.setMonth(3);
        date.setDay(8);
        assertEquals(false, date.equals(obj));
    }

    //tests a date after
    @Test
    public void testCustomDateCompareTo1() {
        CustomDate date = new CustomDate();
        CustomDate obj = new CustomDate();
        obj.setYear(2021);
        obj.setMonth(2);
        obj.setDay(4);
        assertEquals(-1, date.compareTo(obj));
    }

    //tests a date before
    @Test
    public void testCustomDateCompareTo2() {
        CustomDate date = new CustomDate();
        CustomDate obj = new CustomDate();
        obj.setYear(1899);
        obj.setMonth(2);
        obj.setDay(4);
        assertEquals(1, date.compareTo(obj));
    }

    //tests a date that's the same
    @Test
    public void testCustomDateCompareTo3() {
        CustomDate date = new CustomDate();
        CustomDate obj = new CustomDate();
        assertEquals(0, date.compareTo(obj));
    }

    //tests a date slightly before
    @Test
    public void testCustomDateCompareTo4() {
        CustomDate date = new CustomDate();
        CustomDate obj = new CustomDate();
        obj.setYear(1899);
        obj.setMonth(2);
        obj.setDay(4);
        date.setYear(1899);
        date.setMonth(2);
        date.setDay(5);
        assertEquals(1, date.compareTo(obj));
    }

    //tests a date slightly before
    @Test
    public void testCustomDateCompareTo5() {
        CustomDate date = new CustomDate();
        CustomDate obj = new CustomDate();
        obj.setYear(1899);
        obj.setMonth(2);
        obj.setDay(4);
        date.setYear(1899);
        date.setMonth(1);
        date.setDay(5);
        assertEquals(-1, date.compareTo(obj));
    }

}
