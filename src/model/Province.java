package model;

import java.util.Objects;

public class Province{
    private int provinceCode;
    private String provinceName;

    public Province(int provinceCode, String provinceName){
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Province Code: " + provinceCode + "--Province Name: " + provinceName;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(provinceCode, provinceName);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Province o = (Province) obj; //Narrowing
        return provinceCode == o.provinceCode && Objects.equals(provinceName, provinceCode);
    }
    
}