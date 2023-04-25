package pdfConcate;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class pdfMerge {
    static String file1 = "C:\\Users\\User\\Downloads\\1 лек.pdf";
    static String file2 = "C:\\Users\\User\\Downloads\\2 лек.pdf";
    static String file3 = "C:\\Users\\User\\Downloads\\3 лек.pdf";
    static String file4 = "C:\\Users\\User\\Downloads\\4 лек.pdf";
    static String file5 = "C:\\Users\\User\\Downloads\\5 лек.pdf";
    static String file6 = "C:\\Users\\User\\Downloads\\6 лек.pdf";
    public static void main(String[] args) {
        try {
            //пути к исходным pdf файлам

            String[] arr = new String[6];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (String) pdfMerge.class.getDeclaredField("file"+(i+1)).get(new pdfMerge());
            }
            //путь к новому pdf файлу
            System.out.println(Arrays.toString(arr));
            String mergeFile = "output.pdf";


            //открываем исходные pdf документы


            //создаем новый pdf документ
            Document document = new Document();
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(mergeFile));
            document.open();

            for (int i = 0; i < arr.length; i++) {
                PdfReader reader = new PdfReader(arr[i]);

                //копируем страницы из первого pdf документа
                for (int j = 1; j <= reader.getNumberOfPages(); j++) {
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
                reader.close();
            }
            //копируем страницы из второго pdf документа

            //закрываем pdf документы
            document.close();

            System.out.println("PDF файлы успешно объединены!");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
