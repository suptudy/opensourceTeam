package open_teamproject;

public class Clothes_Top implements Clothes {

    @Override
    public int gender() {
        return 0;
    }

    @Override
    public String product_kind() {
        return "Top";
    }

    @Override
    public String product_name() {
        return "newbalance UNI short top";
    }

    @Override
    public String brand() {
        return "newbalance";
    }

    @Override
    public float price() {
        return 69900;
    }
    
}
