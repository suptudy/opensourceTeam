package open_teamproject;

abstract class CompanyCoupon {
    // 2가지의 할인 존재 : 회사(~%), 카드(~원)

    // 회사별 고객 등급 확인
    public abstract String customer_grade();

    // 고객 등급별 할인쿠폰 [회사]
    public abstract void grade_discount(String customerGrade);

    // 이벤트에 따른 [회사]
    public abstract void event_day(String day);

    // 카드사 할인에 따른 [카드]
    public abstract int card_discount(String card);
}
