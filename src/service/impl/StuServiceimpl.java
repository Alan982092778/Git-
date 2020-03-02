package service.impl;

import java.util.List;

import dao.StuDao;
import enity.Stu;
import service.StuService;

public class StuServiceimpl implements StuService {
	StuDao dao=new StuDao();
	@Override
	public List<Stu> find() {
		return dao.find();
	}

}
