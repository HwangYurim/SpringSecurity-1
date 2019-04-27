package SampleService.SampleServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securiry.study.dao.SampleMapper;
import com.securiry.study.vo.UserVo;

import SampleService.SampleService;

@Service
public class SampleServiceImpl implements SampleService {
	
	//#4 dao�� ������ ����
	@Autowired
	private SampleMapper sampleMapper;
	
	/**
	 * ���������� �����´�.
	 * @return
	 */
	@Override
	public UserVo getUser() {

		return sampleMapper.getUser();
	}

}
