package com.ericsson.urm.persistence.core.dto;

public class TestDto {

    public TestDto() {
    }

    public TestDto(String par1, String par2, String par3) {
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
    }

    String par1;
    String par2;
    String par3;

    public String getPar1() {
        return par1;
    }

    public void setPar1(String par1) {
        this.par1 = par1;
    }

    public String getPar2() {
        return par2;
    }

    public void setPar2(String par2) {
        this.par2 = par2;
    }

    public String getPar3() {
        return par3;
    }

    public void setPar3(String par3) {
        this.par3 = par3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestDto testDto = (TestDto) o;

        if (getPar1() != null ? !getPar1().equals(testDto.getPar1()) : testDto.getPar1() != null) return false;
        if (getPar2() != null ? !getPar2().equals(testDto.getPar2()) : testDto.getPar2() != null) return false;
        return getPar3() != null ? getPar3().equals(testDto.getPar3()) : testDto.getPar3() == null;
    }

    @Override
    public int hashCode() {
        int result = getPar1() != null ? getPar1().hashCode() : 0;
        result = 31 * result + (getPar2() != null ? getPar2().hashCode() : 0);
        result = 31 * result + (getPar3() != null ? getPar3().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "par1='" + par1 + '\'' +
                ", par2='" + par2 + '\'' +
                ", par3='" + par3 + '\'' +
                '}';
    }
}
