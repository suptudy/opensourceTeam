package open_teamproject;

public class InnerWear implements Clothes {

    @Override
    public int gender() {
        return 2;
    }

    @Override
    public String product_kind() {
        return "이너웨어";
    }

    @Override
    public String product_name() {
        return "남성 UA RUSH 런 스태미나 타이즈";
    }

    @Override
    public String brand() {
        return "언더아머";
    }

    @Override
    public float price() {
        return 69000;
    }

}
