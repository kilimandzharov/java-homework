package com.kirillmozharov.model;

import com.kirillmozharov.util.ElementEnum;

public interface AbstractElementFactory {
    LogicElement getInstance(int n);
}
