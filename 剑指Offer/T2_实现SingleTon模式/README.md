## 单例模式

单例模式通用代码

```java
public class SingleTon {
    private static SingleTon instance = new SingleTon();
   
    private SingleTon() {

    }
    public static SingleTon getInstance() {
        return instance;
    }
}
```

通过private的构造方法,不让外界调用.确保SingleTon类在应用中只有一个实例类.



使用场景:  

- 要求一个类只能产生一个对象,如果出现多个对象,将对系统造成影响时,采用'单例模式' .


单例模式推荐的写法

1. 饿汉式

   ```java
   /**
    * Created by cyd on 19-4-3.
    * 饿汉式
    */
   
   public class SingleTon {
       private static SingleTon instance = new SingleTon();
   
       private SingleTon() {
   
       }
       public static SingleTon getInstance() {
           return instance;
       }
   }
   ```

   或者  

   ```java
   public class SingleTon {    
       //优化饿汉式
       static class Creator {
           private Creator() {
   
           }
           private static SingleTon instance = new SingleTon();
       }
       
       public static SingleTon getInstance() {
           return Creator.instance;
       }
       
   }
   ```

   下面的写法实现`按需分配`的思想,上面的写法会导致实例创建过早.

2. 懒汉式:

   ```java
   /**
    * Created by cyd on 19-4-3.
    * 懒汉式
    */
   
   public class LazySingleTon {
       private static LazySingleTon instance = null;
       private static Object lock = new Object();
       
       private LazySingleTon() {
   
       }
   
       public static  LazySingleTon getInstance() {
           if (instance == null) {
               synchronized (lock) {
                   if (instance == null) {
                       instance = new LazySingleTon();
                   }
               }
           }
           return instance;
       }
   }
   ```

   getInstance()方法中通过两次判断:

   第一次判断`instance`是否为空,为空的话就把锁给先来到的线程,再进入第二次判断.

   第一次判断不为空,则直接返回`instance`,不加上第一次判断就会造成不管`instance`是否已经存在,相关线程都花费时间等待上一个线程释放锁.

