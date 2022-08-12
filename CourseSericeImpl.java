package com.springrest.springrest.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseSericeImpl implements CourseService {
	List<Course> list;
	public  CourseSericeImpl()
	{ 
	   
	list=new ArrayList<>();
	list.add(new Course(145,"Java","This java course"));
	list.add(new Course(146,"spring","This spring course"));
	list.add(new Course(147,"react","This react course"));
	
	}
	@Override 
	public List<Course> getCourses() {
		
		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		
	
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		
		
		list.add(course);
		
		return course ;
	}
	
	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
	
		list.forEach(e->{
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		
		
		return course;
	}
	
	@Override
     public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}

}


