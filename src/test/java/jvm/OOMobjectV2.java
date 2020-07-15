package jvm;

import java.util.ArrayList;
//-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8

//Heap
//        PSYoungGen      total 9216K, used 8192K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//           eden space 8192K, 100% used [0x00000007bf600000,0x00000007bfe00000,0x00000007bfe00000)
//           from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
//           to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
//        ParOldGen       total 10240K, used 10231K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//           object space 10240K, 99% used [0x00000007bec00000,0x00000007bf5fdcf0,0x00000007bf600000)
//        Metaspace       used 3115K, capacity 4496K, committed 4864K, reserved 1056768K
//           class space    used 342K, capacity 388K, committed 512K, reserved 1048576K



//-XX:+UseSerialGC


public class OOMobjectV2 {
    //生成1m的对象
    private byte[] bytes = new byte[64*1024];

    public static void main(String[] args) throws InterruptedException {
        fillHeap(10000);
    }

    private static void fillHeap(int num) throws InterruptedException {

        ArrayList<OOMobjectV2> ooMobjects = new ArrayList<OOMobjectV2>();
        for (int i = 0; i<num; i++) {
            Thread.sleep(50);
            ooMobjects.add(new OOMobjectV2());
        }

        System.gc();
    }
}