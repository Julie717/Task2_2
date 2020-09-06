package com.buyalskaya.text.entity;

import java.util.List;

public interface Component {
        void add(Component component);
        void remove(Component component);
        ComponentName getComponentName();
        Component getChild(int index);
        List<Component> getChildren();
        int amountOfChild();
        String toString();
}