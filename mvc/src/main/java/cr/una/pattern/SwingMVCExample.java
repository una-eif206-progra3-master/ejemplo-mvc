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
package cr.una.pattern;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import cr.una.pattern.controller.StudentController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.IOException;

/**
 * Swing MVC Example
 *
 * @author mguzmana
 */
public class SwingMVCExample {

    // Using logger for project
    private static final Logger logger = LogManager.getLogger(SwingMVCExample.class);

    /**
     * Main Method
     * @param args the arguments for the main
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();

                } catch (JsonGenerationException e) {
                    logger.error("Error cuando se parsea el archivo de JSon: ", e);
                } catch (JsonMappingException e) {
                    logger.error("Error cuando se Mapea el archivo de JSon: ", e);
                } catch (IOException e) {
                    logger.error("Error al leer el archivo: ", e);
                } catch (Exception e) {
                    logger.error("Error general: ", e);
                }
            }
        });
    }

    /**
     * Create the GUI
     * 
     * @throws Exception
     */
    public static void createAndShowGUI() throws Exception {
        logger.debug("Running the MVC Example - Calling the Controller");

        StudentController studentController = new StudentController();
        studentController.initController();
    }
}
