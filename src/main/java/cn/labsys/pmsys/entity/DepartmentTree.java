package cn.labsys.pmsys.entity;

import java.util.ArrayList;
import java.util.List;

public class DepartmentTree {
	private Long value;
	private String text;
	private Boolean selectable;
	private List<DepartmentTree> nodes = new ArrayList<DepartmentTree>();

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getSelectable() {
		return selectable;
	}

	public void setSelectable(Boolean selectable) {
		this.selectable = selectable;
	}

	public List<DepartmentTree> getNodes() {
		return nodes;
	}

	public void setNodes(List<DepartmentTree> nodes) {
		this.nodes = nodes;
	}

	public DepartmentTree() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentTree(Long value, String text, List<DepartmentTree> nodes) {
		super();
		this.value = value;
		this.text = text;
		this.nodes = nodes;
	}
}
