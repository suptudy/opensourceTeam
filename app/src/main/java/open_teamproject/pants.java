package open_teamproject;

public class pants implements Clothes{
    @Override
    public int gender(){
        return 0;
    }; // 남녀공용(0), 여성(1), 남성(2)

    @Override
    public String product_kind(){  
        return "바지";
    }; // 상품 카테고리 

    @Override
    public String product_name(){
        return "나이키 조거 팬츠 NSW 클럽 하의 바지 트레이닝복 츄리닝";
    }; // 상품 이름

    @Override
    public String brand(){
        return "나이키";
    }; // 상품 브랜드

    @Override
    public float price(){
        return 34900;
    }; // 상품 가격
}
