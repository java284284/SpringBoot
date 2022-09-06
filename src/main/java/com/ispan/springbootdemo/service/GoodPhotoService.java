package com.ispan.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.springbootdemo.model.GoodPhoto;
import com.ispan.springbootdemo.model.GoodPhotoDao;

@Service
@Transactional
public class GoodPhotoService {

	@Autowired
	private GoodPhotoDao gDao;

	// 新增一筆
	public GoodPhoto insertPhoto(GoodPhoto gp) {
		return gDao.save(gp);
	}

	// 列出全部
	public List<GoodPhoto> getAllPhoto() {
		return gDao.findAll();
	}

	// 透過 id 找到 1 筆
	public GoodPhoto getPhotoById(Integer id) {
		Optional<GoodPhoto> optional = gDao.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

}