package com.buyalskaya.text.entity.impl;

import com.buyalskaya.text.entity.Component;
import com.buyalskaya.text.entity.ComponentName;

import java.util.List;

public class Symbol implements Component {
    ComponentName componentName;
    private char symbol;

    public Symbol(char symbol, ComponentName componentName) {
        this.componentName = componentName;
        this.symbol = symbol;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
    }

    @Override
    public ComponentName getComponentName() {
        return componentName;
    }

    @Override
    public Component getChild(int index) {
        return null;
    }

    @Override
    public List<Component> getChildren() {
        return null;
    }

    @Override
    public int amountOfChild() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Symbol symbol = (Symbol) obj;
        return (componentName == symbol.componentName) &&
                (Character.toString(this.symbol).toUpperCase()
                        .equals(Character.toString(symbol.symbol).toUpperCase()));
    }

    @Override
    public int hashCode() {
        return Character.toString(this.symbol).toUpperCase().hashCode() * 31 + componentName.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}