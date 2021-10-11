package com.atguigu.spring5;

public class Orders {

    //属性
    private String oname;

    private String address;


    //有参数构造
    public Orders(String oname,String address){
        this.oname=oname;
        this.address=address;
    }

    public void tsetOrder1(){
        System.out.println(oname+"-"+address);
    }

}
