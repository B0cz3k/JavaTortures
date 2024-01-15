/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lukaszborak.javaproject1;

import java.awt.Color;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class MainPage extends javax.swing.JFrame {
    private Simulation simulation;

    public MainPage(Simulation sim) {
        this.simulation = sim;
        initComponents();
    }
    
    /* List update functionality */ 
    private void updateLists() {
        DefaultListModel<String> userlist = new DefaultListModel();
        userlist.addAll(simulation.getUsernames());
        setUsersList(userlist);
        
        DefaultListModel<String> medialist = new DefaultListModel();
        medialist.addAll(simulation.getMediaNames());
        setMediaList(medialist);
        
        DefaultListModel<String> channellist = new DefaultListModel();
        channellist.addAll(simulation.getChannelNames());
        setChannelsList(channellist);
    }
    
    /* Search bar functionality */
    DefaultListModel defaultUsersModel;
    DefaultListModel defaultMediaModel;
    DefaultListModel defaultChannelsModel;
    
    public void setUsersList(DefaultListModel<String> model) {
        UsersList.setModel(model);
        defaultUsersModel = model;
    }
    public void setMediaList(DefaultListModel<String> model) {
        MediaList.setModel(model);
        defaultMediaModel = model;
    }
    public void setChannelsList(DefaultListModel<String> model) {
        ChannelsList.setModel(model);
        defaultChannelsModel = model;
    }
    private DefaultListModel originalModelForTab(int tabIndex) {
        return switch (tabIndex) {
            case 0 -> defaultUsersModel;
            case 1 -> defaultMediaModel;
            default -> defaultChannelsModel;
        };
    }
    private void searchFilter(String searchTerm, javax.swing.JList myJList) {
        DefaultListModel originalModel = (DefaultListModel) myJList.getModel();
        DefaultListModel filteredItems = new DefaultListModel();

        for (int i = 0; i < originalModel.getSize(); i++) {
            Object item = originalModel.getElementAt(i);
            if (item.toString().toLowerCase().contains(searchTerm.toLowerCase())) {
                filteredItems.addElement(item);
            }
        }
        myJList.setModel(filteredItems);
    }
    
    /* Details tab functionality */
    private void PrintDetails(String text) {
        Details.setText("");
        Details.setText(text);
    }
    public void printCurrentDetails() {
        String selectedValue = MediaList.getSelectedValue();
        PrintDetails(simulation.getDetails(selectedValue));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SimulationSave = new javax.swing.JFileChooser();
        SimulationLoad = new javax.swing.JFileChooser();
        SimulationLoadPopUp = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        closeLoad = new javax.swing.JButton();
        SimulationSavePopUp = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        closeSave = new javax.swing.JButton();
        SimulationLoadFailedPopUp = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        closeLoadFailed = new javax.swing.JButton();
        SimulationSaveFailedPopUp = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        closeSaveFailed = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();
        DataTab = new javax.swing.JTabbedPane();
        UsersTab = new javax.swing.JPanel();
        UsersScrollPane = new javax.swing.JScrollPane();
        UsersList = new javax.swing.JList<>();
        MediaTab = new javax.swing.JPanel();
        MediaScrollPane = new javax.swing.JScrollPane();
        MediaList = new javax.swing.JList<>();
        ChannelsTab = new javax.swing.JPanel();
        ChannelsScrollPane = new javax.swing.JScrollPane();
        ChannelsList = new javax.swing.JList<>();
        SearchBar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Details = new javax.swing.JTextArea();
        NavigationPanel = new javax.swing.JPanel();
        StartButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        LoadButton = new javax.swing.JButton();
        ResumeButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        simStatus = new javax.swing.JLabel();

        SimulationSave.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        SimulationSave.setApproveButtonText("Save");
        SimulationSave.setApproveButtonToolTipText("");
        SimulationSave.setDialogTitle("Save current simulation state...");
        SimulationSave.setSelectedFile(new java.io.File("C:\\Program Files\\NetBeans-20\\simulation.ser"));
        SimulationSave.setToolTipText("");
        SimulationSave.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 80, 80, 80));
        SimulationSave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SimulationSave.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        SimulationSave.setMaximumSize(new java.awt.Dimension(800, 500));
        SimulationSave.setMinimumSize(new java.awt.Dimension(800, 500));
        SimulationSave.setPreferredSize(new java.awt.Dimension(800, 500));
        SimulationSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulationSaveActionPerformed(evt);
            }
        });

        SimulationLoad.setApproveButtonText("Open");
        SimulationLoad.setApproveButtonToolTipText("");
        SimulationLoad.setDialogTitle("Load simulation state...");
        SimulationLoad.setFileHidingEnabled(false);
        SimulationLoad.setSelectedFile(new java.io.File("C:\\Program Files\\NetBeans-20\\simulation.ser"));
        SimulationLoad.setToolTipText("");
        SimulationLoad.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 80, 80, 80));
        SimulationLoad.setMaximumSize(new java.awt.Dimension(800, 500));
        SimulationLoad.setMinimumSize(new java.awt.Dimension(800, 500));
        SimulationLoad.setPreferredSize(new java.awt.Dimension(800, 500));
        SimulationLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulationLoadActionPerformed(evt);
            }
        });

        SimulationLoadPopUp.setTitle("Serialization");
        SimulationLoadPopUp.setAlwaysOnTop(true);
        SimulationLoadPopUp.setPreferredSize(new java.awt.Dimension(300, 200));
        SimulationLoadPopUp.setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Simulation loaded successfullly.");

        jPanel1.setLayout(new java.awt.BorderLayout());

        closeLoad.setText("OK");
        closeLoad.setMaximumSize(new java.awt.Dimension(100, 35));
        closeLoad.setMinimumSize(new java.awt.Dimension(100, 35));
        closeLoad.setPreferredSize(new java.awt.Dimension(100, 35));
        closeLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeLoadActionPerformed(evt);
            }
        });
        jPanel1.add(closeLoad, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout SimulationLoadPopUpLayout = new javax.swing.GroupLayout(SimulationLoadPopUp.getContentPane());
        SimulationLoadPopUp.getContentPane().setLayout(SimulationLoadPopUpLayout);
        SimulationLoadPopUpLayout.setHorizontalGroup(
            SimulationLoadPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimulationLoadPopUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SimulationLoadPopUpLayout.setVerticalGroup(
            SimulationLoadPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimulationLoadPopUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SimulationSavePopUp.setTitle("Serialization");
        SimulationSavePopUp.setAlwaysOnTop(true);
        SimulationSavePopUp.setPreferredSize(new java.awt.Dimension(300, 200));
        SimulationSavePopUp.setResizable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Simulation saved successfullly.");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        closeSave.setText("OK");
        closeSave.setMaximumSize(new java.awt.Dimension(100, 35));
        closeSave.setMinimumSize(new java.awt.Dimension(100, 35));
        closeSave.setPreferredSize(new java.awt.Dimension(100, 35));
        closeSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeSaveActionPerformed(evt);
            }
        });
        jPanel2.add(closeSave, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout SimulationSavePopUpLayout = new javax.swing.GroupLayout(SimulationSavePopUp.getContentPane());
        SimulationSavePopUp.getContentPane().setLayout(SimulationSavePopUpLayout);
        SimulationSavePopUpLayout.setHorizontalGroup(
            SimulationSavePopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimulationSavePopUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SimulationSavePopUpLayout.setVerticalGroup(
            SimulationSavePopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimulationSavePopUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SimulationLoadFailedPopUp.setTitle("Serialization");
        SimulationLoadFailedPopUp.setAlwaysOnTop(true);
        SimulationLoadFailedPopUp.setResizable(false);

        jLabel3.setText("Can't load simulation file.");

        jPanel3.setLayout(new java.awt.BorderLayout());

        closeLoadFailed.setText("OK");
        closeLoadFailed.setMaximumSize(new java.awt.Dimension(100, 35));
        closeLoadFailed.setMinimumSize(new java.awt.Dimension(100, 35));
        closeLoadFailed.setPreferredSize(new java.awt.Dimension(100, 35));
        closeLoadFailed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeLoadFailedActionPerformed(evt);
            }
        });
        jPanel3.add(closeLoadFailed, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout SimulationLoadFailedPopUpLayout = new javax.swing.GroupLayout(SimulationLoadFailedPopUp.getContentPane());
        SimulationLoadFailedPopUp.getContentPane().setLayout(SimulationLoadFailedPopUpLayout);
        SimulationLoadFailedPopUpLayout.setHorizontalGroup(
            SimulationLoadFailedPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimulationLoadFailedPopUpLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel3)
                .addGap(56, 56, 56))
        );
        SimulationLoadFailedPopUpLayout.setVerticalGroup(
            SimulationLoadFailedPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimulationLoadFailedPopUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SimulationSaveFailedPopUp.setTitle("Serialization");
        SimulationSaveFailedPopUp.setAlwaysOnTop(true);
        SimulationSaveFailedPopUp.setResizable(false);

        jLabel4.setText("Can't save simulation file.");

        jPanel4.setLayout(new java.awt.BorderLayout());

        closeSaveFailed.setText("OK");
        closeSaveFailed.setMaximumSize(new java.awt.Dimension(100, 35));
        closeSaveFailed.setMinimumSize(new java.awt.Dimension(100, 35));
        closeSaveFailed.setPreferredSize(new java.awt.Dimension(100, 35));
        closeSaveFailed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeSaveFailedActionPerformed(evt);
            }
        });
        jPanel4.add(closeSaveFailed, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout SimulationSaveFailedPopUpLayout = new javax.swing.GroupLayout(SimulationSaveFailedPopUp.getContentPane());
        SimulationSaveFailedPopUp.getContentPane().setLayout(SimulationSaveFailedPopUpLayout);
        SimulationSaveFailedPopUpLayout.setHorizontalGroup(
            SimulationSaveFailedPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimulationSaveFailedPopUpLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4)
                .addGap(56, 56, 56))
        );
        SimulationSaveFailedPopUpLayout.setVerticalGroup(
            SimulationSaveFailedPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SimulationSaveFailedPopUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaTube");
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(900, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 500));

        MainPanel.setPreferredSize(new java.awt.Dimension(900, 500));

        DataTab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DataTabStateChanged(evt);
            }
        });

        UsersTab.setName("UsersTab"); // NOI18N
        UsersTab.setPreferredSize(new java.awt.Dimension(440, 300));

        UsersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                UsersListValueChanged(evt);
            }
        });
        UsersScrollPane.setViewportView(UsersList);

        javax.swing.GroupLayout UsersTabLayout = new javax.swing.GroupLayout(UsersTab);
        UsersTab.setLayout(UsersTabLayout);
        UsersTabLayout.setHorizontalGroup(
            UsersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UsersScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        UsersTabLayout.setVerticalGroup(
            UsersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UsersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );

        DataTab.addTab("Users", UsersTab);

        MediaTab.setName("MediaTab"); // NOI18N
        MediaTab.setPreferredSize(new java.awt.Dimension(440, 300));

        MediaList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        MediaList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                MediaListValueChanged(evt);
            }
        });
        MediaScrollPane.setViewportView(MediaList);

        javax.swing.GroupLayout MediaTabLayout = new javax.swing.GroupLayout(MediaTab);
        MediaTab.setLayout(MediaTabLayout);
        MediaTabLayout.setHorizontalGroup(
            MediaTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MediaTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MediaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );
        MediaTabLayout.setVerticalGroup(
            MediaTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MediaTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MediaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        DataTab.addTab("Media", MediaTab);

        ChannelsTab.setName("ChannelsTab"); // NOI18N
        ChannelsTab.setPreferredSize(new java.awt.Dimension(440, 300));

        ChannelsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ChannelsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ChannelsListValueChanged(evt);
            }
        });
        ChannelsScrollPane.setViewportView(ChannelsList);

        javax.swing.GroupLayout ChannelsTabLayout = new javax.swing.GroupLayout(ChannelsTab);
        ChannelsTab.setLayout(ChannelsTabLayout);
        ChannelsTabLayout.setHorizontalGroup(
            ChannelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChannelsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChannelsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );
        ChannelsTabLayout.setVerticalGroup(
            ChannelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChannelsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChannelsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        DataTab.addTab("Channels", ChannelsTab);

        SearchBar.setText("Search...");
        SearchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchBarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchBarFocusLost(evt);
            }
        });
        SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarKeyReleased(evt);
            }
        });

        Details.setColumns(20);
        Details.setLineWrap(true);
        Details.setRows(5);
        jScrollPane1.setViewportView(Details);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DataTab)
                    .addComponent(SearchBar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DataTab, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        NavigationPanel.setMinimumSize(new java.awt.Dimension(100, 80));
        NavigationPanel.setPreferredSize(new java.awt.Dimension(900, 50));

        StartButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        StartButton.setText("Start");
        StartButton.setPreferredSize(new java.awt.Dimension(100, 30));
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        StopButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        StopButton.setText("Stop");
        StopButton.setPreferredSize(new java.awt.Dimension(100, 30));
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.setPreferredSize(new java.awt.Dimension(100, 30));
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        LoadButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LoadButton.setText("Load");
        LoadButton.setPreferredSize(new java.awt.Dimension(100, 30));
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        ResumeButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ResumeButton.setText("Resume");
        ResumeButton.setPreferredSize(new java.awt.Dimension(100, 30));
        ResumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumeButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Status:");
        jLabel5.setPreferredSize(new java.awt.Dimension(50, 30));

        simStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        simStatus.setForeground(java.awt.Color.red);
        simStatus.setText("Simulation stopped");
        simStatus.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout NavigationPanelLayout = new javax.swing.GroupLayout(NavigationPanel);
        NavigationPanel.setLayout(NavigationPanelLayout);
        NavigationPanelLayout.setHorizontalGroup(
            NavigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResumeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        NavigationPanelLayout.setVerticalGroup(
            NavigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResumeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(NavigationPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyReleased
        int activeTab = DataTab.getSelectedIndex();
        javax.swing.JList chosenJList;
        chosenJList = switch (activeTab) {
            case 0 -> UsersList;
            case 1 -> MediaList;
            default -> ChannelsList;
        };
        String searchTerm = SearchBar.getText();
        if (searchTerm.isEmpty()) {
            // Restore the original model when the search term is empty
            chosenJList.setModel(originalModelForTab(activeTab));
        } else {
            searchFilter(searchTerm, chosenJList);
        }
    }//GEN-LAST:event_SearchBarKeyReleased

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        simulation.start();
        simStatus.setForeground(Color.GREEN);
        simStatus.setText("Simulation running");
    }//GEN-LAST:event_StartButtonActionPerformed

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        simulation.stop();
        simStatus.setForeground(Color.RED);
        simStatus.setText("Simulation stopped");
    }//GEN-LAST:event_StopButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        simulation.stop();
        simStatus.setForeground(Color.RED);
        simStatus.setText("Simulation stopped");
        SwingUtilities.invokeLater(() -> {
            SimulationSave.showOpenDialog(null);
        });
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
        simulation.stop();
        simStatus.setForeground(Color.RED);
        simStatus.setText("Simulation stopped");
        SwingUtilities.invokeLater(() -> {
            SimulationLoad.showOpenDialog(null);
        });
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void MediaListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_MediaListValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedValue = MediaList.getSelectedValue();
            PrintDetails(simulation.getDetails(selectedValue));
        }
    }//GEN-LAST:event_MediaListValueChanged

    private void UsersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_UsersListValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedValue = UsersList.getSelectedValue();
            PrintDetails(simulation.getDetails(selectedValue));
        }
    }//GEN-LAST:event_UsersListValueChanged

    private void ChannelsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ChannelsListValueChanged
        if (!evt.getValueIsAdjusting()) {
            String selectedValue = ChannelsList.getSelectedValue();
            PrintDetails(simulation.getDetails(selectedValue));
        }
    }//GEN-LAST:event_ChannelsListValueChanged

    private void SearchBarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchBarFocusGained
        if (SearchBar.getText().equals("Search...")) {
            SearchBar.setText("");
        }
    }//GEN-LAST:event_SearchBarFocusGained

    private void SearchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchBarFocusLost
        if (SearchBar.getText().isEmpty()) {
            SearchBar.setText("Search...");
        }
    }//GEN-LAST:event_SearchBarFocusLost

    private void DataTabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DataTabStateChanged
        updateLists();
    }//GEN-LAST:event_DataTabStateChanged

    private void ResumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumeButtonActionPerformed
        simulation.resume();
    }//GEN-LAST:event_ResumeButtonActionPerformed

    private void SimulationSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulationSaveActionPerformed
        boolean result = false;
        File selectedFile = SimulationSave.getSelectedFile();
        result = simulation.save(selectedFile.getName());
        if (result) {
            SimulationSavePopUp.setLocationRelativeTo(this);
            SimulationSavePopUp.pack();
            SimulationSavePopUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            SimulationSavePopUp.setVisible(true);
        } else {
            SimulationSaveFailedPopUp.setLocationRelativeTo(this);
            SimulationSaveFailedPopUp.pack();
            SimulationSaveFailedPopUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            SimulationSaveFailedPopUp.setVisible(true);
        }
    }//GEN-LAST:event_SimulationSaveActionPerformed

    private void SimulationLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulationLoadActionPerformed
        File selectedFile = SimulationLoad.getSelectedFile();
        Simulation result = simulation.load(selectedFile.getName());
        if (result != null) {
            SimulationLoadPopUp.setLocationRelativeTo(this);
            SimulationLoadPopUp.pack();
            SimulationLoadPopUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            SimulationLoadPopUp.setVisible(true);
        } else {
            SimulationLoadFailedPopUp.setLocationRelativeTo(this);
            SimulationLoadFailedPopUp.pack();
            SimulationLoadFailedPopUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            SimulationLoadFailedPopUp.setVisible(true);
        }
    }//GEN-LAST:event_SimulationLoadActionPerformed

    private void closeLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeLoadActionPerformed
        SimulationLoadPopUp.setVisible(false);
    }//GEN-LAST:event_closeLoadActionPerformed

    private void closeSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeSaveActionPerformed
        SimulationSavePopUp.setVisible(false);
    }//GEN-LAST:event_closeSaveActionPerformed

    private void closeLoadFailedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeLoadFailedActionPerformed
        SimulationLoadFailedPopUp.setVisible(false);
    }//GEN-LAST:event_closeLoadFailedActionPerformed

    private void closeSaveFailedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeSaveFailedActionPerformed
        SimulationSaveFailedPopUp.setVisible(false);
    }//GEN-LAST:event_closeSaveFailedActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ChannelsList;
    private javax.swing.JScrollPane ChannelsScrollPane;
    private javax.swing.JPanel ChannelsTab;
    private javax.swing.JTabbedPane DataTab;
    private javax.swing.JTextArea Details;
    private javax.swing.JButton LoadButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JList<String> MediaList;
    private javax.swing.JScrollPane MediaScrollPane;
    private javax.swing.JPanel MediaTab;
    private javax.swing.JPanel NavigationPanel;
    private javax.swing.JButton ResumeButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JFileChooser SimulationLoad;
    private javax.swing.JDialog SimulationLoadFailedPopUp;
    private javax.swing.JDialog SimulationLoadPopUp;
    private javax.swing.JFileChooser SimulationSave;
    private javax.swing.JDialog SimulationSaveFailedPopUp;
    private javax.swing.JDialog SimulationSavePopUp;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton StopButton;
    private javax.swing.JList<String> UsersList;
    private javax.swing.JScrollPane UsersScrollPane;
    private javax.swing.JPanel UsersTab;
    private javax.swing.JButton closeLoad;
    private javax.swing.JButton closeLoadFailed;
    private javax.swing.JButton closeSave;
    private javax.swing.JButton closeSaveFailed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel simStatus;
    // End of variables declaration//GEN-END:variables
}
