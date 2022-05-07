import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Block {
    List<List<Byte>> block; // 2d block of data




    public Block(List<Byte> byteList) {
        this.block = createBlock(byteList);
    }

    public List<List<Byte>> createBlock(String sixteenByteMessage) {
        byte[] byteArray = sixteenByteMessage.getBytes(StandardCharsets.UTF_8);
        List<List<Byte>> outerList = new ArrayList<>();

        List<Byte> innerListOne = new ArrayList<>();
        List<Byte> innerListTwo = new ArrayList<>();
        List<Byte> innerListThree = new ArrayList<>();
        List<Byte> innerListFour = new ArrayList<>();

        for(int i = 0; i < byteArray.length; i++) {
            if(i < 4) innerListOne.add(byteArray[i]);
            else if(i < 8) innerListTwo.add(byteArray[i]);
            else if(i < 12) innerListThree.add(byteArray[i]);
            else innerListFour.add(byteArray[i]);
        }

        outerList.add(innerListOne);
        outerList.add(innerListTwo);
        outerList.add(innerListThree);
        outerList.add(innerListFour);
        return outerList;
    }

    public List<List<Byte>> createBlock(List<Byte> byteList ) {
        List<List<Byte>> outerList = new ArrayList<>();

        List<Byte> innerListOne = new ArrayList<>();
        List<Byte> innerListTwo = new ArrayList<>();
        List<Byte> innerListThree = new ArrayList<>();
        List<Byte> innerListFour = new ArrayList<>();

        for(int i = 0; i < byteList.size(); i++) {
            if(i % 4 == 0) innerListOne.add(byteList.get(i));
            else if(i%4 == 1) innerListTwo.add(byteList.get(i));
            else if(i%4 == 2) innerListThree.add(byteList.get(i));
            else if (i%4 == 3)innerListFour.add(byteList.get(i));
        }
        outerList.add(innerListOne);
        outerList.add(innerListTwo);
        outerList.add(innerListThree);
        outerList.add(innerListFour);
        return outerList;


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


    public List<List<Byte>> getBlock() {
        return block;
    }
}
