package com.anas.simpleencryptionapp.gui.listeners;

import com.anas.simpleencryptionapp.gui.MainFrame;

public abstract class AbstractListener {
    private final MainFrame mainFrame;

    public AbstractListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    protected MainFrame getMainFrame() {
        return mainFrame;
    }
}
