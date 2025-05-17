package unindra.modules.transaction.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    private Integer id;
    private Integer parentId;
    private Integer projectId;
    private Integer contactId;
    private Integer originCoaId;
    private Integer targetCoaId;
    private String trxType; // bill, cash_in, cash_out
    private String trxNumber;
    private LocalDate trxDate;
    private String description;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getParentId() { return parentId; }
    public void setParentId(Integer parentId) { this.parentId = parentId; }

    public Integer getProjectId() { return projectId; }
    public void setProjectId(Integer projectId) { this.projectId = projectId; }

    public Integer getContactId() { return contactId; }
    public void setContactId(Integer contactId) { this.contactId = contactId; }

    public Integer getOriginCoaId() { return originCoaId; }
    public void setOriginCoaId(Integer originCoaId) { this.originCoaId = originCoaId; }

    public Integer getTargetCoaId() { return targetCoaId; }
    public void setTargetCoaId(Integer targetCoaId) { this.targetCoaId = targetCoaId; }

    public String getTrxType() { return trxType; }
    public void setTrxType(String trxType) { this.trxType = trxType; }

    public String getTrxNumber() { return trxNumber; }
    public void setTrxNumber(String trxNo) { this.trxNumber = trxNo; }

    public LocalDate getTrxDate() { return trxDate; }
    public void setTrxDate(LocalDate trxDate) { this.trxDate = trxDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
