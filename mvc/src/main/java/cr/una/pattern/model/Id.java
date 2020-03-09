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

/**
 * Id Model 
 * 
 * @author mguzmana
 */
public class Id {

    @JsonProperty("$oid")
    private String $oid;

    /**
     *
     */
    public Id() {
    }

    /**
     *
     * @param $oid
     */
    public Id(String $oid) {
        this.$oid = $oid;
    }

    /**
     *
     * @return
     */
    public String get$oid() {
        return $oid;
    }

    /**
     *
     * @param $oid
     */
    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

    @Override
    public String toString() {
        return "Id{" + "$oid=" + $oid + '}';
    }

}
