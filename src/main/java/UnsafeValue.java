public class UnsafeValue {
    private int value;

    public int getNext(){
        return value++;
    }

    public static void main(String[] args) {
        UnsafeValue unsafeValue = new UnsafeValue();

        
        System.out.println(unsafeValue.getNext());
        System.out.println(unsafeValue.getNext());

    }
}
