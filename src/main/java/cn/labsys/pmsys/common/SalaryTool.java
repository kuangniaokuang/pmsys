package cn.labsys.pmsys.common;

import java.math.BigDecimal;

public class SalaryTool {

	public double setPoint(double data, int point) {
		BigDecimal bd = new BigDecimal(data);
		return bd.setScale(point, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public double taxCalculation(double data) {
		double newData = data - 3500;
		double tax;
		if (newData <= 0) {
			tax = 0;
		} else if (newData <= 1500) {
			tax = newData * 0.03;
		} else if (newData <= 4500) {
			tax = newData * 0.1 - 105;
		} else if (newData <= 9000) {
			tax = newData * 0.2 - 555;
		} else if (newData <= 35000) {
			tax = newData * 0.25 - 1005;
		} else if (newData <= 55000) {
			tax = newData * 0.3 - 2755;
		} else if (newData <= 80000) {
			tax = newData * 0.35 - 5505;
		} else {
			tax = newData * 0.45 - 13505;
		}
		return tax;
	}
}
