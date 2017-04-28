
package com.example.sal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.SalMapper;

@Service
public class SalUnregisterService {

	@Autowired
	SalMapper salMapper;
	
	public void unregister(int salno) {
		salMapper.deleteBySalno(salno);
	}
}
