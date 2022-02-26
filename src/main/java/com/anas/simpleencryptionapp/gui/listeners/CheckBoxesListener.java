package com.anas.simpleencryptionapp.gui.listeners;

import com.anas.simpleencryptionapp.gui.MainFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxesListener extends AbstractListener implements ItemListener {

    public CheckBoxesListener(MainFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();

        if (super.getMainFrame().getEncryptCheckBox().equals(source)) {
            super.getMainFrame().getProcessButton().setText("Encrypt");
        } else if (super.getMainFrame().getDecryptCheckBox().equals(source)) {
            super.getMainFrame().getProcessButton().setText("Decrypt");
        }
    }
}
