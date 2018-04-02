package cn.labsys.pmsys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.labsys.pmsys.dao.RecruitmentRepository;
import cn.labsys.pmsys.entity.Recruitment;

@RestController
@RequestMapping("/recruitment")
public class RecruitmentController {
	@Autowired
	RecruitmentRepository recruitmentRepository;

	@RequestMapping("/all")
	public List<Recruitment> findAll(String requirementids) {
		String[] requirementidStrings = requirementids.split(",");
		Integer requirementLength = requirementidStrings.length;
		Long[] requirementidLongs = new Long[requirementLength];
		for (int i = 0; i < requirementLength; i++) {
			requirementidLongs[i] = Long.parseLong(requirementidStrings[i]);
		}
		List<Recruitment> recruitments = recruitmentRepository.findByRequirementidIn(requirementidLongs);
		return recruitments;
	}

	@RequestMapping("/r")
	public Recruitment findById(Long id) {
		Recruitment recruitment = recruitmentRepository.findOne(id);
		return recruitment;
	}

	@RequestMapping("/save")
	public Recruitment save(Long id, Long requirementid, String interviewee, Integer step, String interviewdateStr,
			String interviewer, String evaluation, String remark) throws ParseException {
		Recruitment newRecruitment;
		Date updatedate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date interviewdate = null;
		if (interviewdateStr != "") {
			interviewdate = (Date) format.parse(interviewdateStr);
		}
		if (id == 0) {
			id = null;
			newRecruitment = new Recruitment(id, requirementid, interviewee, null, null, null, null, null, null, null,
					null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
					null, null, null, null, null, null, null, null);
		} else {
			newRecruitment = recruitmentRepository.findOne(id);
			if (newRecruitment.getStep() == null || step > newRecruitment.getStep()) {
				newRecruitment.setStep(step);
			}
			switch (step) {
			case 1:
				newRecruitment.setInterviewdate1(interviewdate);
				newRecruitment.setInterviewer1(interviewer);
				newRecruitment.setEvaluation1(evaluation);
				newRecruitment.setRemark1(remark);
				newRecruitment.setUpdatedate1(updatedate);
				break;
			case 2:
				newRecruitment.setInterviewdate2(interviewdate);
				newRecruitment.setInterviewer2(interviewer);
				newRecruitment.setEvaluation2(evaluation);
				newRecruitment.setRemark2(remark);
				newRecruitment.setUpdatedate2(updatedate);
				break;
			case 3:
				newRecruitment.setInterviewdate3(interviewdate);
				newRecruitment.setInterviewer3(interviewer);
				newRecruitment.setEvaluation3(evaluation);
				newRecruitment.setRemark3(remark);
				newRecruitment.setUpdatedate3(updatedate);
				break;
			case 4:
				newRecruitment.setInterviewdate4(interviewdate);
				newRecruitment.setInterviewer4(interviewer);
				newRecruitment.setEvaluation4(evaluation);
				newRecruitment.setRemark4(remark);
				newRecruitment.setUpdatedate4(updatedate);
				break;
			case 5:
				newRecruitment.setInterviewdate5(interviewdate);
				newRecruitment.setInterviewer5(interviewer);
				newRecruitment.setEvaluation5(evaluation);
				newRecruitment.setRemark5(remark);
				newRecruitment.setUpdatedate5(updatedate);
				break;
			case 6:
				newRecruitment.setInterviewdate6(interviewdate);
				newRecruitment.setInterviewer6(interviewer);
				newRecruitment.setEvaluation6(evaluation);
				newRecruitment.setRemark6(remark);
				newRecruitment.setUpdatedate6(updatedate);
				break;
			}
		}
		Recruitment recruitment = recruitmentRepository.save(newRecruitment);
		return recruitment;
	}
}
