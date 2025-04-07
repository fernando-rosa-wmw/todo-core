package org.acme.shared.helper;

import java.time.LocalDate;

public class DateHelper {
    
    public static LocalDate convertStringToDate(String date) {
        return LocalDate.parse(date);
    }

}
