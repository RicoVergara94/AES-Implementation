public class GaloisField {
    public static Byte gAddition(Byte a, Byte b) {
        return (byte) (a^b);
    }
    public static Byte gSubtraction(Byte a, Byte b) {
        return (byte) (a^b);
    }

    public static Byte gMultiplication(Byte a, Byte b) {

        byte p = 0;
        for(int i = 0; i < 8; i++) { // run this loop 8 times
            if(isKthBitSet(b.intValue(), 1)) { // check if low bit is set on b, if it is then p = p ^ a
                 p = (byte)(a ^ p);
            }
            if(isKthBitSet((int)a,8)) {
                int aXored = a^27;
            }
            else {
                a = (byte)((int)a << 1);
            }
            b = (byte)((int)b >> 1);
        }

        return p;
    }

    public static boolean isKthBitSet(int n, int k) {
        if((n & (1 << (k - 1))) > 0) return true;
        else return false;
    }
}
