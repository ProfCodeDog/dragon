package com.dragon.common.util.validate;

import com.dragon.common.envm.IPattern;
import com.dragon.common.envm.ISuffixCode;
import com.dragon.common.exception.IllegalArgException;

public class ValidateUtil {


    public static void validate(IPattern pattern,
                                String input,
                                ISuffixCode suffixCode) {
        if (!pattern.getPattern().matcher(input).matches()) {
            throw new IllegalArgException(suffixCode);
        }
    }

    public static void validateWithTrim(IPattern pattern,
                                        String input,
                                        ISuffixCode suffixCode) {
        if (!pattern.getPattern().matcher(input.trim()).matches()) {
            throw new IllegalArgException(suffixCode);
        }
    }


    public static void validateCanNull(IPattern pattern,
                                       String input,
                                       ISuffixCode suffixCode) {
        if (null == input || input.length() == 0) {
            return;
        }
        if (!pattern.getPattern().matcher(input).matches()) {
            throw new IllegalArgException(suffixCode);
        }
    }

    public static void validateCanTrimNull(IPattern pattern,
                                           String input,
                                           ISuffixCode suffixCode) {
        if (null == input) {
            return;
        }
        input = input.trim();
        if (input.length() == 0) {
            return;
        }
        if (!pattern.getPattern().matcher(input.trim()).matches()) {
            throw new IllegalArgException(suffixCode);
        }
    }

    public static void validateCanNotNull(IPattern pattern,
                                          String input,
                                          ISuffixCode suffixCodeNull,
                                          ISuffixCode suffixCodePattern) {
        if (null == input || input.length() == 0) {
            throw new IllegalArgException(suffixCodeNull);
        }
        if (!pattern.getPattern().matcher(input).matches()) {
            throw new IllegalArgException(suffixCodePattern);
        }
    }

    public static void validateCanNotTrimNull(IPattern pattern,
                                              String input,
                                              ISuffixCode suffixCodeNull,
                                              ISuffixCode suffixCodePattern) {
        if (null == input) {
            throw new IllegalArgException(suffixCodeNull);
        }
        input = input.trim();
        if (input.length() == 0) {
            throw new IllegalArgException(suffixCodeNull);
        }

        if (!pattern.getPattern().matcher(input).matches()) {
            throw new IllegalArgException(suffixCodePattern);
        }
    }
}
