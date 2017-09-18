package sch.com.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.sun.star.io.IOException;

/**
 * Ԥ����ʽת����
 * @author yang
 *
 */
public class DocConverter {
	private static final int environment = 1;// ���� 1��windows 2:linux  
    private String fileString;// (ֻ�漰pdf2swf·������)  
    private String outputPath = "";// ����·�� ����������þ������Ĭ�ϵ�λ��  
    private String fileName;//�ļ�·��ȫ��  
    private File pdfFile;//ת��Ϊ��pdf�ļ�
    private File swfFile;//ת��Ϊ��swf�ļ�
    private File docFile;//��ȡԭʼ�ļ�
    
    public DocConverter(String fileString) {  
        ini(fileString);  
    }  
  
    /** 
     * ��������file 
     *  
     * @param fileString 
     */  
    public void setFile(String fileString) {  
        ini(fileString);  
    }  
    
    /**
     *��ʼ�� �ļ� 
     * @param fileString 
     */  
   private void ini(String fileString) {  
       this.fileString = fileString;  
       fileName = fileString.substring(0, fileString.lastIndexOf("."));  
       docFile = new File(fileString);  
       pdfFile = new File(fileName + ".pdf");  
       swfFile = new File(fileName + ".swf");  
   }  
   /**
    * ���ļ�����ת��Ϊpdf�ļ�
    * @throws Exception
    */
   private void doc2pdf() throws Exception {  
       if (docFile.exists()) {  
           if (!pdfFile.exists()) {  
               OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100); 
               //OpenOfficeConnection connection = new SocketOpenOfficeConnection("yourIP",8100);
               try {  
                   connection.connect();  
                   DocumentConverter converter = new OpenOfficeDocumentConverter(connection); 
                   converter.convert(docFile, pdfFile);  
                   // close the connection  
                   connection.disconnect();  
                   System.out.println("****pdfת���ɹ���PDF�����" + pdfFile.getPath()+ "****");  
               } catch (java.net.ConnectException e) {  
                   e.printStackTrace();  
                   System.out.println("****swfת�����쳣��openoffice����δ������****");  
                   throw e;  
               } catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {  
                   e.printStackTrace();  
                   System.out.println("****swfת�����쳣����ȡת���ļ�ʧ��****");  
                   throw e;  
               } catch (Exception e) {  
                   e.printStackTrace();  
                   throw e;  
               }  
           } else {  
               System.out.println("****�Ѿ�ת��Ϊpdf������Ҫ�ٽ���ת��****");  
           }  
       } else {  
           System.out.println("****swfת�����쳣����Ҫת�����ĵ������ڣ��޷�ת��****");  
       }  
   } 
   
   /**
    * �ڰ�pdf�ļ�ת��Ϊswf
    * @throws Exception
    */
   @SuppressWarnings("unused")
   private void pdf2swf() throws Exception {  
       Runtime r = Runtime.getRuntime();  
       if (!swfFile.exists()) {  
           if (pdfFile.exists()) {  
               if (environment == 1) {// windows��������  
                   try {  
                       Process p = r.exec("D:/yulan/swf/pdf2swf.exe "+ pdfFile.getPath() + " -o "+ swfFile.getPath() + " -T 9 -G -s poly2bitmap");  
                       System.out.print(loadStream(p.getInputStream()));  
                       System.err.print(loadStream(p.getErrorStream()));  
                       System.out.print(loadStream(p.getInputStream()));  
                       System.err.println("****swfת���ɹ����ļ������"  
                               + swfFile.getPath() + "****");  
                       if (pdfFile.exists()) {  
                           pdfFile.delete();  
                       }  
 
                   } catch (IOException e) {  
                       e.printStackTrace();  
                       throw e;  
                   }  
               } else if (environment == 2) {// linux��������  
                   try {  
                       Process p = r.exec("pdf2swf " + pdfFile.getPath()  
                               + " -o " + swfFile.getPath() + " -T 9");  
                       System.out.print(loadStream(p.getInputStream()));  
                       System.err.print(loadStream(p.getErrorStream()));  
                       System.err.println("****swfת���ɹ����ļ������"  
                               + swfFile.getPath() + "****");  
                       if (pdfFile.exists()) {  
                           pdfFile.delete();  
                       }  
                   } catch (Exception e) {  
                       e.printStackTrace();  
                       throw e;  
                   }  
               }  
           } else {  
               System.out.println("****pdf������,�޷�ת��****");  
           }  
       } else {  
           System.out.println("****swf�Ѿ����ڲ���Ҫת��****");  
       }  
   } 
   
   static String loadStream(InputStream in) throws Exception {  
	   
       int ptr = 0;  
       in = new BufferedInputStream(in);  
       StringBuffer buffer = new StringBuffer();  
 
       while ((ptr = in.read()) != -1) {  
           buffer.append((char) ptr);  
       }  
 
       return buffer.toString();  
   }  
   
   /** 
    * ת�������� 
    */  
   @SuppressWarnings("unused")  
   public boolean conver() {  
 
       if (swfFile.exists()) {  
           System.out.println("****swfת������ʼ���������ļ��Ѿ�ת��Ϊswf****");  
           return true;  
       }  
 
       if (environment == 1) {  
           System.out.println("****swfת������ʼ��������ǰ�������л���windows****");  
       } else {  
           System.out.println("****swfת������ʼ��������ǰ�������л���linux****");  
       }  
       try {  
           doc2pdf();  
           pdf2swf();  
       } catch (Exception e) {  
           e.printStackTrace();  
           return false;  
       }  
 
       if (swfFile.exists()) {  
           return true;  
       } else {  
           return false;  
       }  
   }  
 
   /** 
    * �����ļ�·�� 
    *  
    * @param s 
    */  
   public String getswfPath() {  
       if (swfFile.exists()) {  
           String tempString = swfFile.getPath();  
           tempString = tempString.replaceAll("\\\\", "/");  
           return tempString;  
       } else {  
           return "";  
       }  
 
   }  
   /** 
    * �������·�� 
    */  
   public void setOutputPath(String outputPath) {  
       this.outputPath = outputPath;  
       if (!outputPath.equals("")) {  
           String realName = fileName.substring(fileName.lastIndexOf("/"),  
                   fileName.lastIndexOf("."));  
           if (outputPath.charAt(outputPath.length()) == '/') {  
               swfFile = new File(outputPath + realName + ".swf");  
           } else {  
               swfFile = new File(outputPath + realName + ".swf");  
           }  
       }  
   }  
}
