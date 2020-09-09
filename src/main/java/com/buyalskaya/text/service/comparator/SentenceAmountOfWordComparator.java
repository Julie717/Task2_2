package com.buyalskaya.text.service.comparator;

import com.buyalskaya.text.entity.BaseComponent;
import com.buyalskaya.text.service.ServiceFactory;

import java.util.Comparator;

public class SentenceAmountOfWordComparator implements Comparator<BaseComponent> {
    @Override
    public int compare(BaseComponent c1, BaseComponent c2) {
        int countWords1 = ServiceFactory.getInstance().getComponentService().countWordsInSentence(c1);
        int countWords2 = ServiceFactory.getInstance().getComponentService().countWordsInSentence(c2);
        if (countWords1 < countWords2) {
            return -1;
        } else if (countWords1 > countWords2) {
            return 1;
        } else {
            return 0;
        }
    }
}