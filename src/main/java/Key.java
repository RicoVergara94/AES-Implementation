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

    public static List<Byte> circularRotationToRight(List<Byte> byteList, int numberOfRotations) {

        for(int rotations = 0; rotations < numberOfRotations; rotations++) {
            int size = byteList.size();
            Byte temp = byteList.get(size - 1);
            for(int i = size - 1; i > 0; i--) {
                byteList.set(i, byteList.get(i - 1));
            }
            byteList.set(0, temp);

        }
        return byteList;
    }

    public static List<Byte> circularRotationToLeft(List<Byte> byteList, int numberOfRotations) {

        for(int rotations = 0; rotations < numberOfRotations; rotations++) {
            int size = byteList.size();
            Byte temp = byteList.get(0);
            for(int i = 0; i < size - 1; i++) {
                byteList.set(i, byteList.get(i + 1));
            }
            byteList.set(size-1, temp);

        }
        return byteList;
    }


}
