package com.anas.simpleencryptionapp.gui;

import javax.swing.*;
import java.awt.*;

public class Initializer {
    private final MainFrame mainFrame;

    protected Initializer(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    protected Initializer init() {
        initTitleLabel();
        initChecksBoxes();
        initTextAreaAndScrollPane();
        intProcessedText();
        initKeyFiled();
        initProcessButton();
        initClearButton();
        initCopyKeyButton();

        return this;
    }

    private void initCopyKeyButton() {
        mainFrame.setCopyKeyButton(new JButton("Copy Key"));
    }

    private void initTitleLabel() {
        mainFrame.setTitleLabel(new JLabel(mainFrame.getTitle()));
    }

    private void initChecksBoxes() {
        ButtonGroup checkBoxesGroup = new ButtonGroup();

        mainFrame.setEncryptCheckBox(new JRadioButton("Encryption"));
        mainFrame.setDecryptCheckBox(new JRadioButton("Decryption"));

        checkBoxesGroup.add(mainFrame.getEncryptRadioButton());
        checkBoxesGroup.add(mainFrame.getDecryptRadioButton());
    }

    private void initTextAreaAndScrollPane() {
        mainFrame.setTextArea(new JTextArea());
        mainFrame.setTextAreaScrollPane(new JScrollPane(mainFrame.getTextArea()));
    }

    private void intProcessedText() {
        mainFrame.setProcessedText(new JTextArea());
        mainFrame.setCopyProcessedTextButton(new JButton("Copy"));
    }

    private void initKeyFiled() {
        mainFrame.setKeyFiled(new JTextField());
    }

    private void initProcessButton() {
        mainFrame.setProcessButton(new JButton("Encrypt"));
    }

    private void initClearButton() {
        mainFrame.setClearButton(new JButton("Clear"));
    }


    protected void setup() {
        setupFontAndColors();
        setupBounds();
        mainFrame.getProcessedText().setEditable(false);
    }

    private void setupBounds() {
        mainFrame.getTitleLabel().setBounds(150, 20,
                mainFrame.getTitleLabel().getPreferredSize().width,
                mainFrame.getTitleLabel().getPreferredSize().height);

        int radioButtonWidth = 140;
        mainFrame.getEncryptRadioButton().setBounds(10, 60,
                radioButtonWidth,
                mainFrame.getEncryptRadioButton().getPreferredSize().height);

        mainFrame.getEncryptRadioButton().setSelected(true);

        mainFrame.getDecryptRadioButton().setBounds(radioButtonWidth + 10, 60, radioButtonWidth,
                        mainFrame.getDecryptRadioButton().getPreferredSize().height);

        mainFrame.getKeyFiled().setBounds(390, 60,
                        160,
                        mainFrame.getKeyFiled().getPreferredSize().height);


        mainFrame.getTextAreaScrollPane().setBounds(10, 100,
                        mainFrame.getFrameDimension().width - 30, 220);

        mainFrame.getProcessedText().setBounds(10, 330,
                        mainFrame.getFrameDimension().width - 30, 150);

        mainFrame.getProcessButton().setBounds(10, 490,
                        120,
                        mainFrame.getProcessButton().getPreferredSize().height);

        mainFrame.getClearButton().setBounds(140, 490,
                        120,
                        mainFrame.getClearButton().getPreferredSize().height);

        mainFrame.getCopyKeyButton().setBounds(270, 490,
                                160,
                                        mainFrame.getCopyProcessedTextButton().getPreferredSize().height);

        mainFrame.getCopyProcessedTextButton()
                .setBounds(mainFrame.getFrameDimension().width -
                                (mainFrame.getCopyProcessedTextButton().getPreferredSize().width + 65),
                        490,
                        120,
                        mainFrame.getCopyProcessedTextButton().getPreferredSize().height);
    }

    private void setupFontAndColors() {
        Font mainFont = new Font("Ink free", Font.BOLD, 20);
        Color backgroundColor = new Color(0X2041140);
        Color fontColor = new Color(140, 230, 212);

        // Set font for all components
        for (Component c : mainFrame.getComponentsArray()) {
            c.setFont(mainFont);
            c.setForeground(fontColor);
        }
        mainFrame.getTextArea().setFont(mainFont);
        themeRadioButtons(backgroundColor);
        mainFrame.getKeyFiled().setBackground(new Color(0X1021030));

        setTheTextAreas(fontColor);

        themeTheButtons(backgroundColor);

        // Hacker theme
        mainFrame.getContentPane().setBackground(backgroundColor);

        //Set font for title label
        mainFrame.getTitleLabel().setFont(new Font("Ink free", Font.BOLD, 26));
    }

    private void setTheTextAreas(Color fontColor) {
        mainFrame.getTextArea().setBackground(new Color(0X1021030));
        mainFrame.getTextArea().setForeground(fontColor);
        mainFrame.getTextArea().setLineWrap(true);

        mainFrame.getProcessedText().setBackground(new Color(0X1021030));
        mainFrame.getProcessedText().setForeground(fontColor);
        mainFrame.getProcessedText().setLineWrap(true);
    }

    private void themeTheButtons(Color backgroundColor) {
        mainFrame.getProcessButton().setBackground(backgroundColor);
        mainFrame.getClearButton().setBackground(backgroundColor);
        mainFrame.getCopyKeyButton().setBackground(backgroundColor);
        mainFrame.getCopyProcessedTextButton().setBackground(backgroundColor);
    }

    private void themeRadioButtons(Color backgroundColor) {
        mainFrame.getEncryptRadioButton().setBackground(backgroundColor);
        mainFrame.getDecryptRadioButton().setBackground(backgroundColor);
        mainFrame.getEncryptRadioButton().setFocusable(false);
        mainFrame.getDecryptRadioButton().setFocusable(false);
    }
}
