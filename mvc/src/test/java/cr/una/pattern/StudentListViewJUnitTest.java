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

import cr.una.pattern.view.StudentListView;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.assertj.swing.fixture.JSplitPaneFixture;
import org.assertj.swing.fixture.JScrollPaneFixture;
import org.assertj.swing.fixture.JTableFixture;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author mguzmana
 */
public class StudentListViewJUnitTest {

    private FrameFixture window;
    private JPanelFixture ctrlPanel;
    private JSplitPaneFixture splitPanel;
    private JScrollPaneFixture scrollPanel;
    private JTableFixture mainTable;

    public StudentListViewJUnitTest() {
    }

    @Before
    public void setUp() {
        StudentListView view = GuiActionRunner.execute(() -> new StudentListView());
        window = new FrameFixture(view);
        window.show();
        ctrlPanel = window.panel("ctrlPanel");
        splitPanel = window.splitPane("splitPane");
        scrollPanel = window.scrollPane("scrollTablePaneStudent");
        mainTable = window.table("mainTable");
    }

    @Test
    public void testVisibleComponents() {
        String contents[][] = null;
        ctrlPanel.textBox("txtSearch").requireVisible();
        ctrlPanel.button("btnFilter").requireVisible();
        splitPanel.requireVisible();
        scrollPanel.requireVisible();
        mainTable.requireVisible();
        ctrlPanel.textBox("txtSearch").enterText("Mike");
        ctrlPanel.button("btnFilter").click();
        
        contents = mainTable.contents();
        assertEquals(contents[0][1], "Mike");
        
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}
