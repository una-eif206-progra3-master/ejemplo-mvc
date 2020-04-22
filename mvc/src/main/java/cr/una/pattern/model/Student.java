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
package cr.una.pattern.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cr.una.pattern.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Student Model
 * 
 * @author mguzmana
 */
public class Student {

    // Using logger for project
    final Logger logger = LogManager.getLogger(Student.class);

    @JsonProperty("_id")
    private Id id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("course")
    private String course;
    @JsonProperty("rating")
    private String rating;

    /**
     *
     */
    public Student() {
        logger.debug("Design Pattern MVC: [MODEL]");
    }

    /**
     *
     * @param id
     * @param name
     * @param course
     * @param rating
     */
    public Student(Id id, String name, String course, String rating) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public Id getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getCourse() {
        return course;
    }

    /**
     *
     * @param course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     *
     * @return
     */
    public String getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", course=" + course + ", rating=" + rating + '}';
    }

}
