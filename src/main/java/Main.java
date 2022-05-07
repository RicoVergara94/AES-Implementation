import java.nio.charset.StandardCharsets;

public class Main {



    public static void main(String[] args) {
        String s = "Hello World";
//        byte[] byteArray= s.getBytes(StandardCharsets.UTF_8);
//        for(int i = 0; i < byteArray.length; i++) {
//            System.out.println(byteArray[i]);
//        }

//        Blocks blocks = new Blocks(s);

//        System.out.println("this is the size of block list: " + blocks.getListOfBlocks().size());
//        for(Block block : blocks.getListOfBlocks()) {
//            System.out.println(block.getBlock());
//        }

        Key key = new Key();
        System.out.println(key.getKey().getBlock());
    }
}
