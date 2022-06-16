package open_teamproject;

import java.util.HashMap;
import java.util.Map;

public class AuctionMall extends CompanyCoupon {
    public int discount_com_a = 0; // 회사 원 단위 할인
    public int discount_com_m = 0; // 회사 퍼센트 단위 할인
    private String customer;
    private int amountUsed;

    public AuctionMall(Clothes clothes, String customer, int amountUsed) {
        super(clothes);
        this.customer = customer;
        this.amountUsed = amountUsed;
    }

    @Override
    public String customer_grade() {
        System.out.print(customer + "님의 Hmall 등급은 ");

        int vip = 2000000; // 200만원 이상
        int diamond = 1200000; // 120만원 이상
        int sapphire = 800000; // 80만원 이상
        int gold = 500000; // 50만원 이상
        int silver = 300000; // 30만원 이상

        String customerGrade = "silver";
        if (amountUsed < gold) {
            System.out.println(", [silver 등급] 입니다.");
        } else if (gold <= amountUsed & amountUsed < sapphire) {
            System.out.println(", [gold 등급] 입니다.");
            customerGrade = "gold";
        } else if (sapphire <= amountUsed & amountUsed < diamond) {
            System.out.println(", [sapphire 등급] 입니다.");
            customerGrade = "sapphire";
        } else if (diamond <= amountUsed & amountUsed < vip) {
            System.out.println(", [diamond 등급] 입니다.");
            customerGrade = "diamond";
        } else {
            System.out.println(", [vip 등급] 입니다.");
            customerGrade = "vip";
        }
        System.out.println("누적 사용 금액은 " + amountUsed + "입니다.");
        System.out.println();
        return customerGrade;
    }

    @Override
    public void grade_discount(String cumstomerGrade) {
        if (cumstomerGrade == "silver") {
            System.out.println("3000원 할인 쿠폰 1장.");
            discount_com_a += 3000;
        } else if (cumstomerGrade == "gold") {
            System.out.println("5000원 할인 쿠폰 1장");
            discount_com_a += 5000;
        } else if (cumstomerGrade == "sapphire") {
            System.out.println("5000원 할인 쿠폰 2장");
            discount_com_a += 10000;
        } else if (cumstomerGrade == "diamond") {
            System.out.println("10000원 할인 쿠폰 1장");
            discount_com_a += 10000;
        } else { // vip
            System.out.println("10000원 할인 쿠폰 2장");
            discount_com_a += 20000;
        }
    }

    @Override
    public void event_day(String day) {
        if (day == "Friday") {
            System.out.println("클럽데이 20%할인 쿠폰 증정(위 등급멤버쉽 쿠폰을 사용한 후에 사용가능)");
            discount_com_m += 20;
        }

    }

    @Override
    public int card_discount(String card) {
        int discount_card = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("삼성카드", 10);
        map.put("스마일카드", 10);

        if (map.containsKey(card)) {
            discount_card = (int) map.get(card);
            System.out.println("선택하신 " + card + "로 " + discount_card + "원 할인 가능");
            discount_com_m +=10;
        }

        return discount_card;
    }

    @Override
    public int discount_result_com() {
        float WonResult = clothes.price() - discount_com_a;
        float cardResult = (float) (clothes.price() * ((100 - discount_com_m) * 0.01));
        if(WonResult>cardResult){
            System.out.println("쇼핑몰 최대 할인 가능 : " + discount_com_a + "원");
            System.out.println();
            return discount_com_a;
        }else{
            System.out.println("쇼핑몰 최대 할인 가능 : " + discount_com_m + "%");
            System.out.println();
            return discount_com_m;
        }
    }

    @Override
    public float select_discount() {
        float WonResult = clothes.price() - discount_com_a;
        float cardResult = (float) (clothes.price() * ((100 - discount_com_m) * 0.01));
        System.out.println();
        System.out.println("----- 최대 할인 적용 결과 -----");
        if (WonResult > cardResult) {
            System.out.println("[쇼핑몰할인] 최종 금액 : " + WonResult + "원");
            return WonResult;
        } else {
            System.out.println("[카드할인] 최종 금액 : " + cardResult + "원");
            return cardResult;
        }
    }

}
