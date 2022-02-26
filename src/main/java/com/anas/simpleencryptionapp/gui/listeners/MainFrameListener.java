package com.anas.simpleencryptionapp.gui.listeners;

import com.anas.simpleencryptionapp.gui.MainFrame;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainFrameListener extends AbstractListener implements WindowListener {

    public MainFrameListener(MainFrame mainFrame)  {
        super(mainFrame);
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the program?",
                    "", JOptionPane.YES_NO_OPTION);

        switch (response) {
            case JOptionPane.YES_OPTION -> System.exit(0);
            case JOptionPane.NO_OPTION -> {
                super.getMainFrame().setVisible(true);
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
