/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.view;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import ac.cr.una.proyecto.java.controller.InformationPatientController;

/**
 *
 * @author Kimberly
 */
public class InformationPatientView extends JInternalFrame {

    JTable table = new JTable();
    DefaultTableModel tableModel;

    /**
     *
     * @throws IOException
     */
    public InformationPatientView() throws IOException, Exception {
        super("Informacion Personal", true, true, true, true);
        tableModel = new DefaultTableModel();
        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        InformationPatientController controller = new InformationPatientController(tableModel);

        JPanel ctrlPane = new JPanel();
        ctrlPane.setName("ctrlPanel");

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePaneInformation");
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Información Personal",
                TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setName("splitPane");
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

        // Display it all in a scrolling window and make the window appear
        add(splitPane);
        pack();
        setVisible(true);

    }

}
