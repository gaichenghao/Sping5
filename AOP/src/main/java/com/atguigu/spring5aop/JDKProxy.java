package com.atguigu.spring5aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {



    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfances={UserDao.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfances, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl userDao=new UserDaoImpl();
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfances, new UserDaoProxy(userDao));
        int add1 = dao.add(1, 2);
        dao.update("1111");
        System.out.println(add1);


    }
}
//创建代理对象代码
class  UserDaoProxy implements InvocationHandler{

    //1 把创建的代理对象的主人 把主人传进来
    //有参构造传递
    private Object obj;
    public UserDaoProxy(Object object){
        this.obj=object;

    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //方法之前


        System.out.println("方法之前执行。。。"+method.getName()+":传递的参数"+ Arrays.toString(args));


        //方法执行
        Object invoke = method.invoke(obj, args);

        //方法之后

        System.out.println("方法之后执行。。。"+obj);
        return invoke;
    }
}
