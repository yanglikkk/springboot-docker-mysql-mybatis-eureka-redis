package com.kfit.spring_boot_mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

public interface DemoMappper {
	
	//#{name}:参数占位符
	@Select("select *from demo where name=#{name}")
	public List<Demo> likeName(String name);
	
	
	@Select("select * from demo where name = #{name}")
	public Demo getByName(String name);
	
	@Select("select name from demo where id = #{id}")
	public String getNameById(int id);

	@Select("select * from demo where id = #{id}")
	public Demo getById(int id);
	
	@Update("update demo set name=#{name} where id = #{id}")
	public void update(Demo demo);
	
	/**
	 * 保存数据.
	 */
	@Insert("insert into demo(name) values(#{name})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	public void save(Demo demo);
	
}
