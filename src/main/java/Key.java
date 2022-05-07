import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Key {
    Block key;

    public Block getKey() {
        return key;
    }

    public Key() {
        List<Character> charList = new ArrayList<>();
        for(int i = 0; i < 16; i++) {
            Random random = new Random();
            char c = (char) (random.nextInt(26) + 'a');
            charList.add(c);
        }
        List<Byte> byteList = Blocks.convertListOfCharsToListOfBytes(charList);
        this.key = new Block(byteList);
    }

    public static List<Byte> circularRotation(List<Byte> byteList) {
        
    }


}
