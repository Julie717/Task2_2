package com.buyalskaya.text.entity.impl;

import com.buyalskaya.text.entity.Component;
import com.buyalskaya.text.entity.ComponentName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TextComponent implements Component {
    ComponentName componentName;
    List<Component> childComponents = new ArrayList<>();

    public TextComponent(ComponentName componentName) {
        this.componentName = componentName;
    }

    @Override
    public void add(Component component) {
        childComponents.add(component);
    }

    @Override
    public void remove(Component component) {
        childComponents.remove(component);
    }

    @Override
    public ComponentName getComponentName() {
        return componentName;
    }

    @Override
    public Component getChild(int index) {
        return childComponents.get(index);
    }

    @Override
    public List<Component> getChildren() {
        return Collections.unmodifiableList(childComponents);
    }

    @Override
    public int amountOfChild() {
        return childComponents.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        TextComponent textComponent = (TextComponent) obj;
        return (componentName == textComponent.componentName) &&
                (childComponents.equals(textComponent.childComponents));
    }

    @Override
    public int hashCode() {
        return childComponents.hashCode() +componentName.hashCode()*31;
    }

    @Override
    public String toString() {
        return childComponents.stream().map(ch -> ch.toString()).collect(Collectors.joining());
    }
}