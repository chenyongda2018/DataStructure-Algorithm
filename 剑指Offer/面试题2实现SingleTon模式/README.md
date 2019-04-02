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

