package com.cys.boot.entity;

import com.cys.boot.typeNeedHandle.ChatRecord;

/**
 *	@description Chat has chatRecord,chatter(user) 
 *	and target chatter(send to target user)
 *	@author Chenyongsheng
 * 	@date 2022/5/6
 */
public class Chat {
	private long id;
	private long userId;
	private long targetUserid;
	private ChatRecord r1;
	private ChatRecord r2;
	private ChatRecord r3;
	private ChatRecord r4;
	private ChatRecord r5;
	private ChatRecord r6;
	private ChatRecord r7;
	private ChatRecord r8;
	private ChatRecord r9;
	private ChatRecord r10;
	private ChatRecord r11;
	private ChatRecord r12;
	public Chat() {
		//

	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTargetUserid() {
		return targetUserid;
	}
	public void setTargetUserid(long targetUserid) {
		this.targetUserid = targetUserid;
	}
	public ChatRecord getR1() {
		return r1;
	}
	public void setR1(ChatRecord r1) {
		this.r1 = r1;
	}
	public ChatRecord getR2() {
		return r2;
	}
	public void setR2(ChatRecord r2) {
		this.r2 = r2;
	}
	public ChatRecord getR3() {
		return r3;
	}
	public void setR3(ChatRecord r3) {
		this.r3 = r3;
	}
	public ChatRecord getR4() {
		return r4;
	}
	public void setR4(ChatRecord r4) {
		this.r4 = r4;
	}
	public ChatRecord getR5() {
		return r5;
	}
	public void setR5(ChatRecord r5) {
		this.r5 = r5;
	}
	public ChatRecord getR6() {
		return r6;
	}
	public void setR6(ChatRecord r6) {
		this.r6 = r6;
	}
	public ChatRecord getR7() {
		return r7;
	}
	public void setR7(ChatRecord r7) {
		this.r7 = r7;
	}
	public ChatRecord getR8() {
		return r8;
	}
	public void setR8(ChatRecord r8) {
		this.r8 = r8;
	}
	public ChatRecord getR9() {
		return r9;
	}
	public void setR9(ChatRecord r9) {
		this.r9 = r9;
	}
	public ChatRecord getR10() {
		return r10;
	}
	public void setR10(ChatRecord r10) {
		this.r10 = r10;
	}
	public ChatRecord getR11() {
		return r11;
	}
	public void setR11(ChatRecord r11) {
		this.r11 = r11;
	}
	public ChatRecord getR12() {
		return r12;
	}
	public void setR12(ChatRecord r12) {
		this.r12 = r12;
	}
	@Override
	public String toString() {
		return "Chat [id=" + id + ", userId=" + userId + ", targetUserid=" + targetUserid + ", r1=" + r1 + ", r2=" + r2
				+ ", r3=" + r3 + ", r4=" + r4 + ", r5=" + r5 + ", r6=" + r6 + ", r7=" + r7 + ", r8=" + r8 + ", r9=" + r9
				+ ", r10=" + r10 + ", r11=" + r11 + ", r12=" + r12 + "]";
	}
	
}
