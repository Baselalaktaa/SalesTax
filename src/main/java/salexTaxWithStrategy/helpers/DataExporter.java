package salexTaxWithStrategy.helpers;

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import salexTaxWithStrategy.Product;
import salexTaxWithStrategy.Receipt;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

/**
 * class to Export receipt to pdf invoice
 * @author Basel Alaktaa
 * @since 04.09.2021 02:00
 * @version 1.0
 */

public class DataExporter {

    private Receipt receipt;

    private DataExporter(Receipt receipt) {
        this.receipt = receipt;
    }

    public void exportToPdf (){
        final String path = "receipt.pdf";
        try {

            PdfDocument pdfInvoice = new PdfDocument(new PdfWriter(path));
            Document document = new Document(pdfInvoice);

            document.add(new Paragraph("Invoice").setBold().setUnderline().setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph(String.valueOf(Date.from(Instant.parse(Instant.now().toString())))).setTextAlignment(TextAlignment.LEFT).setMultipliedLeading(0.2f));
            document.add(new Paragraph("Thanks for coming").setMultipliedLeading(.2f));
            document.add(new Paragraph("order details below: ").setMultipliedLeading(.2f));

            Table table = new Table(UnitValue.createPointArray(new float[]{50f, 50f, 50f, 50f, 50f, 50f}));

            table.addCell(new Paragraph("NR").setBold());
            table.addCell(new Paragraph("NAME").setBold());
            table.addCell(new Paragraph("QTY").setBold());
            table.addCell(new Paragraph("NET Price").setBold());
            table.addCell(new Paragraph("Tax").setBold());
            table.addCell(new Paragraph("Taxed price").setBold());

            Map<Product , Integer> products = receipt.getShoppingBasket().getProductsWithQty();

            int number = 1;

            for (Map.Entry<Product, Integer> entry : products.entrySet()){
                table.addCell(new Paragraph(String.valueOf(number)));
                table.addCell(new Paragraph(entry.getKey().getName()));
                table.addCell(new Paragraph(String.valueOf(entry.getValue())));
                table.addCell(new Paragraph(String.valueOf(entry.getKey().getPriceBeforeTax())));
                table.addCell(new Paragraph((String.valueOf(entry.getKey().getTax()))));
                table.addCell(new Paragraph((String.valueOf(entry.getKey().getPriceAfterTax()))));
                number ++;
            }
            table.addFooterCell(new Paragraph("Total adding tax for all products " + receipt.getApplicableTax()).setTextAlignment(TextAlignment.LEFT).setBold().setFirstLineIndent(100f));
            table.addFooterCell(new Paragraph("Total price after tax " + receipt.getTotalPrice() ).setTextAlignment(TextAlignment.LEFT).setBold().setFirstLineIndent(100f));

            document.add(table);
            document.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static DataExporter createDataExporter(Receipt receipt) {
        return new DataExporter(receipt);
    }
}
