package open_teamproject;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscountTest_you {
    CompanyCoupon coupon;
    Clothes clothes;

    @Before
    public void setUp() {
        clothes = new InnerWear();
        coupon = new AuctionMall(clothes, "유병권", 900000);
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
    public void test_AuctionMall_customer_grade() {
        assertEquals("sapphire", coupon.customer_grade());
    }

    @Test
    public void test_AuctionMall_discount_result_com1() {
        String customerGrade = coupon.customer_grade();
        coupon.grade_discount(customerGrade);
        assertEquals(10000, coupon.discount_result_com());
    }

    @Test
    public void test_AuctionMall_discount_result_com2() { // Friday 가정
        GetDayCalendar calendar = new GetDayCalendar(2022, 6, 10);
        String day = calendar.check();
        coupon.event_day(day);
        String customerGrade = coupon.customer_grade();
        coupon.grade_discount(customerGrade);

        assertEquals(15000, coupon.discount_result_com());
    }

    @Test
    public void test_AuctionMall_select_discount() {
        GetDayCalendar calendar = new GetDayCalendar(2022, 6, 7);
        String day = calendar.check();
        coupon.event_day(day);
        String customerGrade = coupon.customer_grade();
        coupon.grade_discount(customerGrade);
        coupon.discount_result_com();

        assertEquals(59000.0, coupon.select_discount(), 0.1);
        // 1 : 회사 할인
    }
    
}
