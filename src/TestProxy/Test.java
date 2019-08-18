package TestProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Target target = new TargetImpl();
        DynamicProxyHandler handler = new DynamicProxyHandler(target);
        Target proxySubject = (Target) Proxy.newProxyInstance(
                TargetImpl.class.getClassLoader(),
                TargetImpl.class.getInterfaces(),
                handler);
        System.out.println(proxySubject.excute());
    }
}
