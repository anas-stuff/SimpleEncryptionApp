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

        return this;
    }

  private void initTitleLabel() {
        mainFrame.setTitleLabel(new JLabel(mainFrame.getTitle()));
    }

    private void initChecksBoxes() {
        ButtonGroup checkBoxesGroup = new ButtonGroup();

        mainFrame.setEncryptCheckBox(new JRadioButton("Encryption"));
        mainFrame.setDecryptCheckBox(new JRadioButton("Decryption"));

        checkBoxesGroup.add(mainFrame.getEncryptCheckBox());
        checkBoxesGroup.add(mainFrame.getDecryptCheckBox());
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

        mainFrame.getEncryptCheckBox().setBounds(10, 60,
                120,
                mainFrame.getEncryptCheckBox().getPreferredSize().height);

        mainFrame.getEncryptCheckBox().setSelected(true);

        mainFrame.getDecryptCheckBox().setBounds(150, 60,
                        120, mainFrame.getDecryptCheckBox().getPreferredSize().height);

        mainFrame.getKeyFiled().setBounds(380, 60,
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

        mainFrame.getCopyProcessedTextButton()
                .setBounds(mainFrame.getFrameDimension().width -
                                (mainFrame.getCopyProcessedTextButton().getPreferredSize().width + 65),
                        490,
                        120,
                        mainFrame.getCopyProcessedTextButton().getPreferredSize().height);
    }

    private void setupFontAndColors() {
        Font mainFont = new Font("Ink free", Font.BOLD, 20);

        // Set font for all components
        for (Component c : mainFrame.getComponentsArray()) {
            c.setFont(mainFont);
        }

        //Set font for title label
        mainFrame.getTitleLabel().setFont(new Font("Ink free", Font.BOLD, 26));
    }
}
