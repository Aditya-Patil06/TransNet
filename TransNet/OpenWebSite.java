import java.awt.Desktop;
import java.net.URI;
public class OpenWebSite
{
    public static void openPage(String website)
    {
        try
        {
            if (Desktop.isDesktopSupported())
            {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(website));
            }
            else
            {
                System.out.println("Desktop is not supported on this system.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}