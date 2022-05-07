import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Blocks {
    List<Block> listOfBlocks;

    public List<Block> getListOfBlocks() {
        return listOfBlocks;
    }

    public Blocks(String message) {
        this.listOfBlocks = createListOfBlock(message);
    }

    public List<Block> createListOfBlock(String message) {
        List<Block> blockList = new ArrayList<>();
        List<List<Byte>> outerList = new ArrayList<>();

        message = makeMessageDivisibleBySixteen(message);

        int sizeOfMessage = message.length();


        for(int i = 0; i < sizeOfMessage; i = i + 16) { // going through message and dividing message into 16 bytes

            String s = message.substring(i, i+16);

            List<Character> charList = convertStringToListOfCharacters(s);
            List<Byte> byteList = convertListOfCharsToListOfBytes(charList);
            outerList.add(byteList); // list of 16 bytes stored in outer List

        } // ex. OuterList: { { 16 bytes}, {16 bytes}, {16 bytes} }

        for(List<Byte> byteList : outerList) {
            blockList.add(new Block(byteList));
        }

        return blockList;



    }

    public static int howManyBlocksIsThisMessage(String message) {
        int size = message.length();

        int result = size/16;
        if(size % 16 > 0) result += 1;

        return result;
    }

    public static List<Byte> convertListOfCharsToListOfBytes(List<Character> listOfChars) {
        List<Byte> listOfBytes = new ArrayList<>();

        listOfChars.stream().forEach(ch -> {
            byte b = Character.toString(ch).getBytes()[0];

            listOfBytes.add(b);
        });

        return listOfBytes;

    }

    public String makeMessageDivisibleBySixteen(String message) {
        int size = message.length();
        if (size%16 != 0) {
            for(int i = size%16; i < 16; i++) {
                message += " ";
            }
        }

        return message;
    }

    public List<Character> convertStringToListOfCharacters(String s) {
        List<Character> charList = new ArrayList<>();

        int size = s.length();

        for(int i = 0; i < size; i++) {
            charList.add(s.charAt(i));
        }
        return charList;
    }



}
