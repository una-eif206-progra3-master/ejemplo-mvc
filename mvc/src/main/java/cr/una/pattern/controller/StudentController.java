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
package cr.una.pattern.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import cr.una.pattern.Constants;
import cr.una.pattern.service.StudentService;

/**
 * Student Controller
 *
 * @author mguzmana
 */
public class StudentController implements ActionListener {

    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private StudentService studentService;
    private Object[][] students;

    /**
     * Main Constructor
     *
     * @param searchTermTextField
     * @param tableModel
     * 
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public StudentController(JTextField searchTermTextField,
            DefaultTableModel tableModel) throws JsonGenerationException,
            JsonMappingException, IOException {
        super();
        studentService = new StudentService();
        students = studentService.loadStudentsObjWrapper();

        this.searchTermTextField = searchTermTextField;
        this.tableModel = tableModel;

        // Load the table with the list of students
        tableModel.setDataVector(students, Constants.TABLE_HEADER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String searchTerm = searchTermTextField.getText();

        //Method to search items
        updateTableSearchTerms(searchTerm);
    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && students != null && students.length > 1) {
            Object[][] newData = new Object[students.length][];
            int idx = 0;
            for (Object[] obj : students) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Search term is empty", "Error",
                    JOptionPane.ERROR_MESSAGE);
            tableModel.setDataVector(students, Constants.TABLE_HEADER);
        }
    }

}
