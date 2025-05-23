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
		return this.incomeBudget != null ? this.incomeBudget : BigDecimal.ZERO;
	}

	public void setIncomeBudget(BigDecimal incomeBudget) {
		this.incomeBudget = incomeBudget;
	}

	public BigDecimal getExpenseBudget() {
		return this.expenseBudget != null ? this.expenseBudget : BigDecimal.ZERO;
	}

	public void setExpenseBudget(BigDecimal expenseBudget) {
		this.expenseBudget = expenseBudget;
	}

	public BigDecimal getMarginBudget() {
		return (this.incomeBudget != null && this.expenseBudget != null)
				? this.incomeBudget.subtract(this.expenseBudget)
				: BigDecimal.ZERO;
	}

	public BigDecimal getIncomeReal() {
		return this.incomeReal != null ? this.incomeReal : BigDecimal.ZERO;
	}

	public void setIncomeReal(BigDecimal incomeReal) {
		this.incomeReal = incomeReal;
	}

	public BigDecimal getExpenseReal() {
		return this.expenseReal != null ? this.expenseReal : BigDecimal.ZERO;
	}

	public void setExpenseReal(BigDecimal expenseReal) {
		this.expenseReal = expenseReal;
	}

	public BigDecimal getMarginReal() {
		return (this.incomeReal != null && this.expenseReal != null) ? this.incomeReal.subtract(this.expenseReal)
				: BigDecimal.ZERO;
	}

	public BigDecimal getAssetBudget() {
		return this.assetBudget != null ? this.assetBudget : BigDecimal.ZERO;
	}

	public void setAssetBudget(BigDecimal assetBudget) {
		this.assetBudget = assetBudget;
	}

	public BigDecimal getLiabilityBudget() {
		return this.liabilityBudget != null ? this.liabilityBudget : BigDecimal.ZERO;
	}

	public void setLiabilityBudget(BigDecimal liabilityBudget) {
		this.liabilityBudget = liabilityBudget;
	}

	public BigDecimal getNetWorthBudget() {
		return (this.assetBudget != null && this.liabilityBudget != null)
				? this.assetBudget.subtract(this.liabilityBudget)
				: BigDecimal.ZERO;
	}

	public BigDecimal getAssetReal() {
		return this.assetReal != null ? this.assetReal : BigDecimal.ZERO;
	}

	public void setAssetReal(BigDecimal assetReal) {
		this.assetReal = assetReal;
	}

	public BigDecimal getLiabilityReal() {
		return this.liabilityReal != null ? this.liabilityReal : BigDecimal.ZERO;
	}

	public void setLiabilityReal(BigDecimal liabilityReal) {
		this.liabilityReal = liabilityReal;
	}

	public BigDecimal getNetWorthReal() {
		return (this.incomeReal != null && this.liabilityReal != null) ? this.incomeReal.subtract(this.liabilityReal)
				: BigDecimal.ZERO;
	}
}
