package com.selcukuzunsoy.daos;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.selcukuzunsoy.models.Personel;

@Repository
public interface PersonelRepository extends CrudRepository<Personel, Long> {

	List<Personel> findByTc(String tc);

	@Query("select p from Personel p where p.ad like %:pad%")
	Stream<Personel> findByAdReturnStream(@Param("pad") String ad);

}
