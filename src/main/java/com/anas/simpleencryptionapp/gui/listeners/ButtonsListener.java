package com.anas.simpleencryptionapp.gui.listeners;

import com.anas.simpleencryptionapp.gui.MainFrame;
import com.anas.simpleencryptionapp.gui.Mind;

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
            if (!super.getMainFrame().getTextArea().getText().isBlank())
                processText();
        } else if (super.getMainFrame().getClearButton().equals(source)) {
            clear();
        } else if (super.getMainFrame().getCopyProcessedTextButton().equals(source)) {
            copyProcessedText();
        } else if (super.getMainFrame().getCopyKeyButton().equals(source)) {
            copyKey();
        }
    }

    private void processText() {
        if (super.getMainFrame().getEncryptRadioButton().isSelected()) {
            Mind.getInstance().generateNewKey();
            super.getMainFrame().getKeyFiled().setText(Mind.getInstance().getKey());
            Mind.getInstance().encrypt(super.getMainFrame().getTextArea().getText());
            super.getMainFrame().getProcessedText().setText(Mind.getInstance().getEncryptedSecretMessage());
        } else {
            super.getMainFrame().getProcessedText().setText(
                 Mind.getInstance().decrypt(
                         super.getMainFrame().getTextArea().getText(),
                         super.getMainFrame().getKeyFiled().getText()));
        }
    }

    private void clear() {
        // Clear all text areas and text fields
        super.getMainFrame().getTextArea().setText("");
        super.getMainFrame().getProcessedText().setText("");
        super.getMainFrame().getKeyFiled().setText("");
    }
    private void copyProcessedText() {
        // Copy processed text to clipboard
        super.getMainFrame().getProcessedText().selectAll();
        super.getMainFrame().getProcessedText().copy();
    }

    private void copyKey() {
        // Copy key to clipboard
        super.getMainFrame().getKeyFiled().selectAll();
        super.getMainFrame().getKeyFiled().copy();
    }
}
