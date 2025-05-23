package unindra.modules.auth.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import unindra.modules.auth.model.Analytic;
import unindra.modules.auth.service.AuthService;
import unindra.modules.datastore.coa.ui.CoaList;
import unindra.modules.datastore.contact.ui.ContactList;
import unindra.modules.datastore.project.ui.ProjectList;
import unindra.modules.datastore.budget.ui.BudgetList;
import unindra.modules.transaction.bill.ui.BillList;
import unindra.modules.transaction.cashin.ui.CashInList;
import unindra.modules.transaction.cashout.ui.CashOutList;
import unindra.modules.report.ui.ReportActivity;
import unindra.modules.report.ui.ReportBalanceSheet;
import unindra.modules.report.ui.ReportBill;
import unindra.modules.report.ui.ReportBudgetRealization;
import unindra.modules.report.ui.ReportCashFlow;
import unindra.modules.report.ui.ReportExpense;
import unindra.modules.report.ui.ReportIncome;
import unindra.modules.report.ui.ReportProject;

public class MainMenu extends javax.swing.JFrame {

    private JPanel chartContainer;

    public MainMenu() {
        initComponents();
        pack();
        setLocationRelativeTo(null);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        dateFrom.setDate(cal.getTime());
        dateTo.setDate(new Date());
        showDashboardChart();
    }

    private void showDashboardChart() {
        chartContainer.removeAll();
        chartContainer.setLayout(new GridLayout(1, 2));
        Analytic analytic = AuthService.getAnalytic();

        // ---------------- Grafik Aktivitas Keuangan ----------------
        DefaultCategoryDataset activityDataset = new DefaultCategoryDataset();
        activityDataset.addValue(analytic.getIncomeBudget(), "Anggaran", "Penerimaan");
        activityDataset.addValue(analytic.getExpenseBudget(), "Anggaran", "Pengeluaran");
        activityDataset.addValue(analytic.getMarginBudget(), "Anggaran", "Sisa");
        activityDataset.addValue(analytic.getIncomeReal(), "Realisasi", "Penerimaan");
        activityDataset.addValue(analytic.getExpenseReal(), "Realisasi", "Pengeluaran");
        activityDataset.addValue(analytic.getMarginReal(), "Realisasi", "Sisa");
        JFreeChart activityChart = ChartFactory.createBarChart("Aktivitas Keuangan", "", "Nilai (Rp)", activityDataset);
        styleChart(activityChart);
        ChartPanel activityPanel = new ChartPanel(activityChart);
        activityPanel.setOpaque(false);
        activityPanel.setPreferredSize(new Dimension(600, 400));

        // ---------------- Grafik Kekayaan ----------------
        DefaultCategoryDataset wealthDataset = new DefaultCategoryDataset();
        wealthDataset.addValue(analytic.getAssetBudget(), "Anggaran", "Harta");
        wealthDataset.addValue(analytic.getLiabilityBudget(), "Anggaran", "Utang");
        wealthDataset.addValue(analytic.getNetWorthBudget(), "Anggaran", "Kekayaan Bersih");
        wealthDataset.addValue(analytic.getAssetReal(), "Realisasi", "Harta");
        wealthDataset.addValue(analytic.getLiabilityReal(), "Realisasi", "Utang");
        wealthDataset.addValue(analytic.getNetWorthReal(), "Realisasi", "Kekayaan Bersih");
        JFreeChart wealthChart = ChartFactory.createBarChart("Kekayaan", "", "Nilai (Rp)", wealthDataset);
        styleChart(wealthChart);
        ChartPanel wealthPanel = new ChartPanel(wealthChart);
        wealthPanel.setOpaque(false);
        wealthPanel.setPreferredSize(new Dimension(600, 400));

        // ---------------- Tambahkan ke panel dashboard ----------------
        chartContainer.add(activityPanel);
        chartContainer.add(wealthPanel);
        chartContainer.revalidate();
        chartContainer.repaint();
    }

