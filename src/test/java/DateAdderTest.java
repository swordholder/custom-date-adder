import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateAdderTest {

    @Test
    public void test_date(){

        DateAdder dateAdder = new DateAdder();
        Date date = dateAdder.addDays(2010,2,25,7);
        Assertions.assertEquals(date.year,2010);
        Assertions.assertEquals(date.month,3);
        Assertions.assertEquals(date.day,4);

    }

    @Test
    public void test_negative_add_date(){

        DateAdder dateAdder = new DateAdder();
        Date date = dateAdder.addDays(2010,3,4,-7);
        Assertions.assertEquals(date.year,2010);
        Assertions.assertEquals(date.month,2);
        Assertions.assertEquals(date.day,25);

    }

    @Test
    public void test_negative_year_change(){

        DateAdder dateAdder = new DateAdder();
        Date date = dateAdder.addDays(2010,1,4,-7);
        Assertions.assertEquals(date.year,2009);
        Assertions.assertEquals(date.month,12);
        Assertions.assertEquals(date.day,28);
    }

    @Test
    public void test_positive_year_change(){

        DateAdder dateAdder = new DateAdder();
        Date date = dateAdder.addDays(2010,12,28,7);
        Assertions.assertEquals(date.year,2011);
        Assertions.assertEquals(date.month,1);
        Assertions.assertEquals(date.day,4);
    }
}
