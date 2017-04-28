package com.example.dnltime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.DnltimeMapper;

@Service
public class DnltimeUnregisterService {

	@Autowired
	DnltimeMapper dnltimeMapper;
	
	public void unregister(int dnlno){
		dnltimeMapper.deleteByDnlno(dnlno);
	}
}
