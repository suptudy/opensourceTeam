package open_teamproject;

public class Hat implements Clothes {

    @Override
    public int gender() {
        return 0;
    }

    @Override
    public String product_kind() {
        return "모자";
    }

    @Override
    public String product_name() {
        return "레거시 91 테크 스우시 캡 볼캡 모자 892651";
    }

    @Override
    public String brand() {
        return "나이키";
    }

    @Override
    public float price() {
        return 15000;
    }

}
