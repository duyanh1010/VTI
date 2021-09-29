package com.vti.entity;
public class Position {

		byte positionId;
		String	positionName;
		Account[] accounts;
		public Position(byte positionId,String	positionName) {
			this.positionId=positionId;
			this.positionName=positionName;
		}
		public byte getPositionId() {
			return positionId;
		}
		public void setPositionId(byte positionId) {
			this.positionId = positionId;
		}
		public String getPositionName() {
			return positionName;
		}
		public void setPositionName(String positionName) {
			this.positionName = positionName;
		}
		public Account[] getAccounts() {
			return accounts;
		}
		public void setAccounts(Account[] accounts) {
			this.accounts = accounts;
		}
		public Position() {
			
		}
}
