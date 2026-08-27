import javax.swing.*;
import org.jdatepicker.impl.*;
import java.awt.*;
import java.util.Properties;

public class DatePickerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Date Picker Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Date Picker Properties
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        // Create Date Picker
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        frame.add(datePicker);
        frame.setVisible(true);
    }
}

// Formatter for the DatePicker
class DateLabelFormatter extends javax.swing.JFormattedTextField.AbstractFormatter {
    @Override
    public Object stringToValue(String text) {
        return text;
    }

    @Override
    public String valueToString(Object value) {
        return (value != null) ? value.toString() : "";
    }
}
