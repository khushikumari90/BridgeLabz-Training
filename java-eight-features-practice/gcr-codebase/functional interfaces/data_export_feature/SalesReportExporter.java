package data_export_feature;
class SalesReportExporter implements ReportExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Sales report exported to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Sales report exported to PDF");
    }
}
