package com.ericsson.urm.util.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Encoder {
   static char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

   static String DEFAULT_ALGORITHM = "SHA";

   /**
    * This method encode a String into a SHA Digest.
    *
    * @param stream The String to be encoded
    * @return Returns a String of bytes.
    * @exception app.util.EncoderException
    */
   public static String encodeToByteString( String stream ) throws SHA1EncoderException {
      return new String( encodeToByteString( stream, DEFAULT_ALGORITHM ) );
   }

   /**
    * This method encode a String into a SHA Digest.
    *
    * @param stream The String to be encoded
    * @return Returns a String of hexadecimal values. Every digit is the
    * hexadecimal conversion of the original hash.
    * @exception app.util.EncoderException
    */
   public static String encodeToHexString( String stream ) throws SHA1EncoderException {
      return encodeToHexString( stream, DEFAULT_ALGORITHM );
   }

   /**
    * This method encode a String into a SHA or MD5 Digest.
    *
    * @param stream The String to be encoded
    * @param algorithm The hashing algorithm. It must be "SHA" or "MD5".
    * @exception app.util.EncoderException
    */

   public static byte[] encodeToByteString( String stream, String algorithm ) throws SHA1EncoderException {
      return encode( stream, algorithm );
   }

   /**
    * This method encode a String into a SHA Digest.
    *
    * @param stream The String to be encoded
    * @param algorithm The hashing algorithm. It must be "SHA" or "MD5".
    * @return Returns a String of hexadecimal values. Every digit is the
    * hexadecimal conversion of the original hash.
    * @exception app.util.EncoderException
    */
   public static String encodeToHexString( String stream, String algorithm ) throws SHA1EncoderException {
      byte[] digest = encode( stream, algorithm );

      return byteArrayToHexString( digest );
   }

   /**
    *
    * @param stream The String to be encoded
    * @param algorithm The hashing algorithm. It must be "SHA" or "MD5".
    * @return Returns an array of bytes.
    * @exception app.util.EncoderException
    */
   protected static byte[] encode( String stream, String algorithm ) throws SHA1EncoderException {
      MessageDigest SHA1 = null;

      try {
         SHA1 = MessageDigest.getInstance( algorithm );
      }
      catch ( NoSuchAlgorithmException e ) {
         throw new SHA1EncoderException( "Failed to encode - unrecognized algorithm" );
      }

      byte[] byteStream = stream.getBytes();
      byte[] aMessageDigest = SHA1.digest( byteStream );

      return aMessageDigest;
   } // encode

   /**
    * Converts a byte in its corresponding hexadecimal value.
    * @param b
    */
   static protected String byteToHex( byte b ) {
      // Returns hex String representation of byte b
      char[] array = {hexDigit[ ( b >> 4 ) & 0x0f], hexDigit[b & 0x0f]};
      return new String( array );
   }

   /**
    * Converts a byte array into an hex string
    * @param bytes The byte array
    * @return A String object
    */
   static public String byteArrayToHexString( byte[] bytes ) {
      String hexString = new String();

      for ( int idx = 0; idx < bytes.length; idx++ ) {
         hexString += byteToHex( bytes[idx] );
      }

      return hexString;
   }

   public static void main( String args[] ) {
      String s = "teistpa";
      try {
         System.out.println( "encoded: " + SHA1Encoder.encodeToHexString( s ) );
      }
      catch ( SHA1EncoderException ex ) {
      }
   }
}
