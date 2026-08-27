import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateCountryWordDocument
{

    public static void CreateWord(clsCountry object[])
    {
        XWPFDocument document = new XWPFDocument();
        try
        {
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Hello, this is a sample Word document created with Apache POI.");

            XWPFParagraph styledParagraph = document.createParagraph();
            XWPFRun styledRun = styledParagraph.createRun();
            styledRun.setText("This text is bold and red.");
            styledRun.setBold(true);
            styledRun.setColor("FF0000");

            XWPFTable table = document.createTable(object.length + 1, 2); // Dynamic size
            table.getRow(0).getCell(0).setText("CountryID");
            table.getRow(0).getCell(1).setText("CountryName");

            int i = 1;
            for (clsCountry obj : object) {
                table.getRow(i).getCell(0).setText(String.valueOf(obj.getCountryID()));
                table.getRow(i).getCell(1).setText(obj.getCountryName());
                i++;
            }

            FileOutputStream outputStream = new FileOutputStream("sample.docx");
            document.write(outputStream);
            outputStream.close();
            System.out.println("Word document created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}