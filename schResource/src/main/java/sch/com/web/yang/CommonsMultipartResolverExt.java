package sch.com.web.yang;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;  
/**
 * 重新上传方法
 * @author yang
 *
 */
public class CommonsMultipartResolverExt extends CommonsMultipartResolver {  
    @Override  
    protected MultipartParsingResult parseRequest(HttpServletRequest request)  
            throws MultipartException {  
        final HttpSession hs = request.getSession();  
        FileUploadListener listener = new FileUploadListener(hs); //利用构造方法传递参数  
        String encoding = determineEncoding(request);  
        FileUpload fileUpload = prepareFileUpload(encoding);  
        fileUpload.setProgressListener(listener);  
        try {  
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);  
            return parseFileItems(fileItems, encoding);  
        }  
        catch (FileUploadBase.SizeLimitExceededException ex) {  
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);  
        }  
        catch (FileUploadException ex) {  
            throw new MultipartException("Could not parse multipart servlet request", ex);  
        }  
    }  
}  
