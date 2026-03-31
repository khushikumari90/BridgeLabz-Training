package data_export_feature;
interface ReportExporter {

    void exportToCSV();
    void exportToPDF();

    // Newly added feature (backward compatible)
    default void exportToJSON() {
        System.out.println("Exporting report to JSON using standard format");
    }
}

