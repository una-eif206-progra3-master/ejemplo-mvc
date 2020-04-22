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
package cr.una.pattern.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cr.una.pattern.Constants;
import cr.una.pattern.model.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service to get the data from the service
 *
 * @author mguzmana
 */
public class StudentService {

    /**
     * Empty Constructor
     */
    public StudentService() {
    }

    /**
     * This method will load the information from JSON depending if the filter text
     * @param searchTerm filter term
     * @return the list of Students
     */
    public List<Student> searchStudentsByTermFromFile(String searchTerm) {

        List<Student> studentList = loadAllStudentsFromFile();
        List<Student> updatedStudentList = new ArrayList<Student>();

        if (studentList != null && studentList.size() > 0) {
            for (Student student : studentList) {
                if (searchTerm != null && student.getName().equals(searchTerm)) {
                    updatedStudentList.add(student);
                }
            }
        }

        return updatedStudentList;
    }

    /**
     * This method will load all the data from the JSON
     * @return the list of Students
     */
    public List<Student> loadAllStudentsFromFile() {
        // Library Jackson parse JSon
        // http://wiki.fasterxml.com/JacksonHome
        Student[] students = null;
        List<Student> studentList = null;

        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON string from file to Object
        try {
            students = mapper.readValue(new File(
                    getClass().getClassLoader().getResource(Constants.FILENAME).getFile()
                    ), Student[].class);
            if (students != null && students.length > 0) {
                studentList = new ArrayList<Student>();
                for (Student student: students) {
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
