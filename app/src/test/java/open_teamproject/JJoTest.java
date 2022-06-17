package open_teamproject;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JJoTest {
    CompanyCoupon coupon;
    Clothes clothes;

    @Before
    public void setUp() {
        clothes = new pants();
        coupon = new Jmall(clothes, "조아라", 500000);
    }

    @After
    public void tearDown() {
        coupon = null;
    }

    @Test
    public void test_calculator() {
        GetDayCalendar calendar = new GetDayCalendar(2022, 6, 4);
        assertEquals("Saturday", calendar.check());
    }

    @Test
    public void test_calculator1() {
        GetDayCalendar calendar = new GetDayCalendar(2022, 6, 8);
        assertEquals("Wednesday", calendar.check());
    }

    @Test
    public void test_Jmall_customer_grade() {
        assertEquals("platinum", coupon.customer_grade());
    }

    @Test
    public void test_Jall_discount_result_com1() {
        String customerGrade = coupon.customer_grade();
        coupon.grade_discount(customerGrade);
        assertEquals(20, coupon.discount_result_com());
    }

    @Test
    public void test_Jmall_discount_result_com2() { // Saturday 가정
        GetDayCalendar calendar = new GetDayCalendar(2022, 6, 8);
        String day = calendar.check();
        coupon.event_day(day);
        String customerGrade = coupon.customer_grade();
        coupon.grade_discount(customerGrade);

        assertEquals(20, coupon.discount_result_com());
    }

    @Test
    public void test_Jmall_select_discount() {
        GetDayCalendar calendar = new GetDayCalendar(2022, 6, 7);
        String day = calendar.check();
        coupon.event_day(day);
        String customerGrade = coupon.customer_grade();
        coupon.grade_discount(customerGrade);
        coupon.discount_result_com();

        assertEquals(29900.0, coupon.select_discount(), 0.1);
        // 1 : 회사 할인
    }
}
