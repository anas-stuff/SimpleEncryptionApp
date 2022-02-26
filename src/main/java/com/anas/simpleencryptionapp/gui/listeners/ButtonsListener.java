package com.anas.simpleencryptionapp.gui.listeners;

import com.anas.simpleencryptionapp.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener extends AbstractListener implements ActionListener {
    public ButtonsListener(MainFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (super.getMainFrame().getProcessButton().equals(source)) {
            processText();
        } else if (super.getMainFrame().getClearButton().equals(source)) {
            clear();
        } else if (super.getMainFrame().getCopyProcessedTextButton().equals(source)) {
            copy();
        }
    }

    private void processText() {

    }

    private void clear() {

    }
    private void copy() {
    }
}
