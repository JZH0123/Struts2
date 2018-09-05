package cap.service.impl;

import java.util.List;

import cap.bean.Test;
import cap.dao.TestDAO;
import cap.dao.impl.TestDAOImpl;
import cap.service.TestService;
import cap.util.PageBean;

/**
* @author 作者:
* @createDate 创建时间：2018年7月5日 下午4:07:39
*/
public class TestServiceImpl implements TestService {
      TestDAO testDAO=new TestDAOImpl();
	@Override
	public int addTest(Test test) {
		return testDAO.addTest(test);
	}

	@Override
	public int updateTest(Test test) {
		return testDAO.updateTest(test);
	}

	@Override
	public int delById(int id) {
		return testDAO.delById(id);
	}

	@Override
	public Test findById(int id) {
		return testDAO.findById(id);
	}

	@Override
	public PageBean findByPage(int pageNo, int pageSize) {
		PageBean pg=new PageBean();
		List<Test> testList=testDAO.findByPage(pageNo, pageSize);
		pg.setList(testList);
		pg.setPageNo(pageNo);
		pg.setPageSize(pageSize);
		pg.setTotalRecords(testDAO.getTotalRecords());
		return pg;
	}

}
 