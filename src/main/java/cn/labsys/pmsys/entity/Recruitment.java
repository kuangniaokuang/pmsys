package cn.labsys.pmsys.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recruitment {
	@Id
	@GeneratedValue
	private Long id;
	private Long requirementid;
	private String interviewee; // 应聘者
	private Integer step; // 一面 二面 三面 终面 offer on board
	private Date interviewdate1; // 面试时间
	private String interviewer1; // 面试者
	private String evaluation1; // 面试评价
	private String remark1; // 其他
	private Date updatedate1;
	// 一面 二面 三面 终面 offer on board
	private Date interviewdate2; // 面试时间
	private String interviewer2; // 面试者
	private String evaluation2; // 面试评价
	private String remark2; // 其他
	private Date updatedate2;
	// 一面 二面 三面 终面 offer on board
	private Date interviewdate3; // 面试时间
	private String interviewer3; // 面试者
	private String evaluation3; // 面试评价
	private String remark3; // 其他
	private Date updatedate3;
	// 一面 二面 三面 终面 offer on board
	private Date interviewdate4; // 面试时间
	private String interviewer4; // 面试者
	private String evaluation4; // 面试评价
	private String remark4; // 其他
	private Date updatedate4;
	// 一面 二面 三面 终面 offer on board
	private Date interviewdate5; // 面试时间
	private String interviewer5; // 面试者
	private String evaluation5; // 面试评价
	private String remark5; // 其他
	private Date updatedate5;
	// 一面 二面 三面 终面 offer on board
	private Date interviewdate6; // 面试时间
	private String interviewer6; // 面试者
	private String evaluation6; // 面试评价
	private String remark6; // 其他
	private Date updatedate6;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequirementid() {
		return requirementid;
	}

	public void setRequirementid(Long requirementid) {
		this.requirementid = requirementid;
	}

	public String getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(String interviewee) {
		this.interviewee = interviewee;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Date getInterviewdate1() {
		return interviewdate1;
	}

	public void setInterviewdate1(Date interviewdate1) {
		this.interviewdate1 = interviewdate1;
	}

	public String getInterviewer1() {
		return interviewer1;
	}

	public void setInterviewer1(String interviewer1) {
		this.interviewer1 = interviewer1;
	}

	public String getEvaluation1() {
		return evaluation1;
	}

	public void setEvaluation1(String evaluation1) {
		this.evaluation1 = evaluation1;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public Date getUpdatedate1() {
		return updatedate1;
	}

	public void setUpdatedate1(Date updatedate1) {
		this.updatedate1 = updatedate1;
	}

	public Date getInterviewdate2() {
		return interviewdate2;
	}

	public void setInterviewdate2(Date interviewdate2) {
		this.interviewdate2 = interviewdate2;
	}

	public String getInterviewer2() {
		return interviewer2;
	}

	public void setInterviewer2(String interviewer2) {
		this.interviewer2 = interviewer2;
	}

	public String getEvaluation2() {
		return evaluation2;
	}

	public void setEvaluation2(String evaluation2) {
		this.evaluation2 = evaluation2;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public Date getUpdatedate2() {
		return updatedate2;
	}

	public void setUpdatedate2(Date updatedate2) {
		this.updatedate2 = updatedate2;
	}

	public Date getInterviewdate3() {
		return interviewdate3;
	}

	public void setInterviewdate3(Date interviewdate3) {
		this.interviewdate3 = interviewdate3;
	}

	public String getInterviewer3() {
		return interviewer3;
	}

	public void setInterviewer3(String interviewer3) {
		this.interviewer3 = interviewer3;
	}

	public String getEvaluation3() {
		return evaluation3;
	}

	public void setEvaluation3(String evaluation3) {
		this.evaluation3 = evaluation3;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public Date getUpdatedate3() {
		return updatedate3;
	}

	public void setUpdatedate3(Date updatedate3) {
		this.updatedate3 = updatedate3;
	}

	public Date getInterviewdate4() {
		return interviewdate4;
	}

	public void setInterviewdate4(Date interviewdate4) {
		this.interviewdate4 = interviewdate4;
	}

	public String getInterviewer4() {
		return interviewer4;
	}

	public void setInterviewer4(String interviewer4) {
		this.interviewer4 = interviewer4;
	}

	public String getEvaluation4() {
		return evaluation4;
	}

	public void setEvaluation4(String evaluation4) {
		this.evaluation4 = evaluation4;
	}

	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public Date getUpdatedate4() {
		return updatedate4;
	}

	public void setUpdatedate4(Date updatedate4) {
		this.updatedate4 = updatedate4;
	}

	public Date getInterviewdate5() {
		return interviewdate5;
	}

	public void setInterviewdate5(Date interviewdate5) {
		this.interviewdate5 = interviewdate5;
	}

	public String getInterviewer5() {
		return interviewer5;
	}

	public void setInterviewer5(String interviewer5) {
		this.interviewer5 = interviewer5;
	}

	public String getEvaluation5() {
		return evaluation5;
	}

	public void setEvaluation5(String evaluation5) {
		this.evaluation5 = evaluation5;
	}

	public String getRemark5() {
		return remark5;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public Date getUpdatedate5() {
		return updatedate5;
	}

	public void setUpdatedate5(Date updatedate5) {
		this.updatedate5 = updatedate5;
	}

	public Date getInterviewdate6() {
		return interviewdate6;
	}

	public void setInterviewdate6(Date interviewdate6) {
		this.interviewdate6 = interviewdate6;
	}

	public String getInterviewer6() {
		return interviewer6;
	}

	public void setInterviewer6(String interviewer6) {
		this.interviewer6 = interviewer6;
	}

	public String getEvaluation6() {
		return evaluation6;
	}

	public void setEvaluation6(String evaluation6) {
		this.evaluation6 = evaluation6;
	}

	public String getRemark6() {
		return remark6;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public Date getUpdatedate6() {
		return updatedate6;
	}

	public void setUpdatedate6(Date updatedate6) {
		this.updatedate6 = updatedate6;
	}

	public Recruitment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recruitment(Long id, Long requirementid, String interviewee, Integer step, Date interviewdate1,
			String interviewer1, String evaluation1, String remark1, Date updatedate1, Date interviewdate2,
			String interviewer2, String evaluation2, String remark2, Date updatedate2, Date interviewdate3,
			String interviewer3, String evaluation3, String remark3, Date updatedate3, Date interviewdate4,
			String interviewer4, String evaluation4, String remark4, Date updatedate4, Date interviewdate5,
			String interviewer5, String evaluation5, String remark5, Date updatedate5, Date interviewdate6,
			String interviewer6, String evaluation6, String remark6, Date updatedate6) {
		super();
		this.id = id;
		this.requirementid = requirementid;
		this.interviewee = interviewee;
		this.step = step;
		this.interviewdate1 = interviewdate1;
		this.interviewer1 = interviewer1;
		this.evaluation1 = evaluation1;
		this.remark1 = remark1;
		this.updatedate1 = updatedate1;
		this.interviewdate2 = interviewdate2;
		this.interviewer2 = interviewer2;
		this.evaluation2 = evaluation2;
		this.remark2 = remark2;
		this.updatedate2 = updatedate2;
		this.interviewdate3 = interviewdate3;
		this.interviewer3 = interviewer3;
		this.evaluation3 = evaluation3;
		this.remark3 = remark3;
		this.updatedate3 = updatedate3;
		this.interviewdate4 = interviewdate4;
		this.interviewer4 = interviewer4;
		this.evaluation4 = evaluation4;
		this.remark4 = remark4;
		this.updatedate4 = updatedate4;
		this.interviewdate5 = interviewdate5;
		this.interviewer5 = interviewer5;
		this.evaluation5 = evaluation5;
		this.remark5 = remark5;
		this.updatedate5 = updatedate5;
		this.interviewdate6 = interviewdate6;
		this.interviewer6 = interviewer6;
		this.evaluation6 = evaluation6;
		this.remark6 = remark6;
		this.updatedate6 = updatedate6;
	}
}
