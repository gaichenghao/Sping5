package com.atguigu.spring5;

public class Book {

    private String bname;
    private String bauthor;

    private String address;

    //set注入属性
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book(){
    }

    //有参构造注入属性
    public Book(String bname){
        this.bname=bname;
    }

    public void tsetBool1(){
        System.out.println(bname+"-"+bauthor+address);
    }


    public static void main(String[] args) {
        Book book=new Book();
        book.setBname("abc");
        Book book2 =new Book("abc");
    }


}
