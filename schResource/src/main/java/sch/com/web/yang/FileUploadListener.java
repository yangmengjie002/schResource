package sch.com.web.yang;

import org.apache.commons.fileupload.ProgressListener;  
import javax.servlet.http.HttpSession;  
  
public class FileUploadListener implements ProgressListener {  
  
    final HttpSession hs;  
  
    public FileUploadListener(HttpSession hs) {  
        this.hs = hs;  
    }  
  
    @Override  
    public void update(long pBytesRead, long pContentLength, int pItems) {  
        //pBytesRead �Ѿ��ϴ������ֽ�  
        //pContentLength һ�������ֽ�  
        //pItems �����ϴ��ڼ����ļ�  
        ProcessInfo pri = new ProcessInfo();  
        pri.itemNum = pItems;  
        pri.readSize = pBytesRead;  
        pri.totalSize = pContentLength;  
        pri.show = Math.round(new Float(pBytesRead) / new Float(pContentLength)*100)+" %";  
        pri.rate = Math.round(new Float(pBytesRead) / new Float(pContentLength)*100);  
        hs.setAttribute("proInfo", pri);  
    }  
  
    public class ProcessInfo{  
        public long totalSize = 1;  
        public long readSize = 0;  
        public String show = "";  
        public int itemNum = 0;  
        public int rate = 0;  
    }  
  
}  
