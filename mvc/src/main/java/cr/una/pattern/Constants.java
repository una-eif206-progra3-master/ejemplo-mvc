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

import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author mguzmana
 */
public class Constants {

    /**
     *
     */
    public static final String FILENAME = "data.json";

    /**
     *
     */
    public static final Vector<String> TABLE_HEADER = new Vector(
            Arrays.asList(new String[]{"Id", "Name", "Course", "Rating"}));
}
