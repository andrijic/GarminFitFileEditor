////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Dynastream Innovations Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2017 Dynastream Innovations Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 20.51Release
// Tag = production/akw/20.51.00-0-g012aa19
////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;


public enum Language {
   ENGLISH((short)0),
   FRENCH((short)1),
   ITALIAN((short)2),
   GERMAN((short)3),
   SPANISH((short)4),
   CROATIAN((short)5),
   CZECH((short)6),
   DANISH((short)7),
   DUTCH((short)8),
   FINNISH((short)9),
   GREEK((short)10),
   HUNGARIAN((short)11),
   NORWEGIAN((short)12),
   POLISH((short)13),
   PORTUGUESE((short)14),
   SLOVAKIAN((short)15),
   SLOVENIAN((short)16),
   SWEDISH((short)17),
   RUSSIAN((short)18),
   TURKISH((short)19),
   LATVIAN((short)20),
   UKRAINIAN((short)21),
   ARABIC((short)22),
   FARSI((short)23),
   BULGARIAN((short)24),
   ROMANIAN((short)25),
   CHINESE((short)26),
   JAPANESE((short)27),
   KOREAN((short)28),
   TAIWANESE((short)29),
   THAI((short)30),
   HEBREW((short)31),
   BRAZILIAN_PORTUGUESE((short)32),
   INDONESIAN((short)33),
   MALAYSIAN((short)34),
   VIETNAMESE((short)35),
   BURMESE((short)36),
   MONGOLIAN((short)37),
   CUSTOM((short)254),
    INVALID((short)255);

    protected short value;

    private Language(short value) {
        this.value = value;
    }

   public static Language getByValue(final Short value) {
      for (final Language type : Language.values()) {
         if (value == type.value)
            return type;
      }

      return Language.INVALID;
   }

    /**
     * Retrieves the String Representation of the Value
     * @return The string representation of the value
     */
   public static String getStringFromValue( Language value ) {
       return value.name();
   }

   public short getValue() {
      return value;
   }


}
