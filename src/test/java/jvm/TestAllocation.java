package jvm;

public class TestAllocation {
    private static final  int _1MB = 1024*1024;
/*
-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC


[GC (Allocation Failure) [DefNew: 6177K->463K(9216K), 0.0058735 secs] 6177K->4560K(19456K), 0.0059003 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
Heap
 def new generation   total 9216K, used 6929K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 allcation1,allcation2,allcation1各占用2M,一共6M.在DefNew中
 allcation4大小4M,DefNew中放不下,gc. DefNew中的数据一共6M,Survivor中放不下,把其中4M放到了老年代中.还剩下2M.把allcation4放进DefNew中,正好6M
  eden space 8192K,  78% used [0x00000007bec00000, 0x00000007bf2504c8, 0x00000007bf400000)
  from space 1024K,  45% used [0x00000007bf500000, 0x00000007bf573ff0, 0x00000007bf600000)
  to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
   the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00020, 0x00000007bfa00200, 0x00000007c0000000)
 Metaspace       used 3071K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 337K, capacity 388K, committed 512K, reserved 1048576K


/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/bin/java -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseParallelGC
"-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=54781:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/tools.jar:/Users/yan.zhang/Downloads/OpenSource/ReadSpringSource/target/test-classes:/Users/yan.zhang/Downloads/OpenSource/ReadSpringSource/target/classes:/Users/yan.zhang/.m2/repository/junit/junit/4.10/junit-4.10.jar:/Users/yan.zhang/.m2/repository/org/hamcrest/hamcrest-core/1.1/hamcrest-core-1.1.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-context/4.2.5.RELEASE/spring-context-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-beans/4.2.5.RELEASE/spring-beans-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-core/4.2.5.RELEASE/spring-core-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-expression/4.2.5.RELEASE/spring-expression-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/projectlombok/lombok/1.16.6/lombok-1.16.6.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-jdbc/4.2.5.RELEASE/spring-jdbc-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-tx/4.2.5.RELEASE/spring-tx-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-aop/4.2.5.RELEASE/spring-aop-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-aspects/4.2.5.RELEASE/spring-aspects-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/aspectj/aspectjweaver/1.8.8/aspectjweaver-1.8.8.jar:/Users/yan.zhang/.m2/repository/commons-dbcp/commons-dbcp/1.4/commons-dbcp-1.4.jar:/Users/yan.zhang/.m2/repository/commons-pool/commons-pool/1.5.4/commons-pool-1.5.4.jar:/Users/yan.zhang/.m2/repository/org/mybatis/mybatis/3.3.0/mybatis-3.3.0.jar:/Users/yan.zhang/.m2/repository/org/mybatis/mybatis-spring/1.2.2/mybatis-spring-1.2.2.jar:/Users/yan.zhang/.m2/repository/mysql/mysql-connector-java/8.0.13/mysql-connector-java-8.0.13.jar:/Users/yan.zhang/.m2/repository/com/google/protobuf/protobuf-java/3.6.1/protobuf-java-3.6.1.jar jvm.TestAllocation

[GC (Allocation Failure) [PSYoungGen: 6177K->608K(9216K)] 6177K->4712K(19456K), 0.0115919 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
Heap
 PSYoungGen      total 9216K, used 6988K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 8192K, 77% used [0x00000007bf600000,0x00000007bfc3b3b0,0x00000007bfe00000)
  from space 1024K, 59% used [0x00000007bfe00000,0x00000007bfe98000,0x00000007bff00000)
  to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 ParOldGen       total 10240K, used 4104K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  object space 10240K, 40% used [0x00000007bec00000,0x00000007bf002020,0x00000007bf600000)
 Metaspace       used 3081K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 339K, capacity 388K, committed 512K, reserved 1048576K



/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/bin/java -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseParNewGC "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=54805:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/lib/tools.jar:/Users/yan.zhang/Downloads/OpenSource/ReadSpringSource/target/test-classes:/Users/yan.zhang/Downloads/OpenSource/ReadSpringSource/target/classes:/Users/yan.zhang/.m2/repository/junit/junit/4.10/junit-4.10.jar:/Users/yan.zhang/.m2/repository/org/hamcrest/hamcrest-core/1.1/hamcrest-core-1.1.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-context/4.2.5.RELEASE/spring-context-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-beans/4.2.5.RELEASE/spring-beans-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-core/4.2.5.RELEASE/spring-core-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-expression/4.2.5.RELEASE/spring-expression-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/projectlombok/lombok/1.16.6/lombok-1.16.6.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-jdbc/4.2.5.RELEASE/spring-jdbc-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-tx/4.2.5.RELEASE/spring-tx-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-aop/4.2.5.RELEASE/spring-aop-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:/Users/yan.zhang/.m2/repository/org/springframework/spring-aspects/4.2.5.RELEASE/spring-aspects-4.2.5.RELEASE.jar:/Users/yan.zhang/.m2/repository/org/aspectj/aspectjweaver/1.8.8/aspectjweaver-1.8.8.jar:/Users/yan.zhang/.m2/repository/commons-dbcp/commons-dbcp/1.4/commons-dbcp-1.4.jar:/Users/yan.zhang/.m2/repository/commons-pool/commons-pool/1.5.4/commons-pool-1.5.4.jar:/Users/yan.zhang/.m2/repository/org/mybatis/mybatis/3.3.0/mybatis-3.3.0.jar:/Users/yan.zhang/.m2/repository/org/mybatis/mybatis-spring/1.2.2/mybatis-spring-1.2.2.jar:/Users/yan.zhang/.m2/repository/mysql/mysql-connector-java/8.0.13/mysql-connector-java-8.0.13.jar:/Users/yan.zhang/.m2/repository/com/google/protobuf/protobuf-java/3.6.1/protobuf-java-3.6.1.jar jvm.TestAllocation
Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the Serial old collector is deprecated and will likely be removed in a future release
[GC (Allocation Failure) [ParNew: 6177K->507K(9216K), 0.0035124 secs] 6177K->4603K(19456K), 0.0035411 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
Heap
 par new generation   total 9216K, used 6888K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K,  77% used [0x00000007bec00000, 0x00000007bf23b3b0, 0x00000007bf400000)
  from space 1024K,  49% used [0x00000007bf500000, 0x00000007bf57edd8, 0x00000007bf600000)
  to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
   the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00020, 0x00000007bfa00200, 0x00000007c0000000)
 Metaspace       used 3081K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 339K, capacity 388K, committed 512K, reserved 1048576K

Process finished with exit code 0


 */
    public static void main(String[] args) {

            byte[] allcation1,allcation2,allcation3,allcation4;
            allcation1 = new byte[2*_1MB];
            allcation2 = new byte[2*_1MB];
            allcation3 = new byte[2*_1MB];
            allcation4 = new byte[4*_1MB];//minor gc
//        while (true) {
//            String s = new String("333333333");
//            s = s + new String("111111");
//        }

    }
}
