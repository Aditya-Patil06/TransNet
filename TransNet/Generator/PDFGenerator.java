// Last Updated on 22/02/2025 By yours Truly Aditya Patil
package Generator;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.List;

public class PDFGenerator
{

    private static String getDefaultDirectory()
    {
        return "D:\\Aditya_Project_TransNet\\PDF_Storage";
    }

    public static boolean generatePDF(String[] contentLines, String filename)
    {
        String fullFilePath = getDefaultDirectory() + "\\" + filename;
        System.out.println("Attempting to create PDF at: " + fullFilePath);

        try
        {
            File directory = new File(getDefaultDirectory());
            if (!directory.exists())
            {
                if (!directory.mkdirs())
                {
                    System.err.println("Error creating PDF directory: " + getDefaultDirectory());
                    return false;
                }
                System.out.println("Directory created: " + getDefaultDirectory());
            }

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fullFilePath));
            document.open();

            for (String line : contentLines)
            {
                document.add(new Paragraph(line));
            }

            document.close();
            writer.close();
            System.out.println("PDF created successfully at: " + fullFilePath);
            return true;

        }
        catch (IOException e)
        {
            System.err.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        catch (com.itextpdf.text.DocumentException e)
        {
            System.err.println("DocumentException occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}