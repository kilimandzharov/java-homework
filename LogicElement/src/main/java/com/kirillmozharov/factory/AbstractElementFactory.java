package com.kirillmozharov.factory;

import com.kirillmozharov.model.LogicElement;
import com.kirillmozharov.util.ElementEnum;

public interface AbstractElementFactory {
    LogicElement getInstance(int n);
}
