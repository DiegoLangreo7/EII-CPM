package uo.cpm.s5.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class CalendarioPanel extends JFrame {
    private JDateChooser dateChooser;

    public CalendarioPanel() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calendario Demo");

        JPanel panel = new JPanel();
        dateChooser = new JDateChooser();

        // Personaliza el JDateChooser según tus preferencias
        dateChooser.setDateFormatString("yyyy-MM-dd"); // Formato de la fecha

        // Agrega el JDateChooser al JPanel
        panel.add(dateChooser);

        // Agrega el JCalendar al JPanel (opcional)
        JCalendar jCalendar = new JCalendar();
        panel.add(jCalendar);

        // Añade el JPanel al JFrame
        add(panel);

        pack();
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalendarioPanel().setVisible(true);
        });
    }
}




