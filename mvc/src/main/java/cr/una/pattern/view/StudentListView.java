/*
 * Copyright (C) 2016 mguzmana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */
package cr.una.pattern.view;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import cr.una.pattern.controller.StudentController;

/**
 * Student View
 *
 * @author mguzmana
 */
public class StudentListView extends JFrame {
    // Create views swing UI components

    private String titleView;
    private JTextField searchTermTextField;
    private JButton filterButton;
    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Main Constructor
     *
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public StudentListView(String titleView) {
        
        super(titleView);

        searchTermTextField = new JTextField(26);
        filterButton = new JButton("Filter");
        table = new JTable();
        tableModel = new DefaultTableModel();
        
        searchTermTextField.setName("txtSearch");
        filterButton.setName("btnFilter");

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        // Set the view layout
        JPanel ctrlPane = new JPanel();
        ctrlPane.setName("ctrlPanel");
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(filterButton);
        
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePaneStudent");
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Market Movers",
                TitledBorder.CENTER, TitledBorder.TOP));
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setName("splitPane");
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

        // Display it all in a scrolling window and make the window appear
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(splitPane);
        pack();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getTitleView() {
        return titleView;
    }

    public void setTitleView(String titleView) {
        this.titleView = titleView;
    }

    public JTextField getSearchTermTextField() {
        return searchTermTextField;
    }

    public void setSearchTermTextField(JTextField searchTermTextField) {
        this.searchTermTextField = searchTermTextField;
    }

    public JButton getFilterButton() {
        return filterButton;
    }

    public void setFilterButton(JButton filterButton) {
        this.filterButton = filterButton;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
}
