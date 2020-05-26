package org.budowa.services;

import org.budowa.entities.Building;
import org.budowa.entities.User;
import org.budowa.texts.Translations;

public class RaportService {
    public static RaportService inject() {
        return new RaportService();
    }


    private final PdfBuilder pdfBuilder = PdfBuilder.inject();
    private final DialogService dialogService = DialogService.inject();


    public void print(String title, Building[] buildings) {
        try {

            var builder = this.pdfBuilder.create(title).addText(title).addEmptyLine();
            for (var building : buildings) {
                builder = builder.addDataBlock("Nazwa:", building.getName())
                        .addDataBlock("Status:", building.getStatus().toString())
                        .addEmptyLine();
            }
            builder.save();
            this.dialogService.showInfoDialog(Translations.SUCCESSFULLY_SAVED_PDF);
        } catch (NullPointerException ignored) {
        } catch (Exception ex) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    public void printDetailedList(String name, Building[] buildings) {
        try {
            var pdf = pdfBuilder.create(name);
            for (var building : buildings) {
                pdf = pdf.addDataBlock("Nazwa budynku:", building.getName())
                        .addDataBlock("Status:", building.getStatus().toString())
                        .addDataBlock("Priorytet:", building.getPriority().toString())
                        .addDataBlock("Data dodania:", getDataValue(building.getStartDate()))
                        .addDataBlock("Data zakończenia:", getDataValue(building.getEndDate()))
                        .addDataBlock("Kierownik:", getManagerName(building.getManager()))
                        .addList("Pracownicy:", building.getWorkers().stream().map(User::getFullName).toArray(String[]::new))
                        .addDataBlock("Opis:", building.getDescription())
                        .addEmptyLine()
                        .addEmptyLine();
            }
            pdf.save();
            this.dialogService.showInfoDialog(Translations.SUCCESSFULLY_SAVED_PDF);
        } catch (Exception ex) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

    private String getManagerName(User manager) {
        return manager != null ? manager.getFullName() : "Nieprzypisany";
    }

    private String getDataValue(String date) {
        return date == null || date.equals("") ? "Brak" : date;
    }
}
