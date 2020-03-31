package com.designpatterns.listener;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private String buttonname;
    private List<Listener> mylisteners = new ArrayList<>();
    public void addListener(Listener listener){
        mylisteners.add(listener);
    }
    public void removeListener(Listener listener){
        mylisteners.remove(listener);
    }

    public String getButtonname() {
        return buttonname;
    }

    public void setButtonname(String buttonname) {
        this.buttonname = buttonname;
    }
    public void change(){
        for(Listener listener:mylisteners){
            if(listener instanceof OnClickListener)
                ((OnClickListener) listener).onClickListener();
            if(listener instanceof MouseOnListener)
               ((MouseOnListener) listener).mouseOnListener();
        }
        System.out.println("鼠标状态改变");
    }


}