    // Styling yang digunakan bersama untuk grafik
    private void styleChart(JFreeChart chart) {
        chart.setBackgroundPaint(null);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(0, 0, 0, 0));
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(Color.GRAY);

        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, new Color(60, 179, 113));
        renderer.setSeriesPaint(1, new Color(67, 140, 255));
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelFont(new Font("SansSerif", Font.BOLD, 12));
        renderer.setDefaultPositiveItemLabelPosition(
            new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER)
        );
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setShadowVisible(false);
        renderer.setMaximumBarWidth(0.15);

        plot.setRenderer(renderer);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainMenuTabbedPane = new javax.swing.JTabbedPane();
        Dashboard = new unindra.core.Background();
        dateFrom = new com.toedter.calendar.JDateChooser();
        dateTo = new com.toedter.calendar.JDateChooser();
        DataStore = new unindra.core.Background();
        bCOA = new javax.swing.JButton();
        bProject = new javax.swing.JButton();
        bContact = new javax.swing.JButton();
        bBudget = new javax.swing.JButton();
        Transaction = new unindra.core.Background();
        bCashIn = new javax.swing.JButton();
        bBill = new javax.swing.JButton();
        bCashOut = new javax.swing.JButton();
        Report = new unindra.core.Background();
        bReportBalanceSheet = new javax.swing.JButton();
        bReportCashFlow = new javax.swing.JButton();
        bReportActivity = new javax.swing.JButton();
        bReportBill = new javax.swing.JButton();
        bReportIncome = new javax.swing.JButton();
        bReportExpense = new javax.swing.JButton();
        bReportBudgetRealization = new javax.swing.JButton();
        bReportProject = new javax.swing.JButton();
        chartContainer = new JPanel();
        chartContainer.setOpaque(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainMenuTabbedPane.setBackground(new java.awt.Color(222, 242, 251));
        MainMenuTabbedPane.setName(""); // NOI18N

        dateFrom.setDateFormatString("d-MMM-yyyy");

        dateTo.setDateFormatString("d-MMM-yyyy");

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(760, 760, 760)
                .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(DashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chartContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainMenuTabbedPane.addTab("Dasbor", new javax.swing.ImageIcon(getClass().getResource("/images/icon-analytics.png")), Dashboard); // NOI18N

        bCOA.setBackground(new java.awt.Color(32, 191, 107));
        bCOA.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bCOA.setForeground(new java.awt.Color(255, 255, 255));
        bCOA.setText("<html><body style=\"text-align:center\">Kategori<br />Keuangan</body></html>");
        bCOA.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCOA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCOA.setDefaultCapable(false);
        bCOA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCOAActionPerformed(evt);
            }
        });

        bProject.setBackground(new java.awt.Color(211, 68, 233));
        bProject.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bProject.setForeground(new java.awt.Color(255, 255, 255));
        bProject.setText("<html><body style=\"text-align:center\">Data Proyek</body></html>");
        bProject.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bProject.setDefaultCapable(false);
        bProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProjectActionPerformed(evt);
            }
        });

        bContact.setBackground(new java.awt.Color(40, 170, 233));
        bContact.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bContact.setForeground(new java.awt.Color(255, 255, 255));
        bContact.setText("<html><body style=\"text-align:center\">Data Kontak</body></html>");
        bContact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bContact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bContact.setDefaultCapable(false);
        bContact.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bContactActionPerformed(evt);
            }
        });

        bBudget.setBackground(new java.awt.Color(245, 170, 59));
        bBudget.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bBudget.setForeground(new java.awt.Color(255, 255, 255));
        bBudget.setText("<html><body style=\"text-align:center\">Perencanaan<br />Anggaran</body></html>");
        bBudget.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bBudget.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBudget.setDefaultCapable(false);
        bBudget.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBudgetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DataStoreLayout = new javax.swing.GroupLayout(DataStore);
        DataStore.setLayout(DataStoreLayout);
        DataStoreLayout.setHorizontalGroup(
            DataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataStoreLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(bCOA, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bContact, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bProject, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        DataStoreLayout.setVerticalGroup(
            DataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataStoreLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(DataStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bProject, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bContact, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCOA, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        MainMenuTabbedPane.addTab("Data-data", new javax.swing.ImageIcon(getClass().getResource("/images/icon-box.png")), DataStore); // NOI18N

        bCashIn.setBackground(new java.awt.Color(74, 175, 77));
        bCashIn.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bCashIn.setForeground(new java.awt.Color(255, 255, 255));
        bCashIn.setText("<html><body style=\"text-align:center\">Transaksi<br />Penerimaan</body></html>");
        bCashIn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCashIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCashIn.setDefaultCapable(false);
        bCashIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCashIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCashInActionPerformed(evt);
            }
        });

        bBill.setBackground(new java.awt.Color(255, 133, 133));
        bBill.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bBill.setForeground(new java.awt.Color(255, 255, 255));
        bBill.setText("<html><body style=\"text-align:center\">Tagihan</body></html>");
        bBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBill.setDefaultCapable(false);
        bBill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBillActionPerformed(evt);
            }
        });

        bCashOut.setBackground(new java.awt.Color(83, 170, 224));
        bCashOut.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bCashOut.setForeground(new java.awt.Color(255, 255, 255));
        bCashOut.setText("<html><body style=\"text-align:center\">Transaksi<br />Pengeluaran</body></html>");
        bCashOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCashOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCashOut.setDefaultCapable(false);
        bCashOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCashOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCashOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TransactionLayout = new javax.swing.GroupLayout(Transaction);
        Transaction.setLayout(TransactionLayout);
        TransactionLayout.setHorizontalGroup(
            TransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(bBill, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bCashIn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bCashOut, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        TransactionLayout.setVerticalGroup(
            TransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(TransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bBill, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bCashIn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bCashOut, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        MainMenuTabbedPane.addTab("Transaksi", new javax.swing.ImageIcon(getClass().getResource("/images/icon-payment.png")), Transaction); // NOI18N

        bReportBalanceSheet.setBackground(new java.awt.Color(211, 68, 233));
        bReportBalanceSheet.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bReportBalanceSheet.setForeground(new java.awt.Color(255, 255, 255));
        bReportBalanceSheet.setText("<html><body style=\"text-align:center\">Laporan<br />Posisi Keuangan</body></html>");
        bReportBalanceSheet.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bReportBalanceSheet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReportBalanceSheet.setDefaultCapable(false);
        bReportBalanceSheet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReportBalanceSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportBalanceSheetActionPerformed(evt);
            }
        });

        bReportCashFlow.setBackground(new java.awt.Color(40, 170, 233));
        bReportCashFlow.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bReportCashFlow.setForeground(new java.awt.Color(255, 255, 255));
        bReportCashFlow.setText("<html><body style=\"text-align:center\">Laporan<br />Arus Kas</body></html>");
        bReportCashFlow.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bReportCashFlow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReportCashFlow.setDefaultCapable(false);
        bReportCashFlow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReportCashFlow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportCashFlowActionPerformed(evt);
            }
        });

        bReportActivity.setBackground(new java.awt.Color(32, 191, 107));
        bReportActivity.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bReportActivity.setForeground(new java.awt.Color(255, 255, 255));
        bReportActivity.setText("<html><body style=\"text-align:center\">Laporan<br />Aktivitas</body></html>");
        bReportActivity.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bReportActivity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReportActivity.setDefaultCapable(false);
        bReportActivity.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReportActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportActivityActionPerformed(evt);
            }
        });

        bReportBill.setBackground(new java.awt.Color(255, 133, 133));
        bReportBill.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bReportBill.setForeground(new java.awt.Color(255, 255, 255));
        bReportBill.setText("<html><body style=\"text-align:center\">Laporan<br />Tagihan</body></html>");
        bReportBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bReportBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReportBill.setDefaultCapable(false);
        bReportBill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReportBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportBillActionPerformed(evt);
            }
        });

        bReportIncome.setBackground(new java.awt.Color(74, 175, 77));
        bReportIncome.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bReportIncome.setForeground(new java.awt.Color(255, 255, 255));
        bReportIncome.setText("<html><body style=\"text-align:center\">Laporan<br />Penerimaan</body></html>");
        bReportIncome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bReportIncome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReportIncome.setDefaultCapable(false);
        bReportIncome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReportIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportIncomeActionPerformed(evt);
            }
        });

        bReportExpense.setBackground(new java.awt.Color(83, 170, 224));
        bReportExpense.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bReportExpense.setForeground(new java.awt.Color(255, 255, 255));
        bReportExpense.setText("<html><body style=\"text-align:center\">Laporan<br />Pengeluaran</body></html>");
        bReportExpense.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bReportExpense.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReportExpense.setDefaultCapable(false);
        bReportExpense.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReportExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportExpenseActionPerformed(evt);
            }
        });

        bReportBudgetRealization.setBackground(new java.awt.Color(245, 170, 59));
        bReportBudgetRealization.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bReportBudgetRealization.setForeground(new java.awt.Color(255, 255, 255));
        bReportBudgetRealization.setText("<html><body style=\"text-align:center\">Laporan<br />Realisasi<br />Anggaran</body></html>");
        bReportBudgetRealization.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bReportBudgetRealization.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReportBudgetRealization.setDefaultCapable(false);
        bReportBudgetRealization.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReportBudgetRealization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportBudgetRealizationActionPerformed(evt);
            }
        });

        bReportProject.setBackground(new java.awt.Color(162, 120, 66));
        bReportProject.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        bReportProject.setForeground(new java.awt.Color(255, 255, 255));
        bReportProject.setText("<html><body style=\"text-align:center\">Laporan<br />Proyek</body></html>");
        bReportProject.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bReportProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bReportProject.setDefaultCapable(false);
        bReportProject.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bReportProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReportProjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReportLayout = new javax.swing.GroupLayout(Report);
        Report.setLayout(ReportLayout);
        ReportLayout.setHorizontalGroup(
            ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReportLayout.createSequentialGroup()
                        .addComponent(bReportBill, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bReportIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bReportExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bReportProject, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReportLayout.createSequentialGroup()
                        .addComponent(bReportActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bReportCashFlow, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bReportBalanceSheet, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bReportBudgetRealization, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        ReportLayout.setVerticalGroup(
            ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bReportBalanceSheet, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReportCashFlow, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReportActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReportBudgetRealization, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bReportExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReportIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReportBill, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReportProject, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        MainMenuTabbedPane.addTab("Laporan", new javax.swing.ImageIcon(getClass().getResource("/images/icon-report.png")), Report); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenuTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenuTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCOAActionPerformed
        new CoaList().setVisible(true);
    }//GEN-LAST:event_bCOAActionPerformed

    private void bProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProjectActionPerformed
        new ProjectList().setVisible(true);
    }//GEN-LAST:event_bProjectActionPerformed

    private void bContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bContactActionPerformed
        new ContactList().setVisible(true);
    }//GEN-LAST:event_bContactActionPerformed

    private void bCashInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCashInActionPerformed
        new CashInList().setVisible(true);
    }//GEN-LAST:event_bCashInActionPerformed

    private void bBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBillActionPerformed
        new BillList().setVisible(true);
    }//GEN-LAST:event_bBillActionPerformed

    private void bBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBudgetActionPerformed
        new BudgetList().setVisible(true);
    }//GEN-LAST:event_bBudgetActionPerformed

    private void bReportBalanceSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportBalanceSheetActionPerformed
        new ReportBalanceSheet().setVisible(true);
    }//GEN-LAST:event_bReportBalanceSheetActionPerformed

    private void bReportCashFlowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportCashFlowActionPerformed
        new ReportCashFlow().setVisible(true);
    }//GEN-LAST:event_bReportCashFlowActionPerformed

    private void bReportActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportActivityActionPerformed
        new ReportActivity().setVisible(true);
    }//GEN-LAST:event_bReportActivityActionPerformed

    private void bCashOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCashOutActionPerformed
        new CashOutList().setVisible(true);
    }//GEN-LAST:event_bCashOutActionPerformed

    private void bReportBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportBillActionPerformed
        new ReportBill().setVisible(true);
    }//GEN-LAST:event_bReportBillActionPerformed

    private void bReportIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportIncomeActionPerformed
        new ReportIncome().setVisible(true);
    }//GEN-LAST:event_bReportIncomeActionPerformed

    private void bReportExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportExpenseActionPerformed
        new ReportExpense().setVisible(true);
    }//GEN-LAST:event_bReportExpenseActionPerformed

    private void bReportBudgetRealizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportBudgetRealizationActionPerformed
        new ReportBudgetRealization().setVisible(true);
    }//GEN-LAST:event_bReportBudgetRealizationActionPerformed

    private void bReportProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReportProjectActionPerformed
        new ReportProject().setVisible(true);
    }//GEN-LAST:event_bReportProjectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private unindra.core.Background Dashboard;
    private unindra.core.Background DataStore;
    private javax.swing.JTabbedPane MainMenuTabbedPane;
    private unindra.core.Background Report;
    private unindra.core.Background Transaction;
    private javax.swing.JButton bBill;
    private javax.swing.JButton bBudget;
    private javax.swing.JButton bCOA;
    private javax.swing.JButton bCashIn;
    private javax.swing.JButton bCashOut;
    private javax.swing.JButton bContact;
    private javax.swing.JButton bProject;
    private javax.swing.JButton bReportActivity;
    private javax.swing.JButton bReportBalanceSheet;
    private javax.swing.JButton bReportBill;
    private javax.swing.JButton bReportBudgetRealization;
    private javax.swing.JButton bReportCashFlow;
    private javax.swing.JButton bReportExpense;
    private javax.swing.JButton bReportIncome;
    private javax.swing.JButton bReportProject;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateTo;
    // End of variables declaration//GEN-END:variables
}
