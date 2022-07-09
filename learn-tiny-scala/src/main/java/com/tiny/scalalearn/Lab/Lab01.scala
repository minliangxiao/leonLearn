package com.tiny.scalalearn.Lab

/**
 * object 修饰的类表示这类是单列的，同时只有object 类的main方法才能直接被调用所以这也说明
 * 整个系统的main方法必须是在单列类中。
 * 同名的object 和class之间是伴侣关系  他们会在同一个目录下
 * 类和其 companion 对象可以互相访问对方的私有成员。
 */

class Lab01{
  private val  abc = "nihao"
}

object Lab01 {

  private var  sum = 0;
  def  add(byte: Byte):Unit=sum+=byte;
  def main(args: Array[String]): Unit = {
      val  map = Map[String,Int]()

    var a= new Lab01();

    add(11)
    println(sum)
    println(a.abc);
  }

}
