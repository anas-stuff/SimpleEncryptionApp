package com.anas.simpleencryptionapp.gui;

import com.anas.simpleencryptionapp.gui.listeners.ButtonsListener;
import com.anas.simpleencryptionapp.gui.listeners.RadioButtonsListener;
import com.anas.simpleencryptionapp.gui.listeners.MainFrameListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private String title;
    private JRadioButton encryptCheckBox, decryptCheckBox;
    private JLabel titleLabel;
    private JTextArea textArea;
    private JScrollPane textAreaScrollPane;
    private JTextArea processedText;
    private JScrollPane processedTextScrollPane;
    private JButton copyProcessedTextButton;
    private JTextField keyFiled;
    private JButton processButton;
    private JButton clearButton;
    private JButton copyKeyButton;

    private final Dimension frameDimension;

    public MainFrame(String title) {
        this.title = title;
        frameDimension = new Dimension(600, 600);
        new Initializer(this).init().setup(); // Initialize and setup the components
        this.addListeners();
        this.setUpFrame(); // Set Up the frame
    }

    private void setUpFrame() {
        super.setTitle(title);
        this.setupIcon();
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        super.setLayout(null);
        super.setResizable(false); // Disable resizing (Because I use i3wm :) )
        super.setSize(frameDimension);
        this.addAllComponents();
        super.setLocationRelativeTo(null); // Centered the frame
        super.setVisible(true);
    }

    private void setupIcon() {
        try {
            super.setIconImage(new ImageIcon("src/main/resources/icon.png").getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addAllComponents() {
        for (Component component : this.getComponentsArray()) {
            super.add(component);
        }
        processedTextScrollPane.setViewportView(processedText);
    }

    public Component[] getComponentsArray() {
        return new Component[] {
                titleLabel,
                encryptCheckBox,
                decryptCheckBox,
                titleLabel,
                textAreaScrollPane,
                processedTextScrollPane,
                copyProcessedTextButton,
                keyFiled,
                processedText,
                processButton,
                clearButton,
                copyKeyButton
        };
    }

    private void addListeners() {
        super.addWindowListener(new MainFrameListener(this));

        ButtonsListener buttonsListener = new ButtonsListener(this);

        processButton.addActionListener(buttonsListener);
        copyProcessedTextButton.addActionListener(buttonsListener);
        clearButton.addActionListener(buttonsListener);
        copyKeyButton.addActionListener(buttonsListener);

        RadioButtonsListener radioButtonsListener = new RadioButtonsListener(this);

        encryptCheckBox.addItemListener(radioButtonsListener);
        decryptCheckBox.addItemListener(radioButtonsListener);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public JRadioButton getEncryptRadioButton() {
        return encryptCheckBox;
    }

    public JRadioButton getDecryptRadioButton() {
        return decryptCheckBox;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JScrollPane getTextAreaScrollPane() {
        return textAreaScrollPane;
    }

    public JTextArea getProcessedTextTextArea() {
        return processedText;
    }
    public JScrollPane getProcessedTextScrollPane() {
        return  processedTextScrollPane;
    }

    public JButton getCopyProcessedTextButton() {
        return copyProcessedTextButton;
    }

    public JTextField getKeyFiled() {
        return keyFiled;
    }

    public JButton getProcessButton() {
        return processButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public Dimension getFrameDimension() {
        return frameDimension;
    }

    public JButton getCopyKeyButton() {
        return copyKeyButton;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        super.setTitle(title);
    }

    protected void setEncryptCheckBox(JRadioButton encryptCheckBox) {
        this.encryptCheckBox = encryptCheckBox;
    }

    protected void setDecryptCheckBox(JRadioButton decryptCheckBox) {
        this.decryptCheckBox = decryptCheckBox;
    }

    protected void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    protected void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    protected void setTextAreaScrollPane(JScrollPane textAreaScrollPane) {
        this.textAreaScrollPane = textAreaScrollPane;
    }

    protected void setProcessedText(JTextArea processedText) {
        this.processedText = processedText;
    }

    protected void setProcessedTextScrollPane(JScrollPane processedTextScrollPane) {
        this.processedTextScrollPane = processedTextScrollPane;
    }

    protected void setCopyProcessedTextButton(JButton copyProcessedTextButton) {
        this.copyProcessedTextButton = copyProcessedTextButton;
    }

    protected void setKeyFiled(JTextField keyFiled) {
        this.keyFiled = keyFiled;
    }

    protected void setProcessButton(JButton processButton) {
        this.processButton = processButton;
    }

    protected void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    protected void setCopyKeyButton(JButton copyKeyButton) {
        this.copyKeyButton = copyKeyButton;
    }
}

