package pe.algoritmo.vidarte.views.votaciones;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileNotFoundException;

public class PdfReportGenerator {

    public void generatePdfReport(JTable table, String dest) throws FileNotFoundException {
        // Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        // Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(PageSize.A4.rotate());
        
        // Initialize document
        Document document = new Document(pdf);

        // Create a table with the same number of columns as the JTable
        Table pdfTable = new Table(table.getColumnCount());
        pdfTable.setWidth(UnitValue.createPercentValue(100));

        // Add table headers
        TableModel model = table.getModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            pdfTable.addHeaderCell(new Cell().add(new Paragraph(model.getColumnName(i))));
        }

        // Add table rows
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                pdfTable.addCell(new Cell().add(new Paragraph(model.getValueAt(row, col).toString())));
            }
        }

        // Add the table to the document
        document.add(pdfTable);

        // Close the document
        document.close();
    }
}