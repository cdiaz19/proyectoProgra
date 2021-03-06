/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.view;

import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import ac.cr.una.proyecto.java.controller.OfficeController;

/**
 *
 * @author cristian
 */
public class AddOfficeView extends JInternalFrame {

    String[] offices = {"Hospital", "Clinica"};

    JTextField name = new JTextField(15);
    JTextField phone_number = new JTextField(15);
    JTextField days = new JTextField(15);
    JTextField hourStart = new JTextField(15);
    JTextField hourEnd = new JTextField(15);
    JTextField officesBox = new JTextField(15);
    JButton accept_form = new JButton();
    JButton clean_button = new JButton();

    /**
     *
     * @throws IOException
     */
    public AddOfficeView() throws IOException {
        super("Formulario Nuevo Consultorio", false, true, false, true);
        setSize(260, 330);

        ImageIcon addOffice = new ImageIcon("accept.png");
        ImageIcon limpiar = new ImageIcon("clear.png");
        
        accept_form = new JButton("Aceptar", addOffice);
        clean_button = new JButton("Limpiar",limpiar);

        // Create controller
        OfficeController controller
                = new OfficeController(name, phone_number, days, hourStart,
                        hourEnd, officesBox, accept_form,clean_button);

        accept_form.addActionListener(controller);
        clean_button.addActionListener(controller);

        //Inicializa variables
        JPanel panel = new JPanel();
        FlowLayout lm = new FlowLayout(FlowLayout.CENTER);
        panel.setLayout(lm);
        JLabel nameLabel = new JLabel("Nombre:");
        JLabel phonenumberLabel = new JLabel("Telefono:");
        JLabel daysLabel = new JLabel("Días:");
        JLabel hourStartLabel = new JLabel("Hora Apertura:");
        JLabel hourEndLabel = new JLabel("Hora Cierre:");
        JLabel officeLabel = new JLabel("Consultorio:");

        //setea nombres (ids)
        nameLabel.setName("lblName");
        phonenumberLabel.setName("lblPhone");
        daysLabel.setName("lblDays");
        hourStartLabel.setName("lblHourStart");
        hourEndLabel.setName("lblHourEnd");
        officeLabel.setName("lblOffice");

        name.setName("name");
        phone_number.setName("phone");
        days.setName("days");
        officesBox.setName("offices");
        hourStart.setName("hourStart");
        hourEnd.setName("hourEnd");
        accept_form.setName("ok");
        clean_button.setName("clean");

        //Las agrega al Panel
        panel.setName("Form");
        panel.add(nameLabel);
        panel.add(name);
        panel.add(phonenumberLabel);
        panel.add(phone_number);
        panel.add(daysLabel);
        panel.add(days);
        panel.add(hourStartLabel);
        panel.add(hourStart);
        panel.add(hourEndLabel);
        panel.add(hourEnd);
        panel.add(officeLabel);
        panel.add(officesBox);
        panel.add(accept_form);
        panel.add(clean_button);

        add(panel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        AddOfficeView.setLookAndFeel();
        AddOfficeView officeView = new AddOfficeView();
    }
}
