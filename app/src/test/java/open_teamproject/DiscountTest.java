package open_teamproject;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscountTest {
    CompanyCoupon coupon;

    @Before
    public void setUp() {
        coupon = new Hmall("권수빈", 300000);
    }

    @After
    public void tearDown() {
        coupon = null;
    }

    @Test
    public void test_calculator() {
        GetDayCalendar calendar = new GetDayCalendar(2022, 6, 7);
        assertEquals("Tuesday", calendar.check());
    }

    @Test
    public void test_Hmall_customer_grade() {
        assertEquals("gold", coupon.customer_grade());
    }

    @Test
    public void test_Hmall_discount_result_com1() {
        String customerGrade = coupon.customer_grade();
        coupon.grade_discount(customerGrade);
        assertEquals(10, coupon.discount_result_com());
    }

    @Test
    public void test_Hmall_discount_result_com2() { // wendnesday 가정
        GetDayCalendar calendar = new GetDayCalendar(2022, 6, 8);
        String day = calendar.check();
        coupon.event_day(day);
        String customerGrade = coupon.customer_grade();
        coupon.grade_discount(customerGrade);

        assertEquals(13, coupon.discount_result_com());
    }
}
