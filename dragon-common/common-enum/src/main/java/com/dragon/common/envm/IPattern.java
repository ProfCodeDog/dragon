package com.dragon.common.envm;

import java.util.regex.Pattern;

public interface IPattern {
    Pattern getPattern();

    String getMessage();
}