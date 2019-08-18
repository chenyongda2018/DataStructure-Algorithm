package TestProxy;

public class TargetImpl implements Target{
    @Override
    public String excute() {
        return "hello world";
    }
}
