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
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import cr.una.pattern.Constants;
import cr.una.pattern.model.Student;
import cr.una.pattern.service.StudentService;
import cr.una.pattern.view.StudentListView;

/**
 * Student Controller
 *
 * @author mguzmana
 */
public class StudentController {

    private List<Student> listStudentModel;
    private StudentListView studentListView;
    private StudentService studentService;


    private Vector dataVector;

    /**
     * Default Contructor
     */
    public StudentController() {
        studentListView = new StudentListView("List of Students (MVC Demo)");
        studentService = new StudentService();
    }

    /**
     * Public method to init the controller
     *
     * @throws IOException
     */
    public void initController() {
        listStudentModel = studentService.loadAllStudentsFromFile();
        dataVector = convertModelToVector(listStudentModel);

        studentListView.getFilterButton().addActionListener( e -> searchText());
        studentListView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER);
    }

    /**
     * Method to search a term inside the table
     */
    private void searchText() {
        String searchTerm = studentListView.getSearchTermTextField().getText();
        listStudentModel = studentService.searchStudentsByTermFromFile(searchTerm);
        dataVector = convertModelToVector(listStudentModel);
        studentListView.getTableModel().setDataVector(dataVector, Constants.TABLE_HEADER);
    }

    public Vector convertModelToVector(List<Student> listStudentModel) {
        Vector dataVector = new Vector();

        if (listStudentModel != null && listStudentModel.size() > 0) {
            int index=0;
            for (Student student : listStudentModel) {
                dataVector.add(index, checkIfNull(student.getId().get$oid()));
                dataVector.add(index, checkIfNull(student.getName()));
                dataVector.add(index, checkIfNull(student.getCourse()));
                dataVector.add(index, checkIfNull(student.getRating()));
                index++;
            }
        }

        return dataVector;
    }

    private String checkIfNull(Object obj) {
        String text;
        if (obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }
}
