package unindra.modules.transaction.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Journal {
    private Integer id;
    private Integer trxId;      // Relasi ke transactions.id
    private Integer coaId;      // Relasi ke chart_of_accounts.id
    private BigDecimal debit;
    private BigDecimal credit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getTrxId() { return trxId; }
    public void setTrxId(Integer trxId) { this.trxId = trxId; }

    public Integer getCoaId() { return coaId; }
    public void setCoaId(Integer coaId) { this.coaId = coaId; }

    public BigDecimal getDebit() { return debit; }
    public void setDebit(BigDecimal debit) { this.debit = debit; }

    public BigDecimal getCredit() { return credit; }
    public void setCredit(BigDecimal credit) { this.credit = credit; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
