package com.kuj0j0taro123.swinghash.gui;

import com.kuj0j0taro123.swinghash.Main;
import com.kuj0j0taro123.swinghash.CheckSum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

public class ChecksumControlPanel extends JPanel implements ActionListener, Serializable {
    private JButton hashButton;
    private JButton cancelButton;
    private JProgressBar progressBar;


    ChecksumControlPanel(){
        hashButton = new JButton("Hash");
        hashButton.addActionListener(this);
        hashButton.setFocusable(false);
        hashButton.setEnabled(false);

        cancelButton = new JButton("Stop");
        cancelButton.addActionListener(this);
        cancelButton.setFocusable(false);
        cancelButton.setVisible(false);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setBorderPainted(true);
        progressBar.setVisible(false);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(progressBar, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        // this weight makes the buttons heavy enough to be pushed to the right side of the pane, but still light enough
        // so that the progress bar can extend and push the buttons
        gbc.weightx = 0.001;
        gbc.gridx = 1;
        this.add(hashButton, gbc);
        gbc.gridx = 2;
        this.add(cancelButton, gbc);
    }

    public void changeFont(Font font){
        hashButton.setFont(font);
        cancelButton.setFont(font);
    }

    public void setProgressBarMaximum(){
        try {
            progressBar.setMaximum(
                    (int)(Files.size(Main.filePickerPanel.getFile().toPath()) / 1024  *
                            Main.preferencesFrame.getAlgorithmsToRun().size()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public JButton getHashButton(){
        return this.hashButton;
    }

    public JButton getCancelButton(){
        return this.cancelButton;
    }

    public JProgressBar getProgressBar(){
        return this.progressBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hashButton) {
            Main.checksumPanel.clearTextAreas();

            setProgressBarMaximum();

            hashButton.setVisible(false);
            Main.preferencesFrame.getAlgorithmsToRun().forEach(
                    algo -> Main.executor.execute(new CheckSum(algo, Main.filePickerPanel.file)));
            cancelButton.setVisible(true);
        }
        if (e.getSource() == cancelButton)
            Main.activeThreads.forEach(thread -> thread.stop = true);
    }
}
