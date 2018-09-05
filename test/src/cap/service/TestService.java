package cap.service;


import cap.bean.Test;
import cap.util.PageBean;

/**
* @author 作者:
* @createDate 创建时间：2018年7月5日 下午4:05:59
*/
public interface TestService {
	public int addTest(Test test);
	public int updateTest(Test test);
	public int delById(int id);
	public Test findById(int id);
	public PageBean findByPage(int pageNo,int pageSize);
}
 