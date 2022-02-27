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

        if (super.getMainFrame().getEncryptRadioButton().equals(source)) {
            super.getMainFrame().getProcessButton().setText("Encrypt");
            super.getMainFrame().getKeyFiled().setEditable(false);
        } else if (super.getMainFrame().getDecryptRadioButton().equals(source)) {
            super.getMainFrame().getProcessButton().setText("Decrypt");
        }
    }
}
