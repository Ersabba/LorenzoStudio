package com.ericsson.urm.device.driver.statusword;

import java.io.Serializable;


public class LenntCompleteStatusWordResponse implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private byte[]				completeStatusWord;		// contiene 3 + 3 + 3 + 2 byte

	public byte[] getCompleteStatusWord() {
		return completeStatusWord;
	}

	public void setCompleteStatusWord(byte[] completeStatusWord) {
		this.completeStatusWord = completeStatusWord;
	}

	public byte[] getFirstBlock() {
		if (completeStatusWord == null || completeStatusWord.length < 3)
			return null;
		byte[] block = { completeStatusWord[0], completeStatusWord[1], completeStatusWord[2] };
		return block;
	}

	public byte[] getSecondBlock() {
		if (completeStatusWord == null || completeStatusWord.length < 6)
			return null;
		byte[] block = { completeStatusWord[3], completeStatusWord[4], completeStatusWord[5] };
		return block;
	}

	public byte[] getThirdBlock() {
		if (completeStatusWord == null || completeStatusWord.length < 9)
			return null;
		byte[] block = { completeStatusWord[6], completeStatusWord[7], completeStatusWord[8] };
		return block;
	}

	public byte[] getAceaLinkBlock() {
		if (completeStatusWord == null || completeStatusWord.length < 11)
			return null;
		byte[] block = { completeStatusWord[9], completeStatusWord[10] };
		return block;
	}
}
