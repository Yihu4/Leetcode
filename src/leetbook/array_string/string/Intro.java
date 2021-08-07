package leetbook.array_string.string;

/**
 * @author: mete0ra
 * @create: 2021-08-05 09:57
 */
public class Intro {
    public static void main(String[] args) {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        // 重点
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
        // str创造了"a",在常量池中创造"a"
        // 当执行第二个语句时, 因为常量池中有"a", 所以去寻找栈中对应的地址, 把str的地址赋值给 str1
        String str = "a";
        String str1 = "a";
        System.out.println(str == str1);
        String hello = "Hello";
        String lo = "lo";
        //true. 两个都是常量表达式，都是指向字符串池的引用
        System.out.println(hello == ("Hel" + "lo"));
        //false.  后者不是常量表达式，是运行时通过串联计算的字符串（lo是一个对象，不是常亮"xxx"），会新建对象
        System.out.println(hello == ("Hel" + lo));


        
    }
}
