package strategy;

public class NullTuple extends Tuple{
    public boolean Null;

    public NullTuple(int points, boolean achievedTutto) {
        super(points, achievedTutto);
        Null = false;
    }
}
