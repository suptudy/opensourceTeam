package open_teamproject;

import java.util.HashMap;
import java.util.Map;

public class SSG extends CompanyCoupon{
    public int discount_com = 0; // 회사 할인
    private String customer;
    private int amountUsed;

    public SSG(Clothes clothes, String customer, int amountUsed) {
        super(clothes);
        this.customer = customer;
        this.amountUsed = amountUsed;
    }

    @Override
    public String customer_grade() {
        System.out.print(customer + "님의 SSG 등급은 ");

        int diamond = 800000; // 80만원 이상
        int platinum = 500000; // 30만원 이상
        int gold = 300000; // 10만원 이상
        int silver = 100000; // 10만원 이상
        int bronze = 0; // 미주문

        String customerGrade = "bronze";
        if (amountUsed < bronze) {
            System.out.println(", [bronze 등급] 입니다.");
        } 
          else if(silver <= amountUsed & amountUsed < gold){
            System.err.println("[silver 등급 입니다.");
          }
          else if (gold <= amountUsed & amountUsed < platinum) {
            System.out.println(", [gold 등급] 입니다.");
            customerGrade = "gold";
        } else if (platinum <= amountUsed & amountUsed < diamond) {
            System.out.println(", [platinum 등급] 입니다.");
            customerGrade = "platinum";
        } else {
            System.out.println(", [diamond 등급] 입니다.");
            customerGrade = "diamond";
        }
        System.out.println("누적 사용 금액은 " + amountUsed + "입니다.");
        System.out.println();
        return customerGrade;
    }

    @Override
    public void grade_discount(String cumstomerGrade) {
        if (cumstomerGrade == "bronze"){
            System.out.println("등급별 추가 할인 혜택이 존재하지 않습니다.");
        }
        if (cumstomerGrade == "silver") {
            System.out.println("20000원 이상 1000원 할인 쿠폰 1장.");
        } else if (cumstomerGrade == "gold") {
            System.out.println("20000원 이상 2000원 할인 쿠폰 1장");
            discount_com += 10;
        } else if (cumstomerGrade == "platinum") {
            System.out.println("금액 상관없이 10% 할인 쿠폰 1장(최대 할인 금액 50000원");
            discount_com += 15;
        } else { // diamond
            System.out.println("금액 상관없이 20% 할인 쿠폰 1장(최대 할인금액 50000원");
            discount_com += 20;
        }
    }

    @Override
    public void event_day(String day) {
        if (day == "Wednesday") {
            System.out.println("수요일 행사로 20000원 이상 구매시 해당금액의 10% 적립");
            discount_com += 3;
        }

    }

    @Override
    public int card_discount(String card) {
        int discount_card = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("신한카드", 5000);
        map.put("롯데카드", 5000);
        map.put("하나카드", 5000);
        map.put("KB국민", 5000);
        map.put("카카오페이", 5000);

        if (map.containsKey(card)) {
            discount_card = (int) map.get(card);
            System.out.println("선택하신 " + card + "로 " + discount_card + "원 할인 가능");
        }

        return discount_card;
    }

    @Override
    public int discount_result_com() {
        System.out.println("쇼핑몰 최대 할인 가능 : " + discount_com + "%");
        System.out.println();
        return discount_com;
    }

    @Override
    public float select_discount() {
        float comResult = (float) (clothes.price() * ((100 - discount_com) * 0.01));
        float cardResult = clothes.price() - 5000;
        System.out.println();
        System.out.println("----- 최대 할인 적용 결과 -----");
        if (comResult > cardResult) {
            System.out.println("[쇼핑몰할인] 최종 금액 : " + comResult + "원");
            return comResult;
        } else {
            System.out.println("[카드할인] 최종 금액 : " + cardResult + "원");
            return cardResult;
        }
    }

    
}
