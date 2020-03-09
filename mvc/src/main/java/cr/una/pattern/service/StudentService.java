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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import cr.una.pattern.Constants;
import cr.una.pattern.model.Student;

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
     * Wrapper to return the list of students from the File
     *
     * @return Object[][] data
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public Object[][] loadStudentsObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException {
        Student[] students = loadStudentsFromFile();
        Object[][] data = null;

        if (students != null && students.length > 0) {
            data = new Object[students.length][4]; // filas y columnas
            int i = 0;
            for (Student student : students) {
                data[i][0] = checkIfNull(student.getId().get$oid());
                data[i][1] = checkIfNull(student.getName());
                data[i][2] = checkIfNull(student.getCourse());
                data[i][3] = checkIfNull(student.getRating());
                i++;
            }
        }

        return data;
    }

    private Student[] loadStudentsFromFile() throws JsonGenerationException,
            JsonMappingException, IOException {
        // Library Jackson parse JSon
        // http://wiki.fasterxml.com/JacksonHome
        Student[] students = null;

        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON string from file to Object
        students = mapper.readValue(new File(
                getClass().getClassLoader().getResource(Constants.FILENAME).getFile()
                ), Student[].class);

        return students;
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
