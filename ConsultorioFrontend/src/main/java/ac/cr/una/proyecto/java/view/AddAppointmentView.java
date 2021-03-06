/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.proyecto.java.view;

import com.toedter.calendar.JDateChooser;
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
import ac.cr.una.proyecto.java.controller.AppointmentController;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;


/**
 *
 * @author Yeni
 */
public class AddAppointmentView extends JInternalFrame {
    //create UI components 

    String[] offices = {" ", "Hospital CIMA", "Centro Medico del Este"};

    JTextField namePatient = new JTextField(15);
    JComboBox name = new JComboBox(offices);
    JDateChooser fecha = new JDateChooser();
    JComboBox hora = new JComboBox();
    JButton accept_button = new JButton();
    JButton clean_button = new JButton();

    /**
     *
     * @throws IOException
     */
    public AddAppointmentView() throws IOException, Exception {
        super("Formulario de Cita Nueva", false, true, false, true);
        setSize(200, 300);
        
        ImageIcon aceptar = new ImageIcon("accept.png");
        ImageIcon limpiar = new ImageIcon("clear.png");

        accept_button = new JButton("Aceptar",aceptar);
        clean_button = new JButton("Limpiar",limpiar);
        
        // Create controller
        AppointmentController controller = new AppointmentController(namePatient, name, fecha, hora, accept_button, clean_button);

        accept_button.addActionListener(controller);
        clean_button.addActionListener(controller);
        
       
        
         String horas[] = {" ", "8:00am", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", 
             "2:00pm", "3:00pm", "4:00pm", "5:00pm"};
         
         for (int i=0;i<11;i++)
       {
           hora.addItem(horas[i]);
       }

        //Inicializa variables
        JPanel panel = new JPanel();
        FlowLayout lm = new FlowLayout(FlowLayout.CENTER);
        panel.setLayout(lm);
        JLabel nameLabel = new JLabel("Paciente: ");
        JLabel officeLabel = new JLabel("Tipo de Consultorio: ");
        JLabel dateLabel = new JLabel("Fecha: ");
        JLabel hourLabel = new JLabel("Hora: ");

        //setea nombres (ids)
        nameLabel.setName("lblName");
        officeLabel.setName("lblOffice");
        dateLabel.setName("lblDate");
        hourLabel.setName("lblHour");

        namePatient.setName("name");
        name.setName("office");
        fecha.setName("date");
        hora.setName("hour");
        accept_button.setName("ok");
        clean_button.setName("clean");

        //Las agrega al Panel
        panel.setName("Form");
        panel.add(nameLabel);
        panel.add(namePatient);
        panel.add(officeLabel);
        panel.add(name);
        panel.add(dateLabel);
        panel.add(fecha);
        panel.add(hourLabel);
        panel.add(hora);
        panel.add(accept_button);
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
    public static void main(String[] args) throws IOException, Exception {
        AddAppointmentView.setLookAndFeel();
        AddAppointmentView addAppointmentView = new AddAppointmentView();
    }
}
