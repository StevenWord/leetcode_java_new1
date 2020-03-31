package com.designpatterns.proxy.interfaceimpl;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] arg){
        /*原先的方式
        Producer producer = new Producer();
        producer.saleProduct(10000f);
         */
        /*
        动态代理：
            特点：字节码随用随创建，随用随加载
            作用：在不修改源代码的基础上对代码进行增强。
            分类：基于接口的动态代理和基于子类的动态代理
            基于接口的动态代理
                涉及的类：Proxy
                提供方：JDK官方
            如何创建代理对象：
                使用Proxy类中的newProxyInstance方法
            使用要求：被代理的类是少实现接口中的一种方法
            newProxyInstance的参数
                ClassLoader:
                    用于加载代理对象字节码的，和被代理对象使用相同的类加载器。
                Class[]：
                    字节码数组，让代理对象和被代理对象有相同的方法。通过两个类实现同一个接口
                InvocationHandler:
                    用于提供增强的代码，让我们写如何代理，一般写一个该接口的实现类，通常为
                    匿名内部类，但不是必须的，谁用谁写。

         */

        final Producer producer= new Producer();
        IProducer proxyproducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行别代理对象的所有接口方法都会经过该方法
                      * @param proxy    代理对象的引用
                     * @param method    当年前执行的方法
                     * @param args      当前执行方法的参数
                     * @return          和被代理对象方法的返回值的相同
                     * @throws Throwable
                     */
                @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //实现增强方法
                        //1获取方法参数：
                        Object returnvalue = null;
                        float money = (float)args[0];
                        //2判断当前方法是不是销售
                        if("saleProduct".equals(method.getName())){
                            returnvalue = method.invoke(producer,money*0.8f);
                        }
                        return returnvalue;
                    }
                });
        proxyproducer.saleProduct(10000);
    }
}
