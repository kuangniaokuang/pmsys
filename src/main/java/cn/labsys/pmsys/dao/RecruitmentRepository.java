package cn.labsys.pmsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.labsys.pmsys.entity.Recruitment;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {
	List<Recruitment> findByRequirementidIn(Long[] requirementids);
}
