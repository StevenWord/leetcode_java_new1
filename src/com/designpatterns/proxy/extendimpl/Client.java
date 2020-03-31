package com.designpatterns.proxy.interfaceimpl;

public class Client {
    public static void main(String[] arg){
        final Producer producer= new Producer();
        /*
        动态代理：
            特点：字节码随用随创建，随用随加载
            作用：在不修改源代码的基础上对代码进行增强。
            分类：基于接口的动态代理和基于子类的动态代理
            基于接口的动态代理
                涉及的类：Enhancer
                提供方：第三方类库chlib
            如何创建代理对象：
                使用Proxy类中的newProxyInstance方法
            使用要求：被代理类不能是最终类
            newProxyInstance的参数
                ClassLoader:
                    用于加载代理对象字节码的，和被代理对象使用相同的类加载器。
                Class[]：
                    字节码数组，让代理对象和被代理对象有相同的方法。通过两个类实现同一个接口
                InvocationHandler:
                    用于提供增强的代码，让我们写如何代理，一般写一个该接口的实现类，通常为
                    匿名内部类，但不是必须的，谁用谁写。

         */

    }
}
