package com.oze.ozehospital.helper;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.oze.ozehospital.entities.Patient;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
public class CSVHelper {
    public static ByteArrayInputStream patientToCSV(Optional<Patient> patients) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
                List<? extends Serializable> data = Arrays.asList(
                        String.valueOf(patients.get().getId()),
                        patients.get().getName(),
                        patients.get().getAge(),
                        patients.get().getLastVisitDate(),
                        patients.get().getCreatedAt()
                );
                csvPrinter.printRecord(data);
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import patient profile to CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream patientToCSVAll(List<Patient> patients) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Patient patient : patients) {
                List<? extends Serializable> data = Arrays.asList(
                        String.valueOf(patient.getId()),
                        patient.getName(),
                        patient.getAge(),
                        patient.getLastVisitDate(),
                        patient.getCreatedAt()
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import patient profile to CSV file: " + e.getMessage());
        }
    }
}
