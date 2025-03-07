package com.springcore.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Teacher")
@Scope("prototype")
public class Teacher {
		@Value("Avid madid")
		private String name;
		@Value("al iklal")
		private String city;
		@Value("338")
		private int id;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "Teacher [name=" + name + ", city=" + city + ", id=" + id + "]";
		}
		
		
}
