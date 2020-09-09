package com.buyalskaya.text.entity;

import java.util.List;

public interface BaseComponent {
    void add(BaseComponent component);

    void remove(BaseComponent component);

    ComponentName getComponentName();

    BaseComponent getChild(int index);

    List<BaseComponent> getChildren();

    int amountOfChild();

    String toString();
}