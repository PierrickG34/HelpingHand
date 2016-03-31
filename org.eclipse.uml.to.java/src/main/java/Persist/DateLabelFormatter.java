package Persist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class DateLabelFormatter.
 */
public class DateLabelFormatter extends AbstractFormatter {

    /** The date pattern. */
    private String datePattern = "yyyy-MM-dd";
    
    /** The date formatter. */
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    /* (non-Javadoc)
     * @see javax.swing.JFormattedTextField.AbstractFormatter#stringToValue(java.lang.String)
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    /* (non-Javadoc)
     * @see javax.swing.JFormattedTextField.AbstractFormatter#valueToString(java.lang.Object)
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}