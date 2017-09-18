package sch.com.serviceImpl.wym;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.com.dao.wymm.Tb_InstituteDao;
import sch.com.entity.TbInstitute;
import sch.com.service.wym.Tb_InstituteService;

@Service
public class Tb_InstituteServiceImpl implements Tb_InstituteService{
	@Autowired
	private Tb_InstituteDao dao;
	
	public List<TbInstitute> Tb_InstituteAllQuery() {
		
		return dao.Tb_InstituteAllQuery();
	}

}
