package data_export_feature;
public class ReportApp {
    public static void main(String[] args) {

        ReportExporter sales = new SalesReportExporter();
        ReportExporter inventory = new InventoryReportExporter();

        sales.exportToCSV();
        sales.exportToPDF();
        sales.exportToJSON();   // default method

        inventory.exportToJSON(); // default method
    }
}
