package org.vaadin.example.Clases;

import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DatePick extends VerticalLayout {

    public String fechaEnvio;

    public DatePick(){
        com.vaadin.flow.component.datepicker.DatePicker datePicker = new com.vaadin.flow.component.datepicker.DatePicker();
        datePicker.setLabel("Selecciona una fecha:"); // establezco el texto del label
        List<String> months = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre"); // lista de meses
        List<String> weekdays = Arrays.asList("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"); // lista de días de la semana
        List<String> weekdaysShort = Arrays.asList("Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"); // lista de días de la semana abreviados
        com.vaadin.flow.component.datepicker.DatePicker.DatePickerI18n i18n = new com.vaadin.flow.component.datepicker.DatePicker.DatePickerI18n() // inicializo el date picker
                .setToday("Hoy") // establezco el texto del botón de hoy
                .setCancel("Cancelar") // establezco el texto del botón de cancelar
                .setFirstDayOfWeek(1) // establezco el primer día de la semana
                .setMonthNames(months) // establezco los meses
                .setWeekdays(weekdays) // establezco los días de la semana
                .setWeekdaysShort(weekdaysShort)
                .setDateFormat("dd-MM-yyyy"); // establezco los días de la semana abreviados
        datePicker.setI18n(i18n);
        add(datePicker); // añado el datepicker al layout
        datePicker.addValueChangeListener(event -> {
            LocalDate date = event.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dateString = date.format(formatter);
            System.out.println("Selected date: " + dateString);
            fechaEnvio = dateString;
        });

    }
    public String getFechaEnvio() {
        return fechaEnvio;
    }
}


