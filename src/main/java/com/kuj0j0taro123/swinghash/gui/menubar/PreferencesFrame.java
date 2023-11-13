package com.kuj0j0taro123.swinghash.gui.menubar;

import com.kuj0j0taro123.swinghash.constants.Constants;
import com.kuj0j0taro123.swinghash.gui.GUIUpdater;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class PreferencesFrame extends JFrame implements Serializable {
    // CONTAINS CHECKBOXES FOR ALGORITHMS TO RUN IF THEY'RE CHECKED.

    private JPanel mainPanel;
    private JPanel checkboxPanel;
    private JCheckBox md2checkBox;
    private JCheckBox md5checkBox;
    private JCheckBox sha1checkBox;
    private JCheckBox sha224checkBox;

    public JCheckBox getSha256checkBox() {
        return sha256checkBox;
    }

    private JCheckBox sha256checkBox;
    private JCheckBox sha384checkBox;
    private JCheckBox sha512checkBox;
    private JCheckBox sha3_224checkBox;
    private JCheckBox sha3_256checkBox;
    private JCheckBox sha3_384checkBox;
    private JCheckBox sha3_512checkBox;

    private List<JCheckBox> checkBoxes;
    private HashSet<Constants.ChecksumAlgorithm> algorithmsToRun;

    public PreferencesFrame() {
        algorithmsToRun = new HashSet<>();

        createMainPanel();
        this.add(mainPanel);

        createCheckBoxPanel();
        mainPanel.add(checkboxPanel);

        checkBoxes = createCheckBoxes();
        checkBoxes.forEach(checkBox -> checkBox.addActionListener(new CheckBoxActionListener()));
        checkBoxes.forEach(checkBox -> checkBox.setFocusable(false));
        checkBoxes.forEach(checkBox -> checkboxPanel.add(checkBox));

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.pack();
        this.setTitle("Preferences");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);

    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }

    private void createCheckBoxPanel() {
        checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new GridLayout(4, 3, 0, 0));
        //checkboxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    }

    private List<JCheckBox> createCheckBoxes() {
        List<JCheckBox> ret = new ArrayList<>();
        md2checkBox = new JCheckBox("MD2");

        md5checkBox = new JCheckBox("MD5");
        algorithmsToRun.add(Constants.ChecksumAlgorithm.MD5);
        md5checkBox.setSelected(true);

        sha1checkBox = new JCheckBox("SHA1");
        algorithmsToRun.add(Constants.ChecksumAlgorithm.SHA1);
        sha1checkBox.setSelected(true);

        sha224checkBox = new JCheckBox("SHA224");

        sha256checkBox = new JCheckBox("SHA256");
        algorithmsToRun.add(Constants.ChecksumAlgorithm.SHA256);
        sha256checkBox.setSelected(true);

        sha384checkBox = new JCheckBox("SHA384");

        sha512checkBox = new JCheckBox("SHA512");
        algorithmsToRun.add(Constants.ChecksumAlgorithm.SHA512);
        sha512checkBox.setSelected(true);

        sha3_224checkBox = new JCheckBox("SHA3_224");
        sha3_256checkBox = new JCheckBox("SHA3_256");
        sha3_384checkBox = new JCheckBox("SHA3_384");
        sha3_512checkBox = new JCheckBox("SHA3_512");

        ret.add(md2checkBox);
        ret.add(md5checkBox);
        ret.add(sha1checkBox);
        ret.add(sha224checkBox);
        ret.add(sha256checkBox);
        ret.add(sha384checkBox);
        ret.add(sha512checkBox);
        ret.add(sha3_224checkBox);
        ret.add(sha3_256checkBox);
        ret.add(sha3_384checkBox);
        ret.add(sha3_512checkBox);
        return ret;
    }

    public HashSet<Constants.ChecksumAlgorithm> getAlgorithmsToRun() {
        return this.algorithmsToRun;
    }

    public void checkboxStateChangedHandler(){
        for (Constants.ChecksumAlgorithm algorithm : Constants.ChecksumAlgorithm.values()){
            GUIUpdater.updateChecksumPanelVisibility(algorithm, checkBoxes.get(algorithm.ordinal()).isSelected());
            if (checkBoxes.get(algorithm.ordinal()).isSelected())
                algorithmsToRun.add(algorithm);
            else
                algorithmsToRun.remove(algorithm);
        }
        GUIUpdater.hashButtonUpdate();
    }

    public class CheckBoxActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            checkboxStateChangedHandler();
        }
    }
}



