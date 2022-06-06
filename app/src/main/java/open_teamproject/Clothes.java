package open_teamproject;

public interface Clothes {
    public int gender(); // 남녀공용(0), 여성(1), 남성(2)

    public String product_kind(); // 상품 카테고리

    public String product_name(); // 상품 이름

    public String brand(); // 상품 브랜드

    public float price(); // 상품 가격
}
