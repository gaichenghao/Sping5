package com.atguigu.spring5.testDemo;

import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.collectiontype.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBean2 {
    @Test
    public void test1(){
        //1加载spring配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean5.xml");

        //获取配置文件的对象
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }
}
