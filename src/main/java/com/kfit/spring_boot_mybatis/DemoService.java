package com.kfit.spring_boot_mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@CacheConfig
public class DemoService {

	@Autowired
	private DemoMappper demoMappper;
	@Resource
	private RedisTemplate<String, Demo> redisTemplate;
	@Cacheable(value="redis-getByName")
	public List<Demo> likeName(String name){
		return demoMappper.likeName(name);
	}
	
	@Cacheable(value="demo")
	public Demo getById(int id){
		return demoMappper.getById(id);
	}
	
	@Transactional//添加事务.
	@CachePut(value="demo")
	public Demo save(Demo demo){
		demoMappper.save(demo);
		return demo;
	}
//	@Transactional//添加事务.
	@CachePut(value="demo")
	public Demo update(Demo demo) {
		demoMappper.update(demo);
		return demo;
		
	}
	
	public Demo getByName(String name) {
		return demoMappper.getByName(name);
			
		
	}
	
}
