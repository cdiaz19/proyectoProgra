package una.ac.cr.consultoriofrontend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ac.cr.una.proyecto.java.view.InformationPatientView;
import ac.cr.una.proyecto.java.view.PatientPanelView;
import static ac.cr.una.proyecto.java.Constants.ACTUAL;

/**
 *
 * @author Yeni
 */
public class AppointmentPatientJUnitTest {

    private FrameFixture window;
    private JPanelFixture panel;

    /**
     *
     */
    public AppointmentPatientJUnitTest() {
    }

    /**
     *
     * @throws IOException
     */
    @Before
    public void setUp() throws IOException, Exception {
        //Valor de prueba para test
        ACTUAL = "Santiago"; //Nombre del paciente
        PatientPanelView frame = GuiActionRunner.execute(() -> new PatientPanelView());
        window = new FrameFixture(frame);
        window.show();
        frame.setExtendedState(MAXIMIZED_BOTH);
        InformationPatientView ventanaInterna = new InformationPatientView();
        window.menuItem("citasPaciente").click();
        ventanaInterna.setVisible(true);
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void testVisibleComponents() throws IOException {
        window.table("mainTable").requireVisible();
        window.scrollPane("scrollTablePaneAppointment").requireVisible();
    }

    /**
     *
     */
    @After
    public void tearDown() {
        window.cleanUp();
    }

}
