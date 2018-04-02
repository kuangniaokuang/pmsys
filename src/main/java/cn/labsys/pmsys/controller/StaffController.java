package cn.labsys.pmsys.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.labsys.pmsys.dao.DepartmentRepository;
import cn.labsys.pmsys.dao.StaffRepository;
import cn.labsys.pmsys.entity.Companysite;
import cn.labsys.pmsys.entity.Department;
import cn.labsys.pmsys.entity.Hukou;
import cn.labsys.pmsys.entity.Political;
import cn.labsys.pmsys.entity.Staff;
import cn.labsys.pmsys.entity.StaffModel;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	StaffRepository staffRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@RequestMapping("/save")
	public Staff save(Long id, String staffno, String staffname, String imgurl, Integer workingstate, Long departmentid,
			Long companysiteid, String positionname, Integer sex, String idcardno, String birthdayStr,
			String nationality, Long hukouid, Integer marrystatus, Long politicalid, String highesteducation,
			String school, String major, String joineddateStr, String contractdateStr, String positivedateStr,
			Integer nowworkingyears, String mobileno, String insideno, String outsideno, String nativeplace,
			String livingaddress, Integer contractperiod, Integer contracttype, Integer profile, String cardno,
			String bank, String subbank, String verifier, String staffremark, BigDecimal basic) throws ParseException {
		Date updatedate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date birthday = null;
		if (birthdayStr != "") {
			birthday = (Date) format.parse(birthdayStr);
		}
		Date joineddate = null;
		if (joineddateStr != "") {
			joineddate = (Date) format.parse(joineddateStr);
		}
		Date contractdate = null;
		if (contractdateStr != "") {
			contractdate = (Date) format.parse(contractdateStr);
		}
		Date positivedate = null;
		if (positivedateStr != "") {
			positivedate = (Date) format.parse(positivedateStr);
		}
		// Department department = departmentRepository.findOne(departmentid);
		Department department = new Department();
		department.setId(departmentid);
		Companysite companysite = new Companysite();
		companysite.setId(companysiteid);
		Hukou hukou = new Hukou();
		hukou.setId(hukouid);
		Political political = new Political();
		political.setId(politicalid);
		Staff newstaff;
		if (id == 0) {
			id = null;
			// insert
			newstaff = new Staff(id, staffno, staffname, imgurl, workingstate, department, companysite, positionname,
					sex, idcardno, birthday, nationality, hukou, marrystatus, political, highesteducation, school,
					major, joineddate, contractdate, positivedate, nowworkingyears, mobileno, insideno, outsideno,
					nativeplace, livingaddress, contractperiod, contracttype, profile, cardno, bank, subbank, verifier,
					staffremark, basic, updatedate);
		} else {
			// update
			newstaff = staffRepository.findOne(id);
			newstaff.setStaffno(staffno);
			newstaff.setStaffname(staffname);
			newstaff.setImgurl(imgurl);
			newstaff.setWorkingstate(workingstate);
			newstaff.setDepartment(department);
			newstaff.setCompanysite(companysite);
			newstaff.setPositionname(positionname);
			newstaff.setSex(sex);
			newstaff.setIdcardno(idcardno);
			newstaff.setBirthday(birthday);
			newstaff.setNationality(nationality);
			newstaff.setHukou(hukou);
			newstaff.setMarrystatus(marrystatus);
			newstaff.setPolitical(political);
			newstaff.setHighesteducation(highesteducation);
			newstaff.setSchool(school);
			newstaff.setMajor(major);
			newstaff.setJoineddate(joineddate);
			newstaff.setContractdate(contractdate);
			newstaff.setPositivedate(positivedate);
			newstaff.setNowworkingyears(nowworkingyears);
			newstaff.setMobileno(mobileno);
			newstaff.setInsideno(insideno);
			newstaff.setOutsideno(outsideno);
			newstaff.setNativeplace(nativeplace);
			newstaff.setLivingaddress(livingaddress);
			newstaff.setContractperiod(contractperiod);
			newstaff.setContracttype(contracttype);
			newstaff.setProfile(profile);
			newstaff.setCardno(cardno);
			newstaff.setBank(subbank);
			newstaff.setSubbank(subbank);
			newstaff.setVerifier(verifier);
			newstaff.setStaffremark(staffremark);
			newstaff.setBasic(basic);
			newstaff.setUpdatedate(updatedate);
		}

		Staff staff = staffRepository.save(newstaff);
		return staff;
	}

	@RequestMapping("/s")
	public Staff getById(Long id) {
		Staff staff = staffRepository.findOne(id);
		return staff;
	}

	@RequestMapping("/all")
	public List<Staff> getAll() {
		List<Staff> staffs = (List<Staff>) staffRepository.findAll();
		return staffs;
	}

	@RequestMapping("/getstaff")
	public List<Staff> getStaff() {
		List<Staff> staffs = staffRepository.getStaff();
		return staffs;
	}

	@RequestMapping("/getstafflist")
	public List<StaffModel> getStaffList() {
		List<StaffModel> staffs = staffRepository.getStaffList();
		return staffs;
	}

	@RequestMapping("/upload")
	public String uploadFile(HttpServletRequest request, MultipartFile file) {
		try {
			String filePath = request.getSession().getServletContext().getRealPath("/uploads/");
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(filePath + file.getOriginalFilename())));
			outputStream.write(file.getBytes());
			outputStream.flush();
			outputStream.close();
			return "ok";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}

	@RequestMapping("/downstaff")
	public void downStaff(HttpServletRequest request, HttpServletResponse response)
			throws IOException, InvalidFormatException {
		// String filePath =
		// request.getSession().getServletContext().getRealPath("/excel/staffInfo.xlsx");
		// FileInputStream fInputStream = new FileInputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet sheet = xssfWorkbook.createSheet("StaffInfo");
		List<Staff> staffs = (List<Staff>) staffRepository.findAll();
		// 标题
		XSSFRow headerRow = sheet.createRow(0);
		String headerStrings[] = { "员工号", "姓名", "状态", "公司", "市", "职位", "性别", "身份证号码", "出生日期", "民族", "户口类型", "婚否",
				"政治面貌", "学历", "毕业院校", "专业", "入职时间", "签合同时间", "转正时间", "司龄", "联系电话", "内线座机", "外线座机", "籍贯", "现居住地址",
				"劳动合同期限", "合同形式", "是否接收档案", "银行卡号", "开户行", "支行", "档案审核人", "备注" };
		Cell headerCell = null;
		for (int i = 0, l = headerStrings.length; i < l; i++) {
			headerCell = headerRow.createCell(i);
			headerCell.setCellValue(headerStrings[i]);
		}

		int rowNum = 1;
		for (Staff staff : staffs) {
			XSSFRow row = sheet.createRow(rowNum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(staff.getStaffno() == null ? "" : staff.getStaffno());
			cell = row.createCell(1);
			cell.setCellValue(staff.getStaffname());
			cell = row.createCell(2);
			cell.setCellValue(staff.getWorkingstate());//
			cell = row.createCell(3);
			// cell.setCellValue(staff.getDepartmentid());//
			cell.setCellValue(staff.getDepartment().getDepartmentname());//
			cell = row.createCell(4);
			cell.setCellValue(staff.getCompanysite().getCompanysitename());//
			cell = row.createCell(5);
			cell.setCellValue(staff.getPositionname() == null ? "" : staff.getPositionname());
			cell = row.createCell(6);
			cell.setCellValue(staff.getSex());//
			cell = row.createCell(7);
			cell.setCellValue(staff.getIdcardno() == null ? "" : staff.getIdcardno());
			cell = row.createCell(8);
			cell.setCellValue(staff.getBirthday() == null ? "" : staff.getBirthday().toString());
			cell = row.createCell(9);
			cell.setCellValue(staff.getNationality() == null ? "" : staff.getNationality());
			cell = row.createCell(10);
			cell.setCellValue(staff.getHukou().getHukoutype());//
			cell = row.createCell(11);
			cell.setCellValue(staff.getMarrystatus());//
			cell = row.createCell(12);
			cell.setCellValue(staff.getPolitical().getPoliticalstatus());//
			cell = row.createCell(13);
			cell.setCellValue(staff.getHighesteducation() == null ? "" : staff.getHighesteducation());
			cell = row.createCell(14);
			cell.setCellValue(staff.getSchool() == null ? "" : staff.getSchool());
			cell = row.createCell(15);
			cell.setCellValue(staff.getMajor() == null ? "" : staff.getMajor());
			cell = row.createCell(16);
			cell.setCellValue(staff.getJoineddate() == null ? "" : staff.getJoineddate().toString());
			cell = row.createCell(17);
			cell.setCellValue(staff.getContractdate() == null ? "" : staff.getContractdate().toString());
			cell = row.createCell(18);
			cell.setCellValue(staff.getPositivedate() == null ? "" : staff.getPositivedate().toString());
			cell = row.createCell(19);
			cell.setCellValue(staff.getNowworkingyears() == null ? 0 : staff.getNowworkingyears());
			cell = row.createCell(20);
			cell.setCellValue(staff.getMobileno() == null ? "" : staff.getMobileno());
			cell = row.createCell(21);
			cell.setCellValue(staff.getInsideno() == null ? "" : staff.getInsideno());
			cell = row.createCell(22);
			cell.setCellValue(staff.getOutsideno() == null ? "" : staff.getOutsideno());
			cell = row.createCell(23);
			cell.setCellValue(staff.getNativeplace() == null ? "" : staff.getNativeplace());
			cell = row.createCell(24);
			cell.setCellValue(staff.getLivingaddress() == null ? "" : staff.getLivingaddress());
			cell = row.createCell(25);
			cell.setCellValue(staff.getContractperiod() == null ? "" : staff.getContractperiod().toString());
			cell = row.createCell(26);
			cell.setCellValue(staff.getContracttype());//
			cell = row.createCell(27);
			cell.setCellValue(staff.getProfile());//
			cell = row.createCell(28);
			cell.setCellValue(staff.getCardno() == null ? "" : staff.getCardno());
			cell = row.createCell(29);
			cell.setCellValue(staff.getBank() == null ? "" : staff.getBank());
			cell = row.createCell(30);
			cell.setCellValue(staff.getSubbank() == null ? "" : staff.getSubbank());
			cell = row.createCell(31);
			cell.setCellValue(staff.getVerifier() == null ? "" : staff.getVerifier());
			cell = row.createCell(32);
			cell.setCellValue(staff.getStaffremark() == null ? "" : staff.getStaffremark());
		}
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=staffInfo.xlsx");
		response.flushBuffer();
		xssfWorkbook.write(response.getOutputStream());
		xssfWorkbook.close();
	}
}
