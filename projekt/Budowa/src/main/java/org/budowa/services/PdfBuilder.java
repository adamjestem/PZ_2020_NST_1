package org.budowa.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class PdfBuilder {
    public static PdfBuilder inject() {
        return new PdfBuilder();
    }

    private Document document;

    public PdfBuilder create(String name) throws FileNotFoundException, DocumentException {
        this.document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(String.format("%s.pdf", name)));

        document.open();
        return this;
    }

    public void save() {
        document.close();
    }

    public PdfBuilder addText(String text) throws DocumentException {
        Font defaultFont = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        return this.addText(text, defaultFont);
    }

    public PdfBuilder addText(String text, Font font) throws DocumentException {
        Chunk chunk = new Chunk(text, font);

        this.document.add(chunk);

        return this;
    }

    public PdfBuilder addTable(List<String> headers, Object[][] data) throws DocumentException {
        PdfPTable table = new PdfPTable(headers.size());
        addTableHeader(table, headers);
        addRows(table, data);

        this.document.add(table);
        return this;
    }

    private void addTableHeader(PdfPTable table, List<String> headers) {
        headers.forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });
    }

    private void addRows(PdfPTable table, Object[][] data) {
        Stream.of(data).forEach(row -> Stream.of(row).forEach(cell -> {
            var value = cell.toString();
            table.addCell(value);
        }));
    }

    public PdfBuilder addEmptyLine() throws DocumentException {
        this.document.add(new Paragraph("\n"));
        return this;
    }

    public PdfBuilder addParagraph() throws DocumentException {
        this.document.add(new Paragraph());
        return this;
    }

    public PdfBuilder addTab() throws DocumentException {
        return this.addTab(1);
    }

    public PdfBuilder addTab(int number) throws DocumentException {
        for (int i = 0; i < number; i++) {
            this.document.add(Chunk.TABBING);
        }

        return this;
    }

    public PdfBuilder addDataBlock(String title, String value) throws DocumentException {
        return this.addText(title)
                .addParagraph()
                .addTab()
                .addText(value)
                .addParagraph();
    }

    public PdfBuilder addList(String title, String[] data) throws DocumentException {
        this.addText(title);

        if (data.length > 0) {
            for (var d : data) {
                this.addParagraph().addTab().addText(d);
            }
        } else {
            this.addParagraph().addTab().addText("Brak");
        }
        this.addParagraph();

        return this;
    }

}
