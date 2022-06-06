package open_teamproject;

abstract class CompanyCoupon {
    protected Clothes clothes;

    public CompanyCoupon(Clothes clothes) {
        this.clothes = clothes;
    }
    // 2가지의 할인 존재 : 회사(~%), 카드(~원)

    // 회사별 고객 등급 확인
    public abstract String customer_grade();

    // 고객 등급별 할인쿠폰 [회사]
    public abstract void grade_discount(String customerGrade);

    // 이벤트에 따른 [회사]
    public abstract void event_day(String day);

    // 카드사 할인에 따른 [카드]
    public abstract int card_discount(String card);

    // 회사 할인 최대 혜택
    public abstract int discount_result_com();

    // 할인을 적용할 clothes 정보
    public void select_clothes_info() {
        System.out.println("카테고리명 : " + clothes.product_kind());
        System.out.println("상품명 : " + clothes.product_name());
        System.out.println("브랜드명 : " + clothes.brand());
        System.out.println("정상가 : " + clothes.price());
    }

    // 회사 OR 카드 할인 중 최대 할인
    public abstract float select_discount();

}
