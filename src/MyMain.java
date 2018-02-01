import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class MyMain {
	 public static final String SRC = "c:/MyTest/testPDF.pdf";
	    public static final String DEST = "c:/MyTest/testPDF_with_image_id.pdf";
	    public static final String IMG = "c:/MyTest/btag01.png";
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		/* PdfReader reader1 = new PdfReader( "c:\\Users\\zoltan.bihari\\mytest\\AddImgToPDF\\testPDF.pdf");
		 
		Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File("c:\\Users\\zoltan.bihari\\mytest\\AddImgToPDF\\testPDF.pdf")));
        document.open();
      /*  Image img1 = Image.getInstance("beatag.png");
        img1.scaleAbsolute(50f, 50f);
        document.add(img1);*/
      /*  Image img2 = Image.getInstance("beatag.png");
        img2.scaleToFit(100f, 100f);
        document.add(img2);
        document.close();
        System.out.println("Done");*/
		   File file = new File(DEST);
	        file.getParentFile().mkdirs();
	        new MyMain().manipulatePdf1(SRC, DEST,0,0,0);
	        /*new MyMain().manipulatePdf(DEST, DEST,70, 500,1);
	        new MyMain().manipulatePdf(DEST, DEST,70, 500,3);
	        new MyMain().manipulatePdf(DEST, DEST,70, 500,5);*/
	    }
	 
	    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
	   
	    PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Image image = Image.getInstance(IMG);
        image.scaleAbsolute(150f, 45f);
        PdfImage stream = new PdfImage(image, "", null);
        stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
        image.setDirectReference(ref.getIndirectReference());
        image.setAbsolutePosition(70, 249);                
        PdfContentByte over = stamper.getOverContent(2);
        over.addImage(image);
        stamper.close();
        reader.close();
        System.out.println("END");
   }
	    
	    public void manipulatePdf1(String src, String dest, int x, int y ,int line) throws IOException, DocumentException {
	 	   
		    PdfReader reader = new PdfReader(src);
	        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
	        
	     //   Image image = Image.getInstance(IMG);
	       
	       // Image image3 = Image.getInstance(IMG);
	        Image image4 = Image.getInstance(IMG);
	        
	        Image image = Image.getInstance(IMG);
	        image.scaleAbsolute(150f, 50f);	  
	        PdfImage stream = new PdfImage(image, "", null);	        
	        stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
	        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);	        
	        image.setDirectReference(ref.getIndirectReference());
	        image.setAbsolutePosition(85, 249);                
	        PdfContentByte over = stamper.getOverContent(1);
	        over.addImage(image);
	       System.out.println(over.getXTLM());
	       System.out.println( over.getYTLM());
	       
	       // stamper.close();
	        
	        Image image2 = Image.getInstance(IMG);
	        image2.scaleAbsolute(130f, 45f);	  
	        PdfImage stream2 = new PdfImage(image2, "", null);	        
	        stream2.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
	        PdfIndirectObject ref2 = stamper.getWriter().addToBody(stream2);	        
	        image2.setDirectReference(ref2.getIndirectReference());
	        image2.setAbsolutePosition(85, 249);                
	        PdfContentByte over2 = stamper.getOverContent(2);
	        over2.addImage(image2);
	        
	        
	        /*Image image3 = Image.getInstance(IMG);
	        image3.scaleAbsolute(150f, 50f);	  
	        PdfImage stream3 = new PdfImage(image3, "", null);	        
	        stream3.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
	        PdfIndirectObject ref3 = stamper.getWriter().addToBody(stream3);	        
	        image3.setDirectReference(ref3.getIndirectReference());
	        image3.setAbsolutePosition(70, 249);                
	        PdfContentByte over3 = stamper.getOverContent(3);
	        over3.addImage(image3);*/
	        
	        image4.scaleAbsolute(150f, 45f);	  
	        PdfImage stream4 = new PdfImage(image4, "", null);	        
	        stream4.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
	        PdfIndirectObject ref4 = stamper.getWriter().addToBody(stream4);	        
	        image4.setDirectReference(ref4.getIndirectReference());
	        image4.setAbsolutePosition(85, 494);                
	        PdfContentByte over4 = stamper.getOverContent(5);
	        over4.addImage(image4);
	        
	        stamper.close();
	        
	        reader.close();
	        System.out.println("END");
	   }
} 