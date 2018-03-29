package com.shd.model.pojoExt;

import java.util.List;

public class NodeExt<T> {
	private String text;

	private List<T> children;

	private boolean more = false;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<T> getChildren() {
		return children;
	}

	public void setChildren(List<T> children) {
		this.children = children;
	}

	public boolean isMore() {
		return more;
	}

	public void setMore(boolean more) {
		this.more = more;
	}

}
