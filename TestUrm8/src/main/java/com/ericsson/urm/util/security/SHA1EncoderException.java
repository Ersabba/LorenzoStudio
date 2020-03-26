package com.ericsson.urm.util.security;


public class SHA1EncoderException extends RuntimeException {
   private final String CLASS_NAME = "EncoderException";

   /**
    * Exception constructor
    * @param msg Error message
    */
   public SHA1EncoderException( String msg ) {
      super( msg );
   }
}
