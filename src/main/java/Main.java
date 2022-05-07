import java.nio.charset.StandardCharsets;

public class Main {

    public static int[] circularRotationToRight(int[] a, int numberOfRotations) {

        for(int rotations = 0; rotations < numberOfRotations; rotations++) {
            int size = a.length;
            int temp = a[size - 1];
            for(int i = size - 1; i > 0; i--) {
                a[i] = a[i-1];
            }
            a[0] = temp;

        }
        return a;
    }

    public static int[] circularRotationToLeft(int[] a, int numberOfRotations) {

        for(int rotations = 0; rotations < numberOfRotations; rotations++) {
            int size = a.length;
            int temp = a[0];
            for(int i = 0; i < a.length - 1; i++) {
                a[i] = a[i + 1];
            }
            a[size - 1] = temp;

        }
        return a;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        int[] array = {1,2,3,4,5,6};
        int[] newArray = circularRotationToLeft(array, 3);

//        byte[] byteArray= s.getBytes(StandardCharsets.UTF_8);
//        for(int i = 0; i < byteArray.length; i++) {
//            System.out.println(byteArray[i]);
//        }

//        Blocks blocks = new Blocks(s);

//        System.out.println("this is the size of block list: " + blocks.getListOfBlocks().size());
//        for(Block block : blocks.getListOfBlocks()) {
//            System.out.println(block.getBlock());
//        }

//        Key key = new Key();
//        System.out.println(key.getKey().getBlock());
        for(int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}
