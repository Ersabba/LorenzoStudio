package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;


public class IpGateway implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				id;
	private String				ipAddress;
	private Integer				tcpPort;
	private Integer				ftpPort;
	private String				accessUser;
	private String				accessPassword;
	private String				ftpUser;
	private String				ftpPassword;
	private String				firstConnection;
	private String				lastConnection;
	private Long				connections;
	
	private String				simNumber;
	private Integer				monthlyConnectionsTot;
	private	Integer				monthlyConnectionsOk;
	private Integer				monthlyConnectionsTotBackup;
	private	Integer				monthlyConnectionsOkBackup;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getTcpPort() {
		return tcpPort;
	}

	public void setTcpPort(Integer tcpPort) {
		this.tcpPort = tcpPort;
	}
	
	public Integer getFtpPort() {
		return ftpPort;
	}

	public void setFtpPort(Integer ftpPort) {
		this.ftpPort = ftpPort;
	}

	public String getAccessUser() {
		return accessUser;
	}

	public void setAccessUser(String accessUser) {
		this.accessUser = accessUser;
	}

	public String getAccessPassword() {
		return accessPassword;
	}

	public void setAccessPassword(String accessPassword) {
		this.accessPassword = accessPassword;
	}

	public String getFtpUser() {
		return ftpUser;
	}

	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}

	public String getFtpPassword() {
		return ftpPassword;
	}

	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}

	public String getFirstConnection() {
		return firstConnection;
	}

	public void setFirstConnection(String firstConnection) {
		this.firstConnection = firstConnection;
	}

	public String getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(String lastConnection) {
		this.lastConnection = lastConnection;
	}

	public Long getConnections() {
		return connections;
	}

	public void setConnections(Long connections) {
		this.connections = connections;
	}

	
	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public Integer getMonthlyConnectionsTot() {
		return monthlyConnectionsTot;
	}

	public void setMonthlyConnectionsTot(Integer monthlyConnectionsTot) {
		this.monthlyConnectionsTot = monthlyConnectionsTot;
	}

	
	public Integer getMonthlyConnectionsOk() {
		return monthlyConnectionsOk;
	}

	public void setMonthlyConnectionsOk(Integer monthlyConnectionsOk) {
		this.monthlyConnectionsOk = monthlyConnectionsOk;
	}

	
	public Integer getMonthlyConnectionsTotBackup() {
		return monthlyConnectionsTotBackup;
	}

	public void setMonthlyConnectionsTotBackup(Integer monthlyConnectionsTotBackup) {
		this.monthlyConnectionsTotBackup = monthlyConnectionsTotBackup;
	}

	public Integer getMonthlyConnectionsOkBackup() {
		return monthlyConnectionsOkBackup;
	}

	public void setMonthlyConnectionsOkBackup(Integer monthlyConnectionsOkBackup) {
		this.monthlyConnectionsOkBackup = monthlyConnectionsOkBackup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessPassword == null) ? 0 : accessPassword.hashCode());
		result = prime * result + ((accessUser == null) ? 0 : accessUser.hashCode());
		result = prime * result + ((connections == null) ? 0 : connections.hashCode());
		result = prime * result + ((firstConnection == null) ? 0 : firstConnection.hashCode());
		result = prime * result + ((ftpPassword == null) ? 0 : ftpPassword.hashCode());
		result = prime * result + ((ftpUser == null) ? 0 : ftpUser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((lastConnection == null) ? 0 : lastConnection.hashCode());
		result = prime * result + ((monthlyConnectionsOk == null) ? 0 : monthlyConnectionsOk.hashCode());
		result = prime * result + ((monthlyConnectionsOkBackup == null) ? 0 : monthlyConnectionsOkBackup.hashCode());
		result = prime * result + ((monthlyConnectionsTot == null) ? 0 : monthlyConnectionsTot.hashCode());
		result = prime * result + ((monthlyConnectionsTotBackup == null) ? 0 : monthlyConnectionsTotBackup.hashCode());
		result = prime * result + ((simNumber == null) ? 0 : simNumber.hashCode());
		result = prime * result + ((tcpPort == null) ? 0 : tcpPort.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IpGateway other = (IpGateway) obj;
		if (accessPassword == null) {
			if (other.accessPassword != null)
				return false;
		}
		else if (!accessPassword.equals(other.accessPassword))
			return false;
		if (accessUser == null) {
			if (other.accessUser != null)
				return false;
		}
		else if (!accessUser.equals(other.accessUser))
			return false;
		if (connections == null) {
			if (other.connections != null)
				return false;
		}
		else if (!connections.equals(other.connections))
			return false;
		if (firstConnection == null) {
			if (other.firstConnection != null)
				return false;
		}
		else if (!firstConnection.equals(other.firstConnection))
			return false;
		if (ftpPassword == null) {
			if (other.ftpPassword != null)
				return false;
		}
		else if (!ftpPassword.equals(other.ftpPassword))
			return false;
		if (ftpUser == null) {
			if (other.ftpUser != null)
				return false;
		}
		else if (!ftpUser.equals(other.ftpUser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		}
		else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (lastConnection == null) {
			if (other.lastConnection != null)
				return false;
		}
		else if (!lastConnection.equals(other.lastConnection))
			return false;
		if (monthlyConnectionsOk == null) {
			if (other.monthlyConnectionsOk != null)
				return false;
		}
		else if (!monthlyConnectionsOk.equals(other.monthlyConnectionsOk))
			return false;
		if (monthlyConnectionsOkBackup == null) {
			if (other.monthlyConnectionsOkBackup != null)
				return false;
		}
		else if (!monthlyConnectionsOkBackup.equals(other.monthlyConnectionsOkBackup))
			return false;
		if (monthlyConnectionsTot == null) {
			if (other.monthlyConnectionsTot != null)
				return false;
		}
		else if (!monthlyConnectionsTot.equals(other.monthlyConnectionsTot))
			return false;
		if (monthlyConnectionsTotBackup == null) {
			if (other.monthlyConnectionsTotBackup != null)
				return false;
		}
		else if (!monthlyConnectionsTotBackup.equals(other.monthlyConnectionsTotBackup))
			return false;
		if (simNumber == null) {
			if (other.simNumber != null)
				return false;
		}
		else if (!simNumber.equals(other.simNumber))
			return false;
		if (tcpPort == null) {
			if (other.tcpPort != null)
				return false;
		}
		else if (!tcpPort.equals(other.tcpPort))
			return false;
		return true;
	}
}
