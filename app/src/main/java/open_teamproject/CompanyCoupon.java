package open_teamproject;

abstract class CompanyCoupon {
    // 고객 등급에 따른
    public abstract void customer_grade();

    // 이벤트에 따른
    public abstract void event_day();

    // 카드사 할인에 따른
    public abstract void card_discount();
}
