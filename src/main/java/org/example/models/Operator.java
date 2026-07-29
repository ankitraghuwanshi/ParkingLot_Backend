package org.example.models;

public class Operator extends BaseModel{
    private String OperatorName;
    private int OperatorAge;
    private String OperatorGender;


    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    public int getOperatorAge() {
        return OperatorAge;
    }

    public void setOperatorAge(int operatorAge) {
        OperatorAge = operatorAge;
    }

    public String getOperatorGender() {
        return OperatorGender;
    }

    public void setOperatorGender(String operatorGender) {
        OperatorGender = operatorGender;
    }
}
