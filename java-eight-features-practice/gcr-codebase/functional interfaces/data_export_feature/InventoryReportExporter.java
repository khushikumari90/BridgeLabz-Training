package data_export_feature;
class InventoryReportExporter implements ReportExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Inventory report exported to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Inventory report exported to PDF");
    }
}
