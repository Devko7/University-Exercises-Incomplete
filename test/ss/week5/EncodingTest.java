package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        // 5.7
        // The result changes by having more values in it. It's longer and the numbers and letters
        // are different.
        String input = "Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));

        // 5.8
        String hexString = "4d6f64756c652032";

        // Iterate through the char array, and for each pair of characters,
        // convert them to a byte by using the Integer.parseInt(string, radix) method,
        // where the string is the pair of characters and the radix is 16 for hex.
        byte[] byteArray = new byte[hexString.length() / 2];

        for (int i = 0; i < byteArray.length; i++) {
            int index = i * 2;
            int j = Integer.parseInt(hexString.substring(index, index + 2), 16);
            byteArray[i] = (byte) j;
        }

        String convertedInput = new String(byteArray);

        System.out.println(convertedInput);

        // 5.9a
        String baseString = "Hello World";

        String convertedBase = Base64.encodeBase64String(baseString.getBytes());
        System.out.println(convertedBase);

        //5.9b
        String hexBaseString = "010203040506";

        byte[] byteArray2 = new byte[hexBaseString.length() / 2];

        for (int i = 0; i < byteArray2.length; i++) {
            int index = i * 2;
            int j = Integer.parseInt(hexBaseString.substring(index, index + 2), 16);
            byteArray2[i] = (byte) j;
        }

        String encodedBaseString = Base64.encodeBase64String(byteArray2);
        System.out.println(encodedBaseString);

        // 5.9c
        String baseDecode = "U29mdHdhcmUgU3lzdGVtcw==";

        byte[] decodedBytes = Base64.decodeBase64(baseDecode);
        String convertedBaseBytes = new String(decodedBytes);

        System.out.println(convertedBaseBytes);

        // 5.9d
        String a1 = "a";
        String a2 = "aa";
        String a3 = "aaa";
        String a4 = "aaaa";
        String a10 = "aaaaaaaaaa";

        System.out.println(Base64.encodeBase64String(a1.getBytes()));
        System.out.println(Base64.encodeBase64String(a2.getBytes()));
        System.out.println(Base64.encodeBase64String(a3.getBytes()));
        System.out.println(Base64.encodeBase64String(a4.getBytes()));
        System.out.println(Base64.encodeBase64String(a10.getBytes()));
    }
}
