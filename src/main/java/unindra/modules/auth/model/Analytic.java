package unindra.modules.auth.model;

import java.math.BigDecimal; 

public class Analytic {
    private BigDecimal incomeBudget;
    private BigDecimal expenseBudget;

    private BigDecimal incomeReal;
    private BigDecimal expenseReal;

    private BigDecimal assetBudget;
    private BigDecimal liabilityBudget;

    private BigDecimal assetReal;
    private BigDecimal liabilityReal;

    public BigDecimal getIncomeBudget() {
        return incomeBudget;
    }
    public void setIncomeBudget(BigDecimal incomeBudget) {
        this.incomeBudget = incomeBudget;
    }
    public BigDecimal getExpenseBudget() {
        return expenseBudget;
    }
    public void setExpenseBudget(BigDecimal expenseBudget) {
        this.expenseBudget = expenseBudget;
    }
    public BigDecimal getMarginBudget() {
        return this.incomeBudget.subtract(this.expenseBudget);
    }

    public BigDecimal getIncomeReal() {
        return incomeReal;
    }
    public void setIncomeReal(BigDecimal incomeReal) {
        this.incomeReal = incomeReal;
    }
    public BigDecimal getExpenseReal() {
        return expenseReal;
    }
    public void setExpenseReal(BigDecimal expenseReal) {
        this.expenseReal = expenseReal;
    }
    public BigDecimal getMarginReal() {
        return this.incomeReal.subtract(this.expenseReal);
    }

    public BigDecimal getAssetBudget() {
        return assetBudget;
    }
    public void setAssetBudget(BigDecimal assetBudget) {
        this.assetBudget = assetBudget;
    }
    public BigDecimal getLiabilityBudget() {
        return liabilityBudget;
    }
    public void setLiabilityBudget(BigDecimal liabilityBudget) {
        this.liabilityBudget = liabilityBudget;
    }
    public BigDecimal getNetWorthBudget() {
        return this.assetBudget.subtract(this.liabilityBudget);
    }

    public BigDecimal getAssetReal() {
        return assetReal;
    }
    public void setAssetReal(BigDecimal assetReal) {
        this.assetReal = assetReal;
    }
    public BigDecimal getLiabilityReal() {
        return liabilityReal;
    }
    public void setLiabilityReal(BigDecimal liabilityReal) {
        this.liabilityReal = liabilityReal;
    }
    public BigDecimal getNetWorthReal() {
        return this.incomeReal.subtract(this.liabilityReal);
    }
}
