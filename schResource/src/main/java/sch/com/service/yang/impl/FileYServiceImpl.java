package sch.com.service.yang.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sch.com.dao.yang.FileYDao;
import sch.com.entity.ResourceYInfo;
import sch.com.service.yang.FileYService;
import sch.com.utils.DateUtils;
@Service
public class FileYServiceImpl implements FileYService{
	@Autowired
	private FileYDao fd;

	@Override
	@Transactional
	public List<Map<String, Object>> fileDown(Integer userId, Integer id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> fileInfo = fd.getFileInfo(id);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		Integer resourceId = Integer.parseInt(fileInfo.get(0).get("RESOURCE_ID")+"");
		map.put("resourceId", resourceId);
		Date date = new Date();
		String downloadDate = DateUtils.dateToStrLong(date);
		map.put("downloadDate", downloadDate);
		fd.insertDownload(map);
		return fileInfo;
	}

	@Override
	public List<Map<String, Object>> getResourceInfoFix(String postfix) {
		// TODO Auto-generated method stub
		return fd.getResourceInfoFix(postfix);
	}

	@Override
	public int fileUploadAll(ResourceYInfo resourceInfo) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String dateToStr = DateUtils.dateToStr(date);
		resourceInfo.setUploadDate(dateToStr);
	/*	resourceInfo.setStatusId(1);
		resourceInfo.setMajorId(0);*/
		try {
			return fd.fileUploadAll(resourceInfo);
		} catch (Exception e) {
			throw new RuntimeException("�������������");
		}
	}

	@Override
	public String selectDown(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> downList = fd.selectDown(map);
		if(downList.size()>0){
			return "success";
		}
		return "error";
	}

	@Override
	public List<Map<String, Object>> showDown(Integer id) {
		// TODO Auto-generated method stub
		return fd.showDown(id);
	}
}
