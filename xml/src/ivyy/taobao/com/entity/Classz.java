package ivyy.taobao.com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description£º
 */
public class Classz implements Serializable{

	private List<Student> students=new ArrayList<Student>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
