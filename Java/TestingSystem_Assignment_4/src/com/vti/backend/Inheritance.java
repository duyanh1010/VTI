package com.vti.backend;

import com.vti.InheritanceBai1.*;
import com.vti.InheritanceBai3.HighSchoolStudent;
import com.vti.InheritanceBai4.QLTV;

public class Inheritance {

	public void Bai1() {
	
			QLCB qlcb = new QLCB();
			qlcb.addCanBo();
			qlcb.print();
			qlcb.findName();
			qlcb.delete();
	}
	HighSchoolStudent str = new HighSchoolStudent(1, "Nam", "Chuyen Van", "Dai hOc Cong Nghe");
	public void bai4() {
		QLTV qltv=new QLTV();
		qltv.addTaiLieu();
		qltv.delete();
		qltv.prin();
		qltv.findTL();
	}

}
