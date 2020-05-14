# Java_proj0
 记第一次写Java和一次失败的行星系统。。。Java的学习，后端的开始！

### 前言

5月11日：在YouTube上找了一个数据结构的课[CS 61B Data Structures, Spring 2019](https://sp19.datastructur.es/)来看，发现是用的Java写的，并且前几节课在讲Java的一些语法和基本思想，就开始跟着学习Java。

5月12日：课程进度太快了，第一节课做了一些练习，第二节课的练习就直接写小项目了，直接跟着文档撸代码。于是有了本次的proj0--行星系统。

5月14日：跟着[文档](https://sp19.datastructur.es/materials/proj/proj0/proj0)撸完了。。

### 知识点

#### 5月11日

**跟着做了一点小练习：[Java/exercise.java](https://github.com/wusanshinb/MyCode/blob/master/Java/exercise.java)**

* 在Java中，一切皆对象，写main函数时必须有个主类，主类里面有个main函数。

* 打印句子的函数再次刷新我的三观，叫System.out.println()，System.out.print()，（前者将自动打印换行符），我以为printf就已经很奇怪了哈哈。

* 命令行：`javac hello.java`编译，，`java hello` 运行，，但是我在运行中遇到了问题，Google了很久，发现要先执`SET CLASSPATH=.`方能运行，具体情况如下：

![java](https://xiaoyaovo.cn/wp-content/uploads/2020/05/java.jpg)

* Java很多语法结构跟C语言很像，不过还是有区别，比如：在Java数组类中有length方法可直接计算数组长度；存在（Enhanced For Loop）（~~不知道怎么翻译Orz~~）可简化for循环语句的书写；

* Java里面的每个数据类型都是一个类，比如int[] a = new int[5];

* main函数的形参String[] args代表的是命令行的参数，比如`java hello hello world! 123`传入的是数组args = {"hello","world!","123"};

* static静态方法与non static非静态的区别：我了解到的是静态方法里面不能用类的操作，非静态可以操作对象，比如可以用this关键字。。。以后再细致的学习吧。

* 当时的笔记：

```
 1.Every Java file must contain a class declaration.
 2.You should define a main method using
    public static void main(String[] args)
 3.All code in Java must be part of class.
 4.All functions in Java are methods.
  1.Every method is associated with some class.
 2.To run a class, we must define a main method.
 3.Not all classes have a main method!
```

####  5月12日-14日

**跟着撸project**

​	此项目写了2个类，14个方法，其中包括main方法。

* **public class Body**

  Body类表示宇宙中的物体，一个具体的**实例**（instance）就是代表一个星球，拥有xxPods（x坐标），yyPods（y坐标），xxVel（x方向的速度），yyVel（y方向的速度），mass（质量），imgFileName（图像所在文件的名称）**属性**，其中还定义了一个静态的不可更改的常量G`public static final double G = 6.67e-11;`

* **public Body(double xP, double yP, double xV,double yV, double m, String img)**

  初始化一个**对象**，其中的**this**关键字应该对应的是Python中的**self**，表示访问对象的**属性**

* **public Body(Body b)**

  复制一个对象，这里的方法跟上面初始化Body重名了，用到的是**类的重载**（感谢马云豪学长的指点！）

* 下面定义了6个关于计算的函数（calc.....），用于计算行星之间的作用力，用于位置的更新，**返回值**都是Double类型。

* **public void update(double t,double Nx,double Ny)**

  计算在t时间内受到的作用力，并更新速度，加速度，位置信息。

* **public void draw()**

  画出对象的位置，其中用到了此项目骨架文件给出的StdDraw**库**，[官方文档](https://introcs.cs.princeton.edu/java/15inout/)，可用于简单的绘画。

* **public static double readRadius(String filename)**

  读取给定文件里面关于宇宙半径的数据并返回Double类型。

  这里学到了**文件的读取**操作：1.文件的读取必须包含在**try**语句块中；2.简单的行读取可以用FileReader(filename)、BufferedReader(fileReader)、reader.readline();；String转换为Double用到的是Double.parseDouble(String)；

* **public static Body[] readBodies(String filename)**

  读取给定文件中给定的星球的6个属性，并返回一个Body数组（数组的每个元素都是一个Body成员，这里有点像C语言中的结构体，但是又不一样，主要的思想是面向对象操作，你的一切操作都是在操作对象，数组是个对象，int是个对象，这里的Body也是对象），这里用到的并不是常规的文件读取，而是他给的一个简单读取文件的库**In**，这里给出[官方文档](https://introcs.cs.princeton.edu/java/stdlib/javadoc/In.html)。

* **public static void drawOnce(double radius,Body[] bodies)**

  画出所有的星球和宇宙的背景，同样用到了StdDraw库。

* **public static void main(String[] args)**

  首先在命令行读取宇宙运行的时间和星球每次运动的时间间隔和星球数据的文件名，后用嵌套循环打印宇宙。至此整个项目构建完毕。[具体代码](https://github.com/wusanshinb/Java_proj0/tree/master/src)。

### 总结

了解的大概的程序编写过程，学习了IDEA的基本操作和一些快捷键，学习了一些Java编程思想和一些基本语法，继续努力。

最后运行成功了，但是路径似乎跟现实的太阳系不大一样。。。我认为是物理模型和公式不够精确倒置的。。

运行截图：

![run_capture](https://xiaoyaovo.cn/wp-content/uploads/2020/05/run_capture.png)

[GitHub项目地址](https://github.com/wusanshinb/Java_proj0)

