package a2_springmvc_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import a2_springmvc_crud.dto.StudentDto;

@Component
public class StudentDao {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	
	public String insert(StudentDto d1)
	{
		t.begin();
		m.persist(d1);
		t.commit();
		return "data inserted successfully";
	}
	
	public String deleteById(int id)
	{
		StudentDto d1 = m.find(StudentDto.class, id);
		if(d1!=null)
		{
			t.begin();
			m.remove(d1);
			t.commit();
			return "data deleted";
		}
		else {
			return "data not found";
		}	
	}
	
	public String deleteAll()
	{
		Query q = m.createQuery("select data from StudentDto data");
		List<StudentDto> l = q.getResultList();
		if(l.isEmpty())
		{
			return "no data found";
		}
		else {
			t.begin();
			for(StudentDto d1:l)
			{
				m.remove(d1);
			}
			t.commit();
			return "all data deleted";
		}
		
	}
	public Object fetchById(int id)
	{
		StudentDto d1 = m.find(StudentDto.class, id);
		if(d1!=null)
		{
			return d1;
		}
		else {
			return "no data found";
		}
	}
	
	public List<StudentDto> fetchAll()
	{
		Query q = m.createQuery("select data from StudentDto data");
		List<StudentDto> l = q.getResultList();
		if(l.isEmpty())
		{
			return null;
		}
		else {
			return l;
		}
	}
	public String update(StudentDto d1)
	{
		t.begin();
		m.merge(d1);
		t.commit();
		
		return "updated successfully";
	}
	
	

}
