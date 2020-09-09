package com.buyalskaya.text.service.comparator;

import com.buyalskaya.text.entity.BaseComponent;
import com.buyalskaya.text.entity.ComponentName;
import com.buyalskaya.text.service.ServiceFactory;

import java.util.Comparator;

public class WordOnVowelProportionComparator implements Comparator<BaseComponent> {
    @Override
    public int compare(BaseComponent w1, BaseComponent w2) {
        int countVowels1 = ServiceFactory.getInstance().getComponentService().countVowelsInWord(w1);
        int countLetters1 = ServiceFactory.getInstance().getComponentService().find(w1, ComponentName.LETTER).size();
        int countVowels2 = ServiceFactory.getInstance().getComponentService().countVowelsInWord(w2);
        int countLetters2 = ServiceFactory.getInstance().getComponentService().find(w2, ComponentName.LETTER).size();
        double vowelsToAll1 = (double) countVowels1 / (double) countLetters1;
        double vowelsToAll2 = (double) countVowels2 / (double) countLetters2;
        if (vowelsToAll1 < vowelsToAll2) {
            return -1;
        } else if (vowelsToAll1 > vowelsToAll2) {
            return 1;
        } else {
            return 0;
        }
    }
}