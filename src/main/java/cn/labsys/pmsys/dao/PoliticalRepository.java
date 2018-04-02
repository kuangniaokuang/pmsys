package cn.labsys.pmsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.labsys.pmsys.entity.Political;

public interface PoliticalRepository extends JpaRepository<Political, Long> {

}
